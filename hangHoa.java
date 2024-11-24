import java.util.Scanner;
public class hangHoa {
    private String maHang;
    private String tenHang;
    private double giaHH;
    private String noiSX;
    private int soLuong;

    public hangHoa() {
        this.maHang = "0";
        this.tenHang = "";
        this.giaHH = 0;
        this.soLuong = 0;
        this.noiSX = "";
    }

    public hangHoa (String maHang, String tenHang, int soLuong, double giaHH, String noiSX) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.giaHH = giaHH;
        this.noiSX = noiSX;
    }
    
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setGiaHH(double giaHH) {
        this.giaHH = giaHH;
    }
    public void setNoiSX(String noiSX) {
        this.noiSX = noiSX;
    }
    public String getMaHang() {
        return maHang;
    }
    public String getTenHang() {
        return tenHang;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public double getGiaHH() {
        return giaHH;
    }
    public String getNoiSX() {
        return noiSX;
    }
    public void nhapHangHoa () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hang: ");
        maHang = sc.nextLine();
        System.out.print("Nhap ten hang: ");
        tenHang = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
        System.out.print("Nhap gia hang hoa: ");
        giaHH = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap noi san xuat: ");
        noiSX = sc.nextLine();

    }
    public void xuatHangHoa() {
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang: " + tenHang);
        System.out.println("So luong: " + soLuong);
        System.out.println("Gia hang hoa: " + giaHH);
        System.out.println("Noi san xuat: " + noiSX);
    }
    public double tinhThanhTien() {
        return soLuong * giaHH;
    }
}
