package Pharmacy;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class connection {

    private static String url = "";
    private static Connection con;

    private static void SetURL() {
        url = "jdbc:mysql://localhost:3306/pharmacie"
                + "?useUnicode=true&characterEncoding=UTF-8";
    }

    private static void SetConnection() {
        try {
            SetURL();
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static boolean CheckUserAndPass(String UserName, String Password) {
        secureData secure = new secureData();
        try {
            SetConnection();
            Statement stm = con.createStatement();
            String StrCheck;
            try {
                StrCheck = "select * from users where username='" + UserName + "' and password='" + secure.encrypt("clubinfo2020", Password) + "'";
                stm.executeQuery(StrCheck);
                if (stm.getResultSet().next()) {
                    con.close();
                    return true;
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | IOException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    static Connection conn = null;
    static PreparedStatement preapared = null;
    static ResultSet rs = null;

    public static void updateAI() {
        conn = getConnection();
        String q1 = "SET @num := 0";
        String q2 = "UPDATE drug SET id = @num := (@num+1)";
        String q3 = "ALTER TABLE drug AUTO_INCREMENT =1";
        try {
            preapared = conn.prepareStatement(q1);
            preapared.executeUpdate();
            preapared = conn.prepareStatement(q2);
            preapared.executeUpdate();
            preapared = conn.prepareStatement(q3);
            preapared.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static boolean CheckEmail(String Email) {
        try {
            SetConnection();
            Statement stm = con.createStatement();
            String StrCheck = "select * from users where contact='" + Email + "'";
            stm.executeQuery(StrCheck);
            if (stm.getResultSet().next()) {
                con.close();
                return true;
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    public static String getEmailPass(String Email) {
        secureData secure = new secureData();
        try {
            SetConnection();
            Statement stm = con.createStatement();
            ResultSet rs;
            String StrCheck = "select pass from sender where email='" + Email + "'";
            rs = stm.executeQuery(StrCheck);
            if (rs.next()) {
                return rs.getString("pass");
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return "";
    }

    public static Connection getConnection() {
        try {
            SetURL();
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return con;
    }

    static boolean CheckUserAndPass(JTextField UserName, JPasswordField pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Connection connect;

    public static void showMedicamentsInJCombo(JComboBox combo) {
        Connection connection = getConnection();
        String query = "select * from medicaments";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                combo.addItem(rs.getString("name"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void showDataAfterClickingJcombo(JComboBox combo, JTextField nlot, JTextField resteDestock, JTextField prix, JTextField expDate) {
        Connection connection = getConnection();
        String MyItem = combo.getEditor().getItem().toString().trim();
        String query = "select * from medicaments where name = '" + MyItem + "' ";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                nlot.setText(rs.getString("nlot"));
                resteDestock.setText(rs.getString("rstocke"));
                prix.setText(rs.getString("price"));
                expDate.setText(rs.getString("fullexp"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void showDataAfterClickingJcombo(JComboBox combo, JTextField nlot, JTextField resteDestock, JTextField prix, JComboBox day, JComboBox month, JComboBox year) {
        Connection connection = getConnection();
        String MyItem = combo.getEditor().getItem().toString().trim();
        String query = "select * from medicaments where name = '" + MyItem + "' ";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                nlot.setText(rs.getString("nlot"));
                resteDestock.setText(rs.getString("quantity"));
                prix.setText(rs.getString("price"));
                day.setSelectedItem(rs.getString("exday"));
                month.setSelectedItem(rs.getString("exmonth"));
                year.setSelectedItem(rs.getString("exyear"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
