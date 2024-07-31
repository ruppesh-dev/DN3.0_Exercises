package warehouseManagement;

import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update an existing product
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    // Display all products
    public void displayProducts() {
        System.out.println("Current Inventory:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        // Add some products
        ims.addProduct(new Product("P001", "Laptop", 10, 999.99));
        ims.addProduct(new Product("P002", "Smartphone", 20, 599.99));
        
        // Update a product
        ims.updateProduct(new Product("P001", "Laptop", 15, 949.99));
        
        // Delete a product
        ims.deleteProduct("P002");
        
        // Display all products
        ims.displayProducts();
    }
}
