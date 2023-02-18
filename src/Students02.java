
import java.sql.*;

public class Students02 {
    public static void main(String[] args) {

        Connection connection= null;

        try {
            String DB_URL="jdbc:mysql://localhost:3306/newdb";
            String  user="developer";
            String  password="%Rudy%";
            connection=DriverManager.getConnection(DB_URL,user,password);

            Statement statement;
            statement = connection.createStatement();
            String varname1="DROP TABLE IF EXISTS `newdb`.`students`"   ;
            statement.executeUpdate(varname1);
            System.out.println("eliminazione tabella Students se esiste");
            String varname2 = ""
                    + "CREATE TABLE `students` ( "
                    + "  ` id_Students` int NOT NULL AUTO_INCREMENT, "
                    + "  `last_ name` varchar(30) NOT NULL, "
                    + "  `fiest_name` varchar(30) NOT NULL, "
                    + "  PRIMARY KEY (` id_Students`), "
                    + "  UNIQUE KEY ` id_Students_UNIQUE` (` id_Students`) "
                    + ") ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
            statement.executeUpdate(varname2);
            System.out.println("creata tabella Students");

            String varname3="INSERT INTO `newdb`.`students` (` id_Students`, `last_ name`, `fiest_name`) VALUES (' 1',' Mirco', 'Pacciani')";
            statement.executeUpdate(varname3);
            System.out.println("inserita prima riga ");
            String varname4="INSERT INTO `newdb`.`students` (` id_Students`, `last_ name`, `fiest_name`) VALUES (' 2', 'Tib', 'Marconi')";
            statement.executeUpdate(varname4);
            System.out.println("inserita seconda riga ");
            String varname5="INSERT INTO `newdb`.`students` (` id_Students`, `last_ name`, `fiest_name`) VALUES ('3',' Olga', 'Solarre')";
            statement.executeUpdate(varname5);
            System.out.println("inserita terza riga ");
            String varname6="INSERT INTO `newdb`.`students` (` id_Students`, `last_ name`, `fiest_name`) VALUES ('4',' Daria', 'Fighetto')";
            statement.executeUpdate(varname6);
            System.out.println("inserita quarta riga ");



        } catch (Exception e) {
             e.printStackTrace();
        }
    }
}
