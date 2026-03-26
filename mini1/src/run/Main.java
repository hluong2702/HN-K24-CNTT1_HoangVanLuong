package run;

import exception.InvalidProductException;
import model.Product;
import service.ProductManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidProductException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            int findId;
            System.out.println("========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm đã hết hàng");
            System.out.println("5. Thoát chương trìrình");
            System.out.println("=============================================");
            System.out.println("Lựa chọn của bạn : ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập id : ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên : ");
                    String name = sc.nextLine().trim();
                    System.out.print("Nhập giá : ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập số lượng : ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập danh mục : ");
                    String category = sc.nextLine().trim();

                    ProductManagement.create(new Product(id,name,price,quantity,category));
                    break;
                case 2:
                    ProductManagement.read();
                    break;
                case 3:
                    System.out.print("Nhập id : ");
                    findId = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập số lượng : ");
                    int quantity2 = Integer.parseInt(sc.nextLine());
                    ProductManagement.update(findId,quantity2);
                    break;
                case 4:
                    ProductManagement.delete();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không phù hợp!");
                    break;
            }
        }while(choice != 5);
    }
}
