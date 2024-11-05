import java.util.Scanner;
public class QL_HD {
    DS_HD ds_hd=new DS_HD();

    public void menuHD(){
        ds_hd.docfile();
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("\tQUAN LI HOA DON");
            System.out.println("1. Hoa don khach");
            System.out.println("2. Hoa don nhap hang");
            System.out.println("3. Thoat");
            System.out.print("Hay chon chuc nang: ");
            int chon1=sc.nextInt();
            sc.nextLine();
            System.out.println();
            if(chon1==3) break;
            ds_hd.chonHoaDon(chon1);
            
            
            while(true)
            {
                menuFunction();
                System.out.print("Hay chon chuc nang: ");
                int chon2=sc.nextInt();
                sc.nextLine();
                System.out.println();
                switch (chon2) {
                case 1:
                    ds_hd.nhap();
                    break;
                case 2:
                    ds_hd.xuat();
                    break;
                case 3:
                    ds_hd.timKiem();
                    break;
                case 4:
                    ds_hd.them();
                    break;
                case 5:
                    ds_hd.sua();
                    break;
                case 6:
                    ds_hd.xoa();
                    break;
                case 7:
                    ds_hd.docfile();
                    break;  
                case 8:
                    ds_hd.ghifile();;
                    break;  
                case 9:
                    break;
                default: System.out.println("Nhap sai chuc nang. Hay nhap lai!");
                    break;
                }
                if(chon2==9)  break;
            }
        }
    }
    public void menuFunction(){
        System.out.println("--------------------------------");
        System.out.println("\tQUAN LI HOA DON KHACH");
        System.out.println("1. Nhap danh sach hoa don");
        System.out.println("2. Xuat danh sach hoa don");
        System.out.println("3. Tim kiem hoa don");
        System.out.println("4. Them hoa don");
        System.out.println("5. Sua hoa don");
        System.out.println("6. Xoa hoa don");
        System.out.println("7. Tai hoa don");
        System.out.println("8. Luu hoa don");
        System.out.println("9. Thoat");
    }
}


