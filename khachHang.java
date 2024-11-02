import java.util.Scanner;

public class khachHang extends nguoi {
    private int diemTichLuy;
    private String maKhach;

    public khachHang(){
        super();
        diemTichLuy=0;
        maKhach="";
    }

    public khachHang(String hoTen, String gioiTinh, String soDienThoai, int namSinh,int diem,String ma){
        super(hoTen, gioiTinh, soDienThoai, namSinh);
        this.diemTichLuy=diem;
        this.maKhach=ma;
    }

    @Override
    public void xuat() {
        // TODO Auto-generated method stub
        System.out.println("Ma KH: "+this.maKhach);
        System.out.println("Ho ten: " + getHoTen());    
        System.out.println("Gioi tinh: " + getGioiTinh());
        System.out.println("So dien thoai: "+ getSoDienThoai());
        System.out.println("Nam sinh: " + getNamSinh());
        System.out.println("Diem tich luy: "+this.diemTichLuy);
    }

    public String getMaKhach() {
        return maKhach;
    }
    public void setMaKhach(String maKhach) {
        this.maKhach = maKhach;
    }
    public int getDiemTichLuy() {
        return diemTichLuy;
    }
    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    @Override
    public void nhap() {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma KH: ");
        this.maKhach=sc.nextLine();
        super.nhap();
        System.out.println("Nhap diem tich luy: ");
        this.diemTichLuy=sc.nextInt();
    }
}
