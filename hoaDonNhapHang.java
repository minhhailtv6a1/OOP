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

    public hoaDonNhapHang(Calendar ngay, String maHoaDon, nhanVien nv, ArrayList<hangHoa> hh, int n){
        super(ngay, maHoaDon, nv);
        this.hh = hh;
        this.n = n;
    }

    @Override
    public void nhap() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        this.setMaHoaDon(sc.nextLine());
        while (true){
            System.out.println("Nhap ngay (dd/mm/yyyy): ");
            int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            sc.nextLine();
            int flag = 1;
            if (x <= 0 || x > 31 || y <= 0 || y > 12 || z <= 0)
                flag = 0;
            else
                switch (y) {
                    case 4, 6, 9, 11: {
                        if(x > 30)
                        flag = 0;
                    }                    
                    break;

                    case 2: {
                        //Năm nhuần
                        if(z % 400 == 0 || (z % 4 == 0 && z % 100 != 0))
                        {
                            if(x > 29)
                                flag = 0;
                        }
                        //Không phải năm nhuần
                        else{
                            if(x > 28)
                                flag = 0;
                        }
                    }                    
                    break;

                    default:
                        break;
                }
            if(flag == 0)
            {
                System.out.println("Nhap sai ngay. Hay nhap lai!");
                continue;
            }
            
            // Nếu flag == 1
            Calendar d=Calendar.getInstance();
            d.set(z, y, x);
            this.setNgay(d);
            break;
        }

        //Lấy ra danh sách nhân viên
        DS_NV ds_nv = new DS_NV();
        ds_nv.docFile();

        //Nhập mã nhân viên để tìm nhân viên trong dsNV rồi ghi vào hóa đơn
        System.out.print("Nhap ma nhan vien: ");
        this.setNv(ds_nv.timMa());

        System.out.print("Nhap so luong hang hoa: ");
        this.n = sc.nextInt();
        sc.nextLine();

        //Lấy ra danh sách hàng hóa
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
        System.out.println("Ten nhan vien: " + this.getNv().getHoTen());
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
