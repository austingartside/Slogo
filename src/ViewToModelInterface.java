
/** 
 * @author austingartside
 * This interface provides the methods that need to be implemnented by the backend that relate directly to the
 * visual created on the front end.
 */
public interface ViewToModelInterface {
	
	
	/** 
	 * Allows the pen to go up or down 
	 */ 
	public void setPen();
	
	/** 
	 * Allows the turtle to show or not show
	 */ 
	public void setVisible();
	
	/** 
	 * Change the coordinate of the turtle
	 */ 
	public void setCoordinate();
	
	/** 
	 * Change the direction that the turtle is facing
	 */ 
	public void setOrientation();
	
	/** 
	 * Change the command history as specified by a the user.
	 * That is add elements to a history (or potentially wipe it)
	 */ 
	public void updateHistory();
	
	
	/** 
	 * move the turtle back to it's starting position
	 */
	public void resetToHome();
	
	/** 
	 * Clear the screen of any drawings or actions used so far.
	 * Uses reset in addition to wiping out everything
	 */ 
	public void clear();
	
	//To be completed, other methods that might update the screen in some way shape or form.
}
