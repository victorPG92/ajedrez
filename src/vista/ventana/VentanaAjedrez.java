package vista.ventana;


import java.awt.EventQueue;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Juego.Juego;
import Juego.JuegoAjedrez;
import Juego.JuegosDamas;
import constantes.Mensajes;
import movimientos.Movimiento;
import tableros.TableroAjedrez;
import vista.oyente.oyenteBoton.OyenteRetroceder;
import vista.oyente.oyenteMenu.OyenteCargar;
import vista.oyente.oyenteMenu.OyenteGuardar;
import vista.oyente.oyenteMenu.OyenteGuardarNombre;
import vista.oyente.oyenteMenu.OyenteMenuSalir2;
import vista.tablero.TableroAjedrezVisual;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaAjedrez extends JFrame //extends Observador 
{
		
		//para pintar
		protected  TableroAjedrezVisual canvas ;
		
		//protected Tablero tablero; ////////////////////////////////////////////
		protected Juego juego;
				
		protected Integer fila;
		protected Integer columna;

		
		protected int estado=0; ///////////////////////////////////////////
		
	
		//Panel
		protected JPanel contentPane;
		
		//Botones
		protected JButton btnNewButton;
		
		
		//Etiquetas
		protected JLabel label;
		protected JLabel label_1;
		protected JLabel label_2;
		protected JLabel label_3;
		protected JLabel label_4;
		protected JLabel label_5;
		protected JLabel label_6;
		protected JLabel label_7;
		protected JLabel label_8;
		protected JLabel label_9;
		protected JLabel label_10;
		protected JLabel label_11;
		protected JLabel label_12;
		protected JLabel label_13;
		protected JLabel label_14;
		protected JLabel label_15;
		
		protected JLabel lblTurnoJugador;
		
		
		//Menu
		protected JMenuBar menuBar;
		protected JMenu mnArchivo;

		private JButton btnRetroceder;

		private JScrollPane scrollPane;

		private JTextArea txtrHistorial;
		
		//Componentes visuales:
		protected static final long serialVersionUID = 1L;
		private JTextField txtFichero;

		private JButton btnGuardar;

		private JButton btnCargar;
		
		private static VentanaAjedrez v;

		public static TipoJuego tipoAjedrezEstatico= TipoJuego.ajedrez;
		
		/**
		 * Create the frame.
		 */
		protected VentanaAjedrez()// TipoJuego tipoJuego Tablero tabl)
		
		{
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 665, 877);
						
			anadirMenu();
					
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
			this.setName("Ajedrez");
			this.setTitle("Ajedrez");
			
			if(TipoJuego.ajedrez==tipoAjedrezEstatico)
				juego = new JuegoAjedrez();
			else
				juego= new JuegosDamas();
			contentPane.setLayout(null);
			
			//this.tablero=j.getT();
			
			//j.guardarMemento();
			
			canvas = new TableroAjedrezVisual(this);
			canvas.setBounds(21, 63, 603, 617);
			contentPane.add(canvas);
			
			
			anadirEtiquetas();
			
			crearHistorial();
			ponBotonRetroceder();
			
			
			//Caretaker.getInst().guardaEstado(new Memento(j));
			
			System.out.println("INICIO");
			System.out.println(juego.getT().toString());
			System.out.println("-------------------------------------------");
			canvas.repaint();
		}

		
		
		
		
		
		private void anadirMenu()
		{
			//Menu
			 menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			 mnArchivo = new JMenu("Archivo");
			menuBar.add(mnArchivo);
			
			
			JMenuItem mnNuevo = new JMenu("Nuevo");
			mnArchivo.add(mnNuevo);
			mnNuevo.addMenuDragMouseListener(new OyenteMenuSalir2(this));
			
			
			JMenuItem mnGuarda = new JMenu("Guarda");
			mnArchivo.add(mnGuarda);
			mnGuarda.addActionListener(new OyenteGuardar(juego));
		/*
			mnGuarda.addMouseListener(l);
			mnGuarda.addItemListener(l);
			mnGuarda.addMenuKeyListener(l);
			*/
			mnGuarda.addMenuDragMouseListener(new OyenteGuardar(juego));
						
			
			JMenuItem mnSalir = new JMenu("Salir");
			mnArchivo.add(mnSalir);
			mnSalir.addMenuDragMouseListener(new OyenteMenuSalir2(this));
			
			
			
			JMenu mnEditar = new JMenu("Editar");
			menuBar.add(mnEditar);
			
			JMenu mnOp = new JMenu("Opcion 1");
			menuBar.add(mnOp);
		}
		
		
		private void anadirEtiquetas()
		{
			label = new JLabel(" 0");
			label.setBounds(48, 45, 18, 14);
			contentPane.add(label);
			
			label_1 = new JLabel(" 1");
			label_1.setBounds(130, 43, 13, 14);
			contentPane.add(label_1);
			
			label_2 = new JLabel(" 2");
			label_2.setBounds(198, 43, 18, 14);
			contentPane.add(label_2);
			
			label_3 = new JLabel(" 3");
			label_3.setBounds(270, 40, 18, 14);
			contentPane.add(label_3);
			
			label_4 = new JLabel(" 4");
			label_4.setBounds(340, 43, 18, 14);
			contentPane.add(label_4);
			
			label_5 = new JLabel("5");
			label_5.setBounds(421, 43, 18, 14);
			contentPane.add(label_5);
			
			label_6 = new JLabel("6");
			label_6.setBounds(501, 45, 13, 14);
			contentPane.add(label_6);
			
			label_7 = new JLabel("7");
			label_7.setBounds(567, 45, 13, 14);
			contentPane.add(label_7);
			
			label_8 = new JLabel(" 0");
			label_8.setBounds(0, 99, 18, 14);
			contentPane.add(label_8);
			
			label_9 = new JLabel(" 1");
			label_9.setBounds(0, 161, 18, 14);
			contentPane.add(label_9);
			
			label_10 = new JLabel(" 2");
			label_10.setBounds(0, 241, 13, 14);
			contentPane.add(label_10);
			
			label_11 = new JLabel(" 3");
			label_11.setBounds(0, 319, 18, 14);
			contentPane.add(label_11);
			
			label_12 = new JLabel(" 4");
			label_12.setBounds(0, 398, 18, 14);
			contentPane.add(label_12);
			
			label_13 = new JLabel("5");
			label_13.setBounds(0, 479, 9, 14);
			contentPane.add(label_13);
			
			label_14 = new JLabel(" 6");
			label_14.setBounds(0, 552, 13, 14);
			contentPane.add(label_14);
			
			label_15 = new JLabel(" 7");
			label_15.setBounds(0, 626, 46, 14);
			contentPane.add(label_15);
			
			lblTurnoJugador = new JLabel("Turno : Jugador1");
			lblTurnoJugador.setBounds(440, 15, 180, 14);
			contentPane.add(lblTurnoJugador);
			
			
			
			
			
		}
		
		private void crearHistorial()
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 710, 578, 82);
			contentPane.add(scrollPane);
			
			txtrHistorial = new JTextArea();
			txtrHistorial.setText("Historial");
			scrollPane.setViewportView(txtrHistorial);
		}
		
		private void ponBotonRetroceder()
		{
			////////////////////////////////////////////////////////////////
			btnRetroceder = new JButton("RETROCEDER");
			btnRetroceder.setBounds(22, 11, 121, 23);
			//btnRetroceder.addActionListener( new OyenteRetroceder(j));
			
			
			contentPane.add(btnRetroceder);
			
			ponBotonFichero();
		}
		
		private void ponBotonFichero()
		{
			
			
			btnGuardar = new JButton("Guardar");
			btnGuardar.setBounds(152, 9, 89, 23);
			contentPane.add(btnGuardar);
			
			txtFichero = new JTextField();
			txtFichero.setText("fichero");
			txtFichero.setBounds(247, 12, 86, 20);
			contentPane.add(txtFichero);
			txtFichero.setColumns(10);
			
			btnCargar = new JButton("Cargar");
			btnCargar.setBounds(340, 11, 89, 23);
			contentPane.add(btnCargar);
			
			
			
		}
		
		
		public void repaint()
		{
			super.repaint();
			this.canvas.repaint();
			
			if(juego.isTurno())  lblTurnoJugador.setText(Mensajes.TURNO_JUGADOR_1);
			else			 lblTurnoJugador.setText(Mensajes.TURNO_JUGADOR_2 );
			
			pintarHistorial();
			
			//if(btnRetroceder.getActionListeners().length==0)
			//if(btnGuardar.getActionListeners().length==0)
			//if(btnCargar.getActionListeners().length==0)
				
			
		}
		
		public void ponerListeners()
		{
			btnRetroceder.addActionListener( new OyenteRetroceder(juego,this));
			btnGuardar.addActionListener(new OyenteGuardarNombre(juego,this));
			btnCargar.addActionListener(new OyenteCargar(juego, this));
		}
		
		private void pintarHistorial()
		{
			Stack<Movimiento> movs = juego.getMovimientosJugados();
			
			StringBuilder sb = new StringBuilder();
			sb.append("Movimientos Jugados:\n");
			for (Movimiento movimiento : movs)
			{
			sb.append(movimiento+ "\n");	
			}
			txtrHistorial.setText(sb.toString());
		}
		
		
		
		//getteres y setteres
		
		/*
		public JTextField getTxtFila() {			return txtFila;		}
		public void setTxtFila(JTextField txtFila) {			this.txtFila = txtFila;		}

		public JTextField getTxtColumna() {			return txtColumna;		}
		public void setTxtColumna(JTextField txtColumna) {			this.txtColumna = txtColumna;		}
			*/	
		public TableroAjedrezVisual getCanvas() {			return canvas;		}
		public void setCanvas(TableroAjedrezVisual canvas) {			this.canvas = canvas;		}

		public Integer getFila() {			return fila;		}
		public void setFila(Integer fila) {			this.fila = fila;		}

		public Integer getColumna() {			return columna;		}
		public void setColumna(Integer columna) {			this.columna = columna;		}
		
		/*public Tablero getTablero() {
			return tablero;
		}
		public void setTablero(Tablero tablero) 
		{
			this.tablero = tablero;
			getCanvas().setT(tablero);
		}*/
		
		public Juego getJ() {			return juego;		}
		public void setJuego(Juego j)		{			this.juego=j;
		}
	
	

		public int getEstado() {			return estado;		}
		public void setEstado(int estado) {			this.estado = estado;		}


		
		public String dameNombreFichero()
		{
			return txtFichero.getText();
		}
		
		public static VentanaAjedrez getInstancia()
		{
			
			if(v==null)v= new  VentanaAjedrez();
			return v;
		}
		
		
}



