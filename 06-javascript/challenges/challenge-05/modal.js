function createModal({ title, content, buttons }) {
    let overlay = document.createElement("div");
    overlay.className = "modal-overlay";

    let modal = document.createElement("div");
    modal.className = "modal";

    // Header
    let header = document.createElement("div");
    header.className = "modal-header";

    let h3 = document.createElement("h3");
    h3.textContent = title;

    let closeBtn = document.createElement("span");
    closeBtn.className = "close-btn";
    closeBtn.innerHTML = "✖";

    header.appendChild(h3);
    header.appendChild(closeBtn);

    // Content
    let body = document.createElement("div");
    body.innerHTML = `<p>${content}</p>`;

    // Footer
    let footer = document.createElement("div");
    footer.className = "modal-footer";

    buttons.forEach(btn => {
        let button = document.createElement("button");
        button.textContent = btn.text;
        button.className = btn.type;
        button.addEventListener("click", btn.onClick);
        footer.appendChild(button);
    });

    modal.append(header, body, footer);
    overlay.appendChild(modal);
    document.body.appendChild(overlay);

    function open() {
        overlay.classList.add("active");
        document.body.style.overflow = "hidden";
        document.addEventListener("keydown", escHandler);
    }

    function close() {
        overlay.classList.remove("active");
        document.body.style.overflow = "";
        document.removeEventListener("keydown", escHandler);
        setTimeout(() => overlay.remove(), 300);
    }

    function escHandler(e) {
        if (e.key === "Escape") close();
    }

    // Close actions
    closeBtn.addEventListener("click", close);
    overlay.addEventListener("click", e => {
        if (e.target === overlay) close();
    });

    return { open, close };
}

/* ---------- Example Usage ---------- */

const modal = createModal({
    title: 'Confirm Delete',
    content: 'Are you sure you want to delete this item?',
    buttons: [
        {
            text: 'Cancel',
            type: 'secondary',
            onClick: () => modal.close()
        },
        {
            text: 'Delete',
            type: 'danger',
            onClick: () => {
                alert("Deleted!");
                modal.close();
            }
        }
    ]
});

document.getElementById("openModalBtn").addEventListener("click", () => {
    modal.open();
});
