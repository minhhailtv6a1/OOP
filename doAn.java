public class doAn extends sanPham {
    private String loai; // Loại món ăn

    // Hàm thiết lập không tham số
    public doAn() {
        super(); // Gọi hàm thiết lập không tham số của lớp cha sanPham()
        this.loai = "Unknown"; // Thiết lập giá trị mặc định cho loại món ăn
    }

    // Hàm thiết lập có tham số
    public doAn(String id, String ten, double gia, String loai) {
        super(id, ten, gia); // Gọi hàm thiết lập của lớp cha với id, ten, gia
        this.loai = loai; // Thiết lập loại món ăn
    }

    // Phương thức set
    public void setLoai(String loai) {
        this.loai = loai; // Thiết lập loại món ăn
    }

    // Phương thức get
    public String getLoai() {
        return loai; // Trả về loại món ăn
    }

    @Override
    public void hienThiThongTin() { // Hiển thị thông tin món ăn
        System.out.printf("%-10s %-10s %-40s %-15s %-10s%n",
                "Do An",
                "ID: " + getId(),
                "Ten: " + getTen(),
                "Loai: " + loai,
                "Gia: " + getGia());
    }

    @Override
    public String toString() {
        return "doAn," + id + "," + ten + "," + gia + "," + loai;
    }

}