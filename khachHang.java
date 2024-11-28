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
        DS_KH ds_KH = new DS_KH();
        ds_KH.docFile();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("Nhap ma KH: ");
            String ma = sc.nextLine();
            khachHang tmp = ds_KH.timMa(ma);
            ///Nếu mã khách không tồn tại thì cho nhập
            if(tmp.getMaKhach() == ""){
                this.maKhach = ma;
                break;
            }

            ///Nếu mã khách tồn tại thì thông báo cho nhập lại
            System.out.println("Ma khach hang da ton tai. Hay nhap lai ma khach hang!");
        }
        
        super.nhap();
        System.out.print("Nhap diem tich luy: ");
        this.diemTichLuy=sc.nextInt();
    }
}
