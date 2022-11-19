package ViewModel;

public class SinhVien {

    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String departmant;

    public SinhVien() {
    }

    public SinhVien(String ten, int tuoi, boolean gioiTinh, String departmant) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.departmant = departmant;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDepartmant() {
        return departmant;
    }

    public void setDepartmant(String departmant) {
        this.departmant = departmant;
    }

}
