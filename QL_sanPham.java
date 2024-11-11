import java.io.IOException;
import java.util.Scanner;

public class QL_sanPham {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        CN_sanPham quanLy = new CN_sanPham();
        String menu = "Menu.txt";

        try {
            quanLy.docFile(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String chonChucNang;

        do {
            System.out.println("QUAN LY SAN PHAM");
            System.out.println("1. Them san pham");
            System.out.println("2. Sua san pham");
            System.out.println("3. Xoa san pham");
            System.out.println("4. Tim kiem san pham");
            System.out.println("5. Xem danh sach san pham");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            chonChucNang = scanner.nextLine();

            switch (chonChucNang) {
                case "1":
                    quanLy.themSanPham(scanner); // Gọi phương thức thêm sản phẩm
                    break;
                case "2":
                    quanLy.suaSanPham(scanner); // Gọi phương thức sửa sản phẩm
                    break;
                case "3":
                    quanLy.xoaSanPham(scanner); // Gọi phương thức xóa sản phẩm
                    break;
                case "4":
                    quanLy.timSanPham(scanner); // Gọi phương thức tìm kiếm sản phẩm
                    break;
                case "5":
                    quanLy.xemSanPham(); // Gọi phương thức xem danh sách sản phẩm
                    break;
                case "0":
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
            System.out.println();
        } while (!chonChucNang.equals("0"));

        scanner.close();
    }
}
