import org.example.Product;

import java.util.*;

public class Main {
    static class InvalidProductException extends Exception {
        public InvalidProductException(String message) {
            super(message);
        }
    }

    static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(Product product) throws InvalidProductException {

        boolean exists = products.stream()
                .anyMatch(p -> p.getId() == product.getId());

        if (exists) {
            throw new InvalidProductException("ID đã tồn tại!");
        }

        products.add(product);
    }

    public static void displayProducts() {
        products.forEach(System.out::println);
    }

    public static void updateQuantity(int id, int newQuantity) throws InvalidProductException {

        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (product.isPresent()) {
            product.get().setQuantity(newQuantity);
        } else {
            throw new InvalidProductException("Không tìm thấy sản phẩm!");
        }
    }

    public static void removeOutOfStock() {
        products.removeIf(p -> p.getQuantity() == 0);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== PRODUCT MANAGEMENT =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Cập nhật số lượng");
            System.out.println("4. Xóa sản phẩm hết hàng");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");
            int choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Quantity: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Category: ");
                        String category = sc.nextLine();

                        addProduct(new Product(id, name, price, quantity, category));
                        System.out.println("Thêm thành công!");
                        break;

                    case 2:
                        displayProducts();
                        break;

                    case 3:
                        System.out.print("Nhập ID: ");
                        int updateId = sc.nextInt();

                        System.out.print("Quantity mới: ");
                        int newQuantity = sc.nextInt();

                        updateQuantity(updateId, newQuantity);
                        System.out.println("Cập nhật thành công!");
                        break;

                    case 4:
                        removeOutOfStock();
                        System.out.println("Đã xóa sản phẩm hết hàng!");
                        break;

                    case 5:
                        System.out.println("Thoát chương trình");
                        return;

                }

            } catch (InvalidProductException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
}