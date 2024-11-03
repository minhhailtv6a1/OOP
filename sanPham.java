
abstract class sanPham {
    private static int count = 0; // Biến đếm số lượng sản phẩm
    private int id; // ID sản phẩm
    private String ten; // Tên sản phẩm
    private String gia; // Giá sản phẩm

    // Hàm thiết lập
    public sanPham(String ten, String gia) {
        this.ten = ten;
        this.gia = gia;
        this.id = ++count; // Tăng id mỗi khi có sản phẩm mới
    }

    // Phương thức set
    public void setTen(String ten) {
        this.ten = ten; // Thiết lập tên sản phẩm
    }

    public void setGia(String gia) {
        this.gia = gia; // Thiết lập giá sản phẩm
    }


    // Phương thức get
    public int getId() {
        return id; // Trả về ID sản phẩm
    }

    public String getTen() {
        return ten; // Trả về tên sản phẩm
    }

    public String getGia() {
        return gia; // Trả về giá sản phẩm
    }

    // Phương thức trừu tượng để hiển thị thông tin sản phẩm
    public abstract void hienThiThongTin();
}
