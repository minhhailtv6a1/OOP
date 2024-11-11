import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CN_sanPham {
    private List<sanPham> danhSachSanPham;
    String menu = "Menu.txt";

    public CN_sanPham() {
        danhSachSanPham = new ArrayList<>();
    }

    public void themSanPham(Scanner scanner) throws IOException {
        System.out.print("Nhap so luong san pham can them: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhap thong tin cho san pham " + (i + 1) + ":");
            int loaisp = -1;

            while (true) {
                System.out.println("Ban muon them do an hay thuc uong?");
                System.out.println("1. Do an");
                System.out.println("2. Thuc uong");
                System.out.print("Nhap lua chon: ");

                if (scanner.hasNextInt()) {
                    loaisp = scanner.nextInt();
                    scanner.nextLine();

                    if (loaisp == 1 || loaisp == 2) {
                        break;
                    } else {
                        System.out.println("Lua chon khong hop le! Vui long chon lai.");
                    }
                } else {
                    System.out.println("Nhap khong hop le! Chi duoc nhap so.");
                    scanner.nextLine();
                }
            }

            sanPham sp = null;
            if (loaisp == 1) {
                System.out.println("Ban da chon Do an.");
                sp = nhapThongTinDoAn(scanner);
            } else if (loaisp == 2) {
                System.out.println("Ban da chon Thuc uong.");
                sp = nhapThongTinThucUong(scanner);
            }

            danhSachSanPham.add(sp);
            System.out.println("Da them san pham " + (i + 1) + " thanh cong!");
        }
        ghiFile(menu);
    }

    private doAn nhapThongTinDoAn(Scanner scanner) {
        String id;
        while (true) {
            System.out.print("Nhap ID san pham: ");
            id = scanner.nextLine();
            if (timKiemSanPham(scanner, id) == null)
                break;
            else
                System.out.println("ID san pham da ton tai! Vui long nhap ID khac.");
        }
        System.out.print("Nhap ten san pham: ");
        String ten = scanner.nextLine();

        double gia = nhapGia(scanner);
        System.out.print("Nhap loai do an (Mon nuoc / Mon kho): ");
        String loai = scanner.nextLine();

        return new doAn(id, ten, gia, loai);
    }

    private thucUong nhapThongTinThucUong(Scanner scanner) {
        String id;
        while (true) {
            System.out.print("Nhap ID san pham: ");
            id = scanner.nextLine();
            if (timKiemSanPham(scanner, id) == null)
                break;
            else
                System.out.println("ID san pham da ton tai! Vui long nhap ID khac.");
        }
        System.out.print("Nhap ten san pham: ");
        String ten = scanner.nextLine();

        double gia = nhapGia(scanner);
        System.out.print("Nhap size (S / M / L / XL): ");
        String size = scanner.nextLine();

        return new thucUong(id, ten, gia, size);
    }

    private double nhapGia(Scanner scanner) {
        double gia = 0;
        while (true) {
            System.out.print("Nhap gia san pham: ");
            if (scanner.hasNextDouble()) {
                gia = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Nhap khong hop le! Vui long nhap gia la so.");
                scanner.nextLine();
            }
        }
        return gia;
    }

    public void suaSanPham(Scanner scanner) throws IOException {
        System.out.print("Nhap ID san pham can sua: ");
        sanPham spSua = timKiemSanPham(scanner, null); // Truyền null để nhập ID từ người dùng
        if (spSua != null) {
            System.out.println("Thong tin cu cua san pham da chon: ");
            spSua.hienThiThongTin();

            while (true) {
                System.out.println("Chon thuoc tinh de sua:");
                System.out.println("1. ID");
                System.out.println("2. Ten");
                System.out.println("3. Gia");
                if (spSua instanceof doAn) {
                    System.out.println("4. Loai do an");
                } else if (spSua instanceof thucUong) {
                    System.out.println("4. Size");
                }
                System.out.println("5. Sua tat ca");
                System.out.println("6. Thoat");

                int luaChon = scanner.nextInt();
                scanner.nextLine(); // Đọc dòng mới

                switch (luaChon) {
                    case 1: // Sửa ID
                        String idMoi;
                        while (true) {
                            System.out.print("Nhap ID moi: ");
                            idMoi = scanner.nextLine();
                            if (timKiemSanPham(scanner, idMoi) == null)
                                break; // Kiểm tra ID có tồn tại không
                            else
                                System.out.println("ID san pham da ton tai! Vui long nhap ID khac.");
                        }
                        spSua.setId(idMoi);
                        System.out.println("Da sua ID san pham thanh cong!");
                        break;

                    case 2: // Sửa tên
                        System.out.print("Nhap ten moi: ");
                        String tenMoi = scanner.nextLine();
                        spSua.setTen(tenMoi);
                        System.out.println("Da sua ten san pham thanh cong!");
                        break;

                    case 3: // Sửa giá
                        double giaMoi = nhapGia(scanner);
                        spSua.setGia(giaMoi);
                        System.out.println("Da sua gia san pham thanh cong!");
                        break;

                    case 4: // Sửa loại hoặc size
                        if (spSua instanceof doAn) {
                            System.out.print("Nhap loai do an moi: ");
                            String loaiMoi = scanner.nextLine();
                            ((doAn) spSua).setLoai(loaiMoi);
                            System.out.println("Da sua loai do an thanh cong!");
                        } else if (spSua instanceof thucUong) {
                            System.out.print("Nhap size moi: ");
                            String sizeMoi = scanner.nextLine();
                            ((thucUong) spSua).setSize(sizeMoi);
                            System.out.println("Da sua size thuc uong thanh cong!");
                        }
                        break;

                    case 5: // Sửa tất cả
                        String idTatCa;
                        while (true) {
                            System.out.print("Nhap ID moi: ");
                            idTatCa = scanner.nextLine();
                            if (timKiemSanPham(scanner, idTatCa) == null)
                                break; // Kiểm tra ID có tồn tại không
                            else
                                System.out.println("ID san pham da ton tai! Vui long nhap ID khac.");
                        }
                        spSua.setId(idTatCa);
                        System.out.print("Nhap ten moi: ");
                        String tenTatCa = scanner.nextLine();
                        spSua.setTen(tenTatCa);
                        double giaTatCa = nhapGia(scanner);
                        spSua.setGia(giaTatCa);
                        if (spSua instanceof doAn) {
                            System.out.print("Nhap loai do an moi: ");
                            String loaiTatCa = scanner.nextLine();
                            ((doAn) spSua).setLoai(loaiTatCa);
                        } else if (spSua instanceof thucUong) {
                            System.out.print("Nhap size moi: ");
                            String sizeTatCa = scanner.nextLine();
                            ((thucUong) spSua).setSize(sizeTatCa);
                        }
                        System.out.println("Da sua tat ca thong tin san pham thanh cong!");
                        break;

                    case 6: // Thoát
                        System.out.println("Thoat khoi che do sua.");
                        return;

                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai.");
                }

                // Hiển thị thông tin sản phẩm đã được cập nhật
                System.out.println("Thong tin san pham sau khi sua:");
                spSua.hienThiThongTin();
                // Ghi lại thông tin sản phẩm vào file sau khi sửa
                ghiFile(menu);
            }

        } else {
            System.out.println("Khong tim thay san pham."); // Thông báo nếu không tìm thấy
        }
    }

    public void xoaSanPham(Scanner scanner) throws IOException {
        System.out.print("Nhap ID san pham can xoa: ");
        sanPham spXoa = timKiemSanPham(scanner, null); // Truyền null để nhập ID từ người dùng
        if (spXoa != null) {
            System.out.println("Thong tin san pham da chon: ");
            spXoa.hienThiThongTin();
            System.out.print("Ban chac chan muon xoa san pham nay? (1. Tiep tuc xoa, 2. Huy): ");
            int chosse = scanner.nextInt();
            scanner.nextLine();
            if (chosse == 1) {
                danhSachSanPham.remove(spXoa);
                System.out.println("Da xoa san pham thanh cong!");
                ghiFile(menu);
            }
        } else {
            System.out.println("Khong tim thay san pham."); // Thông báo nếu không tìm thấy
        }
    }

    public void timSanPham(Scanner scanner) {
        System.out.println("Chon phuong thuc tim kiem:");
        System.out.println("1. Tim theo ID");
        System.out.println("2. Tim theo ten");
        System.out.println("3. Tim theo gia");
        System.out.print("Nhap lua chon: ");

        int luaChon = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới

        switch (luaChon) {
            case 1: // Tìm kiếm theo ID
                System.out.print("Nhap ID san pham can tim: ");
                sanPham spTim = timKiemSanPham(scanner, null); // Truyền null để nhập ID từ người dùng
                if (spTim != null) {
                    spTim.hienThiThongTin();
                } else {
                    System.out.println("Khong tim thay san pham."); // Thông báo nếu không tìm thấy
                }
                break;

            case 2: // Tìm kiếm theo tên
                System.out.print("Nhap ten san pham can tim: ");
                String tenCanTim = scanner.nextLine();
                boolean foundByName = false;
                for (sanPham sp : danhSachSanPham) {
                    if (sp.getTen().toLowerCase().contains(tenCanTim.toLowerCase())) {
                        sp.hienThiThongTin();
                        foundByName = true;
                    }
                }
                if (!foundByName) {
                    System.out.println("Khong tim thay san pham co ten '" + tenCanTim + "'.");
                }
                break;

            case 3: // Tìm kiếm theo giá
                System.out.print("Nhap gia san pham can tim: ");
                double giaCanTim = scanner.nextDouble();
                scanner.nextLine();
                boolean foundByPrice = false;
                for (sanPham sp : danhSachSanPham) {
                    if (sp.getGia() == giaCanTim) {
                        sp.hienThiThongTin();
                        foundByPrice = true;
                    }
                }
                if (!foundByPrice) {
                    System.out.println("Khong tim thay san pham co gia " + giaCanTim + ".");
                }
                break;

            default:
                System.out.println("Lua chon khong hop le. Vui long chon lai.");
                break;
        }
    }

    public sanPham timKiemSanPham(Scanner scanner, String id) {
        // Kiểm tra nếu ID là null, yêu cầu người dùng nhập
        if (id == null) {
            id = scanner.nextLine();
        }

        // Tìm sản phẩm với ID
        for (sanPham sp : danhSachSanPham) {
            if (sp.getId().equals(id)) {
                return sp; // Trả về sản phẩm nếu tìm thấy
            }
        }

        return null;
    }

    public void xemSanPham() {
        System.out.println("Danh sach san pham:");
        for (sanPham sp : danhSachSanPham) {
            sp.hienThiThongTin();
        }
    }

    public void docFile(String menu) throws IOException {
        try (Scanner scanner = new Scanner(new FileReader(menu))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String id = parts[0];
                String loai = parts[1];
                String ten = parts[2];
                double gia = Double.parseDouble(parts[3]); // Chuyển đổi gia sang double

                if (loai.equals("doAn")) {
                    String loaiDoAn = scanner.nextLine(); // Đọc loại doAn từ dòng tiếp theo
                    danhSachSanPham.add(new doAn(id, ten, gia, loaiDoAn));
                } else if (loai.equals("thucUong")) {
                    String size = scanner.nextLine(); // Đọc size thucUong từ dòng tiếp theo
                    danhSachSanPham.add(new thucUong(id, ten, gia, size));
                }
            }
        }
    }

    public void ghiFile(String menu) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(menu))) {
            for (sanPham sp : danhSachSanPham) {
                writer.println(
                        sp.getId() + "," + sp.getClass().getSimpleName() + "," + sp.getTen() + "," + sp.getGia());
                if (sp instanceof doAn) {
                    writer.println(((doAn) sp).getLoai()); // Ghi thêm loại cho doAn
                } else if (sp instanceof thucUong) {
                    writer.println(((thucUong) sp).getSize()); // Ghi thêm size cho thucUong
                }
            }
        }
    }

}
