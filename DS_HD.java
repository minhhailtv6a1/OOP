import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class DS_HD {
    ArrayList<hoaDon> hd;
    int n;
    int select;//Chon hoaDonKhach hay hoaDonNhap
    public DS_HD(){
        hd=new ArrayList<hoaDon>();
        n=0;
        select=0;
    }

    public DS_HD(ArrayList<hoaDon> hd,int n,int select){
        this.n=n;
        this.hd=hd;
        this.select=select;
    }

    public void chonHoaDon(int x){
        select=x;
    }
    public void nhap(){
        System.out.println("--------------------------------");
        System.out.println("\tNHAP DANH SACH HOA DON");
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap so luong hoa don: ");
        this.n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            hoaDon tmp;
            if(this.select==1) tmp=new hoaDonKhach();
            else tmp=new hoaDonKhach();//hoaDonNhap
            tmp.nhap();
            hd.add(tmp);
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
        System.out.print("Nhap ma de tim: ");
        String ma=sc.nextLine();
        for(int i=0;i<n;i++)
            if(hd.get(i).getMaHoaDon().equals(ma)){
                hd.get(i).xuat();
                break;
            }
    }

    public void them(){
        System.out.println("--------------------------------");
        System.out.println("\tTHEM HOA DON");
        hoaDon tmp;
        if(this.select==1) tmp=new hoaDonKhach();
            else tmp=new hoaDonKhach();//hoaDonNhap
        tmp.nhap();
        them(tmp);
    }
    public void them(hoaDon a){
        hd.add(a);
        n++;
    }

    public void xoa(){
        System.out.println("--------------------------------");
        System.out.println("\tXOA HOA DON");
        if(hd.size()==0){
            System.out.println("KHONG CO HOA DON NAO");
            return;
        }      
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma de xoa: ");
        String ma=sc.nextLine();
        for(int i=0;i<n;i++)
            if(hd.get(i).getMaHoaDon().equals(ma)){
                hd.remove(i);
                n--;
                break;
            }
    }

    public void sua(){
        System.out.println("--------------------------------");
        System.out.println("\tSUA HOA DON");
        if(hd.size()==0){
            System.out.println("KHONG CO HOA DON NAO");
            return;
        }
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma muon sua: ");
        String ma = sc.nextLine();
        sc.nextLine();
        for(int i=0;i<n;i++)
            if(hd.get(i).getMaHoaDon().equals(ma)){
                hd.get(i).nhap();
                break;
            }
    }

    public void ghifile(){
        try {
            FileWriter fw = new FileWriter("hoaDon.txt");
            String line = "";
            for(int i=0;i<n;i++){
                if(hd.get(i) instanceof hoaDonKhach){
                    hoaDonKhach tmp=(hoaDonKhach)hd.get(i);
                    line += tmp.getMaHoaDon() + "," + tmp.getNgay().get(Calendar.DATE) + "," + tmp.getNgay().get(Calendar.MONTH) + "," + tmp.getNgay().get(Calendar.YEAR) + ",";
                    line += tmp.getKh().getMaKhach();
                    for(sanPhamSoLuong j : tmp.getDs_sp()){
                        line+= "," + j.getSP().getMaSP() + "," + j.getSoLuong() ;
                    }
                    line +="\n";
                }

                // hoa doa nhap
                // else{

                // }
            }
            fw.write(line);
            fw.close();
            } 
            catch (Exception e) {
                System.out.println(e);            
            }
    }
    public void docfile(){
        try {
            BufferedReader input = new BufferedReader(new FileReader("hoaDon.txt"));
            String line = "";
            while (true) {
            line = input.readLine();
            if(line == null) break;

            String[] arr = line.split(",");
            if(arr[0].contains("hdk"))////Nhận diện bằng mã hóa đơn
            {
                DS_KH ds_KH = new DS_KH();
                ds_KH.docfile();
                hoaDonKhach tmp = new hoaDonKhach();
                tmp.setMaHoaDon(arr[0]);
                Calendar date=Calendar.getInstance();
                date.set(Integer.parseInt(arr[3]), Integer.parseInt(arr[2]), Integer.parseInt(arr[1]));
                tmp.setNgay(date);

                //Cho setKh = kh ma tim duoc trong ds_KH bang ma
                tmp.setKh(ds_KH.timMa(arr[4]));              
                DS_SP ds_SP = new DS_SP();
                ds_SP.docfile();
                
                sanPhamSoLuong sp1=new sanPhamSoLuong();
                for(int i=5;i<arr.length-1;i+=2){
                    //Cho setSP = SP ma tim duoc trong ds_SP bang ma
                    sp1.setSP(ds_SP.timMa(arr[i]));
                    sp1.setSoLuong(Integer.parseInt(arr[i+1]));
                    tmp.getDs_sp().add(sp1);
                }
                hd.add(tmp);
            }

            // Hoa don nhap
            // else{
                
            // }
            this.n = hd.size();
            }
            input.close();
            } catch (Exception ex) {
            ex.printStackTrace();
            }
    }
}