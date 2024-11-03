
public class doAn extends sanPham {
    private String loai; // Loại món ăn

    // Hàm thiết lập
    public doAn(String ten, String gia, String loai) {
        super(ten, gia); // Gọi hàm thiết lập của lớp cha
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
    public void hienThiThongTin() {
        // Hiển thị thông tin món ăn
        System.out.println("Do An - ID: " + getId() + ", Ten: " + getTen() + ", Gia: " + getGia() + ", Loai: " + loai);
    }
}
