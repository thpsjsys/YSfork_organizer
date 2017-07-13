package resources.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hhf on 6/28/17.
 */
public class DB {
    private final String DRIVER="com.mysql.jdbc.Driver";
    private final String DATABASE_URL="jdbc:mysql://localhost:3306/organizer?useSSL=false";

    private String userName="user";
    private String password="Password&&123H";


    public DB(){
        /*try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){System.out.println("Driver not fount :"+e.getMessage());}*/
    }
    private Connection openConnection() {
        try {

            return DriverManager.getConnection(DATABASE_URL, userName, password);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    public void update(String query){
        Connection connection = openConnection();
        Statement statement=null;
        try {
            if(connection!=null) {
                statement = connection.createStatement();
                statement.execute(query);
            }
        }catch(SQLException e){System.out.println(e.getMessage());}
        finally {
            try{
                if(statement!=null) statement.close();
                if(connection!=null) connection.close();
            }catch (SQLException e){System.out.println(e.getMessage());}
        }

    }
    public Connection updatePrepare(String query) throws SQLException{
        return openConnection();
    }

    public List read(String query){
        Connection connection = openConnection();
        Statement statement=null;
        ResultSet rs=null;
        try {
            if(connection!=null) {
                statement = connection.createStatement();
                rs = statement.executeQuery(query);
                return resultToArray(rs);
            }
        }catch(SQLException e){System.out.println(e.getMessage());}
        finally {
            try{
                if(statement!=null) statement.close();
                if(connection!=null) connection.close();
                if(rs!=null) rs.close();
            }catch (SQLException e){System.out.println(e.getMessage());}
        }
        return null;

    }
    private List resultToArray(ResultSet rs) throws SQLException{
        ResultSetMetaData md=rs.getMetaData();
        int col=md.getColumnCount();
        ArrayList list=new ArrayList();
        while(rs.next()){
            HashMap row=new HashMap(col);
            for(int i=1;i<=col;i++) row.put(md.getColumnName(i),rs.getObject(i));
            list.add(row);
        }
        return list;
    }
}