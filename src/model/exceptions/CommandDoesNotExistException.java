package model.exceptions;
/**
 * @author austingartside
 * 
 */
public class CommandDoesNotExistException extends Exception{

    private String error;
	public CommandDoesNotExistException(String error){
		this.error = error;
	}
	public String getError(){
	    return error;
    }
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -870246777733169174L;

}
