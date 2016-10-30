package model.parser;
import java.util.*;
/**
 * @author austingartside
 * 
 */
public class ListOfCommands {
	
	private List<List<String>> myCommandList;
	private int myRow;
	private int myCol;
	
	public ListOfCommands(List<List<String>> commandList, int row, int col){
		myCommandList = commandList;
		myRow = row;
		myCol = col;
	}
	
	public boolean isOutOfBounds(){
		return myRow>=getNumRows();
	}
	
	public void goToStart(){
		myRow = 0;
		myCol = 0;
	}
	
	public List<String> getRowList(){
		return myCommandList.get(myRow);
	}
	
	public String getCommand() throws Exception{
		return myCommandList.get(myRow).get(myCol);
	}
	
	public int getNumRows(){
		return myCommandList.size();
	}
	
	public int getRowLength(){
		return myCommandList.get(myRow).size();
	}
	
	public int getRow(){
		return myRow;
	}
	
	public int getCol(){
		return myCol;
	}
	
	public void endParse(){
		myRow = myCommandList.size()+10;
	}
	
	public void incrementRow(){
		myRow++;
	}
	
	public void resetLocation(int oldRow, int oldCol){
		myRow = oldRow;
		myCol = oldCol;
	}
	
	/**
	 * @return true if line is not blank
	 */
	public boolean isValidLine(){
		return getRowList().size()>0;
	}
	
	/**
	 * Move to the next available location in List of Commands 
	 * (skip comments and blank rows and go to next line if hit the end of a line)
	 */
	public void updateLocation() {
		int newCol = getCol()+1;
		if(newCol>=getRowLength()){
			newCol = 0;
			movePastBlankRows();
		}
		myCol = newCol;
	}

	
	
	/**
	 * When moving to the next row, checks if it's blank and continues updating row until it reaches a filled row
	 * Comments and blank lines in original input create blank rows
	 */
	public void movePastBlankRows() {
		incrementRow();
		if(getRow()<getNumRows()){
			while(getRowLength()==0){
				incrementRow();
				if(getRow()==getNumRows()){
					break;
				}
			}
		}
	}

}
