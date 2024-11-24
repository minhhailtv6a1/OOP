import java.util.Scanner;

public class QL_SP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DS_SP quanLy = new DS_SP();

        // Đọc dữ liệu từ file khi khởi động chương trình
        quanLy.docFile();

        String chonChucNang;

        do {
            // Hiển thị menu lựa chọn
            System.out.println("========== QUAN LY SAN PHAM ==========");
            System.out.println("1. Them san pham");
            System.out.println("2. Sua san pham");
            System.out.println("3. Xoa san pham");
            System.out.println("4. Tim kiem san pham");
            System.out.println("5. Xem danh sach san pham");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            chonChucNang = scanner.nextLine(); // Đọc lựa chọn từ người dùng

            switch (chonChucNang) {
                case "1":
                        quanLy.nhap();// Thêm sản phẩm
                    break;

                case "2":
                        quanLy.sua();// Sửa sản phẩm
                    break;

                case "3":
                        quanLy.xoa(); // Xóa sản phẩm
                    break;

                case "4":
                        quanLy.timKiem();// Tìm sản phẩm
                    break;

                case "5":
                    quanLy.xuat(); // Xem danh sách sản phẩm
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
