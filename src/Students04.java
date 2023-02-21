import java.sql.*;

public class Students04 {
    public static void main(String[] args) {

        Connection connection= null;

        try {
            String DB_URL="jdbc:mysql://localhost:3306/mydb";
            String  user="root" ;
            String  password="Mara32?%";
            connection=DriverManager.getConnection(DB_URL,user,password);

            Statement statement;
            statement = connection.createStatement();
            String varname1 = ""
                    + "ALTER TABLE `mydb`.`students` "
                    + "ADD COLUMN `country` VARCHAR(30) NOT NULL AFTER `fiest_name`;";
            statement.executeUpdate(varname1);
            String varname2 = ""
                    + "UPDATE `mydb`.`students` SET `country` = 'Italia' WHERE (`id_Students` = '2');";


            String pippo = ""
                    + "UPDATE `mydb`.`students` SET `country` = 'Germany' WHERE (`id_Students` = '3');";


            String pluto = ""
                    + "UPDATE `mydb`.`students` SET `country` = 'Germany' WHERE (`id_Students` = '4');";


            String paperino = ""
                    + "UPDATE `mydb`.`students` SET `country` = 'Italia' WHERE (`id_Students` = '1');";

            statement.executeUpdate(varname2);
            statement.executeUpdate(pippo);
            statement.executeUpdate(pluto);
            statement.executeUpdate(paperino);

            statement.close();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
