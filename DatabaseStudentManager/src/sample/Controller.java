package sample;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.data.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controller {
    private static final String MYSQL_CONNECTION = "jdbc:mysql://localhost/classroom?user=root";
    private static final String MSSQL_EXPRESS_CONNECTION = "jdbc:sqlserver://JERASUS\\SQLEXPRESS;databaseName=classroom;integratedSecurity=true";
    private Connection connection;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtAnimal;
    @FXML
    private TextField txtBallance;

    public void connectToMySql(){
        try {
            connection = DriverManager.getConnection(MYSQL_CONNECTION);
            System.out.println("MySQL Connected");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("MySQL Failed to connect :(");
        }
    }

    public void connectToSqlServerExpress(){
        try{
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            DriverManager.setLoginTimeout(2);
            connection = DriverManager.getConnection(MSSQL_EXPRESS_CONNECTION);
            System.out.println("MSSQL Express Connected");

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("MSSQL Express Failed to connect :(");
        }
    }

    public void createStudent(){
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String animal = txtAnimal.getText();
        int ballance = Integer.parseInt(txtBallance.getText());
        Student stu = new Student(name, age, animal, ballance);
        stu.save(connection);
    }

    public void getStudents(){
        try {
            Statement stm = connection.createStatement();
            ResultSet results =  stm.executeQuery("SELECT * FROM student");
            ResultSetMetaData meta = results.getMetaData();

            List<String> columns = new ArrayList<>();
            for(int i=0; i<meta.getColumnCount(); i++) {
                // Indexed starting with 1, because databases
                columns.add(meta.getColumnLabel(i+1));
            }

            // Loops through results one row at a time
            while(results.next()){
                System.out.println("---- Next Row ----");
                for(String col : columns) {
                    System.out.println(col +": " + results.getString(col));
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Something went wrong, le :(");
        }
    }


}
