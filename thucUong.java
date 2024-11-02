public class thucUong extends sanPham {
    private String size;
    private boolean coDa;
    private float nongDoDuong;
    public thucUong(){
        super();
        size="";
        coDa=true;
        nongDoDuong=0;
    }
    public thucUong(String maSP, String tenSP, double giaSP,String size,boolean coDa, float nongDoDuong) {
        super(maSP, tenSP, giaSP);
        this.size=size;
        this.coDa=coDa;
        this.nongDoDuong=nongDoDuong;
    }

    @Override
    public void xuat() {
        // TODO Auto-generated method stub
        super.xuat();
        System.out.println("Size: " + this.size);
        String ice = this.coDa==true?"co":"khong";
        System.out.println("Co da: " + ice);
    }

    public void setCoDa(boolean coDa) {
        this.coDa = coDa;
    }
    public void setNongDoDuong(float nongDoDuong) {
        this.nongDoDuong = nongDoDuong;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getSize() {
        return size;
    }
    public float getNongDoDuong() {
        return nongDoDuong;
    }
}
