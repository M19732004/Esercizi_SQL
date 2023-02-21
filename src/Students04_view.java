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
                String DB_URL="jdbc:mysql://localhost:3306/mydb";
                String  user="root";
                String  password="Mara32?%";

                connection= DriverManager.getConnection(DB_URL,user,password);
                Statement statement;
                statement = connection.createStatement();

                String varname3="DROP VIEW IF EXISTS `mydb`.`italian_students`"   ;
                statement.executeUpdate(varname3);
                String varname4="DROP VIEW IF EXISTS `mydb`.`germany_students`"   ;
                statement.executeUpdate(varname4);


                String varname1 = ""
                        + "CREATE "
                        + "    ALGORITHM = UNDEFINED "
                        + "    DEFINER = `root`@`localhost` "
                        + "    SQL SECURITY DEFINER "
                        + "VIEW `mydb`.`italian_students` AS "
                        + "    SELECT "
                        + "        `mydb`.`students`.`last_name` AS `last_name`, "
                        + "        `mydb`.`students`.`fiest_name` AS `fiest_name` "
                        + "    FROM "
                        + "        `mydb`.`students` "
                        + "    WHERE "
                        + "        (`mydb`.`students`.`country` = 'Italia')";

                String varname2 = ""
                        + "CREATE "
                        + "    ALGORITHM = UNDEFINED "
                        + "    DEFINER = `root`@`localhost` "
                        + "    SQL SECURITY DEFINER "
                        + "VIEW `mydb`.`germany_students` AS "
                        + "    SELECT "
                        + "        `mydb`.`students`.`last_name` AS `last_name`, "
                        + "        `mydb`.`students`.`fiest_name` AS `fiest_name` "
                        + "    FROM "
                        + "        `mydb`.`students` "
                        + "    WHERE "
                        + "        (`mydb`.`students`.`country` = 'Germany')";

                statement.executeUpdate(varname1);
                statement.executeUpdate(varname2);

                String varname5="SELECT * FROM `mydb`.`italian_students`";
                ResultSet rs1= statement.executeQuery(varname5);
                List<String> surnames1=new ArrayList<>();

                while (rs1.next()){
                    surnames1.add(rs1.getString("last_name")+" "+rs1.getString("fiest_name"));
                }
                surnames1.stream().forEach(s -> System.out.println(s));

                String varname7="SELECT * FROM `mydb`.`germany_students`";
                ResultSet rs2= statement.executeQuery(varname7);
                List<String>surnames2=new ArrayList<>();
                System.out.println("...................................................");
                while (rs2.next()){
                    surnames2.add(rs2.getString("last_name")+" "+rs2.getString("fiest_name"));
                }
                surnames2.stream().forEach(s -> System.out.println(s));

                statement.close();
                connection.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


