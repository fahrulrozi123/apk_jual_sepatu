package apk_sepatu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class tblpemesan extends javax.swing.JInternalFrame {

    String sql = "select * from sepatu";
    public tblpemesan() {
        initComponents();
        showtable(sql);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuutama = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablepesan = new javax.swing.JTable();

        menuutama.setText("Menu Utama");
        menuutama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuutamaActionPerformed(evt);
            }
        });

        tablepesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama", "No Telpon", "Email", "Lokasi", "Merk", "Ukuran"
            }
        ));
        jScrollPane2.setViewportView(tablepesan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuutama)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(menuutama)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuutamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuutamaActionPerformed
        menuawal awal = new menuawal();
        awal.setVisible(true);
        this.getDesktopPane().add(awal);
        this.dispose();
    }//GEN-LAST:event_menuutamaActionPerformed
public void showtable(String sql){
        try{
            Statement stat = (Statement)koneksi.connectDatabase().createStatement();          
            ResultSet rs = stat.executeQuery(sql);
            DefaultTableModel tableModel;
            tableModel = (DefaultTableModel)tablepesan.getModel();
            tableModel.getDataVector().removeAllElements();
            while(rs.next()){
                tableModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7)
                });
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(tblpemesan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton menuutama;
    private javax.swing.JTable tablepesan;
    // End of variables declaration//GEN-END:variables
}
