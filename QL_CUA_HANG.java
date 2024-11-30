import java.util.Scanner;

public class QL_CUA_HANG {
    static QL_NV ql_NV = new QL_NV();
    static QL_KH ql_KH = new QL_KH();
    static QL_SP ql_SP = new QL_SP();
    static QL_HH ql_HH = new QL_HH();
    static QL_HD ql_HD = new QL_HD();
    public static void menu(){
        System.out.println("---------------------------------");
        System.out.println("\tQUAN LI CUA HANG");
        System.out.println("1. Quan li nhan vien");
        System.out.println("2. Quan li khach hang");
        System.out.println("3. Quan li san pham");
        System.out.println("4. Quan li hang hoa");
        System.out.println("5. Quan li hoa don");
        System.out.println("6. Thoat");
    }
    public static void main(String[] args) {
        while(true){
            menu();
            System.out.print("Hay chon chuc nang: ");
            Scanner sc = new Scanner(System.in);
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    ql_NV.menu();
                    break;
                case 2:
                    ql_KH.menu();
                    break;
                case 3:
                    ql_SP.menu();
                    break;
                case 4:
                    ql_HH.run();
                    break;
                case 5:
                    ql_HD.menu();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Chon sai chuc nang. Hay chon lai!");
                    break;
            }
            if(chon == 6) break;
        }
    }
}
