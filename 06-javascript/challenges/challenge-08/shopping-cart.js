function createShoppingCart() {
    let items = [];
    let discount = 0; // percentage

    function findItem(id) {
        return items.find(item => item.id === id);
    }

    return {
        addItem(product) {
            const existingItem = findItem(product.id);

            if (existingItem) {
                existingItem.quantity += product.quantity;
            } else {
                items.push({ ...product });
            }
        },

        removeItem(id) {
            items = items.filter(item => item.id !== id);
        },

        updateQuantity(id, quantity) {
            const item = findItem(id);
            if (item) {
                item.quantity = quantity;
            }
        },

        getItems() {
            return items.map(item => ({ ...item }));
        },

        getTotal() {
            const total = items.reduce(
                (sum, item) => sum + item.price * item.quantity,
                0
            );

            const discountedTotal = total - (total * discount) / 100;
            return Number(discountedTotal.toFixed(2));
        },

        getItemCount() {
            return items.reduce((count, item) => count + item.quantity, 0);
        },

        isEmpty() {
            return items.length === 0;
        },

        applyDiscount(code, percentage) {
            // simple validation
            if (percentage > 0 && percentage <= 100) {
                discount = percentage;
            }
        },

        clear() {
            items = [];
            discount = 0;
        }
    };
}

/* ---------- Usage Example ---------- */

const cart = createShoppingCart();

cart.addItem({ id: 1, name: 'Laptop', price: 999, quantity: 1 });
cart.addItem({ id: 2, name: 'Mouse', price: 29, quantity: 2 });
cart.addItem({ id: 1, name: 'Laptop', price: 999, quantity: 1 });

console.log(cart.getItems());
// [
//   { id: 1, name: 'Laptop', price: 999, quantity: 2 },
//   { id: 2, name: 'Mouse', price: 29, quantity: 2 }
// ]

cart.updateQuantity(1, 3);
cart.removeItem(2);

console.log(cart.getTotal());      // 2997
console.log(cart.getItemCount());  // 3
console.log(cart.isEmpty());       // false

cart.applyDiscount('SAVE10', 10);
console.log(cart.getTotal());      // 2697.30

cart.clear();
console.log(cart.isEmpty());       // true
