import java.util.Scanner;

public class doAn extends sanPham {
    private String nguyenLieu;
    private String loaiDoAn;

    public doAn(){
        super();
        nguyenLieu="";
        loaiDoAn="";
    }

    public doAn(String maSP, String tenSP, double giaSP,String nguyenLieu,String loaiDoAn){
        super(maSP, tenSP, giaSP);
        this.nguyenLieu=nguyenLieu;
        this.loaiDoAn=loaiDoAn;
    }

    @Override
    public void nhap() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("Nhap nguyen lieu: ");
        this.nguyenLieu = sc.nextLine();
        System.out.print("Nhap loai do an: ");
        this.loaiDoAn = sc.nextLine();
    }

    @Override
    public void xuat() {
        // TODO Auto-generated method stub
        super.xuat();
        System.out.println("Nguyen lieu: " + nguyenLieu);
        System.out.println("Loai do an: " + loaiDoAn);
    }
    public void setLoaiDoAn(String loaiDoAn) {
        this.loaiDoAn = loaiDoAn;
    }
    public void setNguyenLieu(String nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }
    public String getLoaiDoAn() {
        return loaiDoAn;
    }
    public String getNguyenLieu() {
        return nguyenLieu;
    }    
}
