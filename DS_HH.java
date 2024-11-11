import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
public class DS_HH implements danhSach {
    int soLuong;
    ArrayList<hangHoa> ds;
    public DS_HH() {
        soLuong = 0;
        ds = new ArrayList<hangHoa>();
    }
    public DS_HH(int soLuong, ArrayList<hangHoa> ds) {
        this.soLuong = soLuong;
        this.ds = ds;
    }
    public int chonLoaiHH() {
        Scanner sc = new Scanner(System.in);
        int loai;  
            System.out.println("1. Noi that");
            System.out.println("2. Thuc pham");
            System.out.println("3. Thoat");
            System.out.print("Nhap loai hang hoa: ");
            loai = sc.nextInt();
            while (loai < 1|| loai > 3) {
                System.out.println("Nhap sai, vui long nhap lai");
                loai = sc.nextInt();
            }
        return loai;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong hang hoa: ");
        int count = sc.nextInt();
        for (int i=0; i<count; i++) {
            hangHoa hh;
            int loai = chonLoaiHH();
            if(loai == 1) {
                hh = new noiThat();
            }
            else {
                hh = new thucPham();
            }
            hh.nhapHangHoa();
            hh.xuatHangHoa();
            ds.add(hh);
        }
        soLuong += count;
        System.out.println(ds.size());
    }
    public void xuat() {
        for (int i=0; i<ds.size(); i++) {
            ds.get(i).xuatHangHoa();
        }
        System.out.println();
    }
    public void them() {
        Scanner sc = new Scanner(System.in);
        hangHoa hh;
        int loai = chonLoaiHH();
        if (loai == 1){
            hh = new noiThat();
        }
        else {
            hh = new thucPham();
        }
        hh.nhapHangHoa();
        ds.add(hh);
        soLuong++;
    }

    ////// Them co parameter
    public void them(hangHoa hh) {
        ds.add(hh);
        this.soLuong++;
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hang can xoa: ");
        String maHang = sc.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (ds.get(i).getMaHang().equals(maHang)) {
                ds.remove(i);
                soLuong--;
                return;
            }
        }
        System.out.println("Khong tim thay hang co ma: " + maHang);
    }

    public void timKiem(){

    }

    public hangHoa searchHH () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hang can tim: ");
        String maHang = sc.nextLine();
        return searchHH(maHang);
    }
    public hangHoa searchHH (String maHang) {
        for (int i = 0; i < soLuong; i++) {
            if (ds.get(i).getMaHang().equals(maHang)) {
                return ds.get(i);
            }
        }
        return null;
    }

    public void suaMaHang(hangHoa hh){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma moi: ");
        String ma = sc.nextLine();
        hh.setMaHang(ma);
    }

    public void suaTenHang(hangHoa hh) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten moi: ");
        String ten = sc.nextLine();
        hh.setTenHang(ten);
    }

    public void suaGiaHang(hangHoa hh) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap gia moi: ");
        double gia = sc.nextDouble();
        hh.setGiaHH(gia);
    }

    public void suaSoLuong(hangHoa hh) {
        Scanner sc = new Scanner(System.in);
            System.out.print("Nhap so luong moi: ");
            int soLuong = sc.nextInt();
            hh.setSoLuong(soLuong);
    }

    public void suaNoiSX(hangHoa hh) {
        Scanner sc = new Scanner(System.in);
            System.out.print("Nhap noi san xuat moi: ");
            String noiSX = sc.nextLine();
            hh.setNoiSX(noiSX);
    }
    //Sửa hạn bảo hành của thực phẩm
    public void suaHanSD(thucPham hh) {
        Scanner sc = new Scanner(System.in);
            System.out.print("Nhap han su dung moi: ");
            int hanSD = sc.nextInt();
            hh.setHanSD(hanSD);
    }
    //Sửa hạn bảo hành của nội thất
    public void suaHanBH(noiThat hh) {
        Scanner sc = new Scanner(System.in);
            System.out.print("Nhap han bao hanh moi: ");
            int hanBH = sc.nextInt();
            hh.setHanBH(hanBH);
    }

    //Sửa trạng thái của nội thất
    public void suaTinhTrang(noiThat hh) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tinh trang moi: ");
        String tinhTrang = sc.nextLine();
        hh.setTinhTrang(tinhTrang);
    }

    public void sua() {
        Scanner sc = new Scanner (System.in);
        System.out.print( "Nhap ma hang can sua: ");
        String maHang = sc.nextLine();
        hangHoa hh = searchHH(maHang);
        if (hh instanceof noiThat) {
            noiThat tmp = (noiThat) hh;
            int choice;
            do {
                System.out.println("1. Sua ma hang");
                System.out.println("2. Sua ten hang");
                System.out.println("3. Sua so luong");
                System.out.println("4. Sua gia hang");
                System.out.println("5. Sua noi san xuat");
                System.out.println("6. Sua han bao hanh");
                System.out.println("7. Sua tinh trang");
                System.out.println("8. Thoat");
                System.out.print("Nhap lua chon: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        suaMaHang(tmp);
                        break;
                    case 2: 
                        suaTenHang(tmp);
                        break;
                    case 3: 
                        suaSoLuong(tmp);
                        break;
                    case 4: 
                        suaGiaHang(tmp);
                        break;
                    case 5:
                        suaNoiSX(tmp);
                        break;
                    case 6: 
                        suaHanBH(tmp);  
                        break; 
                    case 7: 
                        suaTinhTrang(tmp);
                        break;
                    case 8: 
                        System.out.println("Ket thuc viec sua hang hoa");
                        break;
                    default: 
                        System.out.println("Nhap sai, vui long nhap lai");
                        break;

                }
            } while (choice != 8);
            
        }
        else if (hh instanceof thucPham){
            thucPham tmp = (thucPham) hh;
            int choice;
            do {
                System.out.println("1. Sua ma hang");
                System.out.println("2. Sua ten hang");
                System.out.println("3. Sua so luong");
                System.out.println("4. Sua gia hang");
                System.out.println("5. Sua noi san xuat");
                System.out.println("6. Sua han su dung");
                System.out.print("Nhap lua chon: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        suaMaHang(tmp);
                        break;
                    case 2: 
                        suaTenHang(tmp);
                        break;
                    case 3: 
                        suaSoLuong(tmp);
                        break;
                    case 4: 
                        suaGiaHang(tmp);
                        break;
                    case 5:
                        suaNoiSX(tmp);
                        break;
                    case 6: 
                        suaHanSD(tmp);  
                        break; 
                    case 7: 
                        System.out.println("Ket thuc viec sua hang hoa");
                        break;
                    default: 
                        System.out.println("Nhap sai, vui long nhap lai");
                        break;   
                }
            } while(choice != 7);
        }
        else {
            System.out.println("Khong tim thay hang co ma: " + maHang);
        }
        

    }
    public void docFile() {
        try {
            BufferedReader input = new BufferedReader (new FileReader("DS_HH.txt"));
            String line = input.readLine();
            ds.clear();
            while(line != null) {
                String []cur = line.split(",");
                hangHoa tmp;
                if (cur[0] == "1") {
                    tmp = new noiThat(cur[1], cur[2], Integer.parseInt(cur[3]), Double.parseDouble(cur[4])
                    , cur[5], Integer.parseInt(cur[6]), cur[7]);
                }
                else {
                    tmp = new thucPham(cur[1], cur[2], Integer.parseInt(cur[3]), Double.parseDouble(cur[4])
                    , cur[5], Integer.parseInt(cur[6]));
                }
                ds.add(tmp);
                line = input.readLine();
            }
            this.soLuong = ds.size();
            input.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void ghiFile() {
        try {
            FileWriter output = new FileWriter("DS_HH.txt");
            for (hangHoa hh : ds) {
                if(hh instanceof noiThat) {
                    output.write("1," + hh.getMaHang() + "," + hh.getTenHang() + "," + hh.getSoLuong() + "," + hh.getGiaHH() 
                    + "," + hh.getNoiSX() + "," + ((noiThat) hh).getHanBH() + "," + ((noiThat) hh).getTinhTrang() + "\n");
                }
                else {
                    output.write("2," + hh.getMaHang() + "," + hh.getTenHang() + "," + hh.getSoLuong() + "," + hh.getGiaHH() 
                    + "," + hh.getNoiSX() + "," + ((thucPham) hh).getHanSD() + "\n");
                }
            }
            output.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
