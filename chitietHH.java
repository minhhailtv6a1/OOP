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

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        hh.nhapHangHoa();
        System.out.print("Nhap so luong nhap: ");
    }
}
