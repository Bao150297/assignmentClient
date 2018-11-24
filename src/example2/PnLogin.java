/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example2;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.lang.Object;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * 
 */
public class PnLogin extends javax.swing.JPanel {
    String workingDir = System.getProperty("user.dir");
    private final String USER_AGENT = "Mozilla/5.0";
    File userInfo = new File(workingDir + "/temp/userInfo.txt");
    /**
     * Creates new form PnLogin
     */
    public PnLogin(){
        initComponents();
        ImageIcon icon1 = new ImageIcon(workingDir + "/icon/logo.jpg");
        lbIcon.setIcon(icon1);
        ImageIcon icon2 = new ImageIcon(workingDir + "/icon/power_by.png");
        lbSO.setIcon(icon2);
        ImageIcon icon3 = new ImageIcon(workingDir + "/icon/nodejs_icon.png");
        lbNodeJS.setIcon(icon3);
        ImageIcon icon4 = new ImageIcon(workingDir + "/icon/mongodb_icon.jpg");
        lbMDB.setIcon(icon4);
        ImageIcon icon5 = new ImageIcon(workingDir + "/icon/java_icon.jpg");
        lbJava.setIcon(icon5);
    }
    
    //panel sẽ được hiển thị khi login thành công
    private JPanel pnLoginSuccess;

    /**
     * Xác định panel sẽ hiển thị khi đăng nhập thành công
     * @param pnLoginSuccess
     */
    public void setPnLoginSuccess(JPanel pnLoginSuccess){
        this.pnLoginSuccess = pnLoginSuccess;
    };
    
    private JPanel pnLoginSuccess2;

    /**
     * Xác định panel sẽ hiển thị khi đăng nhập thành công
     * @param pnLoginSuccess2
     */
    public void setPnLoginSuccess2(JPanel pnLoginSuccess2){
        this.pnLoginSuccess2 = pnLoginSuccess2;
    };
    
    private String getInfo() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(userInfo));   
        String st = "";  
        st = br.readLine();
        String[] arr = st.split("/");
        br.close();
        return arr[2];
    }
    
    private void selectForm() throws IOException{
        String result = getInfo();
        JFrame parent = Utitilities.findJFrameOf(this);
        if("student".equals(result)){
            if (parent != null) {
                parent.setContentPane(pnLoginSuccess2);
                parent.pack();
            } else {
                JOptionPane.showMessageDialog(parent, "Panel Login only used for JFrame");
                System.exit(1);
            }
        }else if("user".equals(result)){
            if (parent != null) {
                parent.setContentPane(pnLoginSuccess);
                parent.pack();
            } else {
                JOptionPane.showMessageDialog(parent, "Panel Login only used for JFrame");
                System.exit(1);
            }
        }else{
            return;
        }
    }   
    
    private void loginRequest() throws Exception {
        if(txtID.getText().equals("") || txtPW.getPassword().length == 0){
            JOptionPane.showMessageDialog(null, "Nhập thiếu thông tin!", "Lỗi đăng nhập", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String url = "http://localhost:3000/auth/login";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String user = txtID.getText();
        String pass = new String(txtPW.getPassword());


        String urlParameters = "name=" + URLEncoder.encode(user, "UTF-8") +
        "&password=" + URLEncoder.encode(pass, "UTF-8");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        con.connect();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : ");
        System.out.println("Post parameters : " + urlParameters);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
        }
        in.close();
        System.out.println("Response Code : " + responseCode + "Reponse data : "+ response.toString());
        if(responseCode == 200){
            FileWriter f1 = new FileWriter(userInfo, false);
            f1.write(response.toString());
            f1.close();
            selectForm();
        }
        //print result
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPW = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lbIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbSO = new javax.swing.JLabel();
        lbNodeJS = new javax.swing.JLabel();
        lbMDB = new javax.swing.JLabel();
        lbJava = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đăng nhập", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 600));
        setRequestFocusEnabled(false);

        txtID.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtID.setNextFocusableComponent(txtPW);

        lblUsername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(102, 102, 102));
        lblUsername.setText("Tài khoản");

        lblPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(102, 102, 102));
        lblPassword.setText("Mật khẩu");

        txtPW.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPW.setNextFocusableComponent(btnLogin);

        btnLogin.setBackground(new java.awt.Color(51, 51, 51));
        btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lbIcon.setMaximumSize(new java.awt.Dimension(100, 100));
        lbIcon.setMinimumSize(new java.awt.Dimension(100, 100));
        lbIcon.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel2.setText("Hệ thống quản lý");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel3.setText("sinh viên kí túc xá");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("(hoặc số CMND)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(lbSO, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbJava, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMDB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbNodeJS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(253, 253, 253))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID)
                            .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbSO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbMDB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNodeJS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addComponent(lbJava, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsername)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword)
                            .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        JFrame parent = Utitilities.findJFrameOf(this);
        try {
            /*if (parent != null) {
            parent.setContentPane(pnLoginSuccess);
            parent.pack();
            } else {
            JOptionPane.showMessageDialog(parent, "Panel Login only used for JFrame");
            System.exit(1);
            };
            */
            loginRequest();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parent,"Tài khoản hoặc mật khẩu sai!",
                    "Lỗi đăng nhập!",JOptionPane.INFORMATION_MESSAGE);
            txtPW.setText("");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbJava;
    private javax.swing.JLabel lbMDB;
    private javax.swing.JLabel lbNodeJS;
    private javax.swing.JLabel lbSO;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtID;
    private javax.swing.JPasswordField txtPW;
    // End of variables declaration//GEN-END:variables
}
