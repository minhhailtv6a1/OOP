import java.util.Scanner;
public class QL_NV {
    DS_NV ds_nv = new DS_NV();

    public void menu(){
        Scanner sc=new Scanner(System.in);
        ds_nv.docfile();
        while(true){
            menuFunction();
            System.out.print("Hay chon chuc nang: ");
            int chon = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (chon) {
                case 1: ds_nv.nhap();
                    break;
                
                case 2: ds_nv.xuat();
                    break;
                
                case 3: ds_nv.timKiem();
                    break;
                
                case 4: ds_nv.them();
                    break;

                case 5: ds_nv.sua();
                    break;

                case 6: ds_nv.xoa();
                    break;

                case 7: {
                    System.out.println("------------------------------------------------");
                    System.out.println("\tTAI DANH SACH NHAN VIEN THANH CONG");
                    ds_nv.docfile();
                }
                    break;

                case 8: {
                    System.out.println("------------------------------------------");
                    System.out.println("\tLUU DANH SACH NHAN VIEN THANH CONG");
                    ds_nv.ghifile();
                }
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
        System.out.print("\tQUAN LI NHAN VIEN");
        System.out.println("\n1. Nhap danh sach nhan vien");
        System.out.println("2. Xuat danh sach nhan vien");
        System.out.println("3. Tim kiem nhan vien");
        System.out.println("4. Them nhan vien");
        System.out.println("5. Sua nhan vien");
        System.out.println("6. Xoa nhan vien");
        System.out.println("7. Tai danh sach nhan vien");
        System.out.println("8. Luu danh sach nhan vien");
        System.out.println("9. Thoat");
    }
}
