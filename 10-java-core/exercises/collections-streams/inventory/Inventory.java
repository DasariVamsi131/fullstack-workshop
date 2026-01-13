package inventory;

import java.util.*;
import java.util.stream.Collectors;

public class Inventory {

    private final List<Product> products = new ArrayList<>();
    private final Set<String> categories = new HashSet<>();
    private final Map<String, Product> productById = new HashMap<>();
    private final Queue<Product> lowStockAlerts = new LinkedList<>();

    public void addProduct(Product product) {
        if (product == null || product.getId() == null) return;

        if (productById.containsKey(product.getId())) {
            updateProduct(product.getId(), product);
            return;
        }

        products.add(product);
        productById.put(product.getId(), product);
        categories.add(product.getCategory());

        if (product.getQuantity() < 10) {
            lowStockAlerts.offer(product);
        }
    }

    public boolean updateProduct(String id, Product updated) {
        if (id == null || updated == null) return false;

        Product existing = productById.get(id);
        if (existing == null) return false;

        existing.setName(updated.getName());
        existing.setCategory(updated.getCategory());
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());

        categories.clear();
        categories.addAll(products.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet()));

        refreshLowStockQueue();
        return true;
    }

    public boolean deleteProduct(String id) {
        if (id == null) return false;

        Product removed = productById.remove(id);
        if (removed == null) return false;

        products.remove(removed);

        categories.clear();
        categories.addAll(products.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet()));

        refreshLowStockQueue();
        return true;
    }

    public Product getById(String id) {
        return productById.get(id);
    }

    public List<Product> getByCategory(String category) {
        if (category == null) return Collections.emptyList();

        return products.stream()
                .filter(p -> category.equalsIgnoreCase(p.getCategory()))
                .collect(Collectors.toList());
    }

    public List<Product> getAllSortedByPrice() {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }

    public Queue<Product> getLowStockAlerts() {
        refreshLowStockQueue();
        return new LinkedList<>(lowStockAlerts);
    }

    private void refreshLowStockQueue() {
        lowStockAlerts.clear();
        products.stream()
                .filter(p -> p.getQuantity() < 10)
                .forEach(lowStockAlerts::offer);
    }
}
