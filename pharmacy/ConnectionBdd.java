
import java.sql.*;
import java.sql.DriverManager;

public class ConnectionBdd {

Connection connect;
public ConnectionBdd(){
    try{
        Class.forName("com.mysql.jdbc.Driver");        
    }catch(Exception e){
        System.err.println(e);         
    }
    try{
        connect =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pharmacie","root","");
    }catch(Exception e){
        System.err.println(e);
    }
}
    Connection obtenirconnexion(){return connect;}
}