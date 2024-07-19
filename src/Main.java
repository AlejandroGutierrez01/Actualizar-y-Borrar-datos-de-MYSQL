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
import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10720936";
        String user = "sql10720936";
        String password = "TQeMDi1ru2";

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
//        String sql = "delete from estudiantes where cedula = ?";
//        try{
//            connection = DriverManager.getConnection(url, user, password);
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, "0055296473");
//            int filas = preparedStatement.executeUpdate();
//            if(filas > 0){
//                System.out.println("Estudiante eliminado");
//            }
//            else {
//                System.out.println("Estudiante no eliminado");
//            }
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
        JFrame frame = new JFrame();
        frame.setTitle("Estudiantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Form1().mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 400);
        frame.setVisible(true);
        try (Connection connection= DriverManager.getConnection(url,user,password)){
            System.out.println("Conectado a la base de datos");
            String query="select * from estudiantes";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                Double n1 = Double.valueOf( resultSet.getDouble("b1"));
                Double n2 = Double.valueOf(resultSet.getDouble("b2"));
                Double nota = (n1 + n2)/2;
                System.out.println(" Nombre: "+resultSet.getString("nombre")+"\n Cedula: "+resultSet.getString("cedula")+"\n B1: "+resultSet.getString("b1")+"\n B2: "+resultSet.getString("b2")+"\n Promedio: "+nota);
            }
        }catch (SQLException e1){
            System.out.println(e1);
        }
    }
}
