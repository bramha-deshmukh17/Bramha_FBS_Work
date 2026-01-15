const display = document.querySelector(".display")
const buttons = document.querySelectorAll(".btn")

let exp = ""

const isOperator = (ch) => ["+", "-", "÷", "*", "%"].includes(ch)

buttons.forEach((btn) => {
    btn.addEventListener("click", () => {
        const value= btn.innerText

        if (value=== "AC") {
            exp = ""
            display.value = ""
            return
        }

        if (value=== "C") {
            exp = exp.slice(0, -1)
            display.value = exp
            return
        }

        if (value=== "=") {
            const last = exp.at(-1)
            if (isOperator(last)) return
            try {
               
                exp = exp.replaceAll("÷", "/")
                exp = String(eval(exp)) 
                display.value = exp
            } catch (e) {
                display.value = "Error"
                exp = ""
            }
            return
        }

        // Prevent two consecutive operators: if last char is operator and user presses operator, ignore
        const last = exp.at(-1)
        if (isOperator(last) && isOperator(value)) return

        exp += value
        display.value = exp
    })
})
