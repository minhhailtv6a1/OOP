public class thucUong extends sanPham {
    private String size; // Kích thước đồ uống

    // Hàm thiết lập không tham số
    public thucUong() {
        super(); // Gọi hàm thiết lập không tham số của lớp cha sanPham()
        this.size = "Unknown"; // Thiết lập giá trị mặc định cho kích thước
    }

    // Hàm thiết lập có tham số
    public thucUong(String id, String ten, double gia, String size) {
        super(id, ten, gia); // Gọi hàm thiết lập của lớp cha với id, ten, gia
        this.size = size; // Thiết lập kích thước
    }

    // Phương thức set
    public void setSize(String size) {
        this.size = size; // Thiết lập kích thước đồ uống
    }

    // Phương thức get
    public String getSize() {
        return size; // Trả về kích thước đồ uống
    }

    @Override
    public void hienThiThongTin() { // Hiển thị thông tin đồ uống với format đều các cột
        System.out.printf("%-10s %-10s %-40s %-15s %-10s%n",
                "Thuc Uong",
                "ID: " + getId(),
                "Ten: " + getTen(),
                "Size: " + size,
                "Gia: " + getGia());
    }

    @Override
    public String toString() {
        return "thucUong," + id + "," + ten + "," + gia + "," + size;
    }
}