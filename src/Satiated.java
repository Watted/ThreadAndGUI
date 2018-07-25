/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */


//this class Satiated for the fish or jellyfish 
public class Satiated implements HungerState{

	
	@Override
	public void doAction(Swimmable swim) {
		swim.setState(this);
	}
	public String toString()
	{
		return "Satiated";
	}

}
