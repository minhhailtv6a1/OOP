import java.util.Scanner;


   public class sanPham {
    private String maSP;
    private String tenSP;
    private double giaSP;

    public sanPham(){
        maSP="";
        tenSP="";
        giaSP=0;
    }

    public sanPham(String maSP,String tenSP,double giaSP){
        this.maSP=maSP;
        this.tenSP=tenSP;
        this.giaSP=giaSP;
    }

    public void nhap(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("Ma san pham: ");
            this.maSP=sc.nextLine();
            DS_SP ds_SP = new DS_SP();
            ds_SP.docFile();
            ///Nếu tìm không có sản phẩm có mã trùng
            if(ds_SP.timMa(this.maSP).getMaSP() == "") break;

            System.out.println("Ma san pham da ton tai. Hay nhap lai ma san pham.");
        }
        System.out.print("Ten san pham: ");
        this.tenSP=sc.nextLine();
        System.out.print("Gia san pham: ");
        this.giaSP=sc.nextDouble();
        sc.nextLine();
    }

    public void xuat(){
        System.out.println("Ma san pham: " + this.maSP);
        System.out.println("Ten san pham: " + this.tenSP);
        System.out.println("Gia san pham: " + this.giaSP + "vnd");
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public double getGiaSP() {
        return giaSP;
    }
    public String getMaSP() {
        return maSP;
    }
    public String getTenSP() {
        return tenSP;
    }

    @Override
    public String toString() {
        return null;
    }

}

// import java.util.Scanner;
// public class sanPham {
//     private String maSP;
//     private String tenSP;
//     private double giaSP;

//     public sanPham(){
//         maSP="";
//         tenSP="";
//         giaSP=0;
//     }

//     public sanPham(String maSP,String tenSP,double giaSP){
//         this.maSP=maSP;
//         this.tenSP=tenSP;
//         this.giaSP=giaSP;
//     }

//     public void nhap(){
//         Scanner sc=new Scanner(System.in);
//         System.out.print("Ma san pham: ");
//         this.maSP=sc.nextLine();
//         System.out.print("Ten san pham: ");
//         this.tenSP=sc.nextLine();
//         System.out.print("Gia san pham: ");
//         this.giaSP=sc.nextDouble();
//         sc.nextLine();
//     }

//     public void xuat(){
//         System.out.println("Ma san pham: " + this.maSP);
//         System.out.println("Ten san pham: " + this.tenSP);
//         System.out.println("Gia san pham: " + this.giaSP);
//     }

//     public void setGiaSP(double giaSP) {
//         this.giaSP = giaSP;
//     }
//     public void setMaSP(String maSP) {
//         this.maSP = maSP;
//     }
//     public void setTenSP(String tenSP) {
//         this.tenSP = tenSP;
//     }
//     public double getGiaSP() {
//         return giaSP;
//     }
//     public String getMaSP() {
//         return maSP;
//     }
//     public String getTenSP() {
//         return tenSP;
//     }
// }
