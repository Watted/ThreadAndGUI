/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

//this class for fish or jellyfish hungry
public class Hungry implements HungerState {

	@Override
	public void doAction(Swimmable swim) {
		swim.setState(this);
	}
	public String toString()
	{
		return "Hungry";
	}

	
}
