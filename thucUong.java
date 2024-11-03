// thucUong.java
public class thucUong extends sanPham {
    private String size; // Kích thước đồ uống

    // Hàm thiết lập
    public thucUong(String ten, String gia, String size) {
        super(ten, gia); // Gọi hàm thiết lập của lớp cha
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
    public void hienThiThongTin() {
        // Hiển thị thông tin đồ uống
        System.out.println("Thuc Uong - ID: " + getId() + ", Ten: " + getTen() + ", Gia: " + getGia() + ", Size: " + size);
    }
}

