/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class for planet dialog
public class AddPlanetDialog extends JDialog implements ActionListener,ChangeListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel1;
	private JComboBox<String> comboPlanetName; 
	private String[] names = {"Zostera","Laminaria"};  
	private JLabel lablePlanet,lableSize,lableCoordinate_X,lableCoordinate_Y;
	private JButton save,cancel;
	private Immobile kindOfPlanet;
	private AquaPanel panel;
	private JSlider size,coordinate_x,coordinate_y;
	
	//ctor
	public AddPlanetDialog(AquaPanel panel)
	{
		this.panel=panel;
		this.setSize(1000,600);
		this.setLayout(new BorderLayout());
		setPanel();
		this.save.addActionListener(this);
		this.cancel.addActionListener(this);	
		this.setVisible(true);
	}
	public void setPanel()
	{
		this.panel1 = new JPanel();
		this.panel1.setLayout(new GridLayout(14,1));
		this.lablePlanet = new JLabel("Planet");
		this.lableSize = new JLabel("Size");
		this.lableCoordinate_X = new JLabel("Coordinate X");
		this.lableCoordinate_Y = new JLabel("Coordinate Y"); 
		this.comboPlanetName = new JComboBox<String>(this.names);
		this.size = new JSlider(JSlider.HORIZONTAL,20,320,50);
		this.size.addChangeListener(this);
		this.size.setValue(150);
		this.size.setMajorTickSpacing(50);
		this.size.setPaintTicks(true);
		this.size.setPaintLabels(true);
		this.coordinate_x = new JSlider(JSlider.HORIZONTAL,20,this.panel.getWidth(),50);
		this.coordinate_x.addChangeListener(this);
		this.coordinate_x.setValue(150);
		this.coordinate_x.setMajorTickSpacing(50);
		this.coordinate_x.setPaintTicks(true);
		this.coordinate_x.setPaintLabels(true);
		
		this.coordinate_y = new JSlider(JSlider.HORIZONTAL,20,this.panel.getHeight(),50);
		this.coordinate_y.addChangeListener(this);
		this.coordinate_y.setValue(150);
		this.coordinate_y.setMajorTickSpacing(50);
		this.coordinate_y.setPaintTicks(true);
		this.coordinate_y.setPaintLabels(true);
		this.save = new JButton("Save");
		this.cancel = new JButton("Cancel");
		this.panel1.add(this.lablePlanet);
		this.panel1.add(this.comboPlanetName);
		this.panel1.add(this.lableSize);
		this.panel1.add(this.size);
		this.panel1.add(this.lableCoordinate_X);
		this.panel1.add(this.coordinate_x);
		this.panel1.add(this.lableCoordinate_Y);
		this.panel1.add(this.coordinate_y);
		this.panel1.add(this.save);
		this.panel1.add(this.cancel);
		add(this.panel1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.save)
		{
			if (this.comboPlanetName.getSelectedItem()=="Zostera")
			{
				this.kindOfPlanet = new Zostera(this.panel,"Zostera",this.coordinate_x.getValue(),this.coordinate_y.getValue(),this.size.getValue());
				this.panel.addPlanet(this.kindOfPlanet);
			}
			else if(this.comboPlanetName.getSelectedItem()=="Laminaria")
			{
				this.kindOfPlanet = new Laminaria(this.panel,"Laminaria",this.coordinate_x.getValue(),this.coordinate_y.getValue(),this.size.getValue());
				this.panel.addPlanet(this.kindOfPlanet);
			}
			dispose();
		}
		else if(e.getSource()==this.cancel)
			dispose();
			
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}
