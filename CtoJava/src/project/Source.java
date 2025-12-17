package project;

import java.util.Scanner;

class Date {
    int day, month, year;
}

class Player {
    int jno, runs, wickets, matches, century, half_century, outs, runs_conceded, over_bowled;
    String name;
    String category;
    Date dob;

    public Player() {
        this.dob = new Date();
        this.name = "";
        this.category = "";
    }
}

public class Source {

    static int arraySize = 10, playerCount = 10;
    static Scanner sc = new Scanner(System.in);

    static void defaultDataAdd(Player[] ptr) {
        // Player 1: Virat Kohli (index 0)
        ptr[0] = new Player();
        ptr[0].jno = 1;
        ptr[0].name = "Virat Kohli";
        ptr[0].category = "All-Rounder";
        ptr[0].runs = 100;
        ptr[0].wickets = 5;
        ptr[0].matches = 10;
        ptr[0].century = 1;
        ptr[0].half_century = 1;
        ptr[0].runs_conceded = 5;
        ptr[0].over_bowled = 2;
        ptr[0].outs = 1;
        ptr[0].dob.day = 1;
        ptr[0].dob.month = 1;
        ptr[0].dob.year = 1990;

        // Player 2: Rohit Sharma (index 1)
        ptr[1] = new Player();
        ptr[1].jno = 2;
        ptr[1].name = "Rohit Sharma";
        ptr[1].category = "Bowler";
        ptr[1].runs = 200;
        ptr[1].wickets = 10;
        ptr[1].matches = 20;
        ptr[1].century = 2;
        ptr[1].half_century = 2;
        ptr[1].runs_conceded = 10;
        ptr[1].over_bowled = 4;
        ptr[1].outs = 2;
        ptr[1].dob.day = 2;
        ptr[1].dob.month = 2;
        ptr[1].dob.year = 1991;

        // Player 3: MS Dhoni (index 2)
        ptr[2] = new Player();
        ptr[2].jno = 3;
        ptr[2].name = "MS Dhoni";
        ptr[2].category = "Batsman";
        ptr[2].runs = 300;
        ptr[2].wickets = 15;
        ptr[2].matches = 30;
        ptr[2].century = 3;
        ptr[2].half_century = 3;
        ptr[2].runs_conceded = 15;
        ptr[2].over_bowled = 6;
        ptr[2].outs = 3;
        ptr[2].dob.day = 3;
        ptr[2].dob.month = 3;
        ptr[2].dob.year = 1992;

        // Player 4: Sachin Tendulkar (index 3)
        ptr[3] = new Player();
        ptr[3].jno = 4;
        ptr[3].name = "Sachin Tendulkar";
        ptr[3].category = "All-Rounder";
        ptr[3].runs = 400;
        ptr[3].wickets = 20;
        ptr[3].matches = 40;
        ptr[3].century = 4;
        ptr[3].half_century = 4;
        ptr[3].runs_conceded = 20;
        ptr[3].over_bowled = 8;
        ptr[3].outs = 4;
        ptr[3].dob.day = 4;
        ptr[3].dob.month = 4;
        ptr[3].dob.year = 1993;

        // Player 5: Rahul Dravid (index 4)
        ptr[4] = new Player();
        ptr[4].jno = 5;
        ptr[4].name = "Rahul Dravid";
        ptr[4].category = "Bowler";
        ptr[4].runs = 500;
        ptr[4].wickets = 25;
        ptr[4].matches = 50;
        ptr[4].century = 5;
        ptr[4].half_century = 5;
        ptr[4].runs_conceded = 25;
        ptr[4].over_bowled = 10;
        ptr[4].outs = 5;
        ptr[4].dob.day = 5;
        ptr[4].dob.month = 5;
        ptr[4].dob.year = 1994;

        // Player 6: Yuvraj Singh (index 5)
        ptr[5] = new Player();
        ptr[5].jno = 6;
        ptr[5].name = "Yuvraj Singh";
        ptr[5].category = "Batsman";
        ptr[5].runs = 600;
        ptr[5].wickets = 30;
        ptr[5].matches = 60;
        ptr[5].century = 6;
        ptr[5].half_century = 6;
        ptr[5].runs_conceded = 30;
        ptr[5].over_bowled = 12;
        ptr[5].outs = 6;
        ptr[5].dob.day = 6;
        ptr[5].dob.month = 6;
        ptr[5].dob.year = 1995;

        // Player 7: Suresh Raina (index 6)
        ptr[6] = new Player();
        ptr[6].jno = 7;
        ptr[6].name = "Suresh Raina";
        ptr[6].category = "All-Rounder";
        ptr[6].runs = 700;
        ptr[6].wickets = 35;
        ptr[6].matches = 70;
        ptr[6].century = 7;
        ptr[6].half_century = 7;
        ptr[6].runs_conceded = 35;
        ptr[6].over_bowled = 14;
        ptr[6].outs = 7;
        ptr[6].dob.day = 7;
        ptr[6].dob.month = 7;
        ptr[6].dob.year = 1996;

        // Player 8: Jasprit Bumrah (index 7)
        ptr[7] = new Player();
        ptr[7].jno = 8;
        ptr[7].name = "Jasprit Bumrah";
        ptr[7].category = "Bowler";
        ptr[7].runs = 800;
        ptr[7].wickets = 40;
        ptr[7].matches = 80;
        ptr[7].century = 8;
        ptr[7].half_century = 8;
        ptr[7].runs_conceded = 40;
        ptr[7].over_bowled = 16;
        ptr[7].outs = 8;
        ptr[7].dob.day = 8;
        ptr[7].dob.month = 8;
        ptr[7].dob.year = 1997;

        // Player 9: Hardik Pandya (index 8)
        ptr[8] = new Player();
        ptr[8].jno = 9;
        ptr[8].name = "Hardik Pandya";
        ptr[8].category = "Batsman";
        ptr[8].runs = 900;
        ptr[8].wickets = 45;
        ptr[8].matches = 90;
        ptr[8].century = 9;
        ptr[8].half_century = 9;
        ptr[8].runs_conceded = 45;
        ptr[8].over_bowled = 18;
        ptr[8].outs = 9;
        ptr[8].dob.day = 9;
        ptr[8].dob.month = 9;
        ptr[8].dob.year = 1998;

        // Player 10: KL Rahul (index 9)
        ptr[9] = new Player();
        ptr[9].jno = 10;
        ptr[9].name = "KL Rahul";
        ptr[9].category = "All-Rounder";
        ptr[9].runs = 1000;
        ptr[9].wickets = 50;
        ptr[9].matches = 100;
        ptr[9].century = 10;
        ptr[9].half_century = 10;
        ptr[9].runs_conceded = 50;
        ptr[9].over_bowled = 20;
        ptr[9].outs = 10;
        ptr[9].dob.day = 10;
        ptr[9].dob.month = 10;
        ptr[9].dob.year = 1999;
    }

