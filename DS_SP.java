import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DS_SP implements danhSach{
    ArrayList<sanPham> sp;
    int n;
    int select;

    public DS_SP(){
        sp = new ArrayList<>();
        n=0;
    }

    public DS_SP(ArrayList<sanPham> ds, int n){
        this.sp = ds;
        this.n = n;
    }

    public void nhap(){
        System.out.println("--------------------------------");
        System.out.println("\tNHAP DANH SACH SAN PHAM");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong san pham: ");
        int n1 = Integer.parseInt(sc.nextLine());
        n+=n1;
        for(int i=0;i<n1;i++){
            sanPham tmp;
            System.out.print("Chon do an (1) / thuc uong (2): ");
            select = Integer.parseInt(sc.nextLine());
            System.out.println("San pham " + (i + 1));
            if(select == 1)
            tmp = new doAn();
            else
            tmp = new thucUong();
            tmp.nhap();
            sp.add(tmp);
        }
    }

    public void xuat(){
        System.out.println("------------------------------------------------------");
        System.out.println("\tDANH SACH SAN PHAM  - Tong ( " + sp.size() + " san pham )");
        if(sp.size()==0){
            System.out.println("KHONG CO SAN PHAM NAO");
            return;
        }
        for(int i=0;i<n;i++){
            sp.get(i).xuat();
            System.out.println();
        }
    }

    public void timKiem(){
        System.out.println("---------------------------");
        System.out.println("\tTIM KIEM");
        if(sp.size()==0){
            System.out.println("KHONG CO SAN PHAM NAO");
            return;
        }
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma de tim: ");
        String ma=sc.nextLine();
        for(int i=0;i<n;i++)
            if(sp.get(i).getMaSP().equals(ma)){
                sp.get(i).xuat();
                break;
            }
    }

    public void them(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("\tTHEM SAN PHAM");
        System.out.print("Chon do an (1) / thuc uong (2): ");
        select = Integer.parseInt(sc.nextLine());
        sanPham tmp;
        if(select == 1)
        tmp = new doAn();
        else
        tmp = new thucUong();
        tmp.nhap();
        them(tmp);
    }

    public void them(sanPham a){
        sp.add(a);
        n++;
    }

    public sanPham timMa(){
        Scanner sc = new Scanner(System.in);
        String ma = sc.nextLine();
        for(int i=0;i<n;i++){
            if(sp.get(i).getMaSP().equals(ma))
            return sp.get(i);
        }
        return new sanPham();
    }

    public sanPham timMa(String ma){
        for(int i=0;i<n;i++){
            if(sp.get(i).getMaSP().equals(ma))
            return sp.get(i);
        }
        return new sanPham();
    }

    public void xoa(){
        System.out.println("--------------------------------");
        System.out.println("\tXOA SAN PHAM");
        if(sp.size()==0){
            System.out.println("KHONG CO SAN PHAM NAO");
            return;
        }    
        System.out.print("Nhap ma muon xoa: ");
        sanPham tmp = timMa();
        if(tmp.getMaSP()==""){
            System.out.println("San pham khong ton tai!");
            return;
        }
        sp.remove(tmp);
        n--;
    }

    public void sua(){
        System.out.println("--------------------------------");
        System.out.println("\tSUA SAN PHAM");
        if(sp.size()==0){
            System.out.println("KHONG CO SAN PHAM NAO");
            return;
        }
        System.out.print("Nhap ma muon sua: ");
        sanPham tmp = timMa();
        if(tmp.getMaSP()==""){
            System.out.println("San khong ton tai!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int chon;
        if(sp.get(sp.indexOf(tmp)) instanceof doAn){
        System.out.println("1. Sua ma san pham ");
        System.out.println("2. Sua ten san pham ");
        System.out.println("3. Sua gia san pham ");
        System.out.println("4. Sua nguyen lieu ");
        System.out.println("5. Sua loai do an ");
        System.out.println("6. Sua tat ca");
        System.out.println("7. Thoat ");
        System.out.print("Hay chon thong tin sua: ");
        chon = sc.nextInt();
        sc.nextLine();
        doAn doan= new doAn();
        doan = (doAn)tmp;
        switch(chon){
            case 1: {
                System.out.println("Nhap ma san pham: ");
                String maSP= sc.nextLine();
                doan.setMaSP(maSP);
            } break;

            case 2: {
                System.out.println("Nhap ten san pham: ");
                String tenSP= sc.nextLine();
                doan.setTenSP(tenSP);
            } break;

            case 3: {
                System.out.println("Nhap gia san pham: ");
                double giaSP= Integer.parseInt(sc.nextLine());
                doan.setGiaSP(giaSP);
            } break;

            case 4: {
                System.out.println("Nhap nguyen lieu: ");
                String nguyenLieu= sc.nextLine();
                doan.setNguyenLieu(nguyenLieu);
            } break;

            case 5: {
                System.out.println("Nhap loai do an: ");
                String loai= sc.nextLine();
                doan.setLoaiDoAn(loai);
            } break;

            case 6: {
                doan.nhap();
            } break;

            case 7:
                break;

            default:  System.out.println("Chon sai chuc nang!");
                break;
        }
        sp.set(sp.indexOf(tmp), doan);
    }

    else if(sp.get(sp.indexOf(tmp)) instanceof thucUong){
        System.out.println("1. Sua ma san pham ");
        System.out.println("2. Sua ten san pham ");
        System.out.println("3. Sua gia san pham ");
        System.out.println("4. Sua size ");
        System.out.println("5. Sua luong da ");
        System.out.println("6. Sua nong do duong ");
        System.out.println("7. Sua tat ca");
        System.out.println("8. Thoat ");
        System.out.print("Hay chon thong tin sua: ");
        chon = sc.nextInt();
        sc.nextLine();
        thucUong thucuong= new thucUong();
        thucuong = (thucUong)tmp;
        switch(chon){
            case 1: {
                System.out.println("Nhap ma san pham: ");
                String maSP= sc.nextLine();
                thucuong.setMaSP(maSP);
            } break;

            case 2: {
                System.out.println("Nhap ten san pham: ");
                String tenSP= sc.nextLine();
                thucuong.setTenSP(tenSP);
            } break;

            case 3: {
                System.out.println("Nhap gia san pham: ");
                double giaSP= Integer.parseInt(sc.nextLine());
                thucuong.setGiaSP(giaSP);
            } break;

            case 4: {
                System.out.println("Nhap size: ");
                String size= sc.nextLine();
                thucuong.setSize(size);
            } break;

            case 5: {
                System.out.println("Nhap luong da: ");
                float luongDa= Float.parseFloat(sc.nextLine());
                thucuong.setLuongDa(luongDa);
            } break;

            case 6: {
                System.out.println("Nhap nong do duong: ");
                float nongDoDuong= Float.parseFloat(sc.nextLine());
                thucuong.setNongDoDuong(nongDoDuong);
            }

            case 7: {
                thucuong.nhap();
            } break;

            case 8:
                break;

            default:  System.out.println("Chon sai chuc nang!");
                break;
            }
            sp.set(sp.indexOf(tmp), thucuong);
        }
    }

    public void ghiFile(){
        try{
            FileWriter f = new FileWriter("sanPham.txt");
            String line = "";
            for(int i = 0; i < n; i++){
                if(sp.get(i) instanceof doAn){
                    doAn tmp = new doAn();
                    tmp = (doAn)sp.get(i);
                    line += tmp.getMaSP() + "," + tmp.getTenSP() + "," + (int)tmp.getGiaSP() + ",";
                    line += tmp.getNguyenLieu() + "," + tmp.getLoaiDoAn() + "\n";
                }
                else if(sp.get(i)  instanceof thucUong){
                    thucUong tmp = new thucUong();
                    tmp = (thucUong)sp.get(i);
                    line += tmp.getMaSP() + "," + tmp.getTenSP() + "," + tmp.getGiaSP() + ",";
                    line += tmp.getSize() + "," + tmp.getLuongDa()  + "," + tmp.getNongDoDuong() + "\n";
                }
            }
            f.write(line);
            f.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void docFile(){
        try {
            BufferedReader f = new BufferedReader( new FileReader("sanPham.txt"));
            String line = "";
            // System.out.println(n);
            sp.clear();
            while(true){
                line = f.readLine();
                if(line==null) break;
                String []a = line.split(",");
                if(a.length==5){
                    doAn tmp = new doAn();
                    tmp.setMaSP(a[0]);
                    tmp.setTenSP(a[1]);
                    tmp.setGiaSP(Double.parseDouble(a[2]));
                    tmp.setNguyenLieu(a[3]);
                    tmp.setLoaiDoAn(a[4]);
                    sp.add(tmp);
                }
                else if(a.length == 6){
                    thucUong tmp = new thucUong();
                    tmp.setMaSP(a[0]);
                    tmp.setTenSP(a[1]);
                    tmp.setGiaSP(Double.parseDouble(a[2]));
                    tmp.setSize(a[3]);
                    tmp.setLuongDa(Float.parseFloat(a[4]));
                    tmp.setNongDoDuong(Float.parseFloat(a[5]));
                    sp.add(tmp);
                }
            }
            this.n = sp.size();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}