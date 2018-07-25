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


//this class dialog for duplicate animal
public class DuplicateAnimal extends JDialog implements ActionListener,ChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Integer> comboSpeed2;
	private JComboBox<Integer> comboSpeed1,comboFrequency;
	private JPanel panel;
	private JComboBox<String> comboAnimalDetails; 
	private JComboBox<String> comboColor;
	private String[] item;  
	private String[] colors = {"Red","Blue","Green","Orange","Cyan","Pink","Black"};
	private JLabel lableAnimals,lableSize,lableHorSpeed,lableVerSpeed,lableColor,lableFrequency;
	private JButton copyWith,copyWithOut;
	private Swimmable fishJellyFish;
	private Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};
	private AquaPanel panel1;
	private JSlider size;
	
	//ctor
	public DuplicateAnimal(AquaPanel panel)
	{
		this.panel1=panel;
		setSize(500	,500);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setPanel();
		this.copyWith.addActionListener(this);
		this.copyWithOut.addActionListener(this);	
		setVisible(true);
	}
	
	public void setPanel(){
		this.panel=new JPanel();
		this.panel.setLayout(new GridLayout(14,1));
		this.lableAnimals = new JLabel("Duplicate");
		this.lableSize = new JLabel("Size");
		this.lableHorSpeed = new JLabel("Hor Speed");
		this.lableVerSpeed = new JLabel("Ver Speed");
		this.lableColor = new JLabel("Color");
		this.lableFrequency = new JLabel("Frequency");
		this.item = new String[this.panel1.getAnimal().size()];
		int i=0;
		for(Swimmable a: this.panel1.getAnimal())
		{
			item[i] = a.getAnimalName()+", Size: "+a.getSize()+", Hor_Speed: "+a.getHorSpeed()+", Ver_Speed: "+a.getVerSpeed()+", Color: "+a.getColor();
			i++;
		}
		this.copyWith = new JButton("Copy Whith Changing");
		this.copyWithOut = new JButton("Copy WhithOut Changing");
		this.comboAnimalDetails = new JComboBox<String>(this.item);
		this.comboSpeed1 = new JComboBox<Integer>(this.numbers);
		this.comboSpeed1.setSelectedItem(this.numbers[4]);
		this.comboSpeed2 = new JComboBox<Integer>(this.numbers);
		this.comboSpeed2.setSelectedItem(this.numbers[4]);
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
		this.panel.add(this.comboAnimalDetails);
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
		this.panel.add(this.copyWith);
		this.panel.add(this.copyWithOut);
		add(this.panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Color col=null;
		if(e.getSource()==this.copyWith)
		{
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
			int i = this.comboAnimalDetails.getSelectedIndex();
			int j=0;
			for(Swimmable a:this.panel1.getAnimal())
			{
				if(j==i)
				{
					if(a.getAnimalName().equals("Fish"))
					{
						this.fishJellyFish = ((Fish)a).Clone(false);						
						((Fish)a).setInformation(this.panel1, this.size.getValue(), Integer.parseInt(this.comboSpeed1.getSelectedItem().toString()), Integer.parseInt(this.comboSpeed2.getSelectedItem().toString()), col, Integer.parseInt(this.comboFrequency.getSelectedItem().toString()));
					}
					else
					{
						this.fishJellyFish = ((Jellyfish)a).Clone(false);						
						((Jellyfish)a).setInformation(this.panel1, this.size.getValue(), Integer.parseInt(this.comboSpeed1.getSelectedItem().toString()), Integer.parseInt(this.comboSpeed2.getSelectedItem().toString()), col, Integer.parseInt(this.comboFrequency.getSelectedItem().toString()));
					}
				}
				j++;
			}
			this.panel1.addAnimal(fishJellyFish);
		}
		if(e.getSource()==this.copyWithOut)
		{
			int i =this.comboAnimalDetails.getSelectedIndex();
			int j =0;
			for(Swimmable a:this.panel1.getAnimal())
			{
				if(j==i)
				{
					if(a.getAnimalName().equals("Fish"))
					{
						fishJellyFish = ((Fish)a).Clone(false);
					}
					else
					{
						fishJellyFish = ((Jellyfish)a).Clone(false);
					}
				}
				j++;
			}
			this.panel1.addAnimal(fishJellyFish);
		}
		dispose();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}
