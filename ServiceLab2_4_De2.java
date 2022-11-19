package Service;

import ViewModel.SinhVien;
import java.util.ArrayList;

public class ServiceLab2_4_De2 {

    private final ArrayList<SinhVien> listSV;

    public ServiceLab2_4_De2() {
        this.listSV = new ArrayList<>();
        SinhVien sv1 = new SinhVien("Name 1", 53, true, "JS");
        SinhVien sv2 = new SinhVien("Gender 3", 54, false, "JS");
        SinhVien sv3 = new SinhVien("Departmant 4", 55, true, "IS");
        SinhVien sv4 = new SinhVien("Age 2", 56, false, "EF");
        this.listSV.add(sv1);
        this.listSV.add(sv2);
        this.listSV.add(sv3);
        this.listSV.add(sv4);
    }

    public ArrayList<SinhVien> getList() {
        return this.listSV;
    }

    public ArrayList<SinhVien> getListSearch(String tenSearch) {
        ArrayList<SinhVien> lsv = new ArrayList<>();
        for (SinhVien sv : this.listSV) {
            if (sv.getTen().equals(tenSearch)) {
                lsv.add(sv);
            }
        }
        return lsv;
    }

    public void removeList(int row) {
        this.listSV.remove(row);
    }

    public void addList(SinhVien sv5) {
        this.listSV.add(sv5);
    }

}
