package ViewLogic;

/**
 * @author austingartside
 * This interface provides the methods that need to be implemnented by the backend that relate directly to the
 * visual created on the front end.
 */
public interface ViewToModelInterface {

	/** 
	 * Allows the turtle to show or not show
     * @param visible if true, make visible, else make invisible.
	 */ 
	public void setVisible(boolean visible);
	
	/** 
	 * Change the coordinate of the turtle
	 */ 
	public void setCoordinate(boolean penDown, double xPrev, double yPrev, double x, double y);
	
	/** 
	 * Change the direction that the turtle is facing
	 */ 
	public void setOrientation(double angle);
	
	/** 
	 * Change the command history as specified by a the user.
	 * That is add elements to a history (or potentially wipe it)
	 */ 
	public void updateHistory(Object o);
    /**
     * Change the curr commands as specified by a the user.
     * Every time user enters command, add it to list of curr commands
     */

    public void updateCurrCommands(Object object);
    /**
     * Every time user enters variable, store it. Allow user to change it.
     */
    public void updateCurrVariables(Object object);

	
	/** 
	 * move the turtle back to it's starting position
	 */
	public void resetToHome();
	
	/** 
	 * Clear the screen of any drawings or actions used so far.
	 * Uses reset in addition to wiping out everything
	 */ 
	public void clear();

    /**
     * Gets the language that the user typed in.
     * @return the language of the commands
     */

    public String getLanguage();

    public void parse(String str);
	//To be completed, other methods that might update the screen in some way shape or form.
}
