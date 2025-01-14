import java.util.Scanner;

public class nhanVien extends nguoi {
    private String viTri; // VD: Phục vụ, quản lí
    private int caLam; // Ca làm việc
    private String maNhanVien;
    private int soGio;
    private double luongCoBan;

    public nhanVien(){
        super();
        this.viTri="";
        this.caLam=0;
        this.maNhanVien="";
        this.soGio=0;
        this.luongCoBan=0;
    }

    public nhanVien(String hoTen, String gioiTinh, String soDienThoai, int namSinh,String viTri,int caLam, String ma, int gio,double luong){
        super(hoTen, gioiTinh, soDienThoai, namSinh);
        this.viTri=viTri;
        this.caLam=caLam;
        this.maNhanVien=ma;
        this.soGio=gio;
        this.luongCoBan=luong;
    }

    @Override
    public void nhap() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma NV:");
        this.maNhanVien=sc.nextLine();
        super.nhap();
        System.out.println("Nhap vi tri: ");
        this.viTri=sc.nextLine();
        System.out.println("Nhap ca lam:");
        this.caLam=sc.nextInt();
        sc.nextLine();        
        System.out.println("Nhap so gio: ");
        this.soGio=sc.nextInt();
        System.out.println("Nhap luong co ban:");
        this.luongCoBan=sc.nextDouble();
    }

    public void xuat(){
        System.out.println("Ma nhan vien: " + this.maNhanVien);
        System.out.println("Ho ten: " + this.getHoTen());
        System.out.println("Gioi tinh: " + this.getGioiTinh());
        System.out.println("So dien thoai: "+ this.getSoDienThoai());
        System.out.println("Nam sinh: " + this.getNamSinh()); 
        System.out.println("Vi tri: "+ this.viTri);
        System.out.println("Ca lam: "+ this.caLam);
        System.out.println("So gio: "+this.soGio);
        System.out.println("Luong co ban: " + (int)this.luongCoBan + "d/h");
    }

    public double tinhLuong(){
        return this.luongCoBan*this.soGio;
    }

    public String getViTri() {
        return viTri;
    }
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public int getCaLam() {
        return caLam;
    }
    public void setCaLam(int caLam) {
        this.caLam = caLam;
    }
    public int getSoGio() {
        return soGio;
    }
    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }
    public double getLuongCoBan() {
        return luongCoBan;
    }
    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
}
