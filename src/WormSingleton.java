/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */


import java.awt.*;


//this class for food 
public class WormSingleton {

	private AquaPanel panel;
	private static WormSingleton instance = null;
	
	public WormSingleton(AquaPanel panel)
	{
		this.panel = panel;
	}
	
	//this function to draw the food
	public void drawWorm(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.red);
		g2.drawArc(this.panel.getWidth()/2, this.panel.getHeight()/2-5, 10, 10, 30, 210);
		g2.drawArc(this.panel.getWidth()/2, this.panel.getHeight()/2+5, 10, 10, 180, 270);
		g2.setStroke(new BasicStroke(1));
	}
	
	public static WormSingleton getInstance(AquaPanel panel)
	{
		if(instance == null)
		{
			instance = new WormSingleton(panel);
		}
		return instance;
	}
}
