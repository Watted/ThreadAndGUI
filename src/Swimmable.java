/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */
import java.awt.*;
import java.util.concurrent.CyclicBarrier;

//class abstract for fish and jellyfish
public abstract class Swimmable extends Thread implements SeaCreature {
	private int horSpeed;
	private int verSpeed;
	protected int count = 0;
	static int id=0;
	protected HungerState hungerState;
	
	public Swimmable() {
		horSpeed = 0;
		verSpeed = 0;
	}
	public Swimmable(int hor, int ver) { 
		horSpeed = hor; 
		verSpeed = ver; 
	}
	
	
	public int getHorSpeed() { return horSpeed; }
	public int getVerSpeed() { return verSpeed; }
	public void setHorSpeed(int hor) { horSpeed = hor; } 
	public void setVerSpeed(int ver) { verSpeed = ver; } 
	abstract public void run();////////////
	abstract public String getAnimalName(); 
	abstract public void drawCreature(Graphics g); 
	abstract public void setSuspend(); 
	abstract public void setResume(); 
	abstract public void setBarrier(CyclicBarrier b); 
	abstract public int getSize(); 
	abstract public void eatInc(); 
	abstract public int getEatCount(); 
	abstract public String getColor();
	abstract Swimmable Clone(boolean flag);
	abstract public void setX_front(int x);
	abstract public void setY_front(int y);
	abstract public int getX_front();
	abstract public int getY_front();
	abstract public void set_Id(int id);
	abstract public int get_Id();
	abstract public void setColor(Color col);
	abstract public Color getColorr();
	abstract public void setState(HungerState state);
}
