import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class DS_KH implements danhSach{
    ArrayList<khachHang> ds_kh;
    int n;

    public DS_KH(){
        ds_kh=new ArrayList<khachHang>();
        n=0;
    }
    public DS_KH(ArrayList<khachHang> ds,int n1){
        ds_kh=ds;
        n=n1;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong khach hang: ");
        int n1 = sc.nextInt();
        n+=n1;
        sc.nextLine();
        for(int i=0;i<n1;i++){
            System.out.println("Khach hang: " + ( i + 1 ) );
            khachHang tmp = new khachHang();
            tmp.nhap();
            ds_kh.add(tmp);
        }
    }

    public void xuat(){
        System.out.println("------------------------------------------------------");
        System.out.println("\tDANH SACH KHACH HANG  - Tong ( " + ds_kh.size() + " khach )");
        if(ds_kh.size()==0){
            System.out.println("KHONG CO KHACH HANG NAO");
            return;
        }
        for(int i=0;i<n;i++){
            ds_kh.get(i).xuat();
            System.out.println();
        }
    }

    public void timKiem(){
        System.out.println("---------------------------");
        System.out.println("\tTIM KIEM");
        if(ds_kh.size()==0){
            System.out.println("KHONG CO KHACH HANG NAO");
            return;
        }
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma de tim: ");
        String ma=sc.nextLine();
        for(int i=0;i<n;i++)
            if(ds_kh.get(i).getMaKhach().equals(ma)){
                ds_kh.get(i).xuat();
                break;
            }
    }

    public void them(){
        System.out.println("--------------------------------");
        System.out.println("\tTHEM KHACH HANG");
        khachHang tmp = new khachHang();
        tmp.nhap();
        them(tmp);
    }
    public void them(khachHang a){
        ds_kh.add(a);
        n++;
    }

    public khachHang timMa(){
        Scanner sc = new Scanner(System.in);
        String ma = sc.nextLine();
        for(int i=0;i<n;i++){
            if(ds_kh.get(i).getMaKhach().equals(ma))
            return ds_kh.get(i);
        }
        return new khachHang();
    }

    public khachHang timMa(String ma){
        for(int i=0;i<n;i++){
            if(ds_kh.get(i).getMaKhach().equals(ma))
            return ds_kh.get(i);
        }
        return new khachHang();
    }

    public void xoa(){
        System.out.println("--------------------------------");
        System.out.println("\tXOA KHACH HANG");
        if(ds_kh.size()==0){
            System.out.println("KHONG CO KHACH HANG NAO");
            return;
        }    
        System.out.print("Nhap ma muon xoa: ");
        khachHang tmp = timMa();
        if(tmp.getMaKhach()==""){
            System.out.println("Khach hang khong ton tai!");
            return;
        }
        ds_kh.remove(tmp);
        n--;
    }

    public void sua(){
        System.out.println("--------------------------------");
        System.out.println("\tSUA KHACH HANG");
        if(ds_kh.size()==0){
            System.out.println("KHONG CO KHACH HANG NAO");
            return;
        }
        System.out.print("Nhap ma muon sua: ");
        khachHang tmp = timMa();
        if(tmp.getMaKhach()==""){
            System.out.println("Khach hang khong ton tai!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int chon;
        System.out.println("1. Sua ma khach ");
        System.out.println("2. Sua ten khach ");
        System.out.println("3. Sua nam sinh ");
        System.out.println("4. Sua gioi tinh ");
        System.out.println("5. Sua so dien thoai ");
        System.out.println("6. Sua diem tich luy ");
        System.out.println("7. Sua tat ca ");
        System.out.println("8. Thoat ");
        System.out.print("Hay chon thong tin sua: ");
        chon = sc.nextInt();
        sc.nextLine();
        switch(chon){
            case 1: {
                System.out.println("Nhap ma khach: ");
                String makh= sc.nextLine();
                ds_kh.get(ds_kh.indexOf(tmp)).setMaKhach(makh);
            } break;

            case 2: {
                System.out.println("Nhap ten khach: ");
                String tenkh= sc.nextLine();
                ds_kh.get(ds_kh.indexOf(tmp)).setHoTen(tenkh);
            } break;

            case 3: {
                System.out.println("Nhap nam sinh: ");
                int namSinh= Integer.parseInt(sc.nextLine());
                ds_kh.get(ds_kh.indexOf(tmp)).setNamSinh(namSinh);
            } break;

            case 4: {
                System.out.println("Nhap gioi tinh: ");
                String gioiTinh= sc.nextLine();
                ds_kh.get(ds_kh.indexOf(tmp)).setGioiTinh(gioiTinh);
            } break;

            case 5: {
                System.out.println("Nhap so dien thoai: ");
                String sdt= sc.nextLine();
                ds_kh.get(ds_kh.indexOf(tmp)).setSoDienThoai(sdt);
            } break;

            case 6: {
                System.out.println("Nhap diem tich luy: ");
                int diemTichLuy= Integer.parseInt(sc.nextLine());
                ds_kh.get(ds_kh.indexOf(tmp)).setDiemTichLuy(diemTichLuy);
            } break;

            case 7: {
                ds_kh.get(ds_kh.indexOf(tmp)).nhap();
            } break;

            case 8:
                break;

            default:  System.out.println("Chon sai chuc nang!");
                break;
        }
    }

    public void ghiFile(){
        try{
            FileWriter f = new FileWriter("khachHang.txt");
            String line = "";
            for(int i=0;i<n;i++){
                khachHang  tmp = ds_kh.get(i);
                line += tmp.getMaKhach() + ","  + tmp.getHoTen() + "," + tmp.getNamSinh() + "," + tmp.getGioiTinh() + ",";
                line += tmp.getSoDienThoai() + "," + tmp.getDiemTichLuy() + "\n";
            }
            f.write(line);
            f.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void docFile(){
        try {
            BufferedReader f = new BufferedReader( new FileReader("khachHang.txt"));
            String line = "";
            // System.out.println(n);
            ds_kh.clear();
            while(true){
                line = f.readLine();
                if(line==null) break;
                String []a = line.split(",");
                khachHang tmp = new khachHang();
                // for(int i = 0; i<a.length;i++){
                //     System.out.println(a[i]);
                // }
                int i=0;
                tmp.setMaKhach(a[i]);
                tmp.setHoTen(a[i+1]);
                tmp.setNamSinh(Integer.parseInt(a[i+2]));
                tmp.setGioiTinh(a[i+3]);
                tmp.setSoDienThoai(a[i+4]);
                tmp.setDiemTichLuy(Integer.parseInt(a[i+5]));
                // tmp.xuat();
                ds_kh.add(tmp);
            }
            this.n = ds_kh.size();
        } catch (Exception e) {
            System.out.println(e);
        }        
    }
}
