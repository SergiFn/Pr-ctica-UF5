import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class FinestraConsultaPunts  extends JInternalFrame implements ActionListener{
	FinestraPpal p=null;
	JButton sortir;
	JTable taula;
	JScrollPane jsp;
	DefaultTableModel model;
	GridBagLayout gbl;
	
	/*
	 * Constructor que rep el Frame al que serà
	 * afegit aquest InternalFrame com a paràmetre.
	 */
	public FinestraConsultaPunts(FinestraPpal finestra){
		this.p=finestra;
		inicialitzacions();
		crearComponents();
		afegirDadesTaula();
		afegirComponents();
		posicionarComponents();
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
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbl.setConstraints(jsp, gbc);
		
		//columna 0 fila 0
		gbc.gridx = 0; // columna
		gbc.gridy = 1; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill=GridBagConstraints.NONE;
		gbl.setConstraints(sortir, gbc);
		
		this.setLayout(gbl);
		
		
	}
	
	/*
	 * Métode utilitzat per afegir les dades
	 * de la col·lecció a la taula.
	 */
	public void afegirDadesTaula() {
		model.getDataVector().removeAllElements();
		for(int i=0;i<p.punts.size();i++){
			String id=p.punts.get(i).getId();
			String nom=p.punts.get(i).getNom();
			String descripcio=p.punts.get(i).getDescripcio();
			String tipus=p.punts.get(i).getTipus();
			String activitats=p.punts.get(i).getActivitats();
			Object[] data = {id,nom,descripcio,tipus,activitats};
			model.addRow(data);
		}
		
	}
	
	
	/*
	 * Métode utilitzat per afegir els components 
	 * inicialitzats previament al Frame.
	 */
	private void afegirComponents() {
		this.add(sortir);
		this.add(jsp);
		
	}
	
	
	/*
	 * Métode utilitzat per inicialitzar els objectes que 
	 * utilitzarà el Frame.
	 */
	private void crearComponents() {
		sortir=new JButton("Sortir");
		sortir.addActionListener(this);
		sortir.setActionCommand("Sortir");
		model=new DefaultTableModel();
		taula=new JTable(model);
		jsp=new JScrollPane(taula);
		model.addColumn("Destinacio");
		model.addColumn("Nom");
		model.addColumn("Descripcio");
		model.addColumn("Tipus");
		model.addColumn("Activitats");
		taula.getTableHeader().setReorderingAllowed(false);
	}
	
	
	/*
	 * Métode utilitzat per configurar el Frame.
	 */
	private void inicialitzacions() {
		this.setTitle("Finestra Consulta Punts");
		this.setSize(500,700);
		p.centrarFinestra(this);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if((obj instanceof JButton)){
			if((e.getActionCommand().equals("Sortir"))){
				p.pc.dispose();
				p.comprobarFinestra(this);
			}
		}
	}
}
