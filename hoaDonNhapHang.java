import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class hoaDonNhapHang extends hoaDon {
    private ArrayList<hangHoa> hh;
    private int n;

    public hoaDonNhapHang(){
        hh = new ArrayList<>();
        n = 0;
    }

    public hoaDonNhapHang(Calendar ngay, String maHoaDon, ArrayList<hangHoa> hh, int n){
        super(ngay, maHoaDon);
        this.hh = hh;
        this.n = n;
    }

    @Override
    public void nhap() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        this.setMaHoaDon(sc.nextLine());
        System.out.println("Nhap ngay (dd/mm/yyyy): ");
        Calendar d=Calendar.getInstance();
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        sc.nextLine();
        d.set(z, y, x);
        this.setNgay(d);

        System.out.print("Nhap so luong hang hoa: ");
        this.n = sc.nextInt();
        sc.nextLine();

        DS_HH timDS = new DS_HH();
        timDS.docFile();
        for(int i=0; i<n;i++){
            System.out.print("Nhap ma hang hoa them vao hoa don: ");
            String ma = sc.nextLine();
            hangHoa tmp = timDS.searchHH(ma);
            hh.add(tmp);
        }
    }

    @Override
    public void xuat() {
        // TODO Auto-generated method stub
        System.out.println("- Ma hoa don: " + this.getMaHoaDon());
        System.out.println("- Ngay: " + this.getNgay().get(Calendar.DATE) + "/" + this.getNgay().get(Calendar.MONTH) + "/" + this.getNgay().get(Calendar.YEAR));
        System.out.println("- Cac hang hoa:");
        for(int i=0; i<n;i++){
            System.out.println("+ Hang hoa " + (i + 1) );
            hh.get(i).xuatHangHoa();
        }
    }

    @Override
    public double tongHoaDon() {
        // TODO Auto-generated method stub
        double tong = 0;
        for(int i = 0; i < n; i++){
            tong += hh.get(i).tinhThanhTien();
        }
        return tong;
    }
    public ArrayList<hangHoa> getHh() {
        return hh;
    }
    public int getN() {
        return n;
    }
    public void setHh(ArrayList<hangHoa> hh) {
        this.hh = hh;
    }
    public void setN(int n) {
        this.n = n;
    }
}
