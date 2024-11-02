import java.util.Calendar;
public abstract class hoaDon {
    private Calendar ngay;
    private String maHoaDon;

    public hoaDon(){
        this.ngay=Calendar.getInstance();
        ngay.set(2024,1,1);
        this.maHoaDon="";
    }

    public hoaDon(Calendar ngay,String maHoaDon){
        this.ngay=ngay;
        this.maHoaDon=maHoaDon;
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
}
