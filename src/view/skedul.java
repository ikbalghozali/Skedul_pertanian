/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author MSI GF75
 */
public final class skedul extends javax.swing.JFrame {
    
    public void tanggal(){
        Date ys = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        txttgl.setText(s.format(ys));
    }

    /**
     * Creates new form skedul
     */
    private DefaultTableModel model;
    
    
    
    public skedul() {
        initComponents();
        tanggal();
       
        
        //membuat tableModel
        model = new DefaultTableModel();
        
        //menambahkan tablemodel ke tabel
        tabelSkedul.setModel(model);
        
        model.addColumn("No.");
        model.addColumn("Judul");
        model.addColumn("Tanggal");
        model.addColumn("Note");
        
        //panggil load data
        loadData();
    }

    public void loadData(){
        //menghapus seluruh data
        model.getDataVector().removeAllElements();
        
        //memberi tahu bahwa data telah kosong
        model.fireTableDataChanged();
        
        try{
            int no = 1;
            Connection c = KoneksiDatabase.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM skedul";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[6];
                o[0] = no++;
                o[1] = r.getString("Judul");
                o[2] = r.getString("Tanggal");
                o[3] = r.getString("Note");

                
                model.addRow(o);
            }
            r.close();
            s.close();
            
        }
        catch(SQLException e){
            
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        inputJudul = new javax.swing.JTextField();
        inputTanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputNote = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelSkedul = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Tambah = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txttgl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edukasi = new javax.swing.JLabel();
        about = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        bng = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1152, 840));
        setPreferredSize(new java.awt.Dimension(1152, 840));
        setResizable(false);

        jPanel12.setPreferredSize(new java.awt.Dimension(1152, 840));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel12.add(inputJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 210, -1));
        jPanel12.add(inputTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 210, -1));

        inputNote.setColumns(20);
        inputNote.setRows(5);
        jScrollPane1.setViewportView(inputNote);

        jPanel12.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 210, 130));

        tabelSkedul.setBackground(new java.awt.Color(66, 77, 131));
        tabelSkedul.setForeground(new java.awt.Color(160, 176, 253));
        tabelSkedul.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title1", "Title2", "Title3", "Title4"
            }
        ));
        tabelSkedul.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelSkedul.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tabelSkedul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSkedulMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelSkedul);
        if (tabelSkedul.getColumnModel().getColumnCount() > 0) {
            tabelSkedul.getColumnModel().getColumn(0).setResizable(false);
            tabelSkedul.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabelSkedul.getColumnModel().getColumn(1).setResizable(false);
            tabelSkedul.getColumnModel().getColumn(1).setPreferredWidth(120);
            tabelSkedul.getColumnModel().getColumn(2).setResizable(false);
            tabelSkedul.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelSkedul.getColumnModel().getColumn(3).setResizable(false);
            tabelSkedul.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        jPanel12.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 470, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Judul      :");
        jPanel12.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 70, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tanggal  :");
        jPanel12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 70, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Note       :");
        jPanel12.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 70, -1));

        Tambah.setText("Tambah");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });
        jPanel12.add(Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 610, -1, -1));

        Edit.setText("Edit");
        Edit.setPreferredSize(new java.awt.Dimension(71, 23));
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        jPanel12.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 610, -1, -1));

        Hapus.setText("Hapus");
        Hapus.setPreferredSize(new java.awt.Dimension(71, 23));
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });
        jPanel12.add(Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tangggal Hari Ini :");
        jPanel12.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 140, 30));

        txttgl.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txttgl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttgl.setEnabled(false);
        jPanel12.add(txttgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 150, -1));
        jPanel12.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1158, 382, -1, -1));

        edukasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edukasiMouseClicked(evt);
            }
        });
        jPanel12.add(edukasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 30, 40));

        about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMouseClicked(evt);
            }
        });
        jPanel12.add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 30, 40));

        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        jPanel12.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 30, 40));

        bng.setForeground(new java.awt.Color(255, 255, 255));
        bng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/bgn2.png"))); // NOI18N
        jPanel12.add(bng, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        // TODO add your handling code here:
        String tampilan ="dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(inputTanggal.getDate()));
        String judul = inputJudul.getText();
        String note = inputNote.getText();

        
        try{
            Connection c = KoneksiDatabase.getKoneksi();
            String sql = ("INSERT INTO skedul VALUES (?, ?, ?)");
            PreparedStatement p = c.prepareStatement(sql);
            
            
            p.setString(1, judul);
            p.setString(2, tanggal);
            p.setString(3, note);

            
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
            
        }catch(SQLException e){
            System.out.println("Terjadi error tambah");
        }finally{
            loadData();
        }
    }//GEN-LAST:event_TambahActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        // TODO add your handling code here:
        int i = tabelSkedul.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        
        String judul = (String) model.getValueAt(i, 1);
        
         try{
            Connection c = KoneksiDatabase.getKoneksi();
            String sql = "DELETE FROM skedul WHERE judul = ? ";
            
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, judul);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            
        }catch(SQLException e){
            System.out.println("Terjadi error hapus");
        }finally{
            loadData();
        }
    }//GEN-LAST:event_HapusActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:
        int i = tabelSkedul.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        
        //ambil nim yang terseleksi
        String judul = (String) model.getValueAt(i, 1);
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(inputTanggal.getDate()));
        String note = inputNote.getText();
        
        try{
            Connection c = KoneksiDatabase.getKoneksi();
            String sql = "UPDATE skedul SET tanggal = ?, note = ? WHERE judul = ?";
            
            PreparedStatement p = c.prepareStatement(sql);
            

            p.setString(1, tanggal);
            p.setString(2, note);
            p.setString(3, judul);
            
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            
        }catch(SQLException e){
            System.out.println("Terjadi error ubah");
        }finally{
            loadData();
        }
    }//GEN-LAST:event_EditActionPerformed

    private void tabelSkedulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSkedulMouseClicked
        // TODO add your handling code here:
        int i = tabelSkedul.getSelectedRow();
         if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
         
        String nim = (String) model.getValueAt(i, 1);
        inputJudul.setText(nim);
        
        String nama = (String) model.getValueAt(i, 3);
        inputNote.setText(nama);
    }//GEN-LAST:event_tabelSkedulMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_homeMouseClicked

    private void aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutMouseClicked

    private void edukasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edukasiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_edukasiMouseClicked

    
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
            java.util.logging.Logger.getLogger(skedul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(skedul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(skedul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(skedul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new skedul().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Edit;
    private javax.swing.JButton Hapus;
    private javax.swing.JButton Tambah;
    private javax.swing.JLabel about;
    private javax.swing.JLabel bng;
    private javax.swing.JLabel edukasi;
    private javax.swing.JLabel home;
    private javax.swing.JTextField inputJudul;
    private javax.swing.JTextArea inputNote;
    private com.toedter.calendar.JDateChooser inputTanggal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelSkedul;
    private javax.swing.JTextField txttgl;
    // End of variables declaration//GEN-END:variables
}
