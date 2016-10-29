package ViewLogic;

import javafx.scene.paint.Color;

/**
 * @author austingartside
 *         This interface provides the methods that need to be implemnented by the backend that
 *         relate directly to the
 *         visual created on the front end.
 */
public interface ViewToModelInterface {
    /**
     * Allows the turtle to show or not show
     * @param visible if true, make turtle visible, else make turtle invisible.
     */
    public void setVisible (double visible);
    /**
     * Change the coordinate of the turtle
     */
    public void setCoordinate (double penDown, double xPrev, double yPrev, double x, double y);

    /**
     * Change the direction that the turtle is facing
     */
    public void setOrientation (double angle);

    /**
     * Change the command history as specified by a the user.
     * That is add elements to a history (or potentially wipe it)
     */
    public void updateHistory (String o);
    /**
     * Change the curr commands as specified by a the user.
     * Every time user enters command, add it to list of curr commands
     */

    public void updateCurrCommands (String object);

	
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

	//To be completed, other methods that might update the screen in some way shape or form.
    public void updateCurrVariables (String object);

    public void changeBackgroundColor(Color color);

    // To be completed, other methods that might update the screen in some way shape or form.
}
