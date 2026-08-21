package inventoryproductcatalog;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InventoryService service = new InventoryService();

        while (true) {

            System.out.println();
            System.out.println("================================");
            System.out.println("      INVENTORY MANAGEMENT");
            System.out.println("================================");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Find Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Remove Products Below Price");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = readInt(scanner);

            switch (choice) {

                case 1:
                    addProduct(scanner, service);
                    break;

                case 2:
                    service.displayProducts();
                    break;

                case 3:
                    findProduct(scanner, service);
                    break;

                case 4:
                    updateProduct(scanner, service);
                    break;

                case 5:
                    deleteProduct(scanner, service);
                    break;

                case 6:
                    removeProductsBelowPrice(scanner, service);
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Enter a valid choice.");
            }
        }
    }
    private static int readInt(Scanner scanner){
        while (true){
            try{
                return  scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid number:");
                scanner.nextLine();
            }
        }
    }
    private static double readDouble(Scanner scanner){
        while (true){
            try{
                return scanner.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("please enter a valid price");
                scanner.nextLine();
            }
        }
    }
    private static  void addProduct(Scanner scanner , InventoryService service){
        scanner.nextLine();
        System.out.println("Enter product Id :");
        int id  = readInt(scanner);
        scanner.nextLine();

        System.out.println("Enter product Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter product Category");
        String category = scanner.nextLine();

        System.out.println("Enter Product Price: ");
        double price = readDouble(scanner);

        Product product = new Product(id,name,category,price);
        boolean added = service.addProduct(product);

        if(added){
            System.out.println("Product added Successfully");
        }else{
            System.out.println("Product Id already exists");
        }
    }
    private  static void findProduct(Scanner scanner , InventoryService service){
        scanner.nextLine();
        System.out.println("Enter the Product Id : ");
        int productId = readInt(scanner);

        Product product = service.findProductById(productId);
        if(product==null){
            System.out.println("Product not found");
        }else{
            System.out.println("product found");
            System.out.println(product);
        }
    }
    private static void updateProduct(Scanner scanner , InventoryService service){
        scanner.nextLine();
        System.out.println("Enter product Id : ");
        int productId = readInt(scanner);

        scanner.nextLine();

        Product existingProduct = service.findProductById(productId);

        if(existingProduct==null){
            System.out.println("prodcut not found:");
            return;
        }
        else{
            System.out.println("Entrer new product Name: ");
            String name = scanner.nextLine();

            System.out.println("Enter new product Category: ");
            String category = scanner.nextLine();

            System.out.println("Enter new product price: ");
            double price = readDouble(scanner);

            boolean update = service.updateProduct(productId,name,category,price);
            if(update){
                System.out.println("product updated successfully");
            }else{
                System.out.println("product could not be updated");
            }
        }
    }
    private  static void deleteProduct(Scanner scanner , InventoryService service){
        scanner.nextLine();
        System.out.println("Enter product Id: ");
        int productId = readInt(scanner);

        boolean removed = service.removeProduct(productId);
        if(removed){
            System.out.println("Product removed successfully");
        }else{
            System.out.println("product not found");
        }
    }
    private  static  void removeProductsBelowPrice(Scanner scanner , InventoryService service){
        scanner.nextLine();
        System.out.println("Remove product below price: ");
        double price = readDouble(scanner);
        service.removeProductBelowPrice(price);
        System.out.println("Product below ₹" + price + " have been removed.");
    }
}