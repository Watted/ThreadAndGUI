/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//this class for jellyfish
public class Jellyfish extends Swimmable implements Cloneable, MarineAnimal {
	private int x_front,y_front,size,eatCounter,id,frequency;
	private double newHorSpeed,newVerSpeed,x_dir,y_dir;
	private Color color;
	private AquaPanel panel;
	private boolean isSuspended=false;
	private CyclicBarrier barrier=null;
	
	//ctor
	public Jellyfish(AquaPanel panel, int size, int horSpeed, int verSpeed, Color col, int frequency)
	{
		super(horSpeed,verSpeed);
		this.hungerState = new Satiated();
		this.hungerState.doAction(this);
		this.id = Swimmable.id++;
		this.panel=panel;
		this.size=size;
		this.color=col;
		this.x_front=0;
		this.y_front=0;
		this.x_dir=1;
		this.y_dir=1;
		this.eatCounter=0;	
		this.frequency = frequency;
	}
	
	@Override
	public String getAnimalName() {
		return "JellyFish";
	}

	@Override
	public void drawCreature(Graphics g) {
		int numLegs;
		if(this.size<40)
		{
			numLegs = 5;
		}
		else if(this.size<80)
		{
			numLegs = 9;
		}
		else
		{
			numLegs = 12;
		}
		g.setColor(this.color);
		g.fillArc(this.x_front - this.size/2, this.y_front - this.size/4, this.size, this.size/2, 0, 180);

		for(int i=0; i<numLegs; i++)
			g.drawLine(this.x_front - this.size/2 + this.size/numLegs + this.size*i/(numLegs+1), this.y_front, this.x_front - this.size/2 + this.size/numLegs + this.size*i/(numLegs+1), this.y_front+this.size/3);
	}
	@Override
	public void setSuspend() {
		this.isSuspended=true;
		
	}
	@Override
	public void setResume() {
		synchronized(this){
			this.isSuspended=false;
			notify();
			}
	}

	@Override
	public void setBarrier(CyclicBarrier barrier) {
		this.barrier=barrier;		
	}
	
	@Override
	public int getSize() {
		return this.size;
	}
	@Override
	public synchronized void eatInc() {
		this.eatCounter++;
	}

	@Override
	public int getEatCount() {
		return this.eatCounter;
	}

	@Override
	public String getColor() {
		return "RBG("+Math.abs(this.color.getRed())+","+Math.abs(this.color.getGreen())+","+Math.abs(this.color.getBlue())+")";
	}
	//this function to the threads 
	public void run() {
		while (true){
			try {
				
				Thread.sleep(100);
				if(this.isSuspended){ 
					synchronized(this){
						wait(); 
					}

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			if(this.isSuspended==false){
				if(this.panel.getEatShow()&&this.hungerState instanceof Hungry)
				{
					if(this.barrier!=null){
						try{
							this.barrier.await();
						}catch(InterruptedException e)
						{
							e.printStackTrace();
						}
						catch(BrokenBarrierException e)
						{
							e.printStackTrace();
						}
						
					}
					this.barrier=null;
					double verOld=Math.sqrt(this.getHorSpeed()*this.getHorSpeed()+this.getVerSpeed()*this.getVerSpeed());
					double front=(Math.abs((double)this.y_front-(double)(this.panel.getHeight())/2)/Math.abs((double)this.x_front-(double)(this.panel.getWidth())/2));
					this.newHorSpeed=verOld/Math.sqrt(front*front+1);
					this.newVerSpeed=this.newHorSpeed*front;
					if(this.x_front > this.panel.getWidth()/2)
					{
						this.x_dir = -1;
					}
					else
					{
						this.x_dir=1;
					}
					if(this.y_front > this.panel.getHeight()/2)
					{
						this.y_dir = -1;
					}
					else
					{
						this.y_dir=1;
					}
					this.x_front+=this.newHorSpeed*this.x_dir;
					this.y_front+=this.newVerSpeed*this.y_dir;
					synchronized(this){
						if((Math.abs(this.x_front-this.panel.getWidth()/2)<=5) && (Math.abs(this.y_front-this.panel.getHeight()/2)<=5)){ 							
							if(this.panel.getEatShow()==true)
							{
								panel.eat(this); 
								this.hungerState = new Satiated();
								this.hungerState.doAction(this);
								this.count=0;
							}
						}
					}
				}
				if(this.panel.getEatShow()==false||this.barrier == null)
				{
					this.x_front+=this.getHorSpeed()*this.x_dir;
					this.y_front+=this.getVerSpeed()*this.y_dir;
					if(this.x_front > this.panel.getWidth()) 
					{
						this.x_dir = -1;
						this.count++;
					}
					if(this.y_front > this.panel.getHeight())  
					{
						this.y_dir = -1;
					}
					if(this.x_front <0)
					{
						this.x_dir = 1;
						this.count++;
					}
					if(this.y_front <0)
					{
						this.y_dir = 1;
					}
				}
				if(this.count == this.frequency && this.hungerState instanceof Satiated)
				{
					this.hungerState = new Hungry();
					this.hungerState.doAction(this);
					JOptionPane.showMessageDialog(null, "I'm hungry!!\nplease give me food");
					
				}
			}
			this.panel.repaint();
		}
	}

	//this function for set the information for jellyfish 
	public void setInformation(AquaPanel panel, int size, int horSpeed, int verSpeed, Color col, int frequency)
	{
		this.setHorSpeed(horSpeed);
		this.setVerSpeed(verSpeed);
		this.color = col;
		this.panel = panel;
		this.size = size;
		this.x_front=0;
		this.y_front=0;
		this.x_dir=1;
		this.y_dir=1;
		this.eatCounter=0;	
		this.frequency = frequency;
	}
	
	//this function for copy with changing or copy without changing the jellyfish 
	public Jellyfish Clone(boolean flag)
	{
		Jellyfish help = new Jellyfish(this.panel,this.size,this.getHorSpeed(),this.getVerSpeed(),this.color,this.frequency);
		help.setX_front(this.x_front);
		help.setY_front(this.y_front);
		if(flag == true)
		{
			help.set_Id(this.id);
		}
		return help;
	}
	@Override
	public void setX_front(int x) {
		this.x_front = x;
	}

	@Override
	public void setY_front(int y) {
		this.y_front = y;
	}

	@Override
	public int getX_front() {
		return this.x_front;
	}

	@Override
	public int getY_front() {
		return this.y_front;
	}

	@Override
	public void set_Id(int id) {
		this.id = id;		
	}

	@Override
	public int get_Id() {
		return this.id;
	}

	@Override
	public void setColor(Color col) {
		this.color = col;
	}

	@Override
	public Color getColorr() {
		return this.color;
	}

	@Override
	public void setState(HungerState state) {
		this.hungerState = state;
	}

	@Override
	public void PaintFish(Color color) {
		this.color = color;
	}

	
}
	
	
	
	