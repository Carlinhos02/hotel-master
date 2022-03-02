package Ventanas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reservas extends JFrame{

    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textDirección;
    private JTextField textTeléfono;
    private JTextField textEmail;
    private JTextField textDni;
    private JTextField textTarjeta;
    private JCheckBox estándarCheckBox;
    private JCheckBox balcónCheckBox;
    private JCheckBox suiteCheckBox;
    private JTextField textEstandar;
    private JTextField textBalcon;
    private JTextField textSuite;
    private JComboBox comboBoxRegimen;
    private JTextField textPrecio;
    private JButton calcularButton;
    private JButton limpiarButton;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private JPanel reservas;


    String[] comida={"","Sin desayuno","Con desayuno","Media pensión", "Pensión completa"};


    public Reservas(){

        setContentPane(reservas);
        setTitle("Reservas del hotel");
        setSize(900, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        comboBoxRegimen.addItem(comida[0]);
        comboBoxRegimen.addItem(comida[1]);
        comboBoxRegimen.addItem(comida[2]);
        comboBoxRegimen.addItem(comida[3]);
        comboBoxRegimen.addItem(comida[4]);


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrame Frame= new MainFrame();
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNombre.setText("");
                textApellidos.setText("");
                textDirección.setText("");
                textTeléfono.setText("");
                textEmail.setText("");
                textDni.setText("");
                textTarjeta.setText("");
                textPrecio.setText("");
                textEstandar.setText("");
                textBalcon.setText("");
                textSuite.setText("");
                estándarCheckBox.setSelected(false);
                balcónCheckBox.setSelected(false);
                suiteCheckBox.setSelected(false);
                comboBoxRegimen.setSelectedItem(null);
            }
        });
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int precio;
                precio=0;

                if(estándarCheckBox.isSelected()){
                    int n1= Integer.parseInt(textEstandar.getText());
                    for(int i=0;i<n1;i++){
                        precio=precio+30;
                    }
                }
                if(balcónCheckBox.isSelected()){
                    int n2=Integer.parseInt(textBalcon.getText());
                    for (int i = 0; i < n2; i++) {
                        precio=precio+40;
                    }
                }
                if(suiteCheckBox.isSelected()){
                    int n3=Integer.parseInt(textSuite.getText());
                    for (int i = 0; i < n3; i++) {
                        precio=precio+50;
                    }
                }

                if (comboBoxRegimen.getSelectedItem()=="Sin desayuno")precio=precio+10;
                if(comboBoxRegimen.getSelectedItem()=="Con desayuno")precio=precio+12;
                if(comboBoxRegimen.getSelectedItem()=="Media pensión")precio=precio+17;
                if(comboBoxRegimen.getSelectedItem()=="Pensión completa")precio=precio+23;

                textPrecio.setText(String.valueOf(precio));




            }
        });
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(textNombre.equals("")){
                    JOptionPane.showMessageDialog(null, "No se ha podido hacer la reserva, pruebe a introducir un nombre.", "Error", JOptionPane.ERROR);
                }
                else
                JOptionPane.showMessageDialog(null, "La reserva se ha confirmado.", "Reserva",JOptionPane.INFORMATION_MESSAGE );
            }
        });

        estándarCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(estándarCheckBox.isSelected()) JOptionPane.showMessageDialog(null,"Has seleccionado estándar","Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        balcónCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(balcónCheckBox.isSelected()) JOptionPane.showMessageDialog(null, "Has seleccionado balcón", "Aviso",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        suiteCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(suiteCheckBox.isSelected()) JOptionPane.showMessageDialog(null, "Has seleccionado suite","Aviso",JOptionPane.INFORMATION_MESSAGE );
            }
        });

        comboBoxRegimen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(comboBoxRegimen.getSelectedItem()=="Sin desayuno") JOptionPane.showMessageDialog(null,"Has seleccionado sin desayuno","Aviso", JOptionPane.INFORMATION_MESSAGE);
                if(comboBoxRegimen.getSelectedItem()=="Con desayuno") JOptionPane.showMessageDialog(null,"Has seleccionado con desayuno","Aviso", JOptionPane.INFORMATION_MESSAGE);
                if(comboBoxRegimen.getSelectedItem()=="Media pensión") JOptionPane.showMessageDialog(null,"Has seleccionado media pensión","Aviso", JOptionPane.INFORMATION_MESSAGE);
                if(comboBoxRegimen.getSelectedItem()=="Pensión completa") JOptionPane.showMessageDialog(null,"Has seleccionado pensión completa","Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
