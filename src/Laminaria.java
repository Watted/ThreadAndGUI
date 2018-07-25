/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */


import java.awt.*;

//this class for Laminaria
public class Laminaria extends Immobile{
	private Color colorr = Color.GREEN;
	private AquaPanel panel;
	private int x,y,size,id;
	
	//ctor
	public Laminaria(AquaPanel panel,String name,int x,int y,int size) {
		super(name);
		this.id = Immobile.id++;
		this.x = x;
		this.y = y;
		this.size = size;		
		this.panel = panel;
	}
	
	@Override
	public void drawCreature(Graphics g) {
		g.setColor(colorr);
		
		g.fillArc(x-size/20, y-size, size/10, size*4/5, 0, 360);
		g.fillArc(x-size*3/20, y-size*13/15, size/10, size*2/3, 0, 360);
		g.fillArc(x+size/20, y-size*13/15, size/10, size*2/3, 0, 360);
		g.drawLine(x, y, x, y-size/5);
		g.drawLine(x, y, x-size/10, y-size/5);
		g.drawLine(x, y, x+size/10, y-size/5);
	}

	//this function is return the size
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

	//this function return the information about the Laminaria
	@Override
	public Immobile Clone() {
		Laminaria help = new Laminaria(this.panel, this.getName(), this.x, this.y, this.size);
		help.setId(this.id);
		return help;
	}
}
