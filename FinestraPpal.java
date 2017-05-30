import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FinestraPpal extends JFrame implements ActionListener{
	List<Destinacions> destinacions=new ArrayList<Destinacions>();
	List<PuntsInteres> punts=new ArrayList<PuntsInteres>();
	JDesktopPane jdp=new JDesktopPane();
	FinestraAltaDestinacions a=new FinestraAltaDestinacions(this);
	FinestraConsultaDestinacions c=new FinestraConsultaDestinacions(this);
	FinestraBaixaDestinacions b=new FinestraBaixaDestinacions(this);
	FinestraModificarDestinacions m=new FinestraModificarDestinacions(this);
	FinestraAltaPunts pa=new FinestraAltaPunts(this);
	FinestraConsultaPunts pc=new FinestraConsultaPunts(this);
	FinestraModificarPunts pm=new FinestraModificarPunts(this);
	FinestraBaixaPunts pb=new FinestraBaixaPunts(this);
	JPanel panelDestinacio;
	JPanel panelSortir;
	JButton btnAltaD;
	JButton btnBaixaD;
	JButton btnConsultaD;
	JButton btnModificarD;
	JButton btnSortir;
	JLabel lblDestinacions;
	JPanel panelPunts;
	JButton btnAltaP;
	JButton btnBaixaP;
	JButton btnModificarP;
	JButton btnConsultaP;
	JLabel lblPunts;
	GridBagLayout gblDestinacio;
	GridBagLayout gblPunts;
	
	
	public FinestraPpal(){
		this.getContentPane().add(jdp);
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarDestinacions();
		posicionarPunts();
		afegirDades();
		comprobarDestinacionsAfegides();
		comprobarDestinacions();
		comprobarPunts();
	}
	
	
	
	/*
	 * Métode que centra els InternalFrame, 
	 * agafant la mida de la pantalla de l'usuari
	 */
	public void centrarFinestra(JInternalFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	
	
	/*
	 * Métode que comproba si hi ha algun InternalFrame actiu,
	 * en cas de que hi sigui, bloquejarà l'opció de fer cap
	 * altra funció fins que es tanqui aquell frame.
	 */
	public void comprobarFinestra(JInternalFrame i){
		if(i.isVisible()){
			btnAltaP.setEnabled(false);
			btnBaixaP.setEnabled(false);
			btnConsultaP.setEnabled(false);
			btnModificarP.setEnabled(false);
			btnAltaD.setEnabled(false);
			btnBaixaD.setEnabled(false);
			btnConsultaD.setEnabled(false);
			btnModificarD.setEnabled(false);
		}else{
			btnAltaP.setEnabled(true);
			btnBaixaP.setEnabled(true);
			btnConsultaP.setEnabled(true);
			btnModificarP.setEnabled(true);
			btnAltaD.setEnabled(true);
			btnBaixaD.setEnabled(true);
			btnConsultaD.setEnabled(true);
			btnModificarD.setEnabled(true);
		}
	}
	
	
	/*
	 * Métode que comproba si hi han punts d'interés afegits,
	 * en cas que no n'hi hagi, es bloquejaràn les opcions
	 * de modificar o donar de baixa punts d'interés.
	 */
	public void comprobarPunts() {
		pb.comprobarPunts();
		pm.comprobarPunts();
		
	}
	
	
	/*
	 * Métode que comproba si hi han destinacions afegides,
	 * en cas que no n'hi hagi, es bloquejaràn les opcions
	 * de modificar o donar de baixa punts d'interés.
	 */
	public void comprobarDestinacions() {
		b.comprobarDestinacio();
		m.comprobarDestinacio();
		
		
	}
	
	/*
	 * Métode que afegeix dades predeterminades a la col·lecció,
	 * i actualitza les dades de les taules.
	 */
	private void afegirDades() {
		destinacions.add(new Destinacions("123456","Europa","Espa�a","Barcelona","Badalona","Termens","25670","No te platja"));
		destinacions.add(new Destinacions("654321","EE.UU","Louissiana","Algo","Adeu","Hola","55420","Te platja"));
		c.afegirDadesTaula();
		m.afegirDadesTaula();
		b.afegirDadesTaula();
		comprobarPunts();
		pa.afegirDestinacions();
		
	}
	
	
	/*
	 * Métode que comproba si hi han destinacions afegides,
	 * si no n'hi han, es bloquejaràn els punts d'interés.
	 */
	public void comprobarDestinacionsAfegides() {
		if(destinacions.isEmpty()){
			btnAltaP.setEnabled(false);
			btnBaixaP.setEnabled(false);
			btnConsultaP.setEnabled(false);
			btnModificarP.setEnabled(false);
			btnAltaP.setToolTipText("Per utilitzar punts d'interes tens que tenir una destinacio creada.");
			btnBaixaP.setToolTipText("Per utilitzar punts d'interes tens que tenir una destinacio creada.");
			btnConsultaP.setToolTipText("Per utilitzar punts d'interes tens que tenir una destinacio creada.");
			btnModificarP.setToolTipText("Per utilitzar punts d'interes tens que tenir una destinacio creada.");
		}else{
			btnAltaP.setEnabled(true);
			btnBaixaP.setEnabled(true);
			btnConsultaP.setEnabled(true);
			btnModificarP.setEnabled(true);
			btnAltaP.setToolTipText(null);
			btnBaixaP.setToolTipText(null);
			btnConsultaP.setToolTipText(null);
			btnModificarP.setToolTipText(null);
		}
	}
	
	
	/*
	 * Métode utilitzat per configurar el Frame.
	 */
	public void inicialitzacions() {
		this.setTitle("Finestra Principal");
		this.setSize(new Dimension(500,500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		
	}


	/*
	 * Métode utilitzat per inicialitzar els objectes que 
	 * utilitzarà el Frame.
	 */
	public void crearComponents() {
		btnAltaD=new JButton("Alta");
		btnAltaD.setActionCommand("Alta Destinacio");
		btnAltaD.addActionListener(this);
		btnBaixaD=new JButton("Baixa");
		btnBaixaD.setActionCommand("Baixa Destinacio");
		btnBaixaD.addActionListener(this);
		btnConsultaD=new JButton("Consulta");
		btnConsultaD.setActionCommand("Consulta Destinacio");
		btnConsultaD.addActionListener(this);
		btnModificarD=new JButton("Modificar");
		btnModificarD.setActionCommand("Modificar Destinacio");
		btnModificarD.addActionListener(this);
		btnSortir=new JButton("Sortir");
		btnSortir.addActionListener(this);
		btnSortir.setActionCommand("Sortir");
		panelDestinacio=new JPanel();
		panelSortir=new JPanel();
		panelSortir.add(btnSortir);
		lblDestinacions=new JLabel("Destinacions");
		panelPunts=new JPanel();
		btnAltaP=new JButton("Alta");
		btnAltaP.setActionCommand("Alta Punts");
		btnAltaP.addActionListener(this);
		btnBaixaP=new JButton("Baixa");
		btnBaixaP.addActionListener(this);
		btnBaixaP.setActionCommand("Baixa Punts");
		btnConsultaP=new JButton("Consulta");
		btnConsultaP.addActionListener(this);
		btnConsultaP.setActionCommand("Consulta Punts");
		btnModificarP=new JButton("Modificar");
		btnModificarP.setActionCommand("Modificar Punts");
		btnModificarP.addActionListener(this);
		lblPunts=new JLabel("Punts d'interes");
		jdp.add(panelDestinacio);
		jdp.add(panelPunts);
		panelDestinacio.add(lblDestinacions);
		panelDestinacio.add(btnAltaD);
		panelDestinacio.add(btnBaixaD);
		panelDestinacio.add(btnConsultaD);
		panelDestinacio.add(btnModificarD);
		panelPunts.add(lblPunts);
		panelPunts.add(btnAltaP);
		panelPunts.add(btnBaixaP);
		panelPunts.add(btnConsultaP);
		panelPunts.add(btnModificarP);
		panelPunts.setBounds(200,100,500,500);
	}

	
	/*
	 * Métode utilitzat per afegir els components 
	 * inicialitzats previament al Frame.
	 */
	public void afegirComponents() {
		this.add(a);
		this.add(c);
		this.add(b);
		this.add(m);
		this.add(pa);
		this.add(pc);
		this.add(pm);
		this.add(pb);
		this.add(panelDestinacio,BorderLayout.WEST);
		this.add(panelPunts,BorderLayout.EAST);
		this.add(panelSortir,BorderLayout.SOUTH);
	}
	
	
	/*
	 * Métode que posiciona els botons de l'apartat
	 * de Destinacions.
	 */
	public void posicionarDestinacions() {
		gblDestinacio=new GridBagLayout();
		GridBagConstraints gbcD=new GridBagConstraints();
		
		//columna 0 fila 0
		gbcD.gridx=0;//columna
		gbcD.gridy=0;//fila
		gbcD.gridheight=1;//altura
		gbcD.gridwidth=2;//amplada
		gbcD.anchor=GridBagConstraints.CENTER;
		gblDestinacio.setConstraints(lblDestinacions, gbcD);
		
		//columna 0 fila 2
		gbcD.gridx=0;//columna
		gbcD.gridy=2;//fila
		gbcD.gridheight=1;//altura
		gbcD.gridwidth=2;//amplada
		gbcD.anchor=GridBagConstraints.EAST;
		gbcD.fill=GridBagConstraints.BOTH;
		gblDestinacio.setConstraints(btnAltaD, gbcD);
		
		//columna 0 fila 3
		gbcD.gridx=0;//columna
		gbcD.gridy=3;//fila
		gbcD.gridheight=1;//altura
		gbcD.gridwidth=1;//amplada
		gbcD.anchor=GridBagConstraints.EAST;
		gbcD.fill=GridBagConstraints.NONE;
		gblDestinacio.setConstraints(btnConsultaD, gbcD);
		
		//columna 1 fila 3
		gbcD.gridx=1;//columna
		gbcD.gridy=3;//fila
		gbcD.gridheight=1;//altura
		gbcD.gridwidth=1;//amplada
		gbcD.anchor=GridBagConstraints.EAST;
		gbcD.fill=GridBagConstraints.NONE;
		gblDestinacio.setConstraints(btnModificarD, gbcD);
		
		//columna 0 fila 3
		gbcD.gridx=0;//columna
		gbcD.gridy=4;//fila
		gbcD.gridheight=1;//altura
		gbcD.gridwidth=2;//amplada
		gbcD.anchor=GridBagConstraints.EAST;
		gbcD.fill=GridBagConstraints.BOTH;
		gblDestinacio.setConstraints(btnBaixaD, gbcD);
		panelDestinacio.setLayout(gblDestinacio);
		}
	
	
	/*
	 * Métode que posiciona els botons de l'apartat
	 * de Punts d'interés.
	 */
	private void posicionarPunts() {
		gblPunts=new GridBagLayout();
		GridBagConstraints gbc2=new GridBagConstraints();
		
		//columna 0 fila 0
		gbc2.gridx=0;//columna
		gbc2.gridy=0;//fila
		gbc2.gridheight=1;//altura
		gbc2.gridwidth=2;//amplada
		gbc2.anchor=GridBagConstraints.CENTER;
		gblPunts.setConstraints(lblPunts, gbc2);
		
		//columna 0 fila 2
		gbc2.gridx=0;//columna
		gbc2.gridy=2;//fila
		gbc2.gridheight=1;//altura
		gbc2.gridwidth=2;//amplada
		gbc2.anchor=GridBagConstraints.EAST;
		gbc2.fill=GridBagConstraints.BOTH;
		gblPunts.setConstraints(btnAltaP, gbc2);
		
		//columna 0 fila 3
		gbc2.gridx=0;//columna
		gbc2.gridy=3;//fila
		gbc2.gridheight=1;//altura
		gbc2.gridwidth=1;//amplada
		gbc2.anchor=GridBagConstraints.EAST;
		gbc2.fill=GridBagConstraints.NONE;
		gblPunts.setConstraints(btnConsultaP, gbc2);
		
		//columna 1 fila 3
		gbc2.gridx=1;//columna
		gbc2.gridy=3;//fila
		gbc2.gridheight=1;//altura
		gbc2.gridwidth=1;//amplada
		gbc2.anchor=GridBagConstraints.EAST;
		gbc2.fill=GridBagConstraints.NONE;
		gblPunts.setConstraints(btnModificarP, gbc2);
		
		//columna 0 fila 3
		gbc2.gridx=0;//columna
		gbc2.gridy=4;//fila
		gbc2.gridheight=1;//altura
		gbc2.gridwidth=2;//amplada
		gbc2.anchor=GridBagConstraints.EAST;
		gbc2.fill=GridBagConstraints.BOTH;
		gblPunts.setConstraints(btnBaixaP, gbc2);
		panelPunts.setLayout(gblPunts);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if((obj instanceof JButton)){
			if((e.getActionCommand().equals("Alta Destinacio"))){
				a.show();
				comprobarFinestra(a);
			}
			if((e.getActionCommand().equals("Consulta Destinacio"))){
				c.show();
				comprobarFinestra(c);
			}
			if((e.getActionCommand().equals("Baixa Destinacio"))){
				b.show();
				comprobarFinestra(b);
			}
			if((e.getActionCommand().equals("Modificar Destinacio"))){
				m.show();
				comprobarFinestra(m);
			}
			if((e.getActionCommand().equals("Alta Punts"))){
				pa.show();
				comprobarFinestra(pa);
			}
			if((e.getActionCommand().equals("Consulta Punts"))){
				pc.show();
				comprobarFinestra(pc);
			}
			if((e.getActionCommand().equals("Modificar Punts"))){
				pm.show();
				comprobarFinestra(pm);
			}
			if((e.getActionCommand().equals("Baixa Punts"))){
				pb.show();
				comprobarFinestra(pb);
			}
			if((e.getActionCommand().equals("Sortir"))){
				this.dispose();
			}
		}
	}
}
