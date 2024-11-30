import java.util.Scanner;
public class QL_HH {
    DS_HH ds = new DS_HH();
    public void menu() {
        System.out.println("\n==============MENU==============");
        System.out.println("1. Nhap danh sach hang hoa");
        System.out.println("2. Xuat danh sach hang hoa");
        System.out.println("3. Tim kiem hang hoa");
        System.out.println("4. Them hang hoa");
        System.out.println("5. Xoa hang hoa");
        System.out.println("6. Sua hang hoa");
        // System.out.println("7. Hien danh sach hang hoa");
        // System.out.println("8. Luu danh sach hang hoa");
        System.out.println("7. Thoat");
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        int choice;
        ds.docFile();
        do {
            menu();
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    ds.nhap();
                    break;
                case 2:
                    ds.xuat();
                    break;
                case 3:
                    ds.timKiem();
                    break;
                case 4:
                    int choiceAdd;
                    do{
                        ds.them();
                        System.out.println("1. Tiep tuc them hang hoa");
                        System.out.println("2. Thoat");
                        System.out.print("Nhap lua chon: ");
                        choiceAdd = sc.nextInt();
                        while (choiceAdd != 1 && choiceAdd != 2) {
                            System.out.println("Nhap sai, nhap lai: ");
                            choiceAdd = sc.nextInt();
                        }
                    }
                    while (choiceAdd != 2);
                    break;
                case 5:
                    int choiceRemove;
                    do{
                        ds.xoa();
                        System.out.println("1. Tiep tuc xoa hang hoa");
                        System.out.println("2. Thoat");
                        System.out.print("Nhap lua chon: ");
                        choiceRemove = sc.nextInt();
                        while (choiceRemove != 1 && choiceRemove != 2) {
                            System.out.println("Nhap sai, nhap lai: ");
                            choiceRemove = sc.nextInt();
                        }
                    }
                    while (choiceRemove != 2);
                    break;
                case 6:
                    ds.sua();
                    break;
                // case 7: 
                //     ds.docFile();
                //     break;
                // case 8:
                //     ds.ghiFile();
                //     break;
                case 7:
                    ds.ghiFile();
                    // System.out.println("Ket thuc chuong trinh");
                    break;
                default:
                    System.out.println("Nhap sai, moi nhap lai");
                    break;      
            }

        } while (choice != 7);
    }
}

