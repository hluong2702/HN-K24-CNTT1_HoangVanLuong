package service;

import exception.InvalidProductException;
import model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductManagement {
    public static ArrayList<Product> products = new ArrayList<>();

    public static Product findProductById(int id){
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static void create(Product product) throws InvalidProductException {
        if(findProductById(product.getId()) != null){
            throw new InvalidProductException("Trùng Id");
        }
        products.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    public static void update(int id, int quantity) throws InvalidProductException {
        if(products.isEmpty()){
            System.out.println("Danh sách rỗng!");
            return;
        }
        Product found = findProductById(id);
        if(found == null){
            throw new InvalidProductException("Không tìm thấy sản phẩm!");
        }

        if(quantity < 0){
            System.out.println("Số lượng không phù hợp!");
            return;
        }
        found.setQuantity(quantity);
        System.out.println("Cập nhật số lượng thành công!");
    }

    public static void read(){
        if(products.isEmpty()){
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.println("+-------------------------------------------------+");
        System.out.printf("|%-5s|%-15s|%-10s|%-5s|%-10s|\n", "ID", "Name", "Price", "Qty", "Category");
        System.out.println("+-------------------------------------------------+");
        for(Product product : products){
            System.out.println(product.toString());
            System.out.println("+-------------------------------------------------+");
        }
    }

    public static void delete(){
        if(products.isEmpty()){
            System.out.println("Danh sách rỗng!");
            return;
        }
        products.removeIf(product -> product.getQuantity() == 0);
        System.out.println("Đã xoá những sản phẩm có quantity = 0");
    }
}
