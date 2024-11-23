import java.util.Calendar;
public abstract class hoaDon {
    private Calendar ngay;
    private String maHoaDon;
    private nhanVien nv;

    public hoaDon(){
        this.ngay=Calendar.getInstance();
        ngay.set(2024,1,1);
        this.maHoaDon="";
        nv = new nhanVien();
    }

    public hoaDon(Calendar ngay,String maHoaDon, nhanVien nv){
        this.ngay=ngay;
        this.maHoaDon=maHoaDon;
        this.nv = nv;
    }
    public abstract void nhap();
    public abstract void xuat();
    public abstract double tongHoaDon();

    public void setMaHoaDon(String maHoaDon){
        this.maHoaDon=maHoaDon;
    }

    public String getMaHoaDon(){
        return this.maHoaDon;
    }

    public void setNgay(Calendar ngay){
        this.ngay=ngay;
    }

    public Calendar getNgay(){
        return this.ngay;
    }

    public void setNv(nhanVien nv) {
        this.nv = nv;
    }

    public nhanVien getNv() {
        return nv;
    }
}
