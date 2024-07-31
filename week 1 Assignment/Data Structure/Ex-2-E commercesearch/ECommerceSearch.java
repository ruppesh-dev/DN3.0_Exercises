package onlineStore.search;

public class ECommerceSearch {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Shirt", "Clothing"),
            new Product(4, "Shoes", "Footwear")
        };

        
        Product foundProduct = LinearSearch.linearSearch(products, "Smartphone");
        System.out.println("Linear Search Result: " + (foundProduct != null ? foundProduct : "Product not found"));

        
        foundProduct = BinarySearch.binarySearch(products, "Smartphone");
        System.out.println("Binary Search Result: " + (foundProduct != null ? foundProduct : "Product not found"));
    }
}


