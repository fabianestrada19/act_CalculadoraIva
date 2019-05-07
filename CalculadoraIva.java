
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculadoraIva extends JFrame implements ActionListener
{
	private JLabel textoCantidad;
	private JLabel textoIva;
	private JButton boton;
	private JTextField cajaUno;
	//private JTextField cajaDos;
	public String selectIva;
	
	private JComboBox opcionIva;
	
    public CalculadoraIva()
    {
    	super();
    	configurarVentana();
    	crearComponente();
    }
    
    private void configurarVentana()
    {
    	this.setTitle("Calculadora Iva");
    	this.setSize(300,200);
    	this.setLocationRelativeTo(null);
    	this.setLayout(null);
		this.setResizable(true);
		this.getContentPane().setBackground(new java.awt.Color(232,246,7));
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    private void crearComponente()
    {
    	textoCantidad = new JLabel();
    	
    	textoCantidad.setText("Monto: ");
    	textoCantidad.setBounds(10, 0, 200, 30);
    	textoCantidad.setForeground(Color.red);
    	this.add(textoCantidad);
    	
    	cajaUno = new JTextField();
    	
    	cajaUno.setBounds(80, 0, 100, 30);
    	this.add(cajaUno);

    	textoIva = new JLabel();
    	
    	textoIva.setText("Iva: ");
    	textoIva.setBounds(10, 40, 200, 30);
    	textoIva.setForeground(Color.RED);
    	this.add(textoIva);
    	
    	String[] ivaList = new String[] {"Seleccione un opcion de Iva","16", "10", "8"};
    	JComboBox<String> opcionIva = new JComboBox<>(ivaList);
    	opcionIva.setBounds(80, 40, 100, 30);
    	opcionIva.addActionListener(new ActionListener()
    			{
    				public void actionPerformed(ActionEvent e)
    				{
    					selectIva = opcionIva.getItemAt(opcionIva.getSelectedIndex());
    				}
    			}
    	);
    	this.add(opcionIva);
    	/*
    	cajaDos = new JTextField();
    	
    	cajaDos.setBounds(80, 40, 100, 30);
    	this.add(cajaDos);
    	*/
    	boton = new JButton();
    	
    	boton.setText("Calcular Total con Iva");
    	boton.setBounds(80, 80, 100, 30);
		boton.addActionListener(this);
		boton.setBackground(new java.awt.Color(255,0,0));
    	this.add(boton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	String numeroUno = cajaUno.getText();
    	//String numeroDos = cajaDos.getText();
    	
    	String resultado=comprobarNumero(numeroUno, selectIva);
    	
    	JOptionPane.showMessageDialog(this, "El Total  es: "+resultado);
    }
    
    private String comprobarNumero(String uno, String dos)
    {
    	String resultado;
    	try{
    		double numUno = Double.parseDouble(uno);
    		double numDos = Double.parseDouble(dos);
    		
    		
    		resultado = calcularIva(numUno, numDos);
    	} catch(Exception e){
    		resultado="Error, digito no valido";
    	}
    	return resultado;
    }
    
    public String calcularIva(double cantidad, double iva)
    {
    	double totalIva;
    	double total;
    	
    	totalIva=cantidad*(.01*iva);
    	total=totalIva+cantidad;
    	
    	return Double.toString(total);
    }
    
    public static void main(String[] args)
    {
    	CalculadoraIva ventanaCalculadora = new CalculadoraIva();
    	
    	ventanaCalculadora.setVisible(true);
    	
    }
}