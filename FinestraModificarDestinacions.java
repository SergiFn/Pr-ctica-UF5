import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
public class FinestraModificarDestinacions extends JInternalFrame implements ActionListener{
	FinestraPpal p=null;
	JButton sortir;
	JButton modificar;
	JPanel botons;
	JTable taula;
	JScrollPane jsp;
	DefaultTableModel model;
	GridBagLayout gbl;
	
	
	/*
	 * Constructor que rep el Frame al que serà
	 * afegit aquest InternalFrame com a paràmetre.
	 */
	public FinestraModificarDestinacions(FinestraPpal finestra){
		this.p=finestra;
		inicialitzacions();
		crearComponents();
		afegirDadesTaula();
		afegirComponents();
		posicionarComponents();
		afegirDadesTaula();
		}
	
	
	/*
	 * Métode que comproba si hi han destinacions creades
	 * a la col·lecció, en cas contrari, es bloqueja
	 * l'opció de modificar destinacions.
	 */
	public void comprobarDestinacio(){
		if(p.destinacions.isEmpty()){
			modificar.setEnabled(false);
			modificar.setToolTipText("Tens que afegir una destinacio abans de poder modificar-n'hi una.");
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
		model=new MeuModel();
		taula=new JTable(model);
		taula.setCellSelectionEnabled(true);
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
	}
	
	/*
	 * Métode utilitzat per configurar el Frame.
	 */
	private void inicialitzacions() {
		this.setTitle("Finestra Modificacio");
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
				p.m.dispose();
				p.comprobarFinestra(this);
				p.comprobarDestinacionsAfegides();
			}
			if((e.getActionCommand().equals("Modificar"))){
				int num=taula.getRowCount();
				List<Destinacions> dades=new ArrayList<Destinacions>();
				for(int i=0;i<num;i++){
					dades.add(new Destinacions(taula.getValueAt(i, 0).toString(),taula.getValueAt(i, 1).toString(),taula.getValueAt(i, 2).toString(),taula.getValueAt(i, 3).toString(),taula.getValueAt(i, 4).toString(),taula.getValueAt(i, 5).toString()
							,taula.getValueAt(i, 6).toString(),taula.getValueAt(i, 7).toString()));
					p.destinacions.remove(i);
					p.destinacions.add(i,dades.get(i));
				}
				afegirDadesTaula();
				p.c.afegirDadesTaula();
				p.b.afegirDadesTaula();
				p.pa.afegirDestinacions();
				JOptionPane.showMessageDialog(this,"Modificació realitzada","Modificar Destinació",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	public class MeuModel extends DefaultTableModel
	{
	 public boolean isCellEditable (int row, int column)
	 {
	 if (column == 0)
	 return false;
	 
	 if(column==5)
	 return false;
	 
	 if(column==7)
	 return false;
	 
	 return true;
	 }
	}

}
