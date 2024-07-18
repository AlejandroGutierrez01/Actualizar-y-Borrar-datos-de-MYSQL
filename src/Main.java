//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//public class Main {
//    public static void main(String[] args) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        String sql = "update estudiantes set b1 = ? where cedula = ?";
//        try{
//            connection= DriverManager.getConnection(url,user,password);
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setDouble(1, 19.2);
//            preparedStatement.setString(2,"0651651651");
//            int a = preparedStatement.executeUpdate();
//            System.out.println(a);
//        }
//        catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//        finally{
//            try{
//                if (preparedStatement!= null){
//                    preparedStatement.close();
//                }
//                if (connection != null){
//                    connection.close();
//                }
//            }
//            catch (SQLException e){
//                System.out.println(e.getMessage());
//            }
//            }
//        }
//    }
//}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
        String user = "root";
        String password = "123456";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //INSERT
//        Estudiantes estudiante = new Estudiantes("0651651651","Isaac Quinapallo", 15.21F, 11.24F);
//        String sql = "INSERT INTO estudiantes (cedula,nombre,b1,b2) VALUES(?,?,?,?)";
//        try(Connection connection= DriverManager.getConnection(url,user,password)) {
//            System.out.println("Listo");
//            PreparedStatement cadenaPreparada = connection.prepareStatement(sql);
//            cadenaPreparada.setString(1, estudiante.getCedula());
//            cadenaPreparada.setString(2, estudiante.getNombre());
//            cadenaPreparada.setFloat(3, estudiante.getB1());
//            cadenaPreparada.setFloat(4, estudiante.getB2());
//            cadenaPreparada.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        //UPDATE
//        String sql = "update estudiantes set b1 = ? where cedula = ?";
//        try {
//            connection = DriverManager.getConnection(url, user, password);
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setDouble(1, 10);
//            preparedStatement.setString(2, "0651651651");
//            int a = preparedStatement.executeUpdate();
//            System.out.println(a + " fila(s) actualizada(s).");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            //para cerrar la conexion con la database
//            try {
//                if (preparedStatement != null){
//                    preparedStatement.close();}
//                if (connection != null){
//                    connection.close();}
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }

        //DELETE
        String sql = "delete from estudiantes where cedula = ?";
        try{
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "0055296473");
            int filas = preparedStatement.executeUpdate();
            if(filas > 0){
                System.out.println("Estudiante eliminado");
            }
            else {
                System.out.println("Estudiante no eliminado");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
