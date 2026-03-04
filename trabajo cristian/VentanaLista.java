package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaLista extends JFrame {

    public VentanaLista(String datos){

        setTitle("Lista de Estudiantes");
        setSize(400,500);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setText(datos);

        add(new JScrollPane(area));
    }
}
