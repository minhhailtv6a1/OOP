import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

public class hoaDonKhach extends hoaDon{
    private khachHang kh;
    private ArrayList<sanPhamSoLuong> ds_sp; //new ArrayList<sanPhamSoLuong>()
    private int n;

    public hoaDonKhach(){
        this.kh=new khachHang();
        this.ds_sp=new ArrayList<sanPhamSoLuong>();
    }

    public hoaDonKhach(khachHang kh, ArrayList<sanPhamSoLuong> ds_sp){
        this.kh=kh;
        this.ds_sp=ds_sp;
    }

    public void nhap(){
        //Khi hoan thien chi nhap vao maKH để tìm ra khách hàng
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        this.setMaHoaDon(sc.nextLine());
        System.out.println("Nhap ngay (yyyy//mm/dd): ");
        Calendar d=Calendar.getInstance();
        d.set(sc.nextInt(), sc.nextInt(), sc.nextInt());
        sc.nextLine();
        this.setNgay(d);

        DS_KH ds_kh = new DS_KH();
        ds_kh.docfile();

        System.out.print("Nhap ma khach hang: ");
        kh=ds_kh.timMa();

        System.out.print("Nhap so luong san pham: ");
        n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            sanPhamSoLuong tmp=new sanPhamSoLuong();
            tmp.nhap();
            ds_sp.add(tmp);
        }
    }

    public void xuat(){
        System.out.println("- Ma hoa don: " + this.getMaHoaDon());
        System.out.println("- Ngay: " + this.getNgay().get(Calendar.DATE) + "/" + this.getNgay().get(Calendar.MONTH) + "/" + this.getNgay().get(Calendar.YEAR));
        System.out.println("- Ten khach: " + this.kh.getHoTen());
        System.out.println("- Cac san pham:");
        for(sanPhamSoLuong i: ds_sp){
            System.out.print("+ " + i.getSP().getTenSP());
            System.out.print(": " + (int)i.getSP().getGiaSP() + "d ");///i.;giaSP   
            System.out.println("x" + i.getSoLuong()); //i.soLuong
        }
        System.out.println("- Tong hoa don: " + (int)this.tongHoaDon() + "d");
    }

    public double tongHoaDon(){
        double tong=0;
        for(sanPhamSoLuong i: ds_sp){
            tong+=i.getSP().getGiaSP()*i.getSoLuong();//i.hh.getGiaSP()*i.soLuong
        }
        return tong;
    }

    public ArrayList<sanPhamSoLuong> getDs_sp() {
        return ds_sp;
    }
    public int getN() {
        return n;
    }
    public khachHang getKh() {
        return kh;
    }
    public void setKh(khachHang kh) {
        this.kh = kh;
    }
    public void setDs_sp(ArrayList<sanPhamSoLuong> ds_sp) {
        this.ds_sp = ds_sp;
    }
    public void setN(int n) {
        this.n = n;
    }
}
