/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class for duplicate the animal or the planet
public class MementoDialog extends JDialog implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private JPanel jPanel; 
	private AquaPanel panel;
	private JComboBox<String> comboBox;
	private JLabel label;
	private JButton button1,button2;
	private SeaCreature seaCreature;
	
	//ctor
	public MementoDialog(AquaPanel panel,String type)
	{
		this.panel = panel;
		this.setSize(1000, 600);
		this.jPanel = new JPanel();
		this.jPanel.setLayout(new GridLayout(14, 1));
		this.setLayout(new BorderLayout());
		if(type == "Save")
		{
			this.label = new JLabel("Animal/Plant you want to duplicate");
			this.jPanel.add(this.label);
			String []item = new String[this.panel.getAnimal().size()+this.panel.getPlant().size()];
			int i = 0;
			for(Swimmable a:this.panel.getAnimal())
			{
				item[i] = a.getAnimalName()+", Size: "+a.getSize()+", Hor Speed: "+a.getHorSpeed()+", Ver Speed: "+a.getVerSpeed()+", Color: "+a.getColor();
				i++;
			}
			for(Immobile a:this.panel.getPlant())
			{
				item[i] = a.getName()+",Color: Green"+", Coordinate_X: "+a.getX()+", Coordinate_Y: "+a.getY()+", Size: "+a.getSize();
				i++;
			}
			this.comboBox = new JComboBox<String>(item);
			this.jPanel.add(this.comboBox);
			this.button1 = new JButton("Ok");
			this.jPanel.add(this.button1);
			this.button1.addActionListener(this);
			this.add(this.jPanel);
		}
		else
		{
			this.label = new JLabel("Animal/Plant you want to Restore");
			this.jPanel.add(this.label);
			String[] item = new String[this.panel.getMemento().size()];
			int i=0;
			for(Memento a:this.panel.getMemento())
			{
				if(a.getseaCreature() instanceof Swimmable)
				{
					item[i] = ((Swimmable)a.getseaCreature()).getAnimalName()+", Color: "+((Swimmable)a.getseaCreature()).getColor()+", hor_Speed: "+((Swimmable)a.getseaCreature()).getHorSpeed()+", ver_Speed: "+((Swimmable)a.getseaCreature()).getVerSpeed()+", Size: "+((Swimmable)a.getseaCreature()).getSize();
					i++;
				}
			}
			for(Memento a:this.panel.getMemento())
			{
				if(a.getseaCreature() instanceof Immobile)
				{
					item[i] = ((Immobile)a.getseaCreature()).getName()+", Color: Green, Coordinate_X: "+((Immobile)a.getseaCreature()).getX()+", Coordinate_Y: "+((Immobile)a.getseaCreature()).getY()+", Size: "+((Immobile)a.getseaCreature()).getSize();
					i++;
				}
			}
			this.comboBox = new JComboBox<String>(item);
			this.jPanel.add(this.comboBox);
			this.button2 =new JButton("Ok");
			this.jPanel.add(this.button2);
			this.button2.addActionListener(this);
			this.add(this.jPanel);
		}
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.button1)
		{
			int index = this.comboBox.getSelectedIndex();
			int m=0;
			if(index<this.panel.getAnimal().size())
			{
				for(Swimmable a: this.panel.getAnimal())
				{
					if(index == m)
					{
						seaCreature = a.Clone(true);
					}
					m++;
				}
				for(int i=0;i<this.panel.getMemento().size();i++)
				{
					if(this.panel.getMemntoByIndex(i).getseaCreature() instanceof Swimmable)
					{
						Swimmable swimm = (Swimmable)this.panel.getMemntoByIndex(i).getseaCreature();
						if(swimm.get_Id()==((Swimmable)seaCreature).get_Id())
						{
							this.panel.getMemento().remove(i);
						}
					}
				}
				this.panel.getOriginator().setSeaCreature((Swimmable)seaCreature);
				this.panel.getMemento().add(this.panel.getOriginator().getSeaCreatureToMemento());
			}
			else
			{
				index-= this.panel.getAnimal().size();
				for(Immobile a:this.panel.getPlant())
				{
					if(index == m)
					{
						seaCreature = a.Clone();
					}
					m++;
				}
				for(int i = 0;i<this.panel.getMemento().size();i++)
				{
					if(this.panel.getMemntoByIndex(i).getseaCreature() instanceof Immobile)
					{
						Immobile temp = (Immobile)this.panel.getMemntoByIndex(i).getseaCreature();
						if(temp.getId()==((Immobile)seaCreature).getId())
						{
							this.panel.getMemento().remove(i);
						}
					}
				}
				this.panel.getOriginator().setSeaCreature((Immobile)seaCreature);
				this.panel.getMemento().add(this.panel.getOriginator().getSeaCreatureToMemento());
			}
		}
		else if(e.getSource() == this.button2)
		{
			int i =this.comboBox.getSelectedIndex();
			seaCreature = this.panel.getMemento().get(i).getseaCreature();
			if(seaCreature instanceof Swimmable)
			{
				for(Swimmable s:this.panel.getAnimal())
				{
					if(s.get_Id()==((Swimmable)seaCreature).get_Id())
					{
						s.setX_front(((Swimmable)seaCreature).getX_front());
						s.setY_front(((Swimmable)seaCreature).getY_front());
						s.setColor(((Swimmable)seaCreature).getColorr());
						s.setHorSpeed(((Swimmable)seaCreature).getHorSpeed());
						s.setVerSpeed(((Swimmable)seaCreature).getVerSpeed());
					}
				}
			}
			else
			{
				for(Immobile j:this.panel.getPlant())
				{
					if(j.getId()==((Immobile)seaCreature).getId())
					{
						j.setX(((Immobile)seaCreature).getX());
						j.sety(((Immobile)seaCreature).getY());
					}
				}
			}
		}
		dispose();
	}	
}
