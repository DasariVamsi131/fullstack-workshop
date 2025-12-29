let tasks = JSON.parse(localStorage.getItem("tasks")) || [];
let currentFilter = "All";

const taskInput = document.getElementById("taskInput");
const categorySelect = document.getElementById("categorySelect");
const taskList = document.getElementById("taskList");
const taskCounts = document.getElementById("taskCounts");
const addBtn = document.getElementById("addBtn");

// Add Task
addBtn.addEventListener("click", () => {
    const text = taskInput.value.trim();
    const category = categorySelect.value;

    if (text === "") return;

    const task = {
        id: Date.now(),
        text,
        category,
        completed: false
    };

    tasks.push(task);
    saveTasks();
    renderTasks();
    taskInput.value = "";
});

// Filter Buttons
document.querySelectorAll(".filters button").forEach(btn => {
    btn.addEventListener("click", () => {
        currentFilter = btn.dataset.filter;
        renderTasks();
    });
});

// Save to localStorage
function saveTasks() {
    localStorage.setItem("tasks", JSON.stringify(tasks));
}

// Render Tasks
function renderTasks() {
    taskList.innerHTML = "";

    let filteredTasks = tasks.filter(task => {
        return currentFilter === "All" || task.category === currentFilter;
    });

    filteredTasks.forEach(task => {
        const li = document.createElement("li");
        if (task.completed) li.classList.add("completed");

        li.innerHTML = `
            <div>
                <input type="checkbox" ${task.completed ? "checked" : ""}>
                <span class="task-text">${task.text}</span>
                <span class="category">${task.category}</span>
            </div>
            <span class="delete-btn">✖</span>
        `;

        // Toggle Complete
        li.querySelector("input").addEventListener("change", () => {
            task.completed = !task.completed;
            saveTasks();
            renderTasks();
        });

        // Delete Task
        li.querySelector(".delete-btn").addEventListener("click", () => {
            tasks = tasks.filter(t => t.id !== task.id);
            saveTasks();
            renderTasks();
        });

        taskList.appendChild(li);
    });

    updateCounts();
}

// Update Category Counts
function updateCounts() {
    const workCount = tasks.filter(t => t.category === "Work").length;
    const personalCount = tasks.filter(t => t.category === "Personal").length;

    taskCounts.innerHTML = `
        Work: ${workCount} tasks | Personal: ${personalCount} tasks
    `;
}

// Initial Render
renderTasks();
