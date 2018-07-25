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

public class AddAnimalDialog extends JDialog implements ActionListener, ChangeListener {
	

	private static final long serialVersionUID = 1L;
	private JComboBox<Integer> comboSpeed2;
	private JComboBox<Integer> comboSpeed1,comboFrequency;
	private JPanel panel;
	private JComboBox<String> comboAnimalName; 
	private JComboBox<String> comboColor;
	private String[] names = {"Fish","JellyFish"};  
	private String[] colors = {"Red","Blue","Green","Orange","Cyan","Pink","Black"};
	private JLabel lableAnimals,lableSize,lableHorSpeed,lableVerSpeed,lableColor,lableFrequency;
	private JButton save,cancel;
	private Swimmable fishJellyFish;
	private Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};
	private AquaPanel panel1;
	private JSlider size;

	//ctor
	public AddAnimalDialog(AquaPanel pan)
	{
		this.panel1=pan;
		setSize(500	,500);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setPanel();
		this.save.addActionListener(this);
		this.cancel.addActionListener(this);	
		setVisible(true);
	
	}
	//this function show the dialog
	public void setPanel()
	{
		
		this.panel=new JPanel();
		this.panel.setLayout(new GridLayout(9,3,1,1));
		this.lableAnimals=new JLabel("Animal");
		this.lableSize=new JLabel("Size");
		this.lableHorSpeed=new JLabel("horizontal speed");
		this.lableVerSpeed=new JLabel("vertical speed");
		this.lableColor=new JLabel("Color");
		this.lableFrequency = new JLabel("Frequency");
		this.save=new JButton("Save");
		this.cancel=new JButton("Cancel");
		this.comboSpeed1 = new JComboBox<Integer>(this.numbers);
		this.comboSpeed1.setSelectedItem(this.numbers[4]);
		this.comboSpeed2 = new JComboBox<Integer>(this.numbers);
		this.comboSpeed2.setSelectedItem(this.numbers[4]);	
		this.comboAnimalName=new JComboBox<String>(this.names);
		this.comboColor=new JComboBox<String>(this.colors);
		this.comboFrequency = new JComboBox<Integer>(this.numbers);
		this.comboFrequency.setSelectedItem(this.numbers[4]);
		this.size = new JSlider(JSlider.HORIZONTAL,20,320,50);
		this.size.addChangeListener(this);
		this.size.setValue(150);
		this.size.setMajorTickSpacing(50);
		this.size.setPaintTicks(true);
		this.size.setPaintLabels(true);
		this.panel.add(this.lableAnimals);
		this.panel.add(this.comboAnimalName);
		this.panel.add(this.lableSize);
		this.panel.add(this.size);
		this.panel.add(this.lableHorSpeed);
		this.panel.add(this.comboSpeed1);
		this.panel.add(this.lableVerSpeed);
		this.panel.add(this.comboSpeed2);
		this.panel.add(this.lableColor);
		this.panel.add(this.comboColor);
		this.panel.add(this.lableFrequency);
		this.panel.add(this.comboFrequency);
		this.panel.add(this.save);
		this.panel.add(this.cancel);
		add(this.panel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.save)
		{
			Color col=null;
			if (this.comboColor.getSelectedItem().toString() =="Red"){
				col = Color.RED;
			}
			else if(this.comboColor.getSelectedItem().toString() == "Blue"){
				col = Color.BLUE;
			}
			else if(this.comboColor.getSelectedItem().toString() == "Green"){
				col = Color.GREEN;
			}				
			else if(this.comboColor.getSelectedItem().toString() == "Orange"){
				col = Color.ORANGE;
			}
			else if(this.comboColor.getSelectedItem().toString() == "Cyan"){
				col = Color.CYAN;
			}
			else if(this.comboColor.getSelectedItem().toString() == "Pink"){
				col = Color.PINK;
			}
			else if(this.comboColor.getSelectedItem().toString() == "Black"){
				col = Color.BLACK;
			}
			if (this.comboAnimalName.getSelectedItem()=="Fish")
			{
				this.panel1.factory = new AnimalFactory(this.panel1,col,this.size.getValue(),Integer.parseInt(this.comboSpeed1.getSelectedItem().toString()),Integer.parseInt(this.comboSpeed2.getSelectedItem().toString()),Integer.parseInt(this.comboFrequency.getSelectedItem().toString()));
				this.fishJellyFish = (Swimmable)this.panel1.factory.produceSeaCreature("Fish");
				this.panel1.addAnimal(this.fishJellyFish);
			}
			else if(this.comboAnimalName.getSelectedItem()=="JellyFish")
			{
				this.panel1.factory = new AnimalFactory(this.panel1,col,this.size.getValue(),Integer.parseInt(this.comboSpeed1.getSelectedItem().toString()),Integer.parseInt(this.comboSpeed2.getSelectedItem().toString()),Integer.parseInt(this.comboFrequency.getSelectedItem().toString()));
				this.fishJellyFish = (Swimmable)this.panel1.factory.produceSeaCreature("JellyFish");
				this.panel1.addAnimal(this.fishJellyFish);
			}
			dispose();
		}
		else if(e.getSource()==this.cancel)
			dispose();
			
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		
	}
	
}

