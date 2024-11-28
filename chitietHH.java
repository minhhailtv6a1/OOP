import java.util.Scanner;

public class chitietHH  {
    private hangHoa hh;
    private int soLuong;

    public chitietHH() {
        hh = new hangHoa();
        soLuong = 0;
    }

    public chitietHH(hangHoa hh, int soLuong) {
        this.hh = hh;
        this.soLuong = soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    } 

    public int getSoLuong() {
        return soLuong;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print ("Nhap ma hang hoa muon them: ");
        String ma = sc.nextLine();

        DS_HH ds = new DS_HH();
        ds.docFile();

        if (ds.searchHH(ma) == null) {
            int loai = ds.chonLoaiHH();
            if (loai == 1){
                hh = new noiThat();
            }
            else {
                hh = new thucPham();
            }
            hh.nhapHangHoa(ma);
            soLuong = hh.getSoLuong();
            ds.them(hh);
        }
        else {
            hh = ds.searchHH(ma);
            System.out.print ("Nhap so luong nhap: ");
            soLuong = sc.nextInt();
            hh.setSoLuong(hh.getSoLuong() + soLuong);
        }

        ds.ghiFile();
    }

    public void xuat (){
        // hh.xuatHangHoa();
        System.out.println("+ " + hh.getTenHang() + ": " + (int)hh.getGiaHH() + "vnd" + " x" + this.soLuong);
    }

    public double tinhThanhTien(){
        return hh.getGiaHH() * this.soLuong;
    }

    public hangHoa getHh() {
        return hh;
    }
    public void setHh(hangHoa hh) {
        this.hh = hh;
    }
}
