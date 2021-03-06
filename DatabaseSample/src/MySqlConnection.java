import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlConnection {
    private Connection connection;

    public MySqlConnection() {
        try {
            String dbURL = "jdbc:mysql://localhost/classroom?user=root";
            DriverManager.setLoginTimeout(1);
            connection = DriverManager.getConnection(dbURL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isConnected() {
        if(connection == null) return false;
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void getStudents(){
        try {
            Statement stm = connection.createStatement();
            ResultSet results = stm.executeQuery("SELECT * FROM student");
            ResultSetMetaData meta = results.getMetaData();
            List<String> columns = new ArrayList<>();
            // Indexed from 1, ugh
            for(int i=1; i<=meta.getColumnCount(); i++){
                columns.add(meta.getColumnLabel(i));
            }

            while(results.next()) {
                System.out.println("----- Next Row -----");
                for(String col : columns) {
                    System.out.println(col + ": " + results.getString(col));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
