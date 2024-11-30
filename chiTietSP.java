import java.util.Scanner;
public class chiTietSP {
    private sanPham sp;
    private int soLuong;
    ///Dành cho khách order nước
    private String size;
    private float luongDa;
    private float nongDoDuong;

    public chiTietSP(sanPham sp, int soLuong) {
        this.sp = sp;
        this.soLuong = soLuong;

        this.size = "";
        this.luongDa = 0;
        this.nongDoDuong = 0;
    }

    public chiTietSP(){
        this.sp=new sanPham();
        this.soLuong=0;

        this.size = "";
        this.luongDa = 0;
        this.nongDoDuong = 0;
    }

    public void nhap(){
        DS_SP  ds_sp = new DS_SP();
        ds_sp.docFile();
        
        while(true){
            System.out.print("Nhap ma san pham: ");
            sp=ds_sp.timMa();
            if(sp.getMaSP() != "") break;

            ///Nếu nó bằng rỗng
            System.out.println("Khong ton tai san pham. Hay nhap lai ma san pham!");
        }
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap so luong: ");
        this.soLuong=sc.nextInt();
        sc.nextLine();
        if(this.sp instanceof thucUong){
            System.out.print("Chon size (M/L): ");
            this.size = sc.nextLine();
            System.out.print("Chon luong da (0-100): ");
            this.luongDa = Float.parseFloat(sc.nextLine());
            System.out.print("Chon luong duong (0-100): ");
            this.nongDoDuong = Float.parseFloat(sc.nextLine());
        }
    }
    
    public sanPham getSP() {
        return sp;
    }

    public void setSP(sanPham sp) {
        this.sp = sp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tinhThanhTien() {
        return sp.getGiaSP() * soLuong;
    }

    public float getLuongDa() {
        return luongDa;
    }

    public void setLuongDa(float luongDa) {
        this.luongDa = luongDa;
    }

    public float getNongDoDuong() {
        return nongDoDuong;
    }

    public void setNongDoDuong(float nongDoDuong) {
        this.nongDoDuong = nongDoDuong;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}


// import java.util.Scanner;
// public class chiTietSP {
//     private sanPham sp;
//     private int soLuong;

//     public chiTietSP(sanPham sp, int soLuong) {
//         this.sp = sp;
//         this.soLuong = soLuong;
//     }

//     public chiTietSP(){
//         this.sp=new sanPham();
//         this.soLuong=0;
//     }

//     public void nhap(){
//         DS_SP  ds_sp = new DS_SP();
//         ds_sp.docFile();
        
//         while(true){
//             System.out.print("Nhap ma san pham: ");
//             sp=ds_sp.timMa();
//             if(sp.getMaSP() != "") break;

//             ///Nếu nó bằng rỗng
//             System.out.println("Khong ton tai san pham. Hay nhap lai ma san pham!");
//         }
//         Scanner sc=new Scanner(System.in);
//         System.out.print("Nhap so luong: ");
//         this.soLuong=sc.nextInt();
//         sc.nextLine();

//     }
    
//     public sanPham getSP() {
//         return sp;
//     }

//     public void setSP(sanPham sp) {
//         this.sp = sp;
//     }

//     public int getSoLuong() {
//         return soLuong;
//     }

//     public void setSoLuong(int soLuong) {
//         this.soLuong = soLuong;
//     }

//     public double tinhThanhTien() {
//         return sp.getGiaSP() * soLuong;
//     }

// }
