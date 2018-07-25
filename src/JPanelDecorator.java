/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class for Decorator panel
public class JPanelDecorator implements ActionListener{

	private AquaPanel panel;
	private MarineAnimal marineAnimal;
	private JPanel panel2;
	private JComboBox<String> comboAnimal;
	private JButton buttonColor = new JButton("Change");
	private MarineAnimalDecorator marineAnimalDecorator;
	
	
	//ctor
	public JPanelDecorator(AquaPanel panel)
	{
		this.panel = panel;
		this.panel2 = new JPanel();
		this.panel2.setLayout(new FlowLayout());
		this.panel2.add(this.buttonColor);
		String[] item =new String[this.panel.getAnimal().size()];
		int i= 0;
		for(Swimmable a: this.panel.getAnimal())
		{
			item[i] = a.getAnimalName()+", Size: "+a.getSize()+", Hor_Speed: "+a.getHorSpeed()+", Ver_Speed: "+a.getVerSpeed()+", Color: "+a.getColor();
			i++;
		}
		this.comboAnimal = new JComboBox<String>(item);
		this.panel2.add(this.comboAnimal);
		this.panel.add(this.panel2,BorderLayout.NORTH);
		this.buttonColor.addActionListener(this);
		this.panel.revalidate();
		this.panel.repaint();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.buttonColor)
		{
			int i=this.comboAnimal.getSelectedIndex();
			int j = 0;
			for(Swimmable a: this.panel.getAnimal())
			{
				if(j==i)
				{
					marineAnimal = (MarineAnimal)a;
				}
				j++;
			}
			this.marineAnimalDecorator = new MarineAnimalDecorator(marineAnimal);
			this.marineAnimalDecorator.PaintFish(JColorChooser.showDialog(null, "Kind Of Color", Color.BLUE));
			this.panel.remove(this.panel2);
		}
	}

}
