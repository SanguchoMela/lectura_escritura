import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Formulario {
    private JPanel rootPanel;
    private JTextField name_in;
    private JTextField ci_in;
    private JTextField age_in;
    private JButton cargarButton;
    private JButton guardarButton;
    private JLabel main_label;
    private JLabel name_label;
    private JLabel ci_label;
    private JLabel age_label;
    private JButton mostrarButton;

    String filePath = "datosP.dat";

    public Formulario() {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyClass miObjeto = new MyClass(name_in.getText(),ci_in.getText(),age_in.getText());

                try(
                        FileOutputStream fileOut = new FileOutputStream(filePath);
                        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut))
                {
                    objectOut.writeObject(miObjeto);
                    System.out.println("Archivo escrito correctamente");
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(
                        FileInputStream fileIn = new FileInputStream(filePath);
                        ObjectInputStream objectIn = new ObjectInputStream(fileIn)
                ){
                    MyClass readObject = (MyClass) objectIn.readObject();
                    System.out.println("El archivo en disco es: " + readObject);
                } catch (FileNotFoundException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                name_in.setText(null);
                ci_in.setText(null);
                age_in.setText(null);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario");
        frame.setContentPane(new Formulario().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(350,200);
        frame.setResizable(false);
    }
}
