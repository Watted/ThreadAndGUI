/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */


public class PlanetFactory implements AbstractSeaFactory{

	private int size,x,y;
	private AquaPanel panel;
	private SeaCreature seaCreature = null;
	//ctor
	public PlanetFactory(AquaPanel panel,int size,int x,int y)
	{
		this.panel = panel;
		this.size = size;
		this.x=x;
		this.y = y;
	}
	
	@Override
	public SeaCreature produceSeaCreature(String type) {
		if("Zostera".equals(type))
		{
			this.seaCreature = new Zostera(panel, type, x, y, size);
		}
		if("Laminaria".equals(type))
		{
			this.seaCreature = new Laminaria(panel, type, x, y, size);
		}
		return this.seaCreature;
	}
	
	

	
	

}
