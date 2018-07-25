/*Name: Mohammed Watted
 *ID : 308238187
 *Name: AbedAllah Wattawda
 *ID:  203913595
 */

import java.awt.*;

//this class for planet Zostera
public class Zostera extends Immobile{
	private Color colorr = Color.GREEN;
	private AquaPanel panel;
	private int x,y,size,id;
	
	//ctor
	public Zostera(AquaPanel panel,String name,int x,int y,int size) {
		super(name);
		this.id = Immobile.id++;
		this.x = x;
		this.y = y;
		this.size = size;
		this.panel = panel;
	}
	
	@Override
	public void drawCreature(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(colorr);
		g.drawLine(x, y, x, y-size);
		g.drawLine(x-2, y, x-10, y-size*9/10);
		g.drawLine(x+2, y, x+10, y-size*9/10);
		g.drawLine(x-4, y, x-20, y-size*4/5);
		g.drawLine(x+4, y, x+20, y-size*4/5);
		g.drawLine(x-6, y, x-30, y-size*7/10);
		g.drawLine(x+6, y, x+30, y-size*7/10);
		g.drawLine(x-8, y, x-40, y-size*4/7);
		g.drawLine(x+8, y, x+40, y-size*4/7);
		g2.setStroke(new BasicStroke(1));
	}

	//return the size
	public int getSize()
	{
		return this.size;
	}

	@Override
	public void setX(int cor_x) {
		this.x = cor_x;
	}

	@Override
	public void sety(int cor_y) {
		this.y = cor_y;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}

	//restore and saving the information about the Zostera
	@Override
	public Immobile Clone() {
		Zostera help = new Zostera(this.panel, this.getName(), this.x, this.y, this.size);
		help.setId(this.id);
		return help;
	}

}
