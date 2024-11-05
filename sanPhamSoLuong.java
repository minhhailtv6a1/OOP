import java.util.Scanner;
public class sanPhamSoLuong {
    private sanPham sp;
    private int soLuong;

    public sanPhamSoLuong(sanPham sp, int soLuong) {
        this.sp = sp;
        this.soLuong = soLuong;
    }

    public sanPhamSoLuong(){
        this.sp=new sanPham();
        this.soLuong=0;
    }

    public void nhap(){
        DS_SP  ds_sp = new DS_SP();
        ds_sp.docfile();
        System.out.print("Nhap ma san pham: ");
        sp=ds_sp.timMa();
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap so luong: ");
        this.soLuong=sc.nextInt();
        sc.nextLine();

    }
    
    public sanPham getSP() {
        return sp;
    }

    public void setSP(sanPham sp) {
        this.sp = sp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tinhThanhTien() {
        return sp.getGiaSP() * soLuong;
    }

}
