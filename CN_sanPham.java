
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CN_sanPham {
    private List<sanPham> danhSachSanPham;

    public CN_sanPham() {
        danhSachSanPham = new ArrayList<>();
    }

    public void themSanPham(sanPham sp) {
        danhSachSanPham.add(sp);
    }

    public void suaSanPham(int id, String ten, String gia) {
        for (sanPham sp : danhSachSanPham) {
            if (sp.getId() == id) {
                sp.setTen(ten);
                sp.setGia(gia);
                System.out.println("Da sua san pham thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay san pham co ID: " + id);
    }

    public void xoaSanPham(int id) {
        for (sanPham sp : danhSachSanPham) {
            if (sp.getId() == id) {
                danhSachSanPham.remove(sp);
                System.out.println("Da xoa san pham thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay san pham co ID: " + id);
    }

    public sanPham timKiemSanPham(int id) {
        for (sanPham sp : danhSachSanPham) {
            if (sp.getId() == id) {
                return sp;
            }
        }
        System.out.println("Khong tim thay san pham co ID: " + id);
        return null;
    }

    public void xemSanPham() {
        System.out.println("Danh sach san pham:");
        for (sanPham sp : danhSachSanPham) {
            sp.hienThiThongTin();
        }
    }

    String menu="Menu.txt";

   public void ghiFile(String menu) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(menu))) {
        for (sanPham sp : danhSachSanPham) {
            writer.println(sp.getClass().getSimpleName() + "," + sp.getTen() + "," + sp.getGia());
            if (sp instanceof doAn) {
                writer.println(((doAn) sp).getLoai()); // Ghi thêm loại cho doAn
            } else if (sp instanceof thucUong) {
                writer.println(((thucUong) sp).getSize()); // Ghi thêm size cho thucUong
            }
        }
    }
}

public void docFile(String menu) throws IOException {
    try (Scanner scanner = new Scanner(new FileReader(menu))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String loai = parts[0];
            String ten = parts[1];
            String gia = parts[2];

            if (loai.equals("doAn")) {
                String loaiDoAn = scanner.nextLine(); // Đọc loại doAn từ dòng tiếp theo
                themSanPham(new doAn(ten, gia, loaiDoAn));
            } else if (loai.equals("thucUong")) {
                String size = scanner.nextLine(); // Đọc size thucUong từ dòng tiếp theo
                themSanPham(new thucUong(ten, gia, size));
            }
        }
    }
}




}

