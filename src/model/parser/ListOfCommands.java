package model.parser;
import java.util.*;

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
	
	public List<String> getRowList(){
		return myCommandList.get(myRow);
	}
	
	public String getCommand() throws Exception{
		if(isOutOfBounds()){
			throw new Exception();
		}
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
	
	public void setRow(int row){
		myRow = row;
	}
	
	public void setCol(int col){
		myCol = col;
	}

}
