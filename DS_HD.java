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
        for(int i=0;i<n;i++){
            hd.get(i).xuat();
        }
    }

    public void timKiem(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma de tim: ");
        int ma=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
            if(hd.get(i).getMaHoaDon().equals(ma)){
                hd.get(i).xuat();
                break;
            }
    }

    public void them(){
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
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma de xoa: ");
        int ma=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
            if(hd.get(i).getMaHoaDon().equals(ma)){
                hd.remove(i);
                n--;
                break;
            }
    }

    public void sua(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma muon sua: ");
        int ma=sc.nextInt();
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
            for(int i=0;i<n;i++){
                if(hd.get(i) instanceof hoaDonKhach){
                    hoaDonKhach tmp=(hoaDonKhach)hd.get(i);
                    String line=tmp.getMaHoaDon() + ";" + tmp.getNgay().get(Calendar.DATE) + ";" + tmp.getNgay().get(Calendar.MONTH) + ";" + tmp.getNgay().get(Calendar.YEAR) + ";" + tmp.getKh().getHoTen(); 
                    for(sanPhamSoLuong j : tmp.getDs_sp()){
                        line+=";" + j.getSP().getMaSP() + ";" + j.getSP().getTenSP() + ";" + j.getSP().getGiaSP() + ";" + j.getSoLuong();
                    }
                    line+=";" + tmp.tongHoaDon();
                    fw.write(line + "\n");
                }
            }

            fw.close();
            } 
            catch (Exception e) {
                System.out.println(e);            
            }
    }
    public void docfile(){
        try {
            BufferedReader input = new BufferedReader(new FileReader("hoaDon.txt"));
            String line = input.readLine();
            while (line != null) {
            // chia chuỗi thành các chuỗi con phân cách bởi dấu phẩy
            String[] arr = line.split(";");
            if(arr[0].contains("hdk"))////Nhận diện bằng mã hóa đơn
            {
                hoaDonKhach tmp = new hoaDonKhach();
                tmp.setMaHoaDon(arr[0]);
                Calendar date=Calendar.getInstance();
                date.set(Integer.parseInt(arr[3]), Integer.parseInt(arr[2]), Integer.parseInt(arr[1]));
                tmp.setNgay(date);
                tmp.getKh().setHoTen(arr[4]);
                
                for(int i=5;i<arr.length-1;i+=4)
                {
                    sanPhamSoLuong sp1=new sanPhamSoLuong();
                    sp1.getSP().setMaSP(arr[i]);
                    sp1.getSP().setTenSP(arr[i+1]);
                    sp1.getSP().setGiaSP(Double.parseDouble(arr[i+2]));
                    sp1.setSoLuong(Integer.parseInt(arr[i+3]));
                    tmp.getDs_sp().add(sp1);

                    // System.out.println(arr[i]);
                }
            }
            // for(String s: arr){
            //     System.out.println(s);
            // }
            line = input.readLine();
            }
            input.close();
            } catch (Exception ex) {
            ex.printStackTrace();
            }
    }
}