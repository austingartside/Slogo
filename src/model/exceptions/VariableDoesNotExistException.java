package model.exceptions;

public class VariableDoesNotExistException extends Exception{

    private String error;
	public VariableDoesNotExistException(String error){
		this.error = error;
	    System.out.println(error);
	}
    public String getError(){
        return error;
    }
	/**
	 * 
	 */
	private static final long serialVersionUID = -6095943556667910864L;

}
