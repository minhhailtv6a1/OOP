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
        DS_HD ds_HD = new DS_HD();
        ds_HD.docFile();
        while(true){
            System.out.print("Nhap ma hoa don: ");
            String ma = sc.nextLine();
            hoaDon tmp = ds_HD.timMa(ma);
            ///Nếu mã hóa đơn ko tồn tại thì cho phép hóa đơn lấy mã đó
            if(tmp == null) 
            {
                this.setMaHoaDon(ma);
                break;
            }

            ///Nếu đã tồn tại mã thì thông báo cho nhập lại
            System.out.println("Ma hoa don da ton tai. Hay nhap lai ma hoa don!");
        }

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
        while(true){
            System.out.print("Nhap ma khach hang: ");
            this.kh=ds_kh.timMa();
            if(this.kh.getMaKhach() != "") break;

            ///Nếu tìm không có khách hàng
            System.out.println("Khong ton tai khach hang. Hay nhap lai ma khach hang!");
        }

        //Lấy ra danh sách nhân viên
        DS_NV ds_nv = new DS_NV();
        ds_nv.docFile();

        //Nhập mã nhân viên để tìm nhân viên trong dsNV rồi ghi vào hóa đơn
        while (true)
        {
            System.out.print("Nhap ma nhan vien: ");
            this.setNv(ds_nv.timMa());
            if(this.getNv().getMaNhanVien() != "") break;

            ///Nếu tìm ko có nhân viên
            System.out.println("Khong ton tai nhan vien. Hay nhap lai ma nhan vien!");
        }

        while(true){
            System.out.print("Nhap so luong cac san pham: ");
            this.n = Integer.parseInt(sc.nextLine());
            if(this.n > 0) break;

            System.out.println("So luong phai lon hon 0");
        }

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
        System.out.println("- Cac san pham da mua:");
        for(chiTietSP i: ds_sp){
            if(i.getSP() instanceof doAn){
                System.out.print("+ " + i.getSP().getTenSP());
                System.out.print(": " + (int)i.getSP().getGiaSP() + "vnd ");///i.;giaSP   
                System.out.println("x" + i.getSoLuong()); //i.soLuong
            }
            else if(i.getSP() instanceof thucUong){
                System.out.print("+ " + i.getSP().getTenSP());
                System.out.print(": " + (int)i.getSP().getGiaSP() + "vnd ");///i.;giaSP   
                System.out.print("x" + i.getSoLuong()); //i.soLuong
                System.out.println(", size: " + i.getSize() + ", da: " + (int)i.getLuongDa() + "%, duong: " + (int)i.getNongDoDuong() + "%");
            }
        }
        System.out.println("- Tong hoa don: " + (int)this.tongHoaDon() + "vnd");
    }

    public double tongHoaDon(){
        double tong=0;
        for(chiTietSP i: ds_sp){
            // tong+=i.getSP().getGiaSP()*i.getSoLuong();//i.hh.getGiaSP()*i.soLuong
            tong+=i.tinhThanhTien();
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
