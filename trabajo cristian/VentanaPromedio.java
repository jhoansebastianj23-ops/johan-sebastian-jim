package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import clases.ModeloDatos;
import clases.Procesos;
import entidades.Estudiante;

public class VentanaPromedio extends JFrame implements ActionListener {

    private JTextField txtDocumento, txtNombre, txtMateria;
    private JTextField txtNota1, txtNota2, txtNota3;
    private JLabel lblResultado;

    private JButton btnCalcular, btnEliminar, btnActualizar, btnLista;

    private Procesos procesos;
    private ModeloDatos modelo;

    public VentanaPromedio(){

        procesos = new Procesos();
        modelo = new ModeloDatos();

        setTitle("Sistema Notas");
        setSize(600,450);
        setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes(){

        JLabel lblDoc = new JLabel("Documento:");
        lblDoc.setBounds(20,20,100,25);
        add(lblDoc);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(120,20,150,25);
        add(txtDocumento);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20,60,100,25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120,60,150,25);
        add(txtNombre);

        JLabel lblMateria = new JLabel("Materia:");
        lblMateria.setBounds(20,100,100,25);
        add(lblMateria);

        txtMateria = new JTextField();
        txtMateria.setBounds(120,100,150,25);
        add(txtMateria);

        txtNota1 = new JTextField();
        txtNota1.setBounds(20,150,80,25);
        add(txtNota1);

        txtNota2 = new JTextField();
        txtNota2.setBounds(120,150,80,25);
        add(txtNota2);

        txtNota3 = new JTextField();
        txtNota3.setBounds(220,150,80,25);
        add(txtNota3);

        btnCalcular = new JButton("Registrar");
        btnCalcular.setBounds(20,200,120,30);
        add(btnCalcular);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(160,200,120,30);
        add(btnEliminar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(300,200,120,30);
        add(btnActualizar);

        btnLista = new JButton("Ver Lista");
        btnLista.setBounds(440,200,120,30);
        add(btnLista);

        lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(20,260,500,30);
        add(lblResultado);

        btnCalcular.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnLista.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==btnCalcular){
            registrar();
        }

        if(e.getSource()==btnEliminar){
            lblResultado.setText(modelo.eliminarEstudiante(txtDocumento.getText()));
        }

        if(e.getSource()==btnActualizar){
            registrar();
            lblResultado.setText("Actualizado correctamente");
        }

        if(e.getSource()==btnLista){
            VentanaLista v = new VentanaLista(modelo.imprimirListaEstudiantes());
            v.setVisible(true);
        }
    }

    private void registrar(){

        Estudiante est = new Estudiante();

        est.setDocumento(txtDocumento.getText());
        est.setNombre(txtNombre.getText());
        est.setMateria(txtMateria.getText());
        est.setNota1(Double.parseDouble(txtNota1.getText()));
        est.setNota2(Double.parseDouble(txtNota2.getText()));
        est.setNota3(Double.parseDouble(txtNota3.getText()));

        double prom = procesos.calcularPromedio(est);

        if(prom != -1){

            est.setPromedio(prom);
            modelo.registrarEstudiante(est);

            if(prom < 3.5){
                lblResultado.setText("PERDIÓ con promedio: " + prom);
                lblResultado.setForeground(Color.red);
            } else {
                lblResultado.setText("APROBÓ con promedio: " + prom);
                lblResultado.setForeground(Color.blue);
            }

        } else {
            lblResultado.setText("Notas inválidas (0-5)");
            lblResultado.setForeground(Color.red);
        }
    }
}
