let studentId = null;
let monthlyBudget = 0;


// Add Student
async function addStudent() {

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const budget = Number(document.getElementById("budget").value);

    if (!name || !email || !budget) {
        document.getElementById("studentMessage").innerText =
            "Please fill all student details.";
        return;
    }

    const response = await fetch("/api/students", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: name,
            email: email,
            monthlyBudget: budget
        })
    });

    const student = await response.json();

    studentId = student.id;
    monthlyBudget = student.monthlyBudget;

    document.getElementById("displayBudget").innerText =
        monthlyBudget;

    document.getElementById("studentMessage").innerText =
        "Student added successfully!";

    loadExpenses();
}


// Add Expense
async function addExpense() {

    if (studentId === null) {
        document.getElementById("expenseMessage").innerText =
            "Please add a student first.";
        return;
    }

    const amount = Number(document.getElementById("amount").value);
    const category = document.getElementById("category").value;
    const description = document.getElementById("description").value;
    const expenseDate = document.getElementById("expenseDate").value;

    if (!amount || !category || !description || !expenseDate) {
        document.getElementById("expenseMessage").innerText =
            "Please fill all expense details.";
        return;
    }

    const response = await fetch("/api/expenses", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            amount: amount,
            category: category,
            description: description,
            expenseDate: expenseDate,
            studentId: studentId
        })
    });

    await response.json();

    document.getElementById("expenseMessage").innerText =
        "Expense added successfully!";

    document.getElementById("amount").value = "";
    document.getElementById("category").value = "";
    document.getElementById("description").value = "";
    document.getElementById("expenseDate").value = "";

    loadExpenses();
}


// Load Expenses
async function loadExpenses() {

    if (studentId === null) {
        return;
    }

    const response = await fetch(
        `/api/expenses/student/${studentId}`
    );

    const expenses = await response.json();

    let total = 0;

    const table = document.getElementById("expenseTable");

    table.innerHTML = "";

    expenses.forEach(expense => {

        total += expense.amount;

        const row = document.createElement("tr");

        row.innerHTML = `
            <td>₹${expense.amount}</td>
            <td>${expense.category}</td>
            <td>${expense.description}</td>
            <td>${expense.expenseDate}</td>
        `;

        table.appendChild(row);
    });

    document.getElementById("totalSpent").innerText = total;

    const remaining = monthlyBudget - total;

    document.getElementById("remaining").innerText =
        remaining;

    getAdvice(total);
}


// Get Budget Advice
async function getAdvice(spent) {

    const response = await fetch(
        `/api/advisor?budget=${monthlyBudget}&spent=${spent}`
    );

    const advice = await response.text();

    document.getElementById("advice").innerText =
        advice;
}