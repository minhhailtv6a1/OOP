import java.util.Scanner;
public class noiThat extends hangHoa {
    private int hanBH;
    private String tinhTrang;
    public noiThat() {
        super();
        this.hanBH = 0;
        this.tinhTrang = "";
    }
    public noiThat(String maHang, String tenHang, int soLuong, double giaHH, String noiSX, int hanBH, String tinhTrang) {
        super(maHang, tenHang, soLuong, giaHH, noiSX);
        this.hanBH = hanBH;
        this.tinhTrang = tinhTrang;
    }
    public int getHanBH() {
        return hanBH;
    }
    public String getTinhTrang() {
        return tinhTrang;
    }
    public void setHanBH(int hanBH) {
        this.hanBH = hanBH;
    }
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    @Override
    public void nhapHangHoa() {
        Scanner sc = new Scanner(System.in);
        super.nhapHangHoa();
        System.out.print("Nhap han bao hanh: ");
        hanBH = sc.nextInt();
        System.out.print("Nhap tinh trang: ");
        sc.nextLine();
        tinhTrang = sc.nextLine();
    }
    public void nhapHangHoa(String ma) {
        Scanner sc = new Scanner(System.in);
        super.nhapHangHoa(ma);
        System.out.print("Nhap han bao hanh: ");
        hanBH = sc.nextInt();
        System.out.print("Nhap tinh trang: ");
        sc.nextLine();
        tinhTrang = sc.nextLine();
    }
    @Override
    public void xuatHangHoa() {
        super.xuatHangHoa();
        System.out.println("Thanh tien: " + this.tinhThanhTien());
        System.out.println("Tinh trang: " + tinhTrang);

    }
    

}

