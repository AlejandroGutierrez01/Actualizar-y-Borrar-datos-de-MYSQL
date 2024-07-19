import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Form2 {
    public JPanel borrarPanel;
    private JTextField cedulaBorrar;
    private JButton borrarEstudianteButton;
    private JButton regresarButton;

    String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10720936";
    String user = "sql10720936";
    String password = "TQeMDi1ru2";
    public Form2() {
        borrarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaBorrar = Form2.this.cedulaBorrar.getText();
                String sql = "delete from estudiantes where cedula = ?";
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                try{
                    connection = DriverManager.getConnection(url, user, password);
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, cedulaBorrar);
                    int filas = preparedStatement.executeUpdate();
                    if(filas > 0){
                        System.out.println("Estudiante eliminado");
                    }
                    else {
                        System.out.println("Estudiante no eliminado");
                    }
                }
                catch(Exception e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Estudiantes");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new Form1().mainPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setSize(600, 400);
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
    }
}
