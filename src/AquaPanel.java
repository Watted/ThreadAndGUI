/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CyclicBarrier;


public class AquaPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private int eatCounter=0;
	private JDialog dialogTable;
	private AddAnimalDialog addAnimalDialog;
	private AddPlanetDialog addPlanetDialog;
	private boolean tableShow=false,eatShow=false;
	private JPanel newPanel,infoPanel;
	protected Image image;
	private JButton addAnimal,addPlanet,duplicate,decorator,sleep,wakeUp,reset,food,info,exit;
	private HashSet<Swimmable> animals;
	private HashSet<Immobile> plant;
	private ArrayList<Memento> mementoList;
	private Iterator <Swimmable>iterators;
	private Originator originator = new Originator();
	private CyclicBarrier barrier = null;
	protected AbstractSeaFactory factory;

	
	
//ctor
	public AquaPanel()
	{
		super();
		this.animals=new HashSet<Swimmable>();
		this.plant = new HashSet<Immobile>();
		this.mementoList = new ArrayList<Memento>();
		setLayout(new BorderLayout());
		this.infoPanel=new JPanel(); 
		
		this.newPanel=new JPanel();
		this.newPanel.setLayout(new GridLayout(0,10,0,0)); 
		
		
		this.addAnimal=new JButton("Add Animal");
		this.addPlanet = new JButton("Add Planet");
		this.duplicate = new JButton("Duplicate Animal");
		this.decorator = new JButton("Decorator");
		this.sleep=new JButton("Sleep");
		this.wakeUp=new JButton("Wake up");
		this.reset=new JButton("Reset");
		this.food=new JButton("Food");
		this.info=new JButton("Info");
		this.exit=new JButton("Exit");
		
		
		this.addAnimal.setPreferredSize(new Dimension(109,27));
		this.addPlanet.setPreferredSize(new Dimension(109,27));
		this.duplicate.setPreferredSize(new Dimension(109,27));
		this.decorator.setPreferredSize(new Dimension(109,27));
		this.sleep.setPreferredSize(new Dimension(109,27));
		this.wakeUp.setPreferredSize(new Dimension(109,27));
		this.reset.setPreferredSize(new Dimension(109,27));
		this.food.setPreferredSize(new Dimension(109,27));
		this.info.setPreferredSize(new Dimension(109,27));
		this.exit.setPreferredSize(new Dimension(109,27));
		
		
		this.newPanel.add(this.addAnimal);
		this.newPanel.add(this.addPlanet);
		this.newPanel.add(this.duplicate);
		this.newPanel.add(this.decorator);
		this.newPanel.add(this.sleep);
		this.newPanel.add(this.wakeUp);
		this.newPanel.add(this.reset);
		this.newPanel.add(this.food);
		this.newPanel.add(this.info);
		this.newPanel.add(this.exit);
		add(this.newPanel,BorderLayout.SOUTH); 

		
		this.addAnimal.addActionListener(this);
		this.addPlanet.addActionListener(this);
		this.duplicate.addActionListener(this);
		this.decorator.addActionListener(this);
		this.sleep.addActionListener(this);
		this.wakeUp.addActionListener(this);
		this.reset.addActionListener(this);
		this.food.addActionListener(this);
		this.info.addActionListener(this);
		this.exit.addActionListener(this);		
		
	}
	
	
	//the function is draw the animals and the image if this image exists
	public synchronized void paintComponent(Graphics g)
	{	
	 	super.paintComponent(g);
	 	if(this.image != null) {
            Graphics2D g1 = (Graphics2D) g;
            g1.drawImage(this.image,0,0,getWidth(),getHeight(),this);
	 	}
	 	this.iterators= this.animals.iterator(); 
	 	while(this.iterators.hasNext()){
	 		this.iterators.next().drawCreature(g);
	 	}	 	
		if(this.eatShow){ 
			WormSingleton wormSinglton = WormSingleton.getInstance(this);
			wormSinglton.drawWorm(g);
		}
		if(this.plant.size()!=0)
		{
			for(Immobile a: this.plant)
			{
				a.drawCreature(g);
			}
		}

	}

	public JPanel getPanel()
	{
		return this.newPanel;
	}
	
	public void addMemento(Memento state)
	{
		this.mementoList.add(state);
	}

	public Memento getMementoByIndex(int i)
	{
		return this.mementoList.get(i);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.addAnimal)
		{
			try{
				if(this.animals.size()>=5) 
					throw new Exception("you cannot add another animal you have only 5!");
				else{
					this.addAnimalDialog=new AddAnimalDialog(this); 
				}
				
			}
			catch(Exception e1){
				 JOptionPane.showMessageDialog(null,e1.getMessage());
			}
		}
		else if(e.getSource()==this.addPlanet)
		{
			try{
				if(this.plant.size()>=5) 
					throw new Exception("you cannot add another planet you have only 5!");
				else{
					this.addPlanetDialog=new AddPlanetDialog(this); 
				}
				
			}
			catch(Exception e1){
				 JOptionPane.showMessageDialog(null,e1.getMessage());
			}
		}
		else if(e.getSource() == this.duplicate)
		{
			try{
				if(this.animals.size()==0)
				{
					throw new Exception("There are no animals to Duplicate");
				}
				else if(this.animals.size()>=5)
				{
					throw new Exception("you cannot add another animal you have only 5!");
				}
				else
				{
					DuplicateAnimal duplicateAnimal = new DuplicateAnimal(this);
				}
				
			}
			catch(Exception e1){
				 JOptionPane.showMessageDialog(null,e1.getMessage());
			}
		}
		else if(e.getSource()==this.decorator)
		{
			try{
				if(this.animals.size()==0)
				{
					throw new Exception("There are no animals to Decorator");
				}
				else
				{
					JPanelDecorator panelDecorator = new JPanelDecorator(this);
				}
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,e1.getMessage());
			}
		}
		else if(e.getSource()==this.sleep)
		{
			this.iterators= this.animals.iterator(); 
		 	while(this.iterators.hasNext()){
		 		this.iterators.next().setSuspend(); 
		 	}
		}
		else if(e.getSource()==this.wakeUp){
			this.iterators= this.animals.iterator(); 
		 	while(this.iterators.hasNext()){
		 		this.iterators.next().setResume(); 
		 	}
		}
		else if(e.getSource()==this.reset)
		{
			this.animals.clear();
			this.plant.clear();
			this.mementoList.clear();
			repaint(); 
		}
		else if(e.getSource()==this.food)
		{
			try{
				synchronized(this){
				if(this.eatShow==false)
				{
					this.eatShow=true; 
					int i = 0;
					for(Swimmable a:this.animals)
					{
						if(a.hungerState.toString()=="Hungry")
						{
							i++;
						}
					}
					this.barrier = new CyclicBarrier(i);
					for(Swimmable s:this.animals)
					{
						if(s.hungerState.toString()=="Hungry")
						{
							s.setBarrier(this.barrier);
						}
					}
					repaint();
				}
			}}
			catch(IllegalArgumentException e1)
			{
				this.eatShow = false;
			}
		}
		else if(e.getSource()==this.info)
		{
			if(!this.tableShow){
				this.tableShow=true;
				this.eatCounter=0;
				this.iterators= this.animals.iterator(); 
				this.infoPanel=new JPanel(); 
				this.dialogTable=new JDialog(); 
				String[] columns=new String[]{"Animal","Color","Size","Hor.Speed","Ver.speed","Eat counter"}; 
				DefaultTableModel tableModel = new DefaultTableModel(columns,0);
				JTable table=new JTable (tableModel);
				table.setPreferredScrollableViewportSize(new Dimension(400,100));
				
				while(this.iterators.hasNext()){
					Swimmable sw = this.iterators.next();
					String[] swimm=new String[]{sw.getAnimalName(),sw.getColor(),String.valueOf(sw.getSize()),String.valueOf(sw.getHorSpeed()),String.valueOf(sw.getVerSpeed()),String.valueOf(sw.getEatCount())};
					this.eatCounter+=sw.getEatCount(); 
					tableModel.addRow(swimm);
				}
				if(this.animals.size()>0) 
					tableModel.addRow(new String[]{"table","","","","",String.valueOf(this.eatCounter)});
				
				JScrollPane pane=new JScrollPane(table);
				
				this.infoPanel.add(pane); 
				this.dialogTable.add(this.infoPanel); 
				this.dialogTable.setVisible(true);
				this.dialogTable.setSize(420,200);
			}
			else{
				this.dialogTable.dispose();
				this.tableShow=false;
			}
		}
		else if(e.getSource()==this.exit)
		{
			System.exit(0);
		}
	}
	//this function is adding a new animal 
	public void addAnimal(Swimmable newSwimm)
	{
		this.animals.add(newSwimm); 
		newSwimm.start();
	}
	public void addPlanet(Immobile newPlanet) 
	{
		this.plant.add(newPlanet);
	}
	
		//this function is synchronized to the animal after eating  
	public void eat(Swimmable swimm)
	{
		this.eatShow = false;
		swimm.eatInc();
		for(Swimmable a: this.animals)
		{
			a.setBarrier(null);
		}
		this.eatCounter++;
	}
	
	public Memento getMemntoByIndex(int i)
	{
		return this.mementoList.get(i);
	}
	public void setEatShow()
	{
		this.eatShow=false;
	}
	public boolean getEatShow()
	{
		return this.eatShow;
	}	
	public HashSet<Swimmable> getAnimal()
	{
		return this.animals;
	}
	public HashSet<Immobile> getPlant()
	{
		return this.plant;
	}
	public ArrayList<Memento> getMemento()
	{
		return this.mementoList;
	}
	public Originator getOriginator()
	{
		return this.originator;
	}
	public void setOriginator(Originator originator)
	{
		this.originator = originator;
	}
}	

