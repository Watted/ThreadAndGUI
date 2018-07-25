/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

//this class for planet
public class Originator {
	private SeaCreature seaCreature;

	public void setSeaCreature(SeaCreature sea)
	{
		this.seaCreature = sea;
	}
	public SeaCreature getSeaCreature()
	{
		return this.seaCreature;
	}
	public void setSeaCreatureFromMemento(Memento meme)
	{
		this.seaCreature = meme.getseaCreature();
	}
	public Memento getSeaCreatureToMemento()
	{
		return new Memento(this.seaCreature);
	}
	
	
}
