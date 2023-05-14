import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaSalon  {
    private JTextField textField;
    private JPanel panelMesas;

    JFrame frame;

    Salon salon;

    JButton generarButton;

    JButton simple = new JButton("Simple");
    JButton clubhouse = new JButton("Clubhouse");
    JButton western = new JButton("Western");
    JButton garden = new JButton("Garden");
    JButton original = new JButton("Original");




    public VistaSalon() {
        frame = new JFrame();
        frame.setTitle("Generador de Mesas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textField = new JTextField(10);
        frame.add(textField, BorderLayout.NORTH);

        panelMesas = new JPanel();
        panelMesas.setLayout(new GridLayout(0, 5));
        frame.add(panelMesas, BorderLayout.CENTER);

        generarButton = new JButton("Generar");
        generarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarMesas();
            }
        });
        frame.add(generarButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    public void generarFrameMesa(int finalI, JButton botonMesa){
        JFrame frameMesa = new JFrame();
        JPanel panelMesa = new JPanel();
        int mesaId = finalI - 1;
        frameMesa.setTitle("Mesa " + finalI);
        frameMesa.setSize(500, 300);
        frameMesa.setLayout(new BorderLayout());
        frameMesa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel labelMesa = new JLabel("Mesa " + salon.getMesas().get(mesaId).getNumero());
        panelMesa.add(labelMesa);

        panelMesa.add(simple);
        panelMesa.add(clubhouse);
        panelMesa.add(western);
        panelMesa.add(garden);
        panelMesa.add(original);

        frameMesa.add(panelMesa, BorderLayout.WEST);

        frameMesa.setVisible(true);
    }
    private void generarMesas() {
        panelMesas.removeAll();
        frame.remove(generarButton);
        frame.remove(textField);
        frame.revalidate();
        int cantidadMesas = Integer.parseInt(textField.getText());
        salon = new Salon(cantidadMesas);
        for (int i = 1; i <= cantidadMesas; i++) {

            JButton botonMesa = new JButton("Mesa " + i);
            if (salon.getMesas().get(i - 1).isOcupada()) {
                botonMesa.setBackground(Color.RED);
            } else {
                botonMesa.setBackground(Color.GREEN);
            }
            int finalI = i;
            botonMesa.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    generarFrameMesa(finalI, botonMesa);
                }
            });
            panelMesas.add(botonMesa);
        }
        panelMesas.revalidate();
        panelMesas.repaint();
    }


}