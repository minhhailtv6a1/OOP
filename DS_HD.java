import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class DS_HD implements danhSach {
    ArrayList<hoaDon> hd;
    int n;
    // int select;//Chon hoaDonKhach hay hoaDonNhap
    public DS_HD(){
        hd=new ArrayList<hoaDon>();
        n=0;
        // select=0;
    }

    public DS_HD(ArrayList<hoaDon> hd,int n){
        this.n=n;
        this.hd=hd;
        // this.select=select;
    }

    public int chonHoaDon(){
        Scanner sc = new Scanner(System.in);
        int loai;  
            System.out.println("1. Hoa don khach");
            System.out.println("2. Hoa don nhap hang");
            System.out.println("3. Thoat");
            System.out.print("Chon loai hoa don: ");
            loai = sc.nextInt();
            sc.nextLine();
            while (loai < 1|| loai > 3) {
                System.out.println("Nhap sai, vui long nhap lai");
                loai = sc.nextInt();
                sc.nextLine();
            }
        return loai;
    }
    public void nhap(){
        System.out.println("--------------------------------");
        System.out.println("\tNHAP DANH SACH HOA DON");
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap so luong hoa don: ");
        int n1=sc.nextInt();
        sc.nextLine();
        // int select = chonHoaDon();
        for(int i=0;i<n1;i++){
            int select = chonHoaDon();
            if(select == 3){ 
                // n1 = i;
                return;
            }
            hoaDon tmp;
            if(select==1) tmp=new hoaDonKhach();
            else tmp=new hoaDonNhapHang();//hoaDonNhap
            tmp.nhap();
            hd.add(tmp);
            this.n ++;
            this.ghiFile();
        }
    }

    public void xuat(){
        System.out.println("------------------------------------------------------");
        System.out.println("\tDANH SACH HOA DON  - Tong ( " + hd.size() + " hoa don )");
        if(hd.size()==0){
            System.out.println("KHONG CO HOA DON NAO");
            return;
        }
        for(int i=0;i<n;i++){
            hd.get(i).xuat();
            System.out.println();
        }
    }

    public void timKiem(){
        System.out.println("---------------------------");
        System.out.println("\tTIM KIEM");
        if(hd.size()==0){
            System.out.println("KHONG CO HOA DON NAO");
            return;
        }
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("Nhap ma de tim: ");
            String ma=sc.nextLine();
            for(int i=0;i<n;i++)
                if(hd.get(i).getMaHoaDon().equals(ma)){
                    hd.get(i).xuat();
                    return;
                }
            ///Nếu tìm không có
            System.out.println("Khong ton tai hoa don. Hay nhap lai ma hoa don.");
        }
    }

    public void them(){
        System.out.println("--------------------------------");
        System.out.println("\tTHEM HOA DON");
        hoaDon tmp;
        int select = chonHoaDon();
        if(select == 3) return;
        if(select==1) tmp=new hoaDonKhach();
            else tmp=new hoaDonNhapHang();//hoaDonNhap
        tmp.nhap();
        them(tmp);
    }
    public void them(hoaDon a){
        hd.add(a);
        n++;
        this.ghiFile();
    }

    public void xoa(){
        System.out.println("--------------------------------");
        System.out.println("\tXOA HOA DON");
        if(hd.size()==0){
            System.out.println("KHONG CO HOA DON NAO");
            return;
        }      
        Scanner sc=new Scanner(System.in);
        hoaDon tmp;
        while(true){
            System.out.print("Nhap ma de xoa: ");
            String ma=sc.nextLine();
            tmp = timMa(ma);
            if(tmp != null) break;

            System.out.println("Khong ton tai ma hoa don. Hay nhap lai ma hoa don.");
        }

        int choice;
        while(true){
            System.out.print("Ban co chac chac muon xoa hoa don nay? (Nhap 1 de xoa, 2 de huy): ");
            choice = Integer.parseInt(sc.nextLine());
            if(choice == 1 || choice == 2) break;
            
            System.out.println("Nhap sai. Hay nhap lai.");
        }
        if(choice == 1){
            hd.remove(tmp);
            n--;
            this.ghiFile();
        }
    }

    public hoaDon timMa(String ma){
        for(int i=0;i<n;i++)
            if(hd.get(i).getMaHoaDon().equals(ma)){
                return hd.get(i);
            }
        return null;
    }

    public void sua(){
        System.out.println("--------------------------------");
        System.out.println("\tSUA HOA DON");
        if(hd.size()==0){
            System.out.println("KHONG CO HOA DON NAO");
            return;
        }
        Scanner sc=new Scanner(System.in);

        hoaDon tmp;
        while(true){
            System.out.print("Nhap ma muon sua: ");
            String ma = sc.nextLine();
            tmp = timMa(ma);
            if(tmp != null) break;

            System.out.println("Khong ton tai hoa don. Hay nhap lai ma hoa don.");
        }
        ///Nhập lại thông tin hóa đơn muốn sửa
        hd.get(hd.indexOf(tmp)).nhap();
        this.ghiFile();
    }

    public void ghiFile(){
        try {
            FileWriter fw = new FileWriter("hoaDon.txt");
            String line = "";
            for(int i=0;i<n;i++){
                if(hd.get(i) instanceof hoaDonKhach){ // hoa don khach
                    hoaDonKhach tmp=(hoaDonKhach)hd.get(i);
                    line += tmp.getMaHoaDon() + "," + tmp.getNgay().get(Calendar.DATE) + "," + tmp.getNgay().get(Calendar.MONTH) + "," + tmp.getNgay().get(Calendar.YEAR) + ",";
                    line += tmp.getKh().getMaKhach() + ",";
                    line += tmp.getNv().getMaNhanVien();
                    for(chiTietSP j : tmp.getDs_sp()){

                        // line+= "," + j.getSP().getMaSP() + "," + j.getSoLuong() ;

                        if(j.getSP() instanceof doAn){
                            line+= "," + j.getSP().getMaSP() + "," + j.getSoLuong() ;
                        }
                        else if(j.getSP() instanceof thucUong){
                            line+= "," + j.getSP().getMaSP() + "," + j.getSoLuong() + "," + j.getSize() + "," + j.getLuongDa() + "," + j.getNongDoDuong();
                        }
                    }
                    line +="\n";
                }

                // hoa doa nhap
                else{
                    hoaDonNhapHang tmp = (hoaDonNhapHang)hd.get(i);
                    line += tmp.getMaHoaDon() + "," + tmp.getNgay().get(Calendar.DATE) + "," + tmp.getNgay().get(Calendar.MONTH) + "," + tmp.getNgay().get(Calendar.YEAR) + ",";
                    line += tmp.getNv().getMaNhanVien();
                    for(chitietHH x: tmp.getHh()){
                        line += "," + x.getHh().getMaHang() + "," + x.getSoLuong();
                    }
                    line += "\n";
                }
            }
            fw.write(line);
            fw.close();
            } 
            catch (Exception e) {
                System.out.println(e);            
            }
    }
    public void docFile(){
        try {
            BufferedReader input = new BufferedReader(new FileReader("hoaDon.txt"));
            String line = "";
            while (true) {
            line = input.readLine();
            if(line == null) break;

            String[] arr = line.split(",");
            if(arr[0].contains("hdk"))////Nhận diện bằng mã hóa đơn
            {
                hoaDonKhach tmp = new hoaDonKhach();
                tmp.setMaHoaDon(arr[0]);
                Calendar date=Calendar.getInstance();
                date.set(Integer.parseInt(arr[3]), Integer.parseInt(arr[2]), Integer.parseInt(arr[1]));
                tmp.setNgay(date);

                //Đọc file ds_KH
                DS_KH ds_KH = new DS_KH();
                ds_KH.docFile();
                //Cho setKh = kh ma tim duoc trong ds_KH bang ma
                tmp.setKh(ds_KH.timMa(arr[4]));  
                
                //Đọc file ds_NV
                DS_NV ds_NV = new DS_NV();
                ds_NV.docFile();
                tmp.setNv(ds_NV.timMa(arr[5]));

                //Đọc file ds_SP
                DS_SP ds_SP = new DS_SP();
                ds_SP.docFile();
                


                ArrayList<chiTietSP> chiTietSPs = new ArrayList<>();
                for(int i=6;i<arr.length;){
                    //Cho setSP = SP ma tim duoc trong ds_SP bang ma
                    ///Chi tiết SP để đọc từ file lên
                    chiTietSP sp1=new chiTietSP();
                    sp1.setSP(ds_SP.timMa(arr[i]));
                    sp1.setSoLuong(Integer.parseInt(arr[i+1]));


                    ///Nếu sp là nước thì đọc thêm size, đá, đường
                    if(sp1.getSP() instanceof thucUong){
                        sp1.setSize(arr[i+2]);
                        sp1.setLuongDa(Float.parseFloat(arr[i+3]));
                        sp1.setNongDoDuong(Float.parseFloat(arr[i+4]));
                        i = i + 5;
                    }
                    else {
                        i = i + 2;
                    }

                    ///Lấy chi tiết sp vừa đọc add là ArrayList chiTietSPs
                    chiTietSPs.add(sp1);
                }

                ///Set ds_sp của hóa đơn tmp = ArrayList chiTietSPs
                tmp.setDs_sp(chiTietSPs);
                
                hd.add(tmp);
            }

            // Hoa don nhap
            else{
                hoaDonNhapHang tmp = new hoaDonNhapHang();
                tmp.setMaHoaDon(arr[0]);
                Calendar date=Calendar.getInstance();
                date.set(Integer.parseInt(arr[3]), Integer.parseInt(arr[2]), Integer.parseInt(arr[1]));
                tmp.setNgay(date);

                //Đọc file ds_NV
                DS_NV ds_NV = new DS_NV();
                ds_NV.docFile();
                tmp.setNv(ds_NV.timMa(arr[4]));

                //Đọc file ds_HH
                DS_HH ds_HH = new DS_HH();
                ds_HH.docFile();

                ArrayList<chitietHH> chitietHHs = new ArrayList<>();
                for(int i=5; i<arr.length; i = i + 2){
                    ///Đọc chi tiết hàng hóa từ file
                    chitietHH hh1 = new chitietHH();
                    hh1.setHh(ds_HH.searchHH(arr[i]));
                    hh1.setSoLuong(Integer.parseInt(arr[i+1]));
                    ///Thêm chi tiết vừa đọc vào ArrayList chitietHHs
                    chitietHHs.add(hh1);
                }
                tmp.setHh(chitietHHs);
                tmp.setN(tmp.getHh().size());
                hd.add(tmp);
                // System.out.println(hd.size());
            }
            this.n = hd.size();
            }
            input.close();
            } catch (Exception ex) {
            ex.printStackTrace();
            }
    }
}