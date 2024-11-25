import java.io.*;
import java.util.*;

public class DS_SP {
    private List<sanPham> danhSachSanPham;

    public DS_SP() {
        danhSachSanPham = new ArrayList<>();
    }

    // Đọc dữ liệu từ file
    public void docFile() {
        try {
            BufferedReader f = new BufferedReader(new FileReader("sanPham.txt"));
            String line = "";
            // System.out.println(n);
            danhSachSanPham.clear();
            while (true) {
                line = f.readLine();
                if (line == null)
                    break;
                String[] a = line.split(",");
                if (a.length == 5) {
                    doAn tmp = new doAn();
                    tmp.setMaSP(a[0]);
                    tmp.setTenSP(a[1]);
                    tmp.setGiaSP(Double.parseDouble(a[2]));
                    tmp.setNguyenLieu(a[3]);
                    tmp.setLoaiDoAn(a[4]);
                    danhSachSanPham.add(tmp);
                } else if (a.length == 6) {
                    thucUong tmp = new thucUong();
                    tmp.setMaSP(a[0]);
                    tmp.setTenSP(a[1]);
                    tmp.setGiaSP(Double.parseDouble(a[2]));
                    tmp.setSize(a[3]);
                    tmp.setLuongDa(Float.parseFloat(a[4]));
                    tmp.setNongDoDuong(Float.parseFloat(a[5]));
                    danhSachSanPham.add(tmp);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Ghi dữ liệu vào file
    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("sanPham.txt"))) {
            for (sanPham sp : danhSachSanPham) {
                writer.println(sp.toString());
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    // Nhập nhiều sản phẩm
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong san pham muon them: ");
        int soLuong = Integer.parseInt(sc.nextLine()); // Đọc số lượng sản phẩm từ người dùng

        for (int i = 0; i < soLuong; i++) {
            sanPham sp;
            System.out.println("Nhap san pham thu " + (i + 1) + ": ");
            System.out.print("Nhap loai san pham (1: Do an, 2: Thuc uong): ");
            int loai = Integer.parseInt(sc.nextLine());

            if (loai == 1) {
                sp = new doAn(); // Tạo đối tượng doAn
            } else if (loai == 2) {
                sp = new thucUong(); // Tạo đối tượng thucUong
            } else {
                System.out.println("Loai san pham khong hop le! Vui long chon lai.");
                i--; // Giảm chỉ số để không tăng số lượng sản phẩm nếu loại không hợp lệ
                continue; // Bỏ qua vòng lặp này
            }

            sp.nhap(); // Nhập thông tin sản phẩm
            danhSachSanPham.add(sp); // Thêm sản phẩm vào danh sách
            System.out.println("San pham da duoc them thanh cong!");
        }
             // Ghi dữ liệu vào file sau khi nhập
             ghiFile();
    }

    // Xuất danh sách sản phẩm
    public void xuat() {
        for (sanPham sp : danhSachSanPham) {
            sp.xuat();
            System.out.println("-----------------------------");
        }
    }


    //Thêm mới sản phẩm
    public void them() {
        Scanner sc = new Scanner(System.in);
    sanPham sp;
    int loai = 0;

    System.out.println("Nhap thong tin san pham muon them: ");

    // Vòng lặp để bắt người dùng nhập đúng lựa chọn
    do {
        System.out.print("Nhap loai san pham (1: Do an, 2: Thuc uong): ");
        try {
            loai = Integer.parseInt(sc.nextLine());
            if (loai != 1 && loai != 2) {
                System.out.println("Lua chon khong hop le. Vui long nhap 1 hoac 2.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen (1 hoac 2).");
        }
    } while (loai != 1 && loai != 2);

    // Tạo đối tượng sản phẩm dựa trên lựa chọn
    if (loai == 1) {
        sp = new doAn(); // Tạo đối tượng doAn
    } else {
        sp = new thucUong(); // Tạo đối tượng thucUong
    }

    // Nhập thông tin chi tiết cho sản phẩm
    sp.nhap();
    danhSachSanPham.add(sp); // Thêm sản phẩm vào danh sách
    System.out.println("San pham da duoc them thanh cong!");

    // Ghi dữ liệu vào file sau khi thêm
    ghiFile();
    }
    

    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID san pham can sua: ");
        String id = sc.nextLine();
        for (sanPham sp : danhSachSanPham) {
            if (sp.getMaSP().equals(id)) {
                System.out.println("Thong tin san pham hien tai:");
                sp.xuat();

                // Menu cho phép người dùng chọn thuộc tính để sửa
                System.out.println("Chon thuoc tinh de sua:");
                System.out.println("1. Ten san pham");
                System.out.println("2. Gia san pham");
                System.out.println("3. Nguyen lieu (neu la doAn)");
                System.out.println("4. Loai do an (neu la doAn)");
                System.out.println("5. Size (neu la thucUong)");
                System.out.println("6. Luong da (neu la thucUong)");
                System.out.println("7. Nong do duong (neu la thucUong)");
                System.out.println("8. Sua tat ca thong tin");
                System.out.print("Nhap lua chon (1-8): ");
                int choice = sc.nextInt();
                sc.nextLine(); // Đọc dòng mới

                switch (choice) {
                    case 1:
                        System.out.print("Nhap ten san pham moi: ");
                        String newName = sc.nextLine();
                        sp.setTenSP(newName);
                        break;
                    case 2:
                        System.out.print("Nhap gia san pham moi: ");
                        double newPrice = sc.nextDouble();
                        sp.setGiaSP(newPrice);
                        break;
                    case 3:
                        if (sp instanceof doAn) {
                            System.out.print("Nhap nguyen lieu moi: ");
                            String newIngredient = sc.nextLine();
                            ((doAn) sp).setNguyenLieu(newIngredient);
                        } else {
                            System.out.println("San pham khong phai la doAn.");
                        }
                        break;
                    case 4:
                        if (sp instanceof doAn) {
                            System.out.print("Nhap loai do an moi: ");
                            String newType = sc.nextLine();
                            ((doAn) sp).setLoaiDoAn(newType);
                        } else {
                            System.out.println("San pham khong phai la doAn.");
                        }
                        break;
                    case 5:
                        if (sp instanceof thucUong) {
                            System.out.print("Nhap size moi: ");
                            String newSize = sc.nextLine();
                            ((thucUong) sp).setSize(newSize);
                        } else {
                            System.out.println("San pham khong phai la thucUong.");
                        }
                        break;
                    case 6:
                        if (sp instanceof thucUong) {
                            System.out.print("Nhap luong da moi: ");
                            float newIceAmount = sc.nextFloat();
                            ((thucUong) sp).setLuongDa(newIceAmount);
                        } else {
                            System.out.println("San pham khong phai la thucUong.");
                        }
                        break;
                    case 7:
                        if (sp instanceof thucUong) {
                            System.out.print("Nhap nong do duong moi: ");
                            float newSugarContent = sc.nextFloat();
                            ((thucUong) sp).setNongDoDuong(newSugarContent);
                        } else {
                            System.out.println("San pham khong phai la thucUong.");
                        }
                        break;
                    case 8: // Tùy chọn sửa tất cả
                        System.out.println("Nhap thong tin moi:");
                        sp.nhap();
                        break;
                    default:
                        System.out.println("Lua chon khong hop le.");
                        return; // Thoát nếu lựa chọn không hợp lệ
                }
                    // Ghi dữ liệu vào file sau khi sửa
                    ghiFile();

            } 
        }
        
    }


    // Xóa sản phẩm
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID san pham can xoa: ");
        String id = sc.nextLine();
        
        for (int i = 0; i < danhSachSanPham.size(); i++) {
            if (danhSachSanPham.get(i).getMaSP().equals(id)) {
                // Xuất thông tin sản phẩm
                System.out.println("Thong tin san pham can xoa:");
                danhSachSanPham.get(i).xuat(); // Gọi phương thức xuat() của sản phẩm
                
                // Hỏi người dùng có chắc chắn muốn xóa không
                System.out.print("Ban co chac chan muon xoa san pham nay? (Nhap 1 de xoa, 2 de huy): ");
                int choice = sc.nextInt();
                if (choice == 1) {
                    danhSachSanPham.remove(i);
                    System.out.println("San pham da duoc xoa thanh cong!");
                    // Ghi dữ liệu vào file sau khi xóa
                ghiFile();
                } else if (choice == 2) {
                    System.out.println("Hanh dong xoa da bi huy!");
                } else {
                    System.out.println("Lua chon khong hop le! Hanh dong xoa da bi huy.");
                }
                return;
            }
        }
        System.out.println("Khong tim thay san pham voi ID: " + id);
    }


    // Tìm kiếm sản phẩm
    public void timKiem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID san pham can tim: ");
        String id = sc.nextLine();
        for (sanPham sp : danhSachSanPham) {
            if (sp.getMaSP().equals(id)) {
                sp.xuat();
                return;
            }
        }
        System.out.println("Khong tim thay san pham voi ID: " + id);
    }

}
