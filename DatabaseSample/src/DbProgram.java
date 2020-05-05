
public class DbProgram {
    public static void main(String[] args) {
//        testSqlExpress();
        testMySql();
    }

    public static void testSqlExpress(){
        SqlExpressConnection sqlexp = new SqlExpressConnection();
        if(sqlexp.isConnected()) {
            System.out.println("Connected");
            sqlexp.getStudents();
        }else {
            System.out.println("Fail blog");
        }
    }

    public static void testMySql(){
        MySqlConnection mysql = new MySqlConnection();
        if(mysql.isConnected()) {
            System.out.println("Connected");
            mysql.getStudents();
        }else {
            System.out.println("Fail blog");
        }
    }
}
