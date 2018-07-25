/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

import java.awt.*;

//this class for animals
public class MarineAnimalDecorator implements MarineAnimal {

	private MarineAnimal marineAnimal;
	
	public MarineAnimalDecorator(MarineAnimal marine)
	{
		this.marineAnimal = marine;
	}
	
	@Override
	public void PaintFish(Color color) {
		this.marineAnimal.PaintFish(color);
	}

	public void setMarineAnimal(MarineAnimal marin)
	{
		this.marineAnimal = marin;
	}
	public MarineAnimal getMarineAnimal()
	{
		return this.marineAnimal;
	}
}