    static void display(Player[] ptr) {

        for (int i = 0; i < playerCount; i++) {

            System.out.printf("\nPlayer %d", i + 1);
            System.out.printf("\nJersey No.: %d", ptr[i].jno);
            System.out.printf("  Name: %s", ptr[i].name);
            System.out.printf("\nCategory: %s", ptr[i].category);
            System.out.printf("  DOB: %d/%d/%d", ptr[i].dob.day, ptr[i].dob.month, ptr[i].dob.year);
            System.out.printf("  Matches: %d", ptr[i].matches);
            System.out.printf("  Runs: %d", ptr[i].runs);
            System.out.printf("  Centuries: %d", ptr[i].century);
            System.out.printf("  Half-Centuries: %d", ptr[i].half_century);
            System.out.printf("\nWickets: %d", ptr[i].wickets);
            System.out.printf("  Runs Conceded: %d", ptr[i].runs_conceded);
            System.out.printf("  Overs Bowled: %d", ptr[i].over_bowled);

            // Batsman Average
            if (ptr[i].outs > 0)
                System.out.printf("  Batting Average: %.2f", (float) ptr[i].runs / ptr[i].outs);
            else
                System.out.printf("  Batting Average: N/A");

            // Bowling Economy
            if (ptr[i].over_bowled > 0)
                System.out.printf("  Economy: %.2f", (float) ptr[i].runs_conceded / ptr[i].over_bowled);
            else
                System.out.printf("  Economy: N/A");
        }
    }

    static Player[] addNewPlayer(Player[] ptr) {

        // increase array size only if array is full
        if (playerCount == arraySize) {
            arraySize += 5;
            // logic to simulate realloc
            Player[] newPtr = new Player[arraySize];
            System.arraycopy(ptr, 0, newPtr, 0, ptr.length);
            ptr = newPtr;
        }

        System.out.println("Enter player details:");

        System.out.print("Jersey No.: ");
        // Initialize the new player object before assigning
        ptr[playerCount] = new Player();
        ptr[playerCount].jno = sc.nextInt();

        for (int i = 0; i < playerCount; i++) {
            if (ptr[i].jno == ptr[playerCount].jno) {
                System.out.println("Jersey No. already exists. Please enter a unique Jersey No.");
                return ptr;
            }
        }

        
        sc.nextLine();
        System.out.print("Name: ");
        ptr[playerCount].name = sc.nextLine();

        
        System.out.print("Category (Batsman/Bowler/All-Rounder): ");
        ptr[playerCount].category = sc.next();

        int d, m, y;
        System.out.print("DOB (dd mm yyyy): ");
        d = sc.nextInt();
        m = sc.nextInt();
        y = sc.nextInt();
        ptr[playerCount].dob.day = d;
        ptr[playerCount].dob.month = m;
        ptr[playerCount].dob.year = y;

        System.out.print("Matches: ");
        ptr[playerCount].matches = sc.nextInt();

        System.out.print("Runs: ");
        ptr[playerCount].runs = sc.nextInt();

        System.out.print("Wickets: ");
        ptr[playerCount].wickets = sc.nextInt();

        System.out.print("Centuries: ");
        ptr[playerCount].century = sc.nextInt();

        System.out.print("Half-Centuries: ");
        ptr[playerCount].half_century = sc.nextInt();

        System.out.print("Runs Conceded: ");
        ptr[playerCount].runs_conceded = sc.nextInt();

        System.out.print("Overs Bowled: ");
        ptr[playerCount].over_bowled = sc.nextInt();

        playerCount++;
        System.out.println("\nPlayer added successfully!");

        return ptr;
    }

    static void updateBowlingStats(Player[] ptr) {
        int jno;
        System.out.print("Enter Jersey No. of player to update bowling stats: ");
        jno = sc.nextInt();

        for (int i = 0; i < playerCount; i++) {
            if (ptr[i].jno == jno) {
                int wickets, runs_conceded, overs_bowled;
                System.out.println("Add new bowling stats for one match:");
                System.out.print("Wickets: ");
                wickets = sc.nextInt();
                System.out.print("Runs Conceded: ");
                runs_conceded = sc.nextInt();
                System.out.print("Overs Bowled: ");
                overs_bowled = sc.nextInt();

                ptr[i].matches += 1;
                ptr[i].wickets += wickets;
                ptr[i].runs_conceded += runs_conceded;
                ptr[i].over_bowled += overs_bowled;

                System.out.println("\nBowling stats updated successfully!");
                return;
            }
        }
        System.out.printf("\nPlayer with Jersey No. %d not found.", jno);
    }

    static void updateBattingStats(Player[] ptr) {
        int jno;
        System.out.print("Enter Jersey No. of player to update batting stats: ");
        jno = sc.nextInt();

        for (int i = 0; i < playerCount; i++) {
            if (ptr[i].jno == jno) {
                int runs, outs;
                System.out.println("Add new batting stats for one match:");
                System.out.print("Runs: ");
                runs = sc.nextInt();
                System.out.print("Outs: (0:No, 1:Yes)");
                outs = sc.nextInt();

                int century = runs / 100;
                int half_century = (runs % 100) / 50;

                // ptr[i].matches is missing in C input but incremented in logic, assume
                // matches=1 for "one match"
                ptr[i].matches += 1;
                ptr[i].runs += runs;
                ptr[i].outs += outs;
                ptr[i].century += century;
                ptr[i].half_century += half_century;

                System.out.println("\nBatting stats updated successfully!");
                return;
            }
        }
        System.out.printf("\nPlayer with Jersey No. %d not found.", jno);
    }

    static void updateBothStats(Player[] ptr) {
        int jno;
        System.out.print("Enter Jersey No. of player to update both stats: ");
        jno = sc.nextInt();

        for (int i = 0; i < playerCount; i++) {
            if (ptr[i].jno == jno) {
                int runs, outs, wickets, runs_conceded, overs_bowled;
                System.out.println("Add new stats for one match:");
                System.out.print("Runs: ");
                runs = sc.nextInt();
                System.out.print("Out(0: No, 1:Yes):");
                outs = sc.nextInt();
                System.out.print("Wickets: ");
                wickets = sc.nextInt();
                System.out.print("Runs Conceded: ");
                runs_conceded = sc.nextInt();
                System.out.print("Overs Bowled: ");
                overs_bowled = sc.nextInt();

                int century = runs / 100;
                int half_century = (runs % 100) / 50;

                ptr[i].matches += 1;
                ptr[i].runs += runs;
                ptr[i].outs += outs;
                ptr[i].century += century;
                ptr[i].half_century += half_century;
                ptr[i].wickets += wickets;
                ptr[i].runs_conceded += runs_conceded;
                ptr[i].over_bowled += overs_bowled;

                System.out.println("\nStats updated successfully!");
                return;
            }
        }
        System.out.printf("\nPlayer with Jersey No. %d not found.", jno);
    }

    static void updatePlayerName(Player[] ptr) {
        int jno;
        System.out.print("Enter Jersey No. of player to update Name: ");
        jno = sc.nextInt();

        for (int i = 0; i < playerCount; i++) {
            if (ptr[i].jno == jno) {
                String name;
                sc.nextLine();
                System.out.print("Enter new Name: ");
                name = sc.nextLine();
                ptr[i].name = name;

                System.out.println("\nName updated successfully!");
                return;
            }
        }
        System.out.printf("\nPlayer with Jersey No. %d not found.", jno);
    }

    static void updatePlayer(Player[] ptr) {

        int choice = 1;
        do {
            if (choice == 0)
                break;
            System.out.print("\n\nPress 0: Exit update submenu");
            System.out.print("\nEnter 1: to update bowling stats");
            System.out.print("\nEnter 2: to update batting stats");
            System.out.print("\nEnter 3: to update both stats");
            System.out.print("\nEnter 4: to update player name");

            System.out.print("\nEnter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    updateBowlingStats(ptr);
                    break;
                case 2:
                    updateBattingStats(ptr);
                    break;
                case 3:
                    updateBothStats(ptr);
                    break;
                case 4:
                    updatePlayerName(ptr);
                    break;
                default:
                    System.out.print(choice != 0 ? "\nWrong choice... \nEnter correct choice...\n\n" : "\nExited");
                    break;
            }

        } while (choice != 0);
    }

    static void searchByJno(Player[] ptr) {
        int jno;
        boolean found = false;
        System.out.print("Enter Jersey No. to search: ");
        jno = sc.nextInt();

        for (int i = 0; i < playerCount; i++) {
            if (ptr[i].jno == jno) {
                System.out.println("\nPlayer found:");
                System.out.printf("\nJersey No.: %d", ptr[i].jno);
                System.out.printf("  Name: %s", ptr[i].name);
                System.out.printf("\nCategory: %s", ptr[i].category);
                System.out.printf("  DOB: %d/%d/%d", ptr[i].dob.day, ptr[i].dob.month, ptr[i].dob.year);
                System.out.printf("  Matches: %d", ptr[i].matches);
                System.out.printf("  Runs: %d", ptr[i].runs);
                System.out.printf("  Centuries: %d", ptr[i].century);
                System.out.printf("  Half-Centuries: %d", ptr[i].half_century);
                System.out.printf("\nWickets: %d", ptr[i].wickets);
                System.out.printf("  Runs Conceded: %d", ptr[i].runs_conceded);
                System.out.printf("  Overs Bowled: %d", ptr[i].over_bowled);

                // Batsman Average
                if (ptr[i].outs > 0)
                    System.out.printf("  Batting Average: %.2f", (float) ptr[i].runs / ptr[i].outs);
                else
                    System.out.printf("  Batting Average: N/A");

                // Bowling Economy
                if (ptr[i].over_bowled > 0)
                    System.out.printf("  Economy: %.2f", (float) ptr[i].runs_conceded / ptr[i].over_bowled);
                else
                    System.out.printf("  Economy: N/A");

                found = true;
                break;
            }
        }
        if (!found) {
            System.out.printf("\nPlayer with Jersey No. %d not found.", jno);
        }
    }

