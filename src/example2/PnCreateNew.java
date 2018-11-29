/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example2;

import java.net.MalformedURLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
/**
 *
 * @author noobf
 */
public class PnCreateNew extends javax.swing.JPanel {
    File selectedFile;
   
    /**
     * Creates new form PnCreateNew
     */
    public PnCreateNew() {
        initComponents();
        ButtonGroup bG = new ButtonGroup();
        bG.add(rbOne);
        bG.add(rbFile);
    }
    
    private JPanel pnCreateNew;
    /**
     * Xác định panel sẽ hiển thị khi quay lại trang home
     * @param pnCreateNew
     */
    public void PnBacktoMain(JPanel pnCreateNew){
        this.pnCreateNew = pnCreateNew;
    }; 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTittle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbInfo = new javax.swing.JTable();
        btBack = new javax.swing.JButton();
        thumb = new javax.swing.JLabel();
        btChooseImage = new javax.swing.JButton();
        rbOne = new javax.swing.JRadioButton();
        rbFile = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        btChooseFile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbFilePatch = new javax.swing.JLabel();
        btSubmit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thêm mới hồ sơ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));

        lbTittle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbTittle.setText("THÔNG TIN SINH VIÊN");

        tbInfo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tbInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Họ và tên", null},
                {"Giới tính", null},
                {"Số điện thoại", null},
                {"Địa chỉ email", null},
                {"Ngày sinh", null},
                {"Quên quán", null},
                {"Lớp", null},
                {"Số CMND", null},
                {"Mã phòng kí túc", null}
            },
            new String [] {
                "Thông tin", "Chi tiết"
            }
        ));
        tbInfo.setAutoscrolls(false);
        tbInfo.setRowHeight(25);
        jScrollPane1.setViewportView(tbInfo);
        if (tbInfo.getColumnModel().getColumnCount() > 0) {
            tbInfo.getColumnModel().getColumn(0).setResizable(false);
            tbInfo.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbInfo.getColumnModel().getColumn(1).setResizable(false);
            tbInfo.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        btBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btBack.setText("<html>Back ↵");
        btBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBackMouseClicked(evt);
            }
        });

        thumb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        thumb.setMaximumSize(new java.awt.Dimension(160, 240));
        thumb.setMinimumSize(new java.awt.Dimension(160, 240));
        thumb.setPreferredSize(new java.awt.Dimension(160, 240));

        btChooseImage.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btChooseImage.setText("Tải ảnh");
        btChooseImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btChooseImageMouseClicked(evt);
            }
        });

        rbOne.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rbOne.setText("Nhập thủ công");

        rbFile.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rbFile.setText("Nhập dữ liệu từ file excel");

        btChooseFile.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btChooseFile.setText("Chọn File");
        btChooseFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btChooseFileMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("File patch:");

        btSubmit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSubmit.setForeground(new java.awt.Color(204, 0, 0));
        btSubmit.setText("<html>&#10004; Hoàn tất");
        btSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSubmitMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Font Awesome 5 Free Solid", 0, 18)); // NOI18N
        jLabel2.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFilePatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thumb, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbOne)
                            .addComponent(rbFile))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbTittle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(rbOne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTittle))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thumb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btChooseImage)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(rbFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btChooseFile)
                        .addComponent(jLabel1))
                    .addComponent(lbFilePatch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBackMouseClicked
        JFrame parent = Utitilities.findJFrameOf(this);
        if (parent != null) {
            thumb.setIcon(null);
            int i = 0;
            for(; i < 10 ; i++){
                tbInfo.getModel().setValueAt("", i, 1);
            }
            parent.setContentPane(pnCreateNew);
            parent.pack();
        } else {
            JOptionPane.showMessageDialog(parent, "Panel Login only used for JFrame");
            System.exit(1);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btBackMouseClicked
    
    private void btChooseFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btChooseFileMouseClicked
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().
        getHomeDirectory());
        jfc.setDialogTitle("Chọn một file excel để lấy thông tin: ");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Only excel file", "xls", "xlsx");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                lbFilePatch.setText(selectedFile.getAbsolutePath());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btChooseFileMouseClicked

    private void btChooseImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btChooseImageMouseClicked
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().
        getHomeDirectory());
        jfc.setDialogTitle("Chọn ảnh đại diện: ");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Only image file", "png", "jpg");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = jfc.getSelectedFile();
                String imgURL =selectedFile.getAbsolutePath();
                ImageIcon icon = new ImageIcon(imgURL); 
                thumb.setIcon(icon);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btChooseImageMouseClicked
    
    private StringBody[] getInfo() throws UnsupportedEncodingException{
        StringBody[] arr = new StringBody[10];
        int i = 0;
        for(; i < 9; i++){
            String words = (String)tbInfo.getModel().getValueAt(i, 1);
            if(words == null){
                JOptionPane.showMessageDialog(null, "Nhập thiếu thông tin", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                break;
            }else{
                arr[i] = new StringBody(words);
            }
        }
        arr[9] = new StringBody("0");
        return arr;
    }
    
    private void createNew() throws MalformedURLException, IOException{
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://localhost:3000/api/create");
        if(rbOne.isSelected() == true){
            StringBody[] arr = getInfo();
            int i = 0;
            for(; i < 10; i++){
                if(arr[i] == null) return;
            }
            try {
                FileBody bin = new FileBody(selectedFile);
                MultipartEntity reqEntity = new MultipartEntity();
                reqEntity.addPart("avatar", bin);
                String[] nameBody = {"name", "gender", "phone", "email", "birthday",
                "city", "class", "identify", "room", "times"};
                i = 0;
                for(; i < 10; i++){
                    reqEntity.addPart(nameBody[i], arr[i]);
                }               
                httppost.setEntity(reqEntity);
                HttpResponse httpres = httpclient.execute(httppost);
                int code = httpres.getStatusLine().getStatusCode();
                if(code == 200){
                    JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!",
                            "Thành công", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (ClientProtocolException e) {
            } finally {
                httpclient.getConnectionManager().shutdown();
            }
       }
       else if(rbFile.isSelected() == true){
       
       }else{
           JOptionPane.showMessageDialog(null, "Hãy lựa chọn một hình thức thêm mới thông tin sinh viên",
                   "Lỗi", JOptionPane.INFORMATION_MESSAGE);
       }      
 }
    private void btSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSubmitMouseClicked
        int option = JOptionPane.showConfirmDialog(null, "Xác nhận thêm thông tin sinh viên?",
                "Xác nhận" ,JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
            try {
                createNew();
                // TODO add your handling code here:
            } catch (IOException ex) {
                Logger.getLogger(PnCreateNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            return;
        }
    }//GEN-LAST:event_btSubmitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btChooseFile;
    private javax.swing.JButton btChooseImage;
    private javax.swing.JButton btSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbFilePatch;
    private javax.swing.JLabel lbTittle;
    private javax.swing.JRadioButton rbFile;
    private javax.swing.JRadioButton rbOne;
    private javax.swing.JTable tbInfo;
    private javax.swing.JLabel thumb;
    // End of variables declaration//GEN-END:variables
}
