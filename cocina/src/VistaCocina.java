import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaCocina {
    ControladorCocina controlador;
    JFrame frame;
    JPanel panel;

    JPanel botones = new JPanel();

    JFrame frameOrden;

    JPanel panelBotones;

    JButton actualizar = new JButton("Actualizar");
    public VistaCocina() {
        controlador = new ControladorCocina();
        frame = new JFrame();
        frame.setTitle("Cocina");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        panel= new JPanel();
        actualizar.addActionListener(e -> {
            actualizarOrdenes(0);
        });
        panel.add(actualizar);
        panel.setLayout(new GridLayout(0, 5));
        frame.add(botones, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void actualizarOrdenes(int i){
        for(Orden orden: controlador.ordenes){
            if(!orden.estaAgregado) {
                JButton boton = new JButton("Mesa: " + String.valueOf(orden.getMesa()));
                boton.addActionListener(e -> {
                    generarFrameOrden(orden);
                });
                orden.estaAgregado = true;
                botones.add(boton);
            }
            else{
                for(Component component: botones.getComponents()){
                    if(component instanceof JButton){
                        if(((JButton) component).getText().equals("Mesa: " + String.valueOf(i))){
                            botones.remove(component);
                        }
                    }
                }

            }
        }
        botones.revalidate();
        botones.repaint();

    }
    public void generarFrameOrden(Orden orden){
        JButton ordenLista = new JButton("Marcar como lista");

        frameOrden = new JFrame();
        panelBotones = new JPanel();
        frameOrden.setTitle("Mesa " + orden.getMesa());
        frameOrden.setSize(700, 200);
        frameOrden.setLayout(new BorderLayout());
        frameOrden.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel labelMesa = new JLabel("Mesa " + orden.getMesa());
        JLabel labelOrden = new JLabel(orden.toString());
        if(ordenLista.getActionListeners().length > 0){
            ordenLista.removeActionListener(ordenLista.getActionListeners()[0]);
        }
        ordenLista.addActionListener(e -> {
            actualizarOrdenes(orden.getMesa());
            controlador.ordenes.remove(orden);
            controlador.enviarOrden(orden.getMesa());
        });
        panelBotones.add(ordenLista);
        frameOrden.add(labelMesa, BorderLayout.NORTH);
        frameOrden.add(labelOrden, BorderLayout.WEST);
        frameOrden.add(panelBotones, BorderLayout.CENTER);
        frameOrden.setVisible(true);
    }





}