    static void searchByName(Player[] ptr) {
        String name;
        boolean found = false;
        System.out.print("Enter Name to search: ");
        
        sc.nextLine();
        name = sc.nextLine();

        for (int i = 0; i < playerCount; i++) {
            if (ptr[i].name.equalsIgnoreCase(name)) {
                System.out.println("\nPlayer found:");
                System.out.printf("\nJersey No.: %d", ptr[i].jno);
                System.out.printf("  Name: %s", ptr[i].name);
                System.out.printf("\nCategory: %s", ptr[i].category);
                System.out.printf("  DOB: %d/%d/%d", ptr[i].dob.day, ptr[i].dob.month, ptr[i].dob.year);
                System.out.printf("  Matches: %d", ptr[i].matches);
                System.out.printf("  Runs: %d", ptr[i].runs);
                System.out.printf("  Centuries: %d", ptr[i].century);
                System.out.printf("  Half-Centuries: %d", ptr[i].half_century);
                System.out.printf("\nWickets: %d", ptr[i].wickets);
                System.out.printf("  Runs Conceded: %d", ptr[i].runs_conceded);
                System.out.printf("  Overs Bowled: %d", ptr[i].over_bowled);

                // Batsman Average
                if (ptr[i].outs > 0)
                    System.out.printf("  Batting Average: %.2f", (float) ptr[i].runs / ptr[i].outs);
                else
                    System.out.printf("  Batting Average: N/A");

                // Bowling Economy
                if (ptr[i].over_bowled > 0)
                    System.out.printf("  Economy: %.2f", (float) ptr[i].runs_conceded / ptr[i].over_bowled);
                else
                    System.out.printf("  Economy: N/A");

                found = true;
                break;
            }
        }
        if (!found) {
            System.out.printf("\nPlayer with Name %s not found.", name);
        }
    }

    static void searchPlayer(Player[] ptr) {
        int choice = 1;
        do {
            if (choice == 0)
                break;
            System.out.print("\n\nPress 0: Exit search submenu");
            System.out.print("\nEnter 1: to search by Jersey No.");
            System.out.print("\nEnter 2: to search by Name");

            System.out.print("\nEnter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    searchByJno(ptr);
                    break;
                case 2:
                    searchByName(ptr);
                    break;
                default:
                    System.out.print(choice != 0 ? "\nWrong choice... \nEnter correct choice...\n\n" : "\nExited");
                    break;
            }

        } while (choice != 0);
    }

    static void sortPlayerByRuns(Player[] ptr, int displayFlag, int ascending) {
        Player temp;
        for (int i = 0; i < playerCount - 1; i++) {
            for (int j = 0; j < playerCount - i - 1; j++) {
                if (ascending == 1 ? (ptr[j].runs > ptr[j + 1].runs) : (ptr[j].runs < ptr[j + 1].runs)) {
                    temp = ptr[j];
                    ptr[j] = ptr[j + 1];
                    ptr[j + 1] = temp;
                }
            }
        }
        System.out.printf("\nPlayers sorted by Runs in %s order:", ascending == 1 ? "ascending" : "descending");
        if (displayFlag == 1)
            display(ptr);
    }

    static void sortPlayerByWickets(Player[] ptr, int displayFlag, int ascending) {
        Player temp;
        for (int i = 0; i < playerCount - 1; i++) {
            for (int j = i; j < playerCount - i - 1; j++) {
                if (ascending == 1 ? (ptr[j].wickets > ptr[j + 1].wickets) : (ptr[j].wickets < ptr[j + 1].wickets)) {
                    temp = ptr[j];
                    ptr[j] = ptr[j + 1];
                    ptr[j + 1] = temp;
                }
            }
        }
        System.out.printf("\nPlayers sorted by Wickets in %s order:", ascending == 1 ? "ascending" : "descending");
        if (displayFlag == 1)
            display(ptr);
    }

    static void sortPlayer(Player[] ptr) {
        int choice = 1;
        do {
            if (choice == 0)
                break;
            System.out.print("\n\nPress 0: Exit sort submenu");
            System.out.print("\nEnter 1: sort by Runs (descending)");
            System.out.print("\nEnter 2: sort by Runs (ascending)");
            System.out.print("\nEnter 3: sort by Wickets (descending)");
            System.out.print("\nEnter 4: sort by Wickets (ascending)");

            System.out.print("\nEnter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sortPlayerByRuns(ptr, 1, 0);
                    break;
                case 2:
                    sortPlayerByRuns(ptr, 1, 1);
                    break;
                case 3:
                    sortPlayerByWickets(ptr, 1, 0);
                    break;
                case 4:
                    sortPlayerByWickets(ptr, 1, 1);
                    break;
                default:
                    System.out.print(choice != 0 ? "\nWrong choice... \nEnter correct choice...\n\n" : "\nExited");
                    break;
            }

        } while (choice != 0);
    }

    static void findTop3Batsmen(Player[] ptr) {
        sortPlayerByRuns(ptr, 0, 0);
        System.out.println("\nTop 3 Batsmen:");
        for (int i = 0; i < 3 && i < playerCount; i++) {
            System.out.printf("\n%d. %s - Runs: %d", i + 1, ptr[i].name, ptr[i].runs);
        }
    }

    static void findTop3Bowlers(Player[] ptr) {
        sortPlayerByWickets(ptr, 0, 0);
        System.out.println("\nTop 3 Bowlers:");
        for (int i = 0; i < 3 && i < playerCount; i++) {
            System.out.printf("\n%d. %s - Wickets: %d", i + 1, ptr[i].name, ptr[i].wickets);
        }
    }

    static void topThreePlayers(Player[] ptr) {
        int choice = 1;
        do {
            System.out.print("\n\nPress 0: Exit top three players submenu");
            System.out.print("\nEnter 1: Top 3 Batsmen");
            System.out.print("\nEnter 2: Top 3 Bowlers\n");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    findTop3Batsmen(ptr);
                    break;
                case 2:
                    findTop3Bowlers(ptr);
                    break;
                default:
                    System.out.print(choice != 0 ? "\nWrong choice... \nEnter correct choice...\n\n" : "\nExited");
                    break;
            }

        } while (choice != 0);
    }

    static void deleteByJno(Player[] ptr) {
        int jno;
        boolean found = false;
        System.out.print("Enter Jersey No. to delete: ");
        jno = sc.nextInt();

        for (int i = 0; i < playerCount; i++) {
            if (ptr[i].jno == jno) {
                for (int j = i; j < playerCount - 1; j++) {
                    ptr[j] = ptr[j + 1];
                }
                playerCount--;
                // Clean up last element (not strictly in C but good for Java)
                ptr[playerCount] = null;
                found = true;
                System.out.printf("\nPlayer with Jersey No. %d deleted successfully.", jno);
                break;
            }
        }
        if (!found) {
            System.out.printf("\nPlayer with Jersey No. %d not found.", jno);
        }
    }

    public static void main(String[] args) {

        Player[] ptr = new Player[arraySize];
        int choice = 1;
        defaultDataAdd(ptr);
        System.out.print("Players:");
        display(ptr);

        do {
            System.out.print("\n\nPress 0: Exit");
            System.out.print("\nPress 1: To display all player details");
            System.out.print("\nPress 2: To Add new player details");
            System.out.print("\nPress 3: To update player details");
            System.out.print("\nPress 4: To Find a player");
            System.out.print("\nPress 5: To Sort players");
            System.out.print("\nPress 6: To find top 3 players");
            System.out.print("\nPress 7: To delete player by Jersey No.");

            System.out.print("\n\nEnter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    display(ptr);
                    break;
                case 2:
                    ptr = addNewPlayer(ptr);
                    break;
                case 3:
                    updatePlayer(ptr);
                    break;
                case 4:
                    searchPlayer(ptr);
                    break;
                case 5:
                    sortPlayer(ptr);
                    break;
                case 6:
                    topThreePlayers(ptr);
                    break;
                case 7:
                    deleteByJno(ptr);
                    break;
                default:
                    System.out.print(choice != 0 ? "\nWrong choice... \nEnter correct choice...\n\n" : "\nExited");
                    break;
            }

        } while (choice != 0);
    }
}