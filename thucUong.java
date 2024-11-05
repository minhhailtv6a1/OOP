import java.util.Scanner;
public class thucUong extends sanPham {
    private String size;
    private float luongDa;
    private float nongDoDuong;
    public thucUong(){
        super();
        size="";
        luongDa=0;
        nongDoDuong=0;
    }
    public thucUong(String maSP, String tenSP, double giaSP,String size,float luongDa, float nongDoDuong) {
        super(maSP, tenSP, giaSP);
        this.size=size;
        this.luongDa=luongDa;
        this.nongDoDuong=nongDoDuong;
    }

    @Override
    public void nhap() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhap size: ");
        this.size = sc.nextLine();
        System.out.println("Nhap luong da: ");
        this.luongDa = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap nong do duong: ");
        this.nongDoDuong = Float.parseFloat(sc.nextLine());
    }

    @Override
    public void xuat() {
        // TODO Auto-generated method stub
        super.xuat();
        System.out.println("Size: " + this.size);
        System.out.println("Luong da: " + this.luongDa);
        System.out.println("Nong do duong: " + this.nongDoDuong);
    }

    public void setLuongDa(float luongDa) {
        this.luongDa = luongDa;
    }
    public void setNongDoDuong(float nongDoDuong) {
        this.nongDoDuong = nongDoDuong;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getSize() {
        return size;
    }
    public float getNongDoDuong() {
        return nongDoDuong;
    }
    public float getLuongDa() {
        return luongDa;
    }
}
