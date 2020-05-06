package sample.data;

import java.sql.*;

public class Student {
    int id;
    String name;
    int age;
    String animal;
    int ballance;

    public Student( String name, int age, String animal, int ballance) {
        this(-1, name, age, animal, ballance);
    }

    public Student(int id, String name, int age, String animal, int ballance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.animal = animal;
        this.ballance = ballance;
    }

    public boolean save(Connection connection) {
        try{
            Statement stm = connection.createStatement();
            String query =
                    "INSERT INTO student (student_name, age, animal, ballance) " +
                    "VALUES ('"+name+"',"+age+",'"+animal+"',"+ballance+")";
            boolean success = stm.execute(query);
            return success;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

}
