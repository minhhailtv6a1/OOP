import java.util.Scanner;

public class QL_SP {
    
    public void menu() {
       
        Scanner scanner = new Scanner(System.in);
        DS_SP quanLy = new DS_SP();
        quanLy.docFile();// Đọc dữ liệu từ file khi khởi động chương trình

        String chonChucNang;

        do {
            // Hiển thị menu lựa chọn
            System.out.println("========== QUAN LY SAN PHAM ==========");
            System.out.println("1. Nhap danh sach san pham");
            System.out.println("2. Xuat danh sach san pham");
            System.out.println("3. Them san pham");
            System.out.println("4. Sua san pham");
            System.out.println("5. Xoa san pham");
            System.out.println("6. Tim kiem san pham");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            chonChucNang = scanner.nextLine(); // Đọc lựa chọn từ người dùng

            switch (chonChucNang) {
                case "1":
                        quanLy.nhap();// Nhập danh sách sản phẩm
                    break;

                case "2":
                        quanLy.xuat();// Xem danh sách sản phẩm
                    break;

                case "3":
                        quanLy.them(); //Thêm mới sản phẩm
                    break;

                case "4":
                        quanLy.sua();   // Sửa sản phẩm
                    break;

                case "5":
                    quanLy.xoa(); // Xóa sản phẩm
                    break;
                    
                case "6":
                    quanLy.timKiem();// Tìm sản phẩm
                    break;

                case "0":
                    System.out.println("Thoat.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }

            System.out.println();
        } while (!chonChucNang.equals("0"));

        scanner.close();
    }
}
