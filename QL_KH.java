import java.util.Scanner;
public class QL_KH {
    DS_KH ds_kh = new DS_KH();

    public void menu(){
        Scanner sc=new Scanner(System.in);
        ds_kh.docfile();
        while(true){
            menuFunction();
            System.out.print("Hay chon chuc nang: ");
            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: ds_kh.nhap();
                    break;
                
                case 2: ds_kh.xuat();
                    break;
                
                case 3: ds_kh.timKiem();
                    break;
                
                case 4: ds_kh.them();
                    break;

                case 5: ds_kh.sua();
                    break;

                case 6: ds_kh.xoa();
                    break;

                case 7: ds_kh.docfile();
                    break;

                case 8: ds_kh.ghifile();
                    break;

                case 9: ;
                    break;
                default: System.out.println("Nhap sai chuc nang. Hay nhap lai!");
                    break;
            }
            if(chon==9) break;
        }
    }

    public void menuFunction(){

        System.out.println("--------------------------------");
        System.out.println("\tQUAN LI KHACH HANG");
        System.out.println("1. Nhap danh sach khach hang");
        System.out.println("2. Xuat danh sach khach hang");
        System.out.println("3. Tim kiem khach hang");
        System.out.println("4. Them khach hang");
        System.out.println("5. Sua khach hang");
        System.out.println("6. Xoa khach hang");
        System.out.println("7. Tai danh sach khach hang");
        System.out.println("8. Luu danh sach khach hang");
        System.out.println("9. Thoat");
    }
}
