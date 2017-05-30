import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class FinestraBaixaDestinacions extends JInternalFrame implements ActionListener{
	FinestraPpal p=null;
	JButton sortir;
	JButton esborrar;
	JPanel panelBotons;
	JTable taula;
	JScrollPane jsp;
	DefaultTableModel model;
	GridBagLayout gbl;
	
	/*
	 * Constructor que rep el Frame al que serà
	 * afegit aquest InternalFrame com a paràmetre.
	 */
	public FinestraBaixaDestinacions(FinestraPpal f){
		this.p=f;
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
	}
	
	/*
	 * Métode que comproba si hi han destinacions creades
	 * a la col·lecció, en cas contrari, es bloqueja
	 * l'opció de donar de baixa destinacions.
	 */
	public void comprobarDestinacio(){
		if(p.destinacions.isEmpty()){
			esborrar.setEnabled(false);
			esborrar.setToolTipText("Tens que afegir una destinacio abans de poder donar-n'hi de baixa");
		}else{
			esborrar.setEnabled(true);
			esborrar.setToolTipText(null);
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
		gbl.setConstraints(panelBotons, gbc);
		
		this.setLayout(gbl);
		
		
	}
	
	
	/*
	 * Métode utilitzat per afegir els components 
	 * inicialitzats previament al Frame.
	 */
	private void afegirComponents() {
		this.add(panelBotons);
		this.add(jsp);
		
	}
	
	
	/*
	 * Métode que afegeix les dades de la col·lecció a la taula.
	 */
	public void afegirDadesTaula() {
		model.getDataVector().removeAllElements();
		for(int i=0;i<p.destinacions.size();i++){
			String id=p.destinacions.get(i).getId();
			String continent=p.destinacions.get(i).getContinent();
			String pais=p.destinacions.get(i).getPais();
			String capital=p.destinacions.get(i).getCapital();
			String ciutat=p.destinacions.get(i).getCiutat();
			String poblacio=p.destinacions.get(i).getPoblacio();
			String cp=p.destinacions.get(i).getCP();
			String platja=p.destinacions.get(i).getPlatja();
			
			Object[] data = {id,continent,pais,capital,ciutat,poblacio,cp,platja};
			model.addRow(data);
		}
	}
	
	
	/*
	 * Métode utilitzat per inicialitzar els objectes que 
	 * utilitzarà el Frame.
	 */
	private void crearComponents() {
		sortir=new JButton("Sortir");
		sortir.addActionListener(this);
		sortir.setActionCommand("Sortir");
		esborrar=new JButton("Baixa");
		esborrar.addActionListener(this);
		esborrar.setActionCommand("Esborrar");
		panelBotons=new JPanel();
		panelBotons.add(esborrar);
		panelBotons.add(sortir);
		model=new DefaultTableModel();
		taula=new JTable(model);
		taula.getTableHeader().setReorderingAllowed(false);
		jsp=new JScrollPane(taula);
		model.addColumn("Id");
		model.addColumn("Continent");
		model.addColumn("Pais");
		model.addColumn("Capital");
		model.addColumn("Ciutat");
		model.addColumn("Poblacio");
		model.addColumn("CP");
		model.addColumn("Platja");
		p.c.afegirDadesTaula();
	}
	
	
	/*
	 * Métode utilitzat per configurar el Frame.
	 */
	private void inicialitzacions() {
		this.setTitle("Finestra Baixa");
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
				p.b.dispose();
				p.comprobarFinestra(this);
				p.comprobarDestinacionsAfegides();
			}
			if((e.getActionCommand().equals("Esborrar"))){
				if(taula.isRowSelected(taula.getSelectedRow())){
					
					for(int i=0;i<p.punts.size();i++){
						PuntsInteres pi;
						pi=p.punts.get(i);
						if(pi.getId().equals(taula.getValueAt(taula.getSelectedRow(), 5).toString())){
							p.punts.remove(i);
						}
					}
					p.destinacions.remove(taula.getSelectedRow());
					afegirDadesTaula();
					p.comprobarDestinacions();
					p.c.afegirDadesTaula();
					p.m.afegirDadesTaula();
					p.pa.afegirDestinacions();
					p.pc.afegirDadesTaula();
					JOptionPane.showMessageDialog(this,"Baixa realitzada","Baixa Destinació",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(this,"No has seleccionat cap fila","Baixa Destinaci�",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
	}

}
