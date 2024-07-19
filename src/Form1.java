import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static java.lang.Double.parseDouble;

public class Form1 {
    public JPanel mainPanel;
    private JTextField cedulaText;
    private JTextPane resultadoArea;
    private JTextField nuevaCedulaText;
    private JTextField nuevoNombreText;
    private JTextField nuevaNotaText;
    private JTextField nuevaNota2Text;
    private JButton enviarbtn;
    private JButton modificarButton;
    private JButton eliminarButton;

    String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10720936";
    String user = "sql10720936";
    String password = "TQeMDi1ru2";

    public Form1() {
        enviarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes where cedula= '"+ cedulaText.getText()+"'";
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        resultadoArea.setText(" Cedula: "+ resultSet.getString("cedula")+"\n Nombre: "+ resultSet.getString("nombre")+"\n Nota BI 1:: "+resultSet.getString("b1")+"\n Nota BI 2: " + resultSet.getString("b2"));
                    }
                }catch (SQLException e1){
                    System.out.println(e1);
                }
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = cedulaText.getText();
                String nuevaCedula = nuevaCedulaText.getText();
                String nuevaNombre = nuevoNombreText.getText();
                Double nuevaNota = parseDouble( nuevaNotaText.getText());
                Double nuevaNota2 = parseDouble(nuevaNota2Text.getText());
                String sql = "update estudiantes set cedula = ?, nombre = ?, b1 = ?, b2 = ? where cedula = ?";
                Connection connection = null;
                PreparedStatement preparedStatement = null;

                try {
                    connection = DriverManager.getConnection(url, user, password);
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, nuevaCedula);
                    preparedStatement.setString(2, nuevaNombre);
                    preparedStatement.setDouble(3, nuevaNota);
                    preparedStatement.setDouble(4, nuevaNota2);
                    preparedStatement.setString(5, cedula);
                    int a = preparedStatement.executeUpdate();
                    System.out.println(a + " fila(s) actualizada(s).");
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                } finally {
                    //para cerrar la conexion con la database
                    try {
                        if (preparedStatement != null){
                            preparedStatement.close();}
                        if (connection != null){
                            connection.close();}
                    } catch (SQLException e1) {
                        System.out.println(e1.getMessage());
                    }
                }

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Borrar");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new Form2().borrarPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setSize(600, 400);
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(eliminarButton)).dispose();
            }
        });
    }
}
