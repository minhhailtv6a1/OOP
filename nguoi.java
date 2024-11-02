import java.util.Scanner;
public abstract class nguoi {
    private String hoTen;
    private String gioiTinh;
    private String soDienThoai;
    private int namSinh;

    public nguoi(){
        hoTen="";
        gioiTinh="";
        soDienThoai="";
        namSinh=0;
    }

    public nguoi(String hoTen, String gioiTinh, String soDienThoai, int namSinh){
        this.hoTen=hoTen;
        this.gioiTinh=gioiTinh;
        this.soDienThoai=soDienThoai;
        this.namSinh=namSinh;
    }

    public abstract void xuat();

    public void setHoTen(String hoTen) {
        if(hoTen==null||hoTen.isEmpty()){
            System.out.println("Chua nhap ten");
            return;
        }
        this.hoTen = hoTen;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setNamSinh(int namSinh) {
        if(namSinh<0){
            System.out.println("Nhap sai nam!");
            return;
        }
        this.namSinh = namSinh;
    }
    public int getNamSinh() {
        return namSinh;
    }
    public void setSoDienThoai(String soDienThoai) {
        if(soDienThoai.charAt(0)!='0'||soDienThoai.length()!=10)
        System.out.println("Nhap sai so dien thoai!");
        this.soDienThoai = soDienThoai;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten: ");
        this.hoTen=sc.nextLine();
        System.out.println("Nhap gioi tinh:");
        this.gioiTinh=sc.nextLine();
        System.out.println("Nhap sdt: ");
        while(true){
            this.soDienThoai=sc.nextLine();
            if(soDienThoai.charAt(0)=='0'&&soDienThoai.length()==10) break;
            System.out.println("Sdt khong hop le! Hay nhap lai.");
        }
        System.out.println("Nhap nam sinh: ");
        while(true){
            this.namSinh=sc.nextInt();
            sc.nextLine();
            if(this.namSinh>0) break;
            System.out.println("Nam sinh phai la so nguyen duong! Hay nhap lai.");
        }
    }
}
