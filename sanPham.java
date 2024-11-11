public abstract class sanPham {
    protected String id; // ID sản phẩm
    protected String ten; // Tên sản phẩm
    protected double gia; // Giá sản phẩm

    // Hàm khởi tạo không tham số
    public sanPham() {
        this.id = "default_id"; // Giá trị mặc định cho id
        this.ten = "default_name"; // Giá trị mặc định cho tên
        this.gia = 0; // Giá trị mặc định cho giá
    }

    // Hàm khởi tạo có tham số
    public sanPham(String id, String ten, double gia) {
        this.id = id; // Thiết lập id sản phẩm từ tham số
        this.ten = ten; // Thiết lập tên sản phẩm
        this.gia = gia; // Thiết lập giá sản phẩm
    }

    // Phương thức set
    public void setId(String id) {
        this.id = id; // Thiết lập id sản phẩm
    }

    public void setTen(String ten) {
        this.ten = ten; // Thiết lập tên sản phẩm
    }

    public void setGia(double gia) {
        this.gia = gia; // Thiết lập giá sản phẩm
    }

    // Phương thức get
    public String getId() {
        return id; // Trả về ID sản phẩm
    }

    public String getTen() {
        return ten; // Trả về tên sản phẩm
    }

    public double getGia() {
        return gia; // Trả về giá sản phẩm
    }

    // Phương thức trừu tượng để hiển thị thông tin sản phẩm
    public abstract void hienThiThongTin();

    @Override
    public abstract String toString();
}
