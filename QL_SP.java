import java.util.Scanner;
public class QL_SP {    
    DS_SP ds_sp = new DS_SP();

    public void menu(){
        Scanner sc=new Scanner(System.in);
        ds_sp.docFile();
        while(true){
            menuFunction();
            System.out.print("Hay chon chuc nang: ");
            int chon = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (chon) {
                case 1: ds_sp.nhap();
                    break;
                
                case 2: ds_sp.xuat();
                    break;
                
                case 3: ds_sp.timKiem();
                    break;
                
                case 4: ds_sp.them();
                    break;

                case 5: ds_sp.sua();
                    break;

                case 6: ds_sp.xoa();
                    break;

                case 7: {
                    System.out.println("------------------------------------------------");
                    System.out.println("\tTAI DANH SACH SAN PHAM THANH CONG");
                    ds_sp.docFile();
                }
                    break;

                case 8: {
                    System.out.println("--------------------------------------------------");
                    System.out.println("\tLUU DANH SACH SAN PHAM THANH CONG");
                    ds_sp.ghiFile();
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
        System.out.print("\tQUAN LI SAN PHAM");
        System.out.println("\n1. Nhap danh sach san pham");
        System.out.println("2. Xuat danh sach san pham");
        System.out.println("3. Tim kiem san pham");
        System.out.println("4. Them san pham");
        System.out.println("5. Sua san pham");
        System.out.println("6. Xoa san pham");
        System.out.println("7. Tai danh sach san pham");
        System.out.println("8. Luu danh sach san pham");
        System.out.println("9. Thoat");
    }
}

