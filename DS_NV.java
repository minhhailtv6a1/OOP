import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class DS_NV implements danhSach{
    ArrayList<nhanVien> nv;
    int n;

    public DS_NV(){
        nv=new ArrayList<nhanVien>();
        n=0;
    }
    public DS_NV(ArrayList<nhanVien> ds,int n1){
        nv=ds;
        n=n1;
    }

    public void nhap(){
        System.out.println("--------------------------------");
        System.out.println("\tNHAP DANH SACH NHAN VIEN");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        int n1 = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n1;i++){
            System.out.println("Nhan vien: " + ( i + 1 ) );
            nhanVien tmp = new nhanVien();
            tmp.nhap();
            nv.add(tmp);
            this.n ++;
            this.ghiFile();
        }
    }

    public void xuat(){
        System.out.println("------------------------------------------------------");
        System.out.println("\tDANH SACH NHAN VIEN  - Tong ( " + nv.size() + " nhan vien )");
        if(nv.size()==0){
            System.out.println("KHONG CO NHAN VIEN NAO");
            return;
        }
        for(int i=0;i<n;i++){
            nv.get(i).xuat();
            System.out.println();
        }
    }

    public void timKiem(){
        System.out.println("---------------------------");
        System.out.println("\tTIM KIEM");
        if(nv.size()==0){
            System.out.println("KHONG CO NHAN VIEN NAO");
            return;
        }
        Scanner sc=new Scanner(System.in);
        // DS_NV ds_NV = new DS_NV();
        // ds_NV.docFile();
        String ma;
        while(true){
            System.out.print("Nhap ma de tim: ");
            ma=sc.nextLine();
            ///Nếu có tồn tại nhân viên thì xuất ra và return
            for(int i=0;i<n;i++)
            if(nv.get(i).getMaNhanVien().equals(ma)){
                nv.get(i).xuat();
                return;
            }

            ///Nếu không tồn tại thì bắt nhập lại
            System.out.println("Khong ton tai nhan vien. Hay nhap lai ma nhan vien");
        }
    }

    public void them(){
        System.out.println("--------------------------------");
        System.out.println("\tTHEM NHAN VIEN");
        nhanVien tmp = new nhanVien();
        tmp.nhap();
        them(tmp);
    }
    public void them(nhanVien a){
        nv.add(a);
        n++;
        this.ghiFile();
    }

    public nhanVien timMa(){
        Scanner sc = new Scanner(System.in);
        String ma = sc.nextLine();
        for(int i=0;i<n;i++){
            if(nv.get(i).getMaNhanVien().equals(ma))
            return nv.get(i);
        }
        return new nhanVien();
    }

    public nhanVien timMa(String ma){
        for(int i=0;i<n;i++){
            if(nv.get(i).getMaNhanVien().equals(ma))
            return nv.get(i);
        }
        return new nhanVien();
    }

    public void xoa(){
        System.out.println("--------------------------------");
        System.out.println("\tXOA NHAN VIEN");
        if(nv.size()==0){
            System.out.println("KHONG CO NHAN VIEN NAO");
            return;
        }      

        Scanner sc = new Scanner(System.in);
        nhanVien tmp;
        // DS_NV ds_NV = new DS_NV();
        // ds_NV.docFile();
        while(true){
            System.out.print("Nhap ma muon xoa: ");
            tmp = timMa();
            if(tmp.getMaNhanVien() != "") break;

            System.out.println("Khong ton tai nhan vien. Hay nhap lai ma nhan vien.");
        }

        int choice;
        while(true){
            System.out.print("Ban co chac chan muon xoa nhan vien nay? (Nhap 1 de xoa, 2 de huy): ");
            choice = Integer.parseInt(sc.nextLine());
            if(choice == 1 || choice == 2) break;

            System.out.println("Nhap sai chuc nang. Hay nhap lai.");
        }

        if(choice == 1){
            nv.remove(tmp);
            n--;
            this.ghiFile();
        }
    }

    public void sua(){
        System.out.println("--------------------------------");
        System.out.println("\tSUA NHAN VIEN");
        if(nv.size()==0){
            System.out.println("KHONG CO NHAN VIEN NAO");
            return;
        }
        nhanVien tmp;
        while(true){
            System.out.print("Nhap ma muon sua: ");
            tmp = timMa();
            if(tmp.getMaNhanVien() != "") break;

            System.out.println("Khong ton tai nhan vien. Hay nhap lai ma nhan vien.");
        }
        

        Scanner sc = new Scanner(System.in);
        int chon;
        System.out.println("\tSUA THONG TIN NHAN VIEN");
        System.out.println("1. Sua ma nhan vien ");
        System.out.println("2. Sua ten nhan vien ");
        System.out.println("3. Sua nam sinh ");
        System.out.println("4. Sua gioi tinh ");
        System.out.println("5. Sua so dien thoai ");
        System.out.println("6. Sua vi tri ");
        System.out.println("7. Sua ca lam ");
        System.out.println("8. Sua so gio ");
        System.out.println("9. Sua luong co ban ");
        System.out.println("10. Sua tat ca ");
        System.out.println("11. Thoat ");
        System.out.print("Hay chon thong tin sua: ");
        chon = sc.nextInt();
        sc.nextLine();
        switch(chon){
            case 1: {
                // DS_NV ds_NV = new DS_NV();
                // ds_NV.docFile();
                String ma;
                while(true){
                    System.out.print("Nhap ma nhan vien: ");
                    ma = sc.nextLine();
                    if(timMa(ma).getMaNhanVien() == "") break;

                    System.out.println("Ma nhan vien da ton tai. Hay nhap lai ma nhan vien.");
                }
                nv.get(nv.indexOf(tmp)).setMaNhanVien(ma);
            } break;

            case 2: {
                System.out.print("Nhap ten nhan vien: ");
                String tenkh= sc.nextLine();
                nv.get(nv.indexOf(tmp)).setHoTen(tenkh);
            } break;

            case 3: {
                System.out.println("Nhap nam sinh: ");
                int namSinh= Integer.parseInt(sc.nextLine());
                nv.get(nv.indexOf(tmp)).setNamSinh(namSinh);
            } break;

            case 4: {
                System.out.println("Nhap gioi tinh: ");
                String gioiTinh= sc.nextLine();
                nv.get(nv.indexOf(tmp)).setGioiTinh(gioiTinh);
            } break;

            case 5: {
                System.out.println("Nhap so dien thoai: ");
                String sdt= sc.nextLine();
                nv.get(nv.indexOf(tmp)).setSoDienThoai(sdt);
            } break;

            case 6: {
                System.out.println("Nhap vi tri: ");
                String viTri= sc.nextLine();
                nv.get(nv.indexOf(tmp)).setViTri(viTri);
            } break;

            case 7: {
                System.out.println("Nhap ca lam: ");
                int caLam= Integer.parseInt(sc.nextLine());
                nv.get(nv.indexOf(tmp)).setCaLam(caLam);
            } break;

            case 8: {
                System.out.println("Nhap so gio: ");
                int soGio= Integer.parseInt(sc.nextLine());
                nv.get(nv.indexOf(tmp)).setSoGio(soGio);
            } break;

            case 9: {
                System.out.println("Nhap luong co ban: ");
                double luongCB= Integer.parseInt(sc.nextLine());
                nv.get(nv.indexOf(tmp)).setLuongCoBan(luongCB);
            } break;
            case 10: {
                nv.get(nv.indexOf(tmp)).nhap();
            } break;

            case 11:
                break;

            default:  System.out.println("Chon sai chuc nang!");
                break;
        }
        this.ghiFile();
    }

    public void ghiFile(){
        try{
            FileWriter f = new FileWriter("nhanVien.txt");
            String line = "";
            for(int i=0;i<n;i++){
                nhanVien  tmp = nv.get(i);
                line += tmp.getMaNhanVien() + ","  + tmp.getHoTen() + "," + tmp.getNamSinh() + "," + tmp.getGioiTinh() + ",";
                line += tmp.getSoDienThoai() + "," + tmp.getViTri() + "," + tmp.getCaLam() + "," + tmp.getSoGio() + ",";
                line += (int)tmp.getLuongCoBan() + "\n";
            }
            f.write(line);
            f.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void docFile(){
        try {
            BufferedReader f = new BufferedReader( new FileReader("nhanVien.txt"));
            String line = "";
            // System.out.println(n);
            nv.clear();
            while(true){
                line = f.readLine();
                if(line==null) break;
                String []a = line.split(",");
                nhanVien tmp = new nhanVien();
                // for(int i = 0; i<a.length;i++){
                //     System.out.println(a[i]);
                // }
                int i=0;
                tmp.setMaNhanVien(a[i]);
                tmp.setHoTen(a[i+1]);
                tmp.setNamSinh(Integer.parseInt(a[i+2]));
                tmp.setGioiTinh(a[i+3]);
                tmp.setSoDienThoai(a[i+4]);
                tmp.setViTri(a[i+5]);
                tmp.setCaLam(Integer.parseInt(a[i+6]));
                tmp.setSoGio(Integer.parseInt(a[i+7]));
                tmp.setLuongCoBan(Integer.parseInt(a[i+8]));
                // tmp.xuat();
                nv.add(tmp);
            }
            this.n=nv.size();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
