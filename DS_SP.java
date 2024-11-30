import java.io.*;
import java.util.*;

public class DS_SP implements danhSach{
    private List<sanPham> danhSachSanPham;

    public DS_SP() {
        danhSachSanPham = new ArrayList<>();
    }

    // Đọc dữ liệu từ file
    public void docFile() {
        try {
            BufferedReader f = new BufferedReader(new FileReader("sanPham.txt"));
            String line = "";
            // System.out.println(n);
            danhSachSanPham.clear();
            while (true) {
                line = f.readLine();
                if (line == null)
                    break;
                String[] a = line.split(",");
                if (a.length == 5) {
                    doAn tmp = new doAn();
                    tmp.setMaSP(a[0]);
                    tmp.setTenSP(a[1]);
                    tmp.setGiaSP(Double.parseDouble(a[2]));
                    tmp.setNguyenLieu(a[3]);
                    tmp.setLoaiDoAn(a[4]);
                    danhSachSanPham.add(tmp);
                } else if (a.length == 6) {
                    thucUong tmp = new thucUong();
                    tmp.setMaSP(a[0]);
                    tmp.setTenSP(a[1]);
                    tmp.setGiaSP(Double.parseDouble(a[2]));
                    tmp.setSize(a[3]);
                    tmp.setLuongDa(Float.parseFloat(a[4]));
                    tmp.setNongDoDuong(Float.parseFloat(a[5]));
                    danhSachSanPham.add(tmp);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Ghi dữ liệu vào file
    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("sanPham.txt"))) {
            for (sanPham sp : danhSachSanPham) {
                writer.println(sp.toString());
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    // Nhập nhiều sản phẩm
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong san pham muon them: ");
        int soLuong = Integer.parseInt(sc.nextLine()); // Đọc số lượng sản phẩm từ người dùng

        for (int i = 0; i < soLuong; i++) {
            sanPham sp;
            System.out.println("Nhap san pham thu " + (i + 1) + ": ");
            System.out.print("Nhap loai san pham (1: Do an, 2: Thuc uong): ");
            int loai = Integer.parseInt(sc.nextLine());

            if (loai == 1) {
                sp = new doAn(); // Tạo đối tượng doAn
            } else if (loai == 2) {
                sp = new thucUong(); // Tạo đối tượng thucUong
            } else {
                System.out.println("Loai san pham khong hop le! Vui long chon lai.");
                i--; // Giảm chỉ số để không tăng số lượng sản phẩm nếu loại không hợp lệ
                continue; // Bỏ qua vòng lặp này
            }

            sp.nhap(); // Nhập thông tin sản phẩm
            danhSachSanPham.add(sp); // Thêm sản phẩm vào danh sách
            System.out.println("San pham da duoc them thanh cong!");
        }
             // Ghi dữ liệu vào file sau khi nhập
             ghiFile();
    }

    // Xuất danh sách sản phẩm
    public void xuat() {
        for (sanPham sp : danhSachSanPham) {
            sp.xuat();
            System.out.println("-----------------------------");
        }
    }


    //Thêm mới sản phẩm
    public void them() {
        Scanner sc = new Scanner(System.in);
        sanPham sp;
    
        System.out.println("Nhap thong tin san pham muon them: ");
        while(true){
            System.out.print("Nhap loai san pham (1: Do an, 2: Thuc uong): ");
            int loai = Integer.parseInt(sc.nextLine());
            
            if (loai == 1) {
                sp = new doAn(); // Tạo đối tượng doAn
                break;
            } else if (loai == 2) {
                sp = new thucUong(); // Tạo đối tượng thucUong
                break;
            } else {
                System.out.println("Loai san pham khong hop le! Vui long chon lai.");
                continue; // Bỏ qua vòng lặp này
            }
        }
    
        sp.nhap(); // Nhập thông tin sản phẩm
        danhSachSanPham.add(sp); // Thêm sản phẩm vào danh sách
        System.out.println("San pham da duoc them thanh cong!");
    
        ghiFile(); // Ghi dữ liệu vào file sau khi thêm
    }
    

    public void sua() {
        Scanner sc = new Scanner(System.in);
        String id;
        ///Kiểm tra id nhập phải tồn tại mới sửa
        while(true){
            System.out.print("Nhap ID san pham can sua: ");
            id = sc.nextLine();
            ///Nếu tìm thấy sản phẩm có id vừa nhập
            if(timMa(id).getMaSP() != "") break;

            System.out.println("Khong ton tai san pham. Hay nhap lai ma san pham.");
        }
        for (sanPham sp : danhSachSanPham) {
            if (sp.getMaSP().equals(id)) {
                System.out.println("Thong tin san pham hien tai:");
                sp.xuat();

                // Menu cho phép người dùng chọn thuộc tính để sửa
                System.out.println("Chon thuoc tinh de sua:");
                System.out.println("1. Ten san pham");
                System.out.println("2. Gia san pham");
                System.out.println("3. Nguyen lieu (neu la doAn)");
                System.out.println("4. Loai do an (neu la doAn)");
                System.out.println("5. Size (neu la thucUong)");
                System.out.println("6. Luong da (neu la thucUong)");
                System.out.println("7. Nong do duong (neu la thucUong)");
                System.out.println("8. Sua tat ca thong tin");
                System.out.print("Nhap lua chon (1-8): ");
                int choice = sc.nextInt();
                sc.nextLine(); // Đọc dòng mới

                switch (choice) {
                    case 1:
                        System.out.print("Nhap ten san pham moi: ");
                        String newName = sc.nextLine();
                        sp.setTenSP(newName);
                        break;
                    case 2:
                        System.out.print("Nhap gia san pham moi: ");
                        double newPrice = sc.nextDouble();
                        sp.setGiaSP(newPrice);
                        break;
                    case 3:
                        if (sp instanceof doAn) {
                            System.out.print("Nhap nguyen lieu moi: ");
                            String newIngredient = sc.nextLine();
                            ((doAn) sp).setNguyenLieu(newIngredient);
                        } else {
                            System.out.println("San pham khong phai la doAn.");
                        }
                        break;
                    case 4:
                        if (sp instanceof doAn) {
                            System.out.print("Nhap loai do an moi: ");
                            String newType = sc.nextLine();
                            ((doAn) sp).setLoaiDoAn(newType);
                        } else {
                            System.out.println("San pham khong phai la doAn.");
                        }
                        break;
                    case 5:
                        if (sp instanceof thucUong) {
                            System.out.print("Nhap size moi: ");
                            String newSize = sc.nextLine();
                            ((thucUong) sp).setSize(newSize);
                        } else {
                            System.out.println("San pham khong phai la thucUong.");
                        }
                        break;
                    case 6:
                        if (sp instanceof thucUong) {
                            System.out.print("Nhap luong da moi: ");
                            float newIceAmount = sc.nextFloat();
                            ((thucUong) sp).setLuongDa(newIceAmount);
                        } else {
                            System.out.println("San pham khong phai la thucUong.");
                        }
                        break;
                    case 7:
                        if (sp instanceof thucUong) {
                            System.out.print("Nhap nong do duong moi: ");
                            float newSugarContent = sc.nextFloat();
                            ((thucUong) sp).setNongDoDuong(newSugarContent);
                        } else {
                            System.out.println("San pham khong phai la thucUong.");
                        }
                        break;
                    case 8: // Tùy chọn sửa tất cả
                        System.out.println("Nhap thong tin moi:");
                        sp.nhap();
                        break;
                    default:
                        System.out.println("Lua chon khong hop le.");
                        return; // Thoát nếu lựa chọn không hợp lệ
                }
                    // Ghi dữ liệu vào file sau khi sửa
                    ghiFile();

            } 
        }
        
    }


    // Xóa sản phẩm
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        String id;
        
        ///Kiểm tra id nhập phải tồn tại mới sửa
        while(true){
            System.out.print("Nhap ID san pham can xoa: ");
            id = sc.nextLine();
            if(timMa(id).getMaSP() != "") break;

            System.out.println("Khong ton tai san pham. Hay nhap lai ma san pham.");
        }
        
        for (int i = 0; i < danhSachSanPham.size(); i++) {
            if (danhSachSanPham.get(i).getMaSP().equals(id)) {
                // Xuất thông tin sản phẩm
                System.out.println("Thong tin san pham can xoa:");
                danhSachSanPham.get(i).xuat(); // Gọi phương thức xuat() của sản phẩm
                
                // Hỏi người dùng có chắc chắn muốn xóa không
                System.out.print("Ban co chac chan muon xoa san pham nay? (Nhap 1 de xoa, 2 de huy): ");
                int choice = sc.nextInt();
                if (choice == 1) {
                    danhSachSanPham.remove(i);
                    System.out.println("San pham da duoc xoa thanh cong!");
                    // Ghi dữ liệu vào file sau khi xóa
                ghiFile();
                } else if (choice == 2) {
                    System.out.println("Hanh dong xoa da bi huy!");
                } else {
                    System.out.println("Lua chon khong hop le! Hanh dong xoa da bi huy.");
                }
                return;
            }
        }
        System.out.println("Khong tim thay san pham voi ID: " + id);
    }


    // Tìm kiếm sản phẩm
    public void timKiem() {
        Scanner sc = new Scanner(System.in);
        String id;
        ///Kiểm tra id nhập phải tồn tại mới tìm kiếm
        while(true){
            System.out.print("Nhap ID san pham can tim: ");
            id = sc.nextLine();
            if(timMa(id).getMaSP() != "") break;

            System.out.println("Khong ton tai san pham. Hay nhap lai ma san pham.");
        }
        for (sanPham sp : danhSachSanPham) {
            if (sp.getMaSP().equals(id)) {
                sp.xuat();
                return;
            }
        }
    }
    

    public sanPham timMa(){
                Scanner sc = new Scanner(System.in);
                String ma = sc.nextLine();
                for(int i=0;i<danhSachSanPham.size();i++){
                    if(danhSachSanPham.get(i).getMaSP().equals(ma))
                    return danhSachSanPham.get(i);
                }
                return new sanPham();
    }
    public sanPham timMa(String ma){
        for(int i=0;i<danhSachSanPham.size();i++){
            if(danhSachSanPham.get(i).getMaSP().equals(ma))
            return danhSachSanPham.get(i);
        }
        return new sanPham();
    }
}



// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.util.ArrayList;
// import java.util.Scanner;

// public class DS_SP implements danhSach{
//     ArrayList<sanPham> sp;
//     int n;
//     int select;

//     public DS_SP(){
//         sp = new ArrayList<>();
//         n=0;
//     }

//     public DS_SP(ArrayList<sanPham> ds, int n){
//         this.sp = ds;
//         this.n = n;
//     }

//     public void nhap(){
//         System.out.println("--------------------------------");
//         System.out.println("\tNHAP DANH SACH SAN PHAM");
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Nhap so luong san pham: ");
//         int n1 = Integer.parseInt(sc.nextLine());
//         this.n += n1;
//         for(int i=0;i<n1;i++){
//             sanPham tmp;
//             System.out.print("Chon do an (1) / thuc uong (2): ");
//             select = Integer.parseInt(sc.nextLine());
//             System.out.println("San pham " + (i + 1));
//             if(select == 1)
//             tmp = new doAn();
//             else
//             tmp = new thucUong();
//             tmp.nhap();
//             sp.add(tmp);
//         }
//     }

//     public void xuat(){
//         System.out.println("------------------------------------------------------");
//         System.out.println("\tDANH SACH SAN PHAM  - Tong ( " + sp.size() + " san pham )");
//         if(sp.size()==0){
//             System.out.println("KHONG CO SAN PHAM NAO");
//             return;
//         }
//         for(int i=0;i<n;i++){
//             sp.get(i).xuat();
//             System.out.println();
//         }
//     }

//     public void timKiem(){
//         System.out.println("---------------------------");
//         System.out.println("\tTIM KIEM");
//         if(sp.size()==0){
//             System.out.println("KHONG CO SAN PHAM NAO");
//             return;
//         }
//         Scanner sc=new Scanner(System.in);
//         System.out.print("Nhap ma de tim: ");
//         String ma=sc.nextLine();
//         for(int i=0;i<n;i++)
//             if(sp.get(i).getMaSP().equals(ma)){
//                 sp.get(i).xuat();
//                 break;
//             }
//     }

//     public void them(){
//         Scanner sc = new Scanner(System.in);
//         System.out.println("--------------------------------");
//         System.out.println("\tTHEM SAN PHAM");
//         System.out.print("Chon do an (1) / thuc uong (2): ");
//         select = Integer.parseInt(sc.nextLine());
//         sanPham tmp;
//         if(select == 1)
//         tmp = new doAn();
//         else
//         tmp = new thucUong();
//         tmp.nhap();
//         them(tmp);
//     }

//     public void them(sanPham a){
//         sp.add(a);
//         n++;
//     }

//     public sanPham timMa(){
//         Scanner sc = new Scanner(System.in);
//         String ma = sc.nextLine();
//         for(int i=0;i<n;i++){
//             if(sp.get(i).getMaSP().equals(ma))
//             return sp.get(i);
//         }
//         return new sanPham();
//     }

//     public sanPham timMa(String ma){
//         for(int i=0;i<n;i++){
//             if(sp.get(i).getMaSP().equals(ma))
//             return sp.get(i);
//         }
//         return new sanPham();
//     }

//     public void xoa(){
//         System.out.println("--------------------------------");
//         System.out.println("\tXOA SAN PHAM");
//         if(sp.size()==0){
//             System.out.println("KHONG CO SAN PHAM NAO");
//             return;
//         }    
//         System.out.print("Nhap ma muon xoa: ");
//         sanPham tmp = timMa();
//         if(tmp.getMaSP()==""){
//             System.out.println("San pham khong ton tai!");
//             return;
//         }
//         sp.remove(tmp);
//         n--;
//     }

//     public void sua(){
//         System.out.println("--------------------------------");
//         System.out.println("\tSUA SAN PHAM");
//         if(sp.size()==0){
//             System.out.println("KHONG CO SAN PHAM NAO");
//             return;
//         }
//         System.out.print("Nhap ma muon sua: ");
//         sanPham tmp = timMa();
//         if(tmp.getMaSP()==""){
//             System.out.println("San khong ton tai!");
//             return;
//         }

//         Scanner sc = new Scanner(System.in);
//         int chon;
//         if(sp.get(sp.indexOf(tmp)) instanceof doAn){
//         System.out.println("1. Sua ma san pham ");
//         System.out.println("2. Sua ten san pham ");
//         System.out.println("3. Sua gia san pham ");
//         System.out.println("4. Sua nguyen lieu ");
//         System.out.println("5. Sua loai do an ");
//         System.out.println("6. Sua tat ca");
//         System.out.println("7. Thoat ");
//         System.out.print("Hay chon thong tin sua: ");
//         chon = sc.nextInt();
//         sc.nextLine();
//         doAn doan= new doAn();
//         doan = (doAn)tmp;
//         switch(chon){
//             case 1: {
//                 System.out.println("Nhap ma san pham: ");
//                 String maSP= sc.nextLine();
//                 doan.setMaSP(maSP);
//             } break;

//             case 2: {
//                 System.out.println("Nhap ten san pham: ");
//                 String tenSP= sc.nextLine();
//                 doan.setTenSP(tenSP);
//             } break;

//             case 3: {
//                 System.out.println("Nhap gia san pham: ");
//                 double giaSP= Integer.parseInt(sc.nextLine());
//                 doan.setGiaSP(giaSP);
//             } break;

//             case 4: {
//                 System.out.println("Nhap nguyen lieu: ");
//                 String nguyenLieu= sc.nextLine();
//                 doan.setNguyenLieu(nguyenLieu);
//             } break;

//             case 5: {
//                 System.out.println("Nhap loai do an: ");
//                 String loai= sc.nextLine();
//                 doan.setLoaiDoAn(loai);
//             } break;

//             case 6: {
//                 doan.nhap();
//             } break;

//             case 7:
//                 break;

//             default:  System.out.println("Chon sai chuc nang!");
//                 break;
//         }
//         sp.set(sp.indexOf(tmp), doan);
//     }

//     else if(sp.get(sp.indexOf(tmp)) instanceof thucUong){
//         System.out.println("1. Sua ma san pham ");
//         System.out.println("2. Sua ten san pham ");
//         System.out.println("3. Sua gia san pham ");
//         System.out.println("4. Sua size ");
//         System.out.println("5. Sua luong da ");
//         System.out.println("6. Sua nong do duong ");
//         System.out.println("7. Sua tat ca");
//         System.out.println("8. Thoat ");
//         System.out.print("Hay chon thong tin sua: ");
//         chon = sc.nextInt();
//         sc.nextLine();
//         thucUong thucuong= new thucUong();
//         thucuong = (thucUong)tmp;
//         switch(chon){
//             case 1: {
//                 System.out.println("Nhap ma san pham: ");
//                 String maSP= sc.nextLine();
//                 thucuong.setMaSP(maSP);
//             } break;

//             case 2: {
//                 System.out.println("Nhap ten san pham: ");
//                 String tenSP= sc.nextLine();
//                 thucuong.setTenSP(tenSP);
//             } break;

//             case 3: {
//                 System.out.println("Nhap gia san pham: ");
//                 double giaSP= Integer.parseInt(sc.nextLine());
//                 thucuong.setGiaSP(giaSP);
//             } break;

//             case 4: {
//                 System.out.println("Nhap size: ");
//                 String size= sc.nextLine();
//                 thucuong.setSize(size);
//             } break;

//             case 5: {
//                 System.out.println("Nhap luong da: ");
//                 float luongDa= Float.parseFloat(sc.nextLine());
//                 thucuong.setLuongDa(luongDa);
//             } break;

//             case 6: {
//                 System.out.println("Nhap nong do duong: ");
//                 float nongDoDuong= Float.parseFloat(sc.nextLine());
//                 thucuong.setNongDoDuong(nongDoDuong);
//             }

//             case 7: {
//                 thucuong.nhap();
//             } break;

//             case 8:
//                 break;

//             default:  System.out.println("Chon sai chuc nang!");
//                 break;
//             }
//             sp.set(sp.indexOf(tmp), thucuong);
//         }
//     }

//     public void ghiFile(){
//         try{
//             FileWriter f = new FileWriter("sanPham.txt");
//             String line = "";
//             for(int i = 0; i < n; i++){
//                 if(sp.get(i) instanceof doAn){
//                     doAn tmp = new doAn();
//                     tmp = (doAn)sp.get(i);
//                     line += tmp.getMaSP() + "," + tmp.getTenSP() + "," + (int)tmp.getGiaSP() + ",";
//                     line += tmp.getNguyenLieu() + "," + tmp.getLoaiDoAn() + "\n";
//                 }
//                 else if(sp.get(i)  instanceof thucUong){
//                     thucUong tmp = new thucUong();
//                     tmp = (thucUong)sp.get(i);
//                     line += tmp.getMaSP() + "," + tmp.getTenSP() + "," + tmp.getGiaSP() + ",";
//                     line += tmp.getSize() + "," + tmp.getLuongDa()  + "," + tmp.getNongDoDuong() + "\n";
//                 }
//             }
//             f.write(line);
//             f.close();
//         } catch(Exception e){
//             System.out.println(e);
//         }
//     }

//     public void docFile(){
//         try {
//             BufferedReader f = new BufferedReader( new FileReader("sanPham.txt"));
//             String line = "";
//             // System.out.println(n);
//             sp.clear();
//             while(true){
//                 line = f.readLine();
//                 if(line==null) break;
//                 String []a = line.split(",");
//                 if(a.length==5){
//                     doAn tmp = new doAn();
//                     tmp.setMaSP(a[0]);
//                     tmp.setTenSP(a[1]);
//                     tmp.setGiaSP(Double.parseDouble(a[2]));
//                     tmp.setNguyenLieu(a[3]);
//                     tmp.setLoaiDoAn(a[4]);
//                     sp.add(tmp);
//                 }
//                 else if(a.length == 6){
//                     thucUong tmp = new thucUong();
//                     tmp.setMaSP(a[0]);
//                     tmp.setTenSP(a[1]);
//                     tmp.setGiaSP(Double.parseDouble(a[2]));
//                     tmp.setSize(a[3]);
//                     tmp.setLuongDa(Float.parseFloat(a[4]));
//                     tmp.setNongDoDuong(Float.parseFloat(a[5]));
//                     sp.add(tmp);
//                 }
//             }
//             this.n = sp.size();
//         } catch (Exception e) {
//             System.out.println(e);
//         }
        
//     }
// }