package model.exceptions;

public class MissingListStartException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -77219367255703852L;
    private String error;
	public MissingListStartException(String temp){
		System.out.println(temp);
        error = temp;
	}
	public String getError(){
	    return error;
    }
	
	/**
	 * 
	 */

}
