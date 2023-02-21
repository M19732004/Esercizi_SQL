import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Students04_view {
   String name;
    String surname;

    Students04_view(String name,String surname){
       this.name=name;
       this.surname=surname;


       }

        public static void main(String[] args) {


            Connection connection= null;

            try {
                String DB_URL="jdbc:mysql://localhost:3306/newdb";
                String  user="root";
                String  password="Rudy32?%";
                connection= DriverManager.getConnection(DB_URL,user,password);

                Statement statement;
                statement = connection.createStatement();
                String varname3="DROP VIEW IF EXISTS `newdb`.`italian_students`"   ;
                statement.executeUpdate(varname3);

                String varname5="SELECT * FROM newdb.students;";
                ResultSet rs= statement.executeQuery(varname5);

                List<String> surnames=new ArrayList<>();
                while (rs.next()){

                    System.out.println(rs.getString( "last_name")+" "+ rs.getString("fiest_name") +"\n");
                   rs.next();
                    String varname1 = ""
                        + "CREATE "
                        + "    ALGORITHM = UNDEFINED "
                        + "    DEFINER = `root`@`localhost` "
                        + "    SQL SECURITY DEFINER "
                        + "VIEW `newdb`.`italian_students` AS "
                       + "    SELECT "
                        + "        `newdb`.`students`.`last_name` AS `last_name`, "
                        + "        `newdb`.`students`.`fiest_name` AS `fiest_name` "
                        + "    FROM "
                        + "        `newdb`.`students` "
                        + "    WHERE "
                        + "        (`newdb`.`students`.`country` = 'Italia')";
                String varname4="DROP VIEW IF EXISTS `newdb`.`german_students`"   ;
                statement.executeUpdate(varname4);


               String varname2 = ""
                        + "CREATE "
                        + "    ALGORITHM = UNDEFINED "
                        + "    DEFINER = `root`@`localhost` "
                        + "    SQL SECURITY DEFINER "
                        + "VIEW `newdb`.`german_students` AS "
                        + "    SELECT "
                        + "        `newdb`.`students`.`last_name` AS `last_name`, "
                        + "        `newdb`.`students`.`fiest_name` AS `fiest_name` "
                        + "    FROM "
                        + "        `newdb`.`students` "
                        + "    WHERE "
                        + "        (`newdb`.`students`.`country` = 'Germany')";

                    statement.executeUpdate(varname1);
                    statement.executeUpdate(varname2);

                    surnames.stream().forEach(s -> System.out.println(s));

                }
                statement.close();
                connection.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


