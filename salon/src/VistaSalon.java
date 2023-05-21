import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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

    JButton personalizada = new JButton("Personalizada");
    int mesaId;
    JFrame frameMesa;
    JPanel panelOrdenMesa;

    JPanel panelBotones;

    JButton enviarOrden = new JButton("Enviar Orden");
    int cantidadMesas;

    JFrame frameOriginal;

    JButton pepinillos = new JButton("Pepinillos");
    JButton cebolla = new JButton("Cebolla");
    JButton tomate = new JButton("Tomate");

    JButton aguacate = new JButton("Aguacate");

    JButton tocino = new JButton("Tocino");

    JButton hongos = new JButton("Hongos");

    JButton huevo = new JButton("Huevo");

    JButton queso = new JButton("Queso");

    JButton lechuga = new JButton("Lechuga");

    JButton pan = new JButton("Pan");

    JButton torta = new JButton("Torta");

    JPanel panelIngredientes;


    JFrame framePersonalizada;
    JPanel panelPersonalizada;

    JButton simpleP = new JButton("Simple");

    JButton clubhouseP = new JButton("Clubhouse");

    JButton westernP = new JButton("Western");

    JButton gardenP = new JButton("Garden");

    JButton originalP = new JButton("Original");









    public VistaSalon() {
        JLabel label = new JLabel("Ingrese la cantidad de Mesas:");
        frame = new JFrame();
        frame.setTitle("Salon");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.WEST);
        textField = new JTextField(10);
        textField.setPreferredSize(new Dimension(50, 50));
        frame.add(textField, BorderLayout.EAST);

        panelMesas = new JPanel();
        panelMesas.setLayout(new GridLayout(0, 5));
        frame.add(panelMesas, BorderLayout.CENTER);

        generarButton = new JButton("Generar");
        generarButton.setPreferredSize(new Dimension(100, 100));
        generarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(label);
                generarMesas();
            }
        });
        frame.add(generarButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    public void generarActionListenerH(JButton b, Hamburguesa h, JButton botonMesa){
        b.setPreferredSize(new Dimension(100, 100));
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salon.getMesas().get(mesaId).getOrden().agregarHamburguesa(h);
                salon.getMesas().get(mesaId).setOcupada(true);
                JOptionPane.showMessageDialog(frameMesa, "Hamburguesa " + h.getNombre() + " agregada a la orden de la mesa " + salon.getMesas().get(mesaId).getNumero());
                botonMesa.setBackground(Color.RED);
            }
        });
    }


    private void generarMesas() {

        frame.remove(generarButton);
        frame.remove(textField);
        frame.revalidate();
        cantidadMesas = Integer.parseInt(textField.getText());
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
    public void botonesHamburguesa(JButton botonMesa){
        panelOrdenMesa.add(simple);
        generarActionListenerH(simple, new Simple(), botonMesa);
        panelOrdenMesa.add(clubhouse);
        generarActionListenerH(clubhouse, new ClubHouse(), botonMesa);
        panelOrdenMesa.add(western);
        generarActionListenerH(western, new Western(), botonMesa);
        panelOrdenMesa.add(garden);
        generarActionListenerH(garden, new Garden(), botonMesa);
        original.setPreferredSize(new Dimension(100, 100));
        generarActionListenerH(original, new Original(), botonMesa);
        panelOrdenMesa.add(original);

        personalizada = new JButton("Personalizada");
        personalizada.setPreferredSize(new Dimension(100, 100));
        personalizada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarFramePersonalizada();
            }
        });
        panelOrdenMesa.add(personalizada);
    }

    public void verOrden(){
        Orden orden = salon.getMesas().get(mesaId).getOrden();
        JOptionPane.showMessageDialog(frameMesa, "Orden de la mesa " + salon.getMesas().get(mesaId).getNumero() + "\n" + orden.toString());
    }
    public void generarFrameMesa(int finalI, JButton botonMesa){
        JButton verOrden = new JButton("Ver Orden");
        verOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verOrden();
            }
        });
        frameMesa = new JFrame();
        panelOrdenMesa = new JPanel();
        panelBotones = new JPanel();

        mesaId = finalI - 1;
        frameMesa.setTitle("Mesa " + finalI);
        frameMesa.setSize(700, 200);
        frameMesa.setLayout(new BorderLayout());
        frameMesa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel labelMesa = new JLabel("Mesa " + salon.getMesas().get(mesaId).getNumero(), SwingConstants.CENTER);

        panelBotones.add(verOrden);
        panelBotones.add(enviarOrden);

        frameMesa.add(labelMesa, BorderLayout.NORTH);
        botonesHamburguesa(botonMesa);
        frameMesa.add(panelBotones, BorderLayout.CENTER);
        frameMesa.add(panelOrdenMesa, BorderLayout.SOUTH);
        frameMesa.setVisible(true);
    }
    public void generarFramePersonalizada(){
        framePersonalizada = new JFrame();
        framePersonalizada.setTitle("Crear Hamburguesa Personalizada");
        framePersonalizada.setSize(500, 500);
        framePersonalizada.setLayout(new BorderLayout());
        framePersonalizada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel labelMesa = new JLabel("Personalizada", SwingConstants.CENTER);
        framePersonalizada.add(labelMesa, BorderLayout.NORTH);
        panelIngredientes = new JPanel();
        panelIngredientes.setLayout(new GridLayout(0, 3));
        panelIngredientes.add(simpleP);
        generarActionListenerP(simpleP, new Simple());
        panelIngredientes.add(clubhouseP);
        generarActionListenerP(clubhouseP, new ClubHouse());
        panelIngredientes.add(westernP);
        generarActionListenerP(westernP, new Western());
        panelIngredientes.add(gardenP);
        generarActionListenerP(gardenP, new Garden());
        panelIngredientes.add(originalP);
        generarActionListenerP(originalP, new Original());

        framePersonalizada.add(panelIngredientes, BorderLayout.CENTER);
        framePersonalizada.setVisible(true);
    }

    public void generarActionListenerP(JButton b, Hamburguesa h){
        b.setPreferredSize(new Dimension(100, 100));
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarFrameAgregar(h);
            }
        });
    }
    public void generarFrameAgregar(Hamburguesa originalH){

        frameOriginal = new JFrame();
        frameOriginal.setTitle("Crear Hamburguesa Personalizada");
        frameOriginal.setSize(500, 500);
        frameOriginal.setLayout(new BorderLayout());
        frameOriginal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel labelMesa = new JLabel("Original", SwingConstants.CENTER);
        frameOriginal.add(labelMesa, BorderLayout.NORTH);
        panelIngredientes = new JPanel();
        panelIngredientes.setLayout(new GridLayout(0, 3));
        panelIngredientes.add(pan);
        generarActionListenerI(pan,1, originalH);
        panelIngredientes.add(torta);
        generarActionListenerI(torta, 2, originalH);
        panelIngredientes.add(queso);
        generarActionListenerI(queso, 3,originalH);
        panelIngredientes.add(lechuga);
        generarActionListenerI(lechuga, 4, originalH);
        panelIngredientes.add(tomate);
        generarActionListenerI(tomate,5, originalH);
        panelIngredientes.add(cebolla);
        generarActionListenerI(cebolla, 6, originalH);
        panelIngredientes.add(pepinillos);
        generarActionListenerI(pepinillos, 7, originalH);
        panelIngredientes.add(aguacate);
        generarActionListenerI(aguacate, 8, originalH);
        panelIngredientes.add(tocino);
        generarActionListenerI(tocino, 9, originalH);
        panelIngredientes.add(hongos);
        generarActionListenerI(hongos, 10, originalH);
        panelIngredientes.add(huevo);
        generarActionListenerI(huevo, 11, originalH);
        JButton agregar = new JButton("Agregar");
        agregar.setPreferredSize(new Dimension(100, 100));
        agregar.setBackground(Color.GREEN);
        agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (originalH.getIngredientes().size() == 0) {
                    JOptionPane.showMessageDialog(frameOriginal, "La hamburguesa debe tener al menos un ingrediente");
                    return;
                }
                originalH.definirPrecio();
                salon.getMesas().get(mesaId).getOrden().agregarHamburguesa(originalH);
                JOptionPane.showMessageDialog(frameOriginal, "Hamburguesa " + originalH.getNombre() + " agregada a la orden de la mesa " + salon.getMesas().get(mesaId).getNumero());
                frameOriginal.dispose();
            }
        });
        panelIngredientes.add(agregar);

        frameOriginal.add(panelIngredientes, BorderLayout.CENTER);

        frameOriginal.setVisible(true);
    }
    public void generarActionListenerI(JButton b,int i, Hamburguesa originalH){
        b.setPreferredSize(new Dimension(100, 100));
        if(b.getActionListeners().length > 0){
            b.removeActionListener(b.getActionListeners()[0]);
        }
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                originalH.agregarIngrediente(i);
                JOptionPane.showMessageDialog(frameOriginal, "Ingrediente agregado a la hamburguesa ");
            }
        });
    }
}