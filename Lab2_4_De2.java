package View;

import Service.ServiceLab2_4_De2;
import ViewModel.SinhVien;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Lab2_4_De2 extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcm;
    private final ServiceLab2_4_De2 sv;
    private final ButtonGroup b;
    private final Dialog dialog;

    public Lab2_4_De2() {
        initComponents();
        setLocationRelativeTo(null);// set Jframe giữa màn hình
        this.dialog = new Dialog();
        this.dtm = new DefaultTableModel();
        this.dcm = new DefaultComboBoxModel();
        this.sv = new ServiceLab2_4_De2();
        b = new ButtonGroup();
        b.add(this.rdoMale);
        b.add(this.rdoFemale);
        this.rdoMale.setSelected(true);
        this.addComboBox();
        this.addColums();
        this.loadTable(this.sv.getList());
    }

    void addComboBox() {
        ArrayList<String> listCBB = new ArrayList<>();
        listCBB.add("JS");
        listCBB.add("IS");
        listCBB.add("EF");

        dcm = (DefaultComboBoxModel) this.cbDepartmant.getModel();

        for (String item : listCBB) {
            dcm.addElement(item);
        }
        this.cbDepartmant.setSelectedIndex(0);
    }

    void addColums() {
        ArrayList<String> listColums = new ArrayList<>();
        listColums.add("Name");
        listColums.add("Age");
        listColums.add("Gender");
        listColums.add("Departmant");

        dtm = (DefaultTableModel) this.tbStudentList.getModel();
        dtm.setRowCount(0);
        for (String item : listColums) {
            dtm.addColumn(item);
        }
    }

    void loadTable(ArrayList<SinhVien> listDV) {
        dtm = (DefaultTableModel) this.tbStudentList.getModel();
        dtm.setRowCount(0);

        for (SinhVien sv : listDV) {
            Object[] rowData = {
                sv.getTen(),
                sv.getTuoi(),
                sv.isGioiTinh(),
                sv.getDepartmant()
            };
            dtm.addRow(rowData);
        }
    }

    void clearForm() {
        this.txtSearchName.setText("");
        this.txtName.setText("");
        this.txtAge.setText("");
        this.rdoMale.setSelected(true);
        this.cbDepartmant.setSelectedIndex(0);
        this.loadTable(this.sv.getList());

    }

    public SinhVien getFormData() {
        String nameStr = this.txtName.getText().trim();
        String ageSTr = this.txtAge.getText().trim();
        boolean gioiTinhStr = true;
        String departmantStr = this.cbDepartmant.getSelectedItem().toString();

        if (nameStr.equals("") || ageSTr.equals("")) {
            JOptionPane.showMessageDialog(this, "Thiếu dữ liệu!");
            return null;
        }

        int tuoi = -1;
        try {
            tuoi = Integer.parseInt(ageSTr);
            if (tuoi < 0) {
                JOptionPane.showMessageDialog(this, "Cân nặng phải > 0!");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cân nặng phải là số!");
            return null;
        }

        if (this.rdoMale.isSelected()) {
            gioiTinhStr = true;
        }
        if (this.rdoFemale.isSelected()) {
            gioiTinhStr = false;
        }

        SinhVien sv = new SinhVien(nameStr, tuoi, gioiTinhStr, departmantStr);
        return sv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSearchName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        cbDepartmant = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStudentList = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setText("Search Name");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("information"));

        jLabel7.setText("Name");

        jLabel8.setText("Age");

        jLabel9.setText("Gender");

        jLabel11.setText("Departmant");

        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });

        txtAge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAgeMouseClicked(evt);
            }
        });

        rdoMale.setText("Male");
        rdoMale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoMaleMouseClicked(evt);
            }
        });

        rdoFemale.setText("Female");
        rdoFemale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoFemaleMouseClicked(evt);
            }
        });

        cbDepartmant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbDepartmantMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtAge))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addComponent(cbDepartmant, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoMale)
                                .addGap(88, 88, 88)
                                .addComponent(rdoFemale)
                                .addGap(71, 71, 71)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbDepartmant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSort.setText("Sort");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText(" Student List");

        tbStudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbStudentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStudentListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbStudentList);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnAdd)
                            .addGap(88, 88, 88)
                            .addComponent(btnRemove)
                            .addGap(69, 69, 69)
                            .addComponent(btnSort)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnClear)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSearchName)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSearch))))
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove)
                    .addComponent(btnSort)
                    .addComponent(btnExit))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Clear thành công!");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        this.loadTable(this.sv.getListSearch(this.txtSearchName.getText()));
        JOptionPane.showMessageDialog(this, "Search thành công!");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        SinhVien sv = this.getFormData();

        if (sv == null) {
            return;
        }
        this.sv.addList(sv);
        this.loadTable(this.sv.getList());
        JOptionPane.showMessageDialog(this, "Add thành công!");
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtNameMouseClicked

    private void txtAgeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAgeMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtAgeMouseClicked

    private void cbDepartmantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbDepartmantMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cbDepartmantMouseClicked

    private void rdoMaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoMaleMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rdoMaleMouseClicked

    private void rdoFemaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoFemaleMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rdoFemaleMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int row = this.tbStudentList.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
        }

        int cofirm = JOptionPane.showConfirmDialog(this, "Xác nhận xóa!");
        if (cofirm != JOptionPane.YES_OPTION) {
            return;
        }

        this.sv.removeList(row);
        this.loadTable(this.sv.getList());
        JOptionPane.showMessageDialog(this, "Xóa thành công!");
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tbStudentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStudentListMouseClicked
        int row = this.tbStudentList.getSelectedRow();

        if (row == -1) {
            return;
        }

        this.txtName.setText(this.tbStudentList.getValueAt(row, 0).toString());
        this.txtAge.setText(this.tbStudentList.getValueAt(row, 1).toString());
        if (this.tbStudentList.getValueAt(row, 2).toString().equals("true")) {
            this.rdoMale.setSelected(true);
        }
        if (this.tbStudentList.getValueAt(row, 2).toString().equals("false")) {
            this.rdoFemale.setSelected(true);
        }
        this.cbDepartmant.setSelectedItem(this.tbStudentList.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tbStudentListMouseClicked

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        this.sv.getList().sort(
                (o1, o2) -> {
                    return o1.getTen().compareTo(o2.getTen());
                });

        this.loadTable(this.sv.getList());
    }//GEN-LAST:event_btnSortActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lab2_4_De2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSort;
    private javax.swing.JComboBox<String> cbDepartmant;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTable tbStudentList;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearchName;
    // End of variables declaration//GEN-END:variables
}
