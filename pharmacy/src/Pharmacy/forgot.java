/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static java.lang.Thread.sleep;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author 0day
 */
public class forgot extends javax.swing.JFrame {

    /**
     * Creates new form Account1
     */
    static boolean state = true;

    public forgot() {
        initComponents();
    }

    private void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        txtemail = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnsend = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        txtcode = new javax.swing.JTextField();
        check = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        sec = new javax.swing.JLabel();
        lblcode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1210, 670));
        jPanel1.setPreferredSize(new java.awt.Dimension(1210, 670));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(29, 32, 38));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 240, 20));

        txtemail.setBackground(new java.awt.Color(29, 32, 38));
        txtemail.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtemail.setForeground(new java.awt.Color(255, 255, 255));
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.setBorder(null);
        jPanel2.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 260, 50));

        jLabel19.setBackground(new java.awt.Color(29, 32, 38));
        jLabel19.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Email");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 60, 30));

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("P H A R M A C Y");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 60));

        btnsend.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnsend.setText("send");
        btnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendActionPerformed(evt);
            }
        });
        jPanel2.add(btnsend, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 680));

        jLabel18.setFont(new java.awt.Font("Zapfino", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Before the time :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 170, 40));

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 370, 20));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/person.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 70, 70));

        txtcode.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        txtcode.setForeground(new java.awt.Color(29, 32, 38));
        txtcode.setBorder(null);
        jPanel1.add(txtcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 370, 50));

        check.setBackground(new java.awt.Color(255, 255, 255));
        check.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        check.setText("Check the code");
        check.setToolTipText("Go to Login Screen");
        check.setBorder(null);
        check.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        jPanel1.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 150, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Forgot Your Password !");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 440, 50));

        jLabel20.setFont(new java.awt.Font("Zapfino", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Enter the code the you received in your email:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 420, 40));

        min.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        min.setForeground(new java.awt.Color(255, 0, 51));
        min.setText("01:");
        jPanel1.add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 30, 20));

        sec.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sec.setForeground(new java.awt.Color(255, 0, 51));
        sec.setText("30");
        jPanel1.add(sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, -1, 20));
        jPanel1.add(lblcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        String entredCode = getText(txtcode);
        String correctCode = lblcode.getText();
        if (entredCode.equals(correctCode)) {            
            this.dispose();
            update u = new update(getText(txtemail));
            u.setLocationRelativeTo(null);
            u.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "l code li dakhlto ghalat");
        }
    }//GEN-LAST:event_checkActionPerformed
    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
    int miliseconds;
    int seconds;
    int minutes;

    public void Timer() {        
        btnsend.setEnabled(false);                
        seconds = Integer.parseInt(sec.getText());
        minutes = Integer.parseInt(min.getText().substring(0, 2));
        state = true;
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (state) {
                        try {
                            sleep(1);
                            if (miliseconds > 1000) {
                                miliseconds = 0;
                                seconds--;
                            }
                            if (seconds < 0) {
                                miliseconds = 0;
                                seconds = 59;
                                minutes--;
                            }
                            if (seconds < 10) {
                                sec.setText("0" + seconds);
                            } else {
                                sec.setText("" + seconds);
                            }
                            if (minutes < 10) {
                                min.setText("0" + minutes + ":");
                            } else {
                                min.setText("" + minutes + ":");
                            }
                            if (min.getText().equals("00:") && sec.getText().equals("00")) {
                                JOptionPane.showMessageDialog(null, "Time end!");                                
                                btnsend.setEnabled(true);
                                txtcode.setEditable(false);
                                check.setEnabled(false);
                                state = false;
                                min.setText("01:");
                                sec.setText("30");
                            }
                            miliseconds++;
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    } else {
                        break;
                    }
                }
            }
        };
        t.start();
    }
    private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendActionPerformed
        // TODO add your handling code here:
        secureData secure = new secureData();
        if (checkString(getText(txtemail))) {
            JOptionPane.showMessageDialog(null, "please enter you gmail");
        } else {
            try {
                if (connection.CheckEmail(getText(txtemail))) {
                    String[] to = {getText(txtemail)};
                    String myEmail = "wassimaghali2018@gmail.com";
                    String encPassword = connection.getEmailPass(myEmail);
                    String decPassword = secure.decrypt("clubinfo2020", encPassword);
                    String code = getRandomNumberString();
                    sendFromGMail(myEmail, decPassword, to, "Forgot Password", "You code to recover your account is:".concat(code));
                    lblcode.setText(code);
                    JOptionPane.showMessageDialog(null, "Check the inbox of your E-Mail <".concat(getText(txtemail)).concat(">"));
                    txtcode.setEditable(true);
                    check.setEnabled(true);
                    Timer();
                } else {
                    JOptionPane.showMessageDialog(null, "Hada l email makach f database !");
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | IOException ex) {
                Logger.getLogger(forgot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_btnsendActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        lblcode.setVisible(false);
        check.setEnabled(false);
        txtcode.setEditable(false);
    }//GEN-LAST:event_formWindowOpened

    public String getText(JTextField str) {
        return str.getText().trim();
    }
    Connection conn = null;
    PreparedStatement preapared = null;
    ResultSet rs = null;

    public boolean checkString(String... strings) {
        boolean compare = false;
        for (String string : strings) {
            if (string.equals("")) {
                compare |= true;
            }
        }
        return compare;
    }

    public void setDefault() {
        txtemail.setText("");
        txtcode.setText("");
        txtemail.setText("");

    }

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
            java.util.logging.Logger.getLogger(forgot.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgot.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgot.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgot.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsend;
    public javax.swing.JButton check;
    public javax.swing.JButton jButton7;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblcode;
    private javax.swing.JLabel min;
    private javax.swing.JLabel sec;
    public javax.swing.JTextField txtcode;
    public javax.swing.JTextField txtemail;
    // End of variables declaration//GEN-END:variables
}
