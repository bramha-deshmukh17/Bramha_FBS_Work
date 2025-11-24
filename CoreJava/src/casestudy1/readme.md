# Java Case Study 1 - Bank

## Table of Contents
- [Overview](#overview)  
- [Features](#features)  
- [Architecture](#architecture)  
- [Project Files](#project-files)  
- [How the Code Flows](#how-the-code-flows)  
  - [Open Account Flow](#open-account-flow)  
  - [Deposit Flow](#deposit-flow)  
  - [Withdraw Flow](#withdraw-flow)  
  - [End of Day (EOD) Flow](#end-of-day-eod-flow)  
  - [Account Statement by Date Range](#account-statement-by-date-range)  
- [Class and Method Reference (Brief)](#class-and-method-reference-brief)  
  - [Transaction](#transaction)  
  - [Account (Abstract)](#account-abstract)  
  - [SavingsAccount](#savingsaccount)  
  - [SalaryAccount](#salaryaccount)  
  - [CurrentAccount](#currentaccount)  
  - [LoanAccount](#loanaccount)  
  - [BankModel](#bankmodel)  
  - [BankController](#bankcontroller)  
  - [BankView](#bankview)  
- [How to Compile and Run](#how-to-compile-and-run)  
- [Design Notes and Limitations](#design-notes-and-limitations)  
- [Next Improvements (Suggestions)](#next-improvements-suggestions)  
- [Source Code](#source-code)

---

## Overview
This is a small console-based banking case study implemented in Java following an MVC pattern. The system supports multiple account types and basic branch-level operations. Transactions are recorded at the account level and mirrored to the branch level for end-of-day reporting.

---

## Features
- Open accounts: Savings, Salary, Current, and Loan.  
- Deposit and withdraw operations with business rules per account type.  
- Loan repayment via deposit into a loan account with automatic loan closure.  
- Branch-level daily transaction log and end-of-day report.  
- Interest posting only on the first day of each month.  
- Account statement retrieval for a specified date range.  

---

## Architecture
The project follows MVC separation of concerns.

- Model: `BankModel`, `Account` subclasses, `Transaction` — contains business logic and data.  
- Controller: `BankController` — mediates between view and model and forwards user actions.  
- View: `BankView` — handles console input/output and drives the application loop.

Data relationships:
- A branch has many accounts.  
- An account has many transactions.  

---

## How the Code Flows

### Open Account Flow
1. The view collects account details and account type and passes an object array to the controller.  
2. The controller constructs the correct account subclass and calls `model.openAccount()`.  
3. The model stores the account in the branch accounts array and prints confirmation.

### Deposit Flow
1. The view asks for the account number and amount, then calls `controller.deposit()`.  
2. The controller forwards to `model.deposit()`.  
3. The model finds the account, invokes `account.deposit()`, which updates the balance and adds a transaction.  
4. The model mirrors the account transaction to the branch `allTransactions` log.

### Withdraw Flow
1. The view asks for the account number and amount, then calls `controller.withdraw()`.  
2. The controller forwards to `model.withdraw()`.  
3. The model finds the account, invokes `account.withdraw()`, which checks `canWithdraw` and status, then updates the balance and adds a transaction.  
4. The model mirrors the account transaction to the branch log if the balance changed.

### End of Day (EOD) Flow
1. The view triggers `controller.generateReport()`.  
2. The controller forwards to `model.generateEODReport()`.  
3. The model iterates accounts and calls `accountLifeCycle()` for each account.  
4. The model applies interest only if the current day is the first day of the month. It calls `calculateInterest()` on each account and, if non-zero, posts the interest to balance, creates an account transaction, and mirrors it to the branch log.  
5. The model prints the branch-level transaction summary for the day.

### Account Statement by Date Range
1. The view collects account number, start date, and end date, then calls `controller.getStatement()`.  
2. The controller forwards to `model.getAccountStatement()`.  
3. The model locates the account and calls `account.getStatementByDate()`, which prints transactions in the range.

---

## Class and Method Reference (Brief)

### Transaction
- Constructor sets transaction fields and date. Purpose: create a single transaction record used by account and branch logs.

### Account (Abstract)
- `deposit(amount)`: Deposit funds if account not frozen or closed; add a transaction; update lifecycle.  
- `withdraw(amount)`: Final; apply withdrawal only if account state and `canWithdraw` permit; add transaction; then lifecycle.  
- `getStatementByDate(start, end)`: Final; prints transactions for specified date range and a summary.  
- `addTransaction(amount, type, remark)`: Ensure internal array capacity; create transaction record and append.  
- `getLastTransaction()`: Return most recent transaction or null.  
- `canWithdraw(amount)`: Abstract; account-specific withdrawal rule.  
- `accountLifeCycle()`: Abstract; lifecycle checks such as minimum balance or inactivity detection.  
- `calculateInterest()`: Abstract; return interest amount (positive for credit, negative for debit). Posted by model only on day 1.

### SavingsAccount
- Constructor sets status to inactive if opening balance below minimum.  
- `canWithdraw`: Enforces minimum balance rule.  
- `accountLifeCycle`: Sets status active or inactive based on balance.  
- `calculateInterest`: Returns interest based on configured `interestRate`.

### SalaryAccount
- Tracks `lastTransactionDate`; updates it in overridden `addTransaction`.  
- `canWithdraw`: Disallows if inactive by inactivity rule; ensures non-negative balance.  
- `accountLifeCycle`: Computes months since last transaction; sets status inactive and notifies when needed.  
- `calculateInterest`: Returns zero.  
- `notifyUser`: Prints inactivity notification.

### CurrentAccount
- Holds `overdraftLimit` and interest on overdraft.  
- `canWithdraw`: Allows withdrawal up to overdraft limit.  
- `accountLifeCycle`: Freezes account when overdraft beyond limit.  
- `calculateInterest`: Returns negative interest amount when balance negative.

### LoanAccount
- Opening balance is negative loan amount; `amountRepaid` tracked on deposits.  
- `deposit`: Overridden to behave as loan repayment; updates `amountRepaid`; closes when repaid.  
- `accountLifeCycle`: Marks loan cleared if applicable.  
- `calculateInterest`: Returns negative interest on outstanding loan using `interestRate`.

### BankModel
- `openAccount(account)`: Add account (resizes array when needed).  
- `closeAccount(accountNumber)`: Mark status closed.  
- `searchAccount(accountNumber)`: Linear search.  
- `addToAllTransactions(transaction)`: Append branch-level transaction (resize as needed).  
- `withdraw(accountNumber, amount)`: Invoke account withdrawal; mirror transaction if balance changed.  
- `deposit(accountNumber, amount)`: Invoke account deposit; mirror transaction if balance changed.  
- `getAccountStatement(accountNumber, start, end)`: Call account statement method.  
- `generateEODReport()`: Run lifecycle; post interest; mirror interest transactions; print summary.

### BankController
- `openAccount(data)`: Build subclass and call `model.openAccount()`.  
- `deposit(accountNumber, amount)`: Forward.  
- `withdraw(accountNumber, amount)`: Forward.  
- `getStatement(accNo, start, end)`: Forward.  
- `generateReport()`: Forward.

### BankView
- Console interface with main menu and helper input methods.  
- `start()`: Drives main loop.  
- `getNewAccountDetails()`: Collect info including overdraft for current accounts.  
- `getAccountNumberInput()`, `getAmountInput()`: Prompt helpers.

---
