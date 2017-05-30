import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

@SuppressWarnings("serial")
public class FinestraAltaPunts extends JInternalFrame implements ActionListener{
	FinestraPpal p=null;
	JLabel camps;
	JLabel dades;
	JButton btnSortir;
	JButton btnAlta;
	JPanel botons;
	JLabel lblId;
	JComboBox<String> puntsDestinacio;
	JLabel lblNom;
	JTextField nom;
	JLabel lblDesc;
	JTextField desc;
	JLabel lblTipus;
	JComboBox<String> tipus;
	JLabel lblActi;
	JComboBox<String> activitats;
	GridBagLayout gbl;
	
	/*
	 * Constructor que rep el Frame al que serà
	 * afegit aquest InternalFrame com a paràmetre.
	 */
	public FinestraAltaPunts(FinestraPpal finestra){
		this.p=finestra;
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
	}
	
	
	/*
	 * Métode que afegeix poblacions de la col·lecció destinacions
	 * al JComboBox utilitzat per referencia una destinacó
	 * a l'hora de donar d'alta un punt d'interés.
	 */
	public void afegirDestinacions() {
		puntsDestinacio.removeAllItems();
		for(int i=0;i<p.destinacions.size();i++){
			puntsDestinacio.addItem(p.destinacions.get(i).getPoblacio());
		}
		
	}
	
	
	/*
	 * Métode que posiciona els components
	 * inicialitzats previament.
	 */
	private void posicionarComponents() {
		gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		//columna 0 fila 0
		gbc.gridx = 0; // columna
		gbc.gridy = 0; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets=new Insets(10,10,10,10);
		gbl.setConstraints(camps, gbc);
		
		//columna 1 fila 0
		gbc.gridx = 1; // columna
		gbc.gridy = 0; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(dades, gbc);
		
		//columna 0 fila 1
		gbc.gridx = 0; // columna
		gbc.gridy = 2; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(lblId, gbc);
		
		//columna 1 fila 1
		gbc.gridx = 1; // columna
		gbc.gridy = 2; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(puntsDestinacio, gbc);
		
		//columna 0 fila 2
		gbc.gridx = 0; // columna
		gbc.gridy = 3; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(lblNom, gbc);
		
		//columna 1 fila 2
		gbc.gridx = 1; // columna
		gbc.gridy = 3; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(nom, gbc);
		
		//columna 0 fila 3
		gbc.gridx = 0; // columna
		gbc.gridy = 4; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(lblDesc, gbc);
		
		//columna 1 fila 3
		gbc.gridx = 1; // columna
		gbc.gridy = 4; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(desc, gbc);
		
		//columna 0 fila 4
		gbc.gridx = 0; // columna
		gbc.gridy = 5; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(lblTipus, gbc);
		
		//columna 1 fila 4
		gbc.gridx = 1; // columna
		gbc.gridy = 5; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(tipus, gbc);
		
		//columna 0 fila 5
		gbc.gridx = 0; // columna
		gbc.gridy = 6; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(lblActi, gbc);
		
		//columna 1 fila 5
		gbc.gridx = 1; // columna
		gbc.gridy = 6; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(activitats, gbc);
		
		//columna 0 fila 6
		gbc.gridx = 0; // columna
		gbc.gridy = 7; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(botons, gbc);
		
		this.setLayout(gbl);
	}
	
	
	/*
	 * Métode utilitzat per afegir els components 
	 * inicialitzats previament al Frame.
	 */
	private void afegirComponents() {
		this.add(camps);
		this.add(dades);
		this.add(botons);
		this.add(lblId);
		this.add(puntsDestinacio);
		this.add(lblNom);
		this.add(nom);
		this.add(lblDesc);
		this.add(desc);
		this.add(lblTipus);
		this.add(tipus);
		this.add(lblActi);
		this.add(activitats);
	}
	
	
	/*
	 * Métode utilitzat per inicialitzar els objectes que 
	 * utilitzarà el Frame.
	 */
	private void crearComponents() {
		//Label
		camps=new JLabel("Camps");
		dades=new JLabel("Dades");
		
		//Botons
		btnSortir=new JButton("Sortir");
		btnSortir.addActionListener(this);
		btnSortir.setActionCommand("Sortir");
		btnAlta=new JButton("Alta");
		btnAlta.addActionListener(this);
		btnAlta.setActionCommand("Alta");
		botons=new JPanel();
		botons.add(btnAlta);
		botons.add(btnSortir);
		
		//ID
		lblId=new JLabel("Id Destinacio: ");
		puntsDestinacio=new JComboBox<String>();
		
		//Nom
		lblNom=new JLabel("Nom: ");
		nom = new JTextField(15);
		nom.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent evt) {
	         if(!(Character.isLetter(evt.getKeyChar()))){
	        	 getToolkit().beep();
	                evt.consume();
	            }
	        }
	    });
		
		//Descripció
		lblDesc=new JLabel("Descripcio: ");
		desc=new JTextField(15);
		desc.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent evt) {
	         if(!(Character.isLetter(evt.getKeyChar()))){
	        	 getToolkit().beep();
	                evt.consume();
	            }
	        }
	    });
		
		//Tipus
		lblTipus=new JLabel("Tipus: ");
		tipus=new JComboBox<String>();
		tipus.addItem("Gastronomic");
		tipus.addItem("Cultural");
		tipus.addItem("Oci");
		tipus.addItem("Esport");
		tipus.addItem("Platja");
		tipus.addItem("Muntanya");
		tipus.addItem("Rural");
		
		//Activitats
		lblActi=new JLabel("Activitats: ");
		activitats=new JComboBox<String>();
		activitats.addItem("Esqui");
		activitats.addItem("Natacio");
		activitats.addItem("Escalada");
		activitats.addItem("Compres");
		activitats.addItem("Equitacio");
		activitats.addItem("Senderisme");
		
	}
	
	
	/*
	 * Métode utilitzat per configurar el Frame.
	 */
	private void inicialitzacions() {
		this.setTitle("Finestra Alta Punts");
		this.setSize(500,700);
		p.centrarFinestra(this);		
		this.setVisible(false);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
	}
	
	/*
	 * Métode utilitzat per llimpiar els camps després de fer
	 * una alta.
	 */
	private void llimpiarText() {
		puntsDestinacio.setSelectedItem(puntsDestinacio.getItemAt(0));
		nom.setText("");
		desc.setText("");
		tipus.setSelectedItem(tipus.getItemAt(0));
		activitats.setSelectedItem(activitats.getItemAt(0));
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if((obj instanceof JButton)){
			if((e.getActionCommand().equals("Sortir"))){
				p.pa.dispose();
				p.comprobarFinestra(this);
			}
			if((e.getActionCommand().equals("Alta"))){
				if(!nom.getText().equals("") && !desc.getText().equals("")){
					p.punts.add(new PuntsInteres(puntsDestinacio.getSelectedItem().toString(),nom.getText(),desc.getText(),tipus.getSelectedItem().toString(),activitats.getSelectedItem().toString()));
					p.pc.afegirDadesTaula();
					p.pm.afegirDadesTaula();
					p.pb.afegirDadesTaula();
					p.comprobarPunts();
					llimpiarText();
					JOptionPane.showMessageDialog(this,"Alta realitzada","Alta Punts d'Interés",JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(nom.getText().equals(""))
						JOptionPane.showMessageDialog(this,"Nom no introduït","Error Nom",JOptionPane.WARNING_MESSAGE);
					
					if(desc.getText().equals(""))
						JOptionPane.showMessageDialog(this,"Descripció no introduïda","Error Nom",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
	}

}
