package inventory;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    void testExpectedUsage() {

        Inventory inventory = new Inventory();

        inventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 50));
        inventory.addProduct(new Product("P002", "Mouse", "Electronics", 29.99, 5));
        inventory.addProduct(new Product("P003", "Desk", "Furniture", 299.99, 15));

        // Get by category
        List<Product> electronics = inventory.getByCategory("Electronics");
        assertEquals(2, electronics.size());

        // Get sorted by price
        List<Product> sorted = inventory.getAllSortedByPrice();
        assertEquals(3, sorted.size());
        assertEquals("Mouse", sorted.get(0).getName());
        assertEquals("Desk", sorted.get(1).getName());
        assertEquals("Laptop", sorted.get(2).getName());

        // Get low stock alerts
        Queue<Product> lowStock = inventory.getLowStockAlerts();
        int count = 0;

        while (!lowStock.isEmpty()) {
            Product p = lowStock.poll();
            System.out.println("Low stock: " + p.getName());
            count++;
        }

        assertEquals(1, count);
    }
}
