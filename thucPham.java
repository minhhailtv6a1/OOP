import java.util.Scanner;

public class thucPham extends hangHoa{
    private int hanSD;

    public thucPham () {
        super();
        this.hanSD = 0;
    }

    public thucPham (String maHang, String tenHang, int soLuong, double giaHH, String noiSX, int hanSD) {
        super(maHang, tenHang, soLuong, giaHH, noiSX);
        this.hanSD = hanSD;  
    }

    public void setHanSD(int hanSD) {
        this.hanSD = hanSD;
    }
    
    public int getHanSD() {
        return hanSD;
    }
    
    @Override
    public void xuatHangHoa() {
        super.xuatHangHoa();
        System.out.println("Han su dung: " + hanSD + " thang");
        System.out.println("Thanh tien: " + this.tinhThanhTien());
    }
    @Override
    public void nhapHangHoa() {
        Scanner sc= new Scanner(System.in);
        super.nhapHangHoa();
        System.out.print("Nhap han su dung: ");
        hanSD = sc.nextInt();   
    }
    public void nhapHangHoa(String ma) {
        Scanner sc= new Scanner(System.in);
        super.nhapHangHoa(ma);
        System.out.print("Nhap han su dung: ");
        hanSD = sc.nextInt();   
    }
}


// import java.util.Scanner;

// public class thucPham extends hangHoa{
//     private int hanSD;

//     public thucPham () {
//         super();
//         this.hanSD = 0;
//     }

//     public thucPham (String maHang, String tenHang, int soLuong, double giaHH, String noiSX, int hanSD) {
//         super(maHang, tenHang, soLuong, giaHH, noiSX);
//         this.hanSD = hanSD;  
//     }

//     public void setHanSD(int hanSD) {
//         this.hanSD = hanSD;
//     }
    
//     public int getHanSD() {
//         return hanSD;
//     }
    
//     @Override
//     public void xuatHangHoa() {
//         super.xuatHangHoa();
//         System.out.println("- Han su dung: " + hanSD);
//         System.out.println("- Thanh tien: " + this.tinhThanhTien());
//     }
//     @Override
//     public void nhapHangHoa() {
//         Scanner sc= new Scanner(System.in);
//         super.nhapHangHoa();
//         System.out.print("Nhap han su dung: ");
//         hanSD = sc.nextInt();   
//     }
//     public void nhapHangHoa(String ma) {
//         Scanner sc= new Scanner(System.in);
//         super.nhapHangHoa(ma);
//         System.out.print("Nhap han su dung: ");
//         hanSD = sc.nextInt();   
//     }
// }