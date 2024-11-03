
import java.io.IOException;
import java.util.Scanner;

public class QL_sanPham {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CN_sanPham quanLy = new CN_sanPham();
        String menu = "Menu.txt";
        try {
            quanLy.docFile(menu);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        int chonChucNang = -1; // Khởi tạo giá trị không hợp lệ

        do {
            
        while (true) {
            // Hiển thị menu
            System.out.println("QUAN LY SAN PHAM");
            System.out.println("1. Them san pham");
            System.out.println("2. Sua san pham");
            System.out.println("3. Xoa san pham");
            System.out.println("4. Tim kiem san pham");
            System.out.println("5. Xem danh sach san pham");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            
            // Kiểm tra nếu người dùng nhập đúng kiểu số nguyên
            if (scanner.hasNextInt()) {
                chonChucNang = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng thừa sau số
                
                // Xử lý theo lựa chọn
                if (chonChucNang >= 0 && chonChucNang <= 5) {
                    break; // Thoát vòng lặp nếu nhập đúng
                } else {
                    System.out.println("Lua chon khong hop le! Vui long chon tu 0 den 5.");
                }
            } else {
                System.out.println("Nhap khong hop le! Chi duoc nhap so.");
                scanner.nextLine(); // Đọc bỏ đầu vào không hợp lệ
            }
        }

            switch (chonChucNang) {
                case 1: //Them san pham moi
                int loaisp = -1; // Khởi tạo giá trị không hợp lệ

                      // Vòng lặp để đảm bảo nhập đúng
                    while (true) {
                     System.out.println("Ban muon them do an hay thuc uong?");
                     System.out.println("1. Do an");
                     System.out.println("2. Thuc uong");
                    System.out.print("Nhap lua chon: ");
            
                     // Kiểm tra nếu người dùng nhập đúng kiểu số nguyên
                    if (scanner.hasNextInt()) {
                         loaisp = scanner.nextInt();
                        scanner.nextLine(); // Đọc bỏ dòng thừa

                        // Kiểm tra xem loaisp có phải 1 hoặc 2 không
                    if (loaisp == 1 || loaisp == 2) {
                      break; // Thoát vòng lặp nếu nhập đúng
                    } else {
                        System.out.println("Lua chon khong hop le! Vui long chon lai.");
                            }
                    } else {
                        System.out.println("Nhap khong hop le! Chi duoc nhap so.");
                         scanner.nextLine(); // Đọc bỏ đầu vào không hợp lệ
                    }
                    }

                     // Tiếp tục xử lý thêm sản phẩm dựa trên lựa chọn
                    if (loaisp == 1) {
                    System.out.println("Ban da chon Do an.");
                      // Xử lý logic cho thêm đồ ăn ở đây
                     } else {
                    System.out.println("Ban da chon Thuc uong.");
                    // Xử lý logic cho thêm thức uống ở đây
                    }
                    sanPham sp= null;
                     if (loaisp == 1) { //Neu chon Do an
                    System.out.print("Nhap ten san pham: ");
                    String ten = scanner.nextLine();
                    
                    System.out.print("Nhap gia san pham: ");
                    String gia = scanner.nextLine();
                    System.out.print("Nhap loai do an: ");
                    String loai = scanner.nextLine();
                    
                    sp = new doAn(ten, gia, loai);
                    System.out.println("Da them san pham thanh cong!");
                    
                    } else if (loaisp == 2) { // Nếu chọn đồ uống
                    System.out.print("Nhap ten san pham: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhap gia san pham: ");
                    String gia = scanner.nextLine();
                    System.out.print("Nhap size (S, M, L, XL): ");
                    String size = scanner.nextLine();
                    
                    sp = new thucUong(ten, gia, size);
                    
                    }
                    quanLy.themSanPham(sp);
                    System.out.println("Da them san pham thanh cong!");
                    try {
                        quanLy.ghiFile(menu);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                

                case 2: // Sửa sản phẩm
                    int idSua = -1; // Khởi tạo biến với giá trị không hợp lệ
                    System.out.print("Nhap ID san pham can sua: ");
                    while (true) {
                        if (scanner.hasNextInt()) { // Kiểm tra xem người dùng có nhập số nguyên hay không
                        idSua = scanner.nextInt();
                        scanner.nextLine(); // Đọc bỏ dòng thừa
                        break; // Thoát khỏi vòng lặp nếu nhập hợp lệ
                     } else {
                        System.out.print("Nhap khong hop le! Chi duoc nhap so. Vui long nhap lai ID san pham: ");
                        scanner.nextLine(); // Đọc bỏ đầu vào không hợp lệ
                        }
                    }
                    sanPham spSua = quanLy.timKiemSanPham(idSua);
                    if (spSua != null) {
                    spSua.hienThiThongTin();
                    System.out.print("Nhap ten moi: ");
                    String tenMoi = scanner.nextLine();
                    System.out.print("Nhap gia moi: ");
                    String giaMoi = scanner.nextLine();
                    quanLy.suaSanPham(idSua, tenMoi, giaMoi);
                    try {
                        quanLy.ghiFile(menu);
                        } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        }
                    }
                    break;

                case 3: // Xóa sản phẩm
                     int idXoa = -1; // Khởi tạo biến với giá trị không hợp lệ
                     System.out.print("Nhap ID san pham can xoa: ");
                    while (true) {
                     if (scanner.hasNextInt()) { // Kiểm tra xem người dùng có nhập số nguyên hay không
                        idXoa = scanner.nextInt();
                        scanner.nextLine(); // Đọc bỏ dòng thừa
                        break; // Thoát khỏi vòng lặp nếu nhập hợp lệ
                     } else {
                        System.out.print("Nhap khong hop le! Chi duoc nhap so. Vui long nhap lai ID san pham: ");
                        scanner.nextLine(); // Đọc bỏ đầu vào không hợp lệ
                        }
                    }
                    sanPham spXoa = quanLy.timKiemSanPham(idXoa);
                    if (spXoa != null) {
                        spXoa.hienThiThongTin();
    
                    System.out.println("Ban chac chan muon xoa san pham nay? ");
                    System.out.println("1.Tiep tuc xoa.");
                    System.out.println("2.Huy xoa.");
                    System.out.print("Nhap lua chon: ");
                    int chosse = scanner.nextInt();
                    while( chosse !=1 && chosse !=2){
                        System.out.println("Vui long chon lai!");
                        System.out.println("1.Tiep tuc xoa.");
                        System.out.println("2.Huy xoa.");
                        System.out.print("Nhap lua chon: ");
                        chosse = scanner.nextInt();
                    }
                    if (chosse == 1)
                        quanLy.xoaSanPham(idXoa);
                    else break;
                    }
                    break;

                case 4: // Tìm kiếm sản phẩm
                    int idTim = -1; // Khởi tạo biến với giá trị không hợp lệ
                    System.out.print("Nhap ID san pham can tim: ");
                    while (true) {
                        if (scanner.hasNextInt()) { // Kiểm tra xem người dùng có nhập số nguyên hay không
                        idTim = scanner.nextInt();
                        scanner.nextLine(); // Đọc bỏ dòng thừa
                        break; // Thoát khỏi vòng lặp nếu nhập hợp lệ
                        } else {
                        System.out.print("Nhap khong hop le! Chi duoc nhap so. Vui long nhap lai ID san pham: ");
                        scanner.nextLine(); // Đọc bỏ đầu vào không hợp lệ
                        }
                    }
                    sanPham spTim = quanLy.timKiemSanPham(idTim);
                    if (spTim != null) {
                        spTim.hienThiThongTin();
                    }
                    break;

                case 5: // Xem danh sách sản phẩm (Menu)
                    quanLy.xemSanPham();
                    break;

                case 0: // Thoát
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
            System.out.println();
        } while (chonChucNang !=0);

        scanner.close();
     }
  }

