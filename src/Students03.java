import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;
//Esercizio_03

public class Students03 {
    public static void main(String[] args) {

        Connection connection= null;

        try {
            String DB_URL="jdbc:mysql://localhost:3306/mydb";
            String  user="developer";
            String  password="%Rudy%32";
            connection=DriverManager.getConnection(DB_URL,user,password);

            Statement statement;
            statement = connection.createStatement();

            String varname7="SELECT * FROM mydb.students;";
            ResultSet rs= statement.executeQuery(varname7);

            List<String>surnames=new ArrayList<>();
            while (rs.next()){

                System.out.println(rs.getString( "id_Students")+" "+
                        rs.getString("last_name")+" "
                        +rs.getString("fiest_name") +"\n");
                surnames.add(rs.getString("fiest_name"));

            }
            surnames.stream().forEach(s -> System.out.println(s));

            statement.close();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
