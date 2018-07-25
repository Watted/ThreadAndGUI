/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

import java.awt.*;

//this class animal factory
public class AnimalFactory implements AbstractSeaFactory{
	
	private AquaPanel panel;
	private Color color;
	private int size,horSpeed,verSpeed,frequency;
	private SeaCreature seaCreature =null;
	
	//ctor
	public AnimalFactory(AquaPanel panel,Color col,int size,int hor,int ver,int freauency) {
		this.panel = panel;
		this.color = col;
		this.size = size;
		this.horSpeed = hor;
		this.verSpeed = ver;
		this.frequency = freauency;
	}
	
	@Override
	public SeaCreature produceSeaCreature(String type) {
		if(type.equals("Fish"))
		{
			this.seaCreature = new Fish(this.panel, this.size, this.horSpeed, this.verSpeed, this.color, this.frequency);
		}
		if(type.equals("JellyFish"))
		{
			this.seaCreature = new Jellyfish(this.panel, this.size, this.horSpeed, this.verSpeed, this.color, this.frequency);
		}
		return this.seaCreature;
	}

	

	
	

}
