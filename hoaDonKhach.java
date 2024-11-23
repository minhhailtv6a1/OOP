import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

public class hoaDonKhach extends hoaDon{
    private khachHang kh;
    private ArrayList<chiTietSP> ds_sp; //new ArrayList<chiTietSP>()
    private int n;

    public hoaDonKhach(){
        this.kh=new khachHang();
        this.ds_sp=new ArrayList<chiTietSP>();
    }

    public hoaDonKhach(Calendar ngay, String maHoaDon, nhanVien nv, khachHang kh, ArrayList<chiTietSP> ds_sp, int n){
        super(ngay, maHoaDon, nv);
        this.kh=kh;
        this.ds_sp=ds_sp;
        this.n = n;
    }

    public void nhap(){
        //Khi hoan thien chi nhap vao maKH để tìm ra khách hàng
        Scanner sc=new Scanner(System.in);
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

        //Lấy ra danh sách khách hàng
        DS_KH ds_kh = new DS_KH();
        ds_kh.docFile();

        //Nhập mã khách để tìm khách trong dsKH rồi ghi vào hóa đơn
        System.out.print("Nhap ma khach hang: ");
        this.kh=ds_kh.timMa();

        //Lấy ra danh sách nhân viên
        DS_NV ds_nv = new DS_NV();
        ds_nv.docFile();

        //Nhập mã nhân viên để tìm nhân viên trong dsNV rồi ghi vào hóa đơn
        System.out.print("Nhap ma nhan vien: ");
        this.setNv(ds_nv.timMa());

        System.out.print("Nhap so luong cac san pham: ");
        n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            chiTietSP tmp=new chiTietSP();
            tmp.nhap();
            ds_sp.add(tmp);
        }
    }

    public void xuat(){
        System.out.println("- Ma hoa don: " + this.getMaHoaDon());
        System.out.println("- Ngay: " + this.getNgay().get(Calendar.DATE) + "/" + this.getNgay().get(Calendar.MONTH) + "/" + this.getNgay().get(Calendar.YEAR));
        System.out.println("- Ten khach: " + this.kh.getHoTen());
        System.out.println("- Ten nhan vien: " + this.getNv().getHoTen());
        System.out.println("- Cac san pham:");
        for(chiTietSP i: ds_sp){
            System.out.print("+ " + i.getSP().getTenSP());
            System.out.print(": " + (int)i.getSP().getGiaSP() + "d ");///i.;giaSP   
            System.out.println("x" + i.getSoLuong()); //i.soLuong
        }
        System.out.println("- Tong hoa don: " + (int)this.tongHoaDon() + "d");
    }

    public double tongHoaDon(){
        double tong=0;
        for(chiTietSP i: ds_sp){
            tong+=i.getSP().getGiaSP()*i.getSoLuong();//i.hh.getGiaSP()*i.soLuong
        }
        return tong;
    }

    public ArrayList<chiTietSP> getDs_sp() {
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
    public void setDs_sp(ArrayList<chiTietSP> ds_sp) {
        this.ds_sp = ds_sp;
    }
    public void setN(int n) {
        this.n = n;
    }
}
