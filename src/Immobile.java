/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

//this abstract class for planet
public abstract class Immobile implements SeaCreature{
	private String name;
	static int id = 0;
	
	public Immobile(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	abstract public void setX(int cor_x);
	abstract public void sety(int cor_y);
	abstract public int getX();
	abstract public int getY();
	abstract public void setId(int id);
	abstract public int getId();
	abstract public Immobile Clone();
	abstract public int getSize();
	
	
}
