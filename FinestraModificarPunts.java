import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class FinestraModificarPunts extends JInternalFrame implements ActionListener{
	FinestraPpal p=null;
	JButton sortir;
	JButton modificar;
	JPanel botons;
	JTable taula;
	JComboBox tipus;
	JScrollPane jsp;
	DefaultTableModel model;
	GridBagLayout gbl;
	
	
	/*
	 * Constructor que rep el Frame al que serà
	 * afegit aquest InternalFrame com a paràmetre.
	 */
	public FinestraModificarPunts(FinestraPpal finestra){
		this.p=finestra;
		inicialitzacions();
		crearComponents();
		afegirDadesTaula();
		afegirComponents();
		posicionarComponents();
		afegirDadesTaula();
	}
	
	/*
	 * Métode que comproba si hi han punts donat d'alta
	 * a la col·lecció Punts, en cas contrari, es 
	 * bloqueja l'opció de modificar punts d'interés.
	 */
	public void comprobarPunts(){
		if(p.punts.isEmpty()){
			modificar.setEnabled(false);
			modificar.setToolTipText("Tens que afegir un punt d'interes abans de poder modificar-n'hi");
		}else{
			modificar.setEnabled(true);
			modificar.setToolTipText(null);
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
		gbl.setConstraints(botons, gbc);
		
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
		this.add(botons);
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
		modificar=new JButton("Modificar");
		modificar.addActionListener(this);
		modificar.setActionCommand("Modificar");
		botons=new JPanel();
		botons.add(modificar);
		botons.add(sortir);
		tipus=new JComboBox<String>();
		tipus.addItem("Gastronomic");
		tipus.addItem("Cultural");
		tipus.addItem("Oci");
		tipus.addItem("Esport");
		tipus.addItem("Platja");
		tipus.addItem("Muntanya");
		tipus.addItem("Rural");
		model=new MeuModel();
		taula=new JTable(model);
		taula.setCellSelectionEnabled(true);
		taula.getTableHeader().setReorderingAllowed(false);
		jsp=new JScrollPane(taula);
		for(int i=0;i<taula.getRowCount();i++){
			model.setValueAt(tipus, i, 3);
		}
		model.addColumn("Destinacio");
		model.addColumn("Nom");
		model.addColumn("Descripcio");
		model.addColumn("Tipus");
		model.addColumn("Activitat");
	}
	
	
	/*
	 * Métode utilitzat per configurar el Frame.
	 */
	private void inicialitzacions() {
		this.setTitle("Finestra Modificacio Punts");
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
				p.pm.dispose();
				p.comprobarFinestra(this);
			}
			if((e.getActionCommand().equals("Modificar"))){
				int num=taula.getRowCount();
				List<PuntsInteres> dades=new ArrayList<PuntsInteres>();
				for(int i=0;i<num;i++){
					dades.add(new PuntsInteres(taula.getValueAt(i, 0).toString(),taula.getValueAt(i, 1).toString(),taula.getValueAt(i, 2).toString(),taula.getValueAt(i, 3).toString(),taula.getValueAt(i, 4).toString()));
					p.punts.remove(i);
					p.punts.add(i,dades.get(i));
				}
				p.pc.afegirDadesTaula();
				p.pb.afegirDadesTaula();
				p.comprobarPunts();
				JOptionPane.showMessageDialog(this,"Modificació realitzada","Modificar Punts d'Interés",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	public class MeuModel extends DefaultTableModel
	{
	 public boolean isCellEditable (int row, int column)
	 {
	 if (column == 0)
		 return false;
	 
	 if(column==3)
		 return false;
	 
	 if(column==4)
		 return false;
	 
	 return true;
	 }
	}
}