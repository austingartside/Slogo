package ViewLogic;
import View.CanvasGenerator;
import View.DisplayGenerator;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Controller;
/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class DisplayUpdater implements ViewToModelInterface{
    private String language;
    private DisplayGenerator generator;
    private Controller myController;

    public DisplayUpdater(DisplayGenerator g, Controller control){
        generator = g;
            language = "English";
            myController = control;
    }
    public void setUp(){
        generator.setScene();
        addHandlers();
        addEnterHandler();
    }
    public Scene getGeneratorScene(){
        return generator.getScene();
    }

    public void setCoordinate(boolean penDown, double xPrev, double yPrev, double x, double y){
        generator.drawTurtle(x, y);
        if(penDown){
            generator.drawLine(xPrev, yPrev, x, y);
        }
    }
    public String getLanguage(){
        return language;
    }
    public void updateHistory(String object){
        generator.getCommandHistory().getItems().add(object);
    }
    public void updateCurrCommands(String object){
        generator.getCurrCommands().getItems().add(object);
    }
    public void updateCurrVariables(String object){
        generator.getCurrVariables().getItems().add(object);
    }
    public void setVisible(boolean visible){
        if(visible){
            generator.makeTurtleVisible();
        }
        else{
            generator.makeTurtleInvisible();
        }
    }
    public void setOrientation(double angle){
        generator.rotateTurtle(angle);
    }
    public void resetToHome(){
        generator.drawTurtle(0, 0);
    }
    public void clear(){
        generator.drawTurtle(0, 0);
        generator.clear();
    }

    private void addEnterHandler(){
        generator.getEnter().setOnAction((actionEvent -> {
            //try {
				try {
					myController.enterAction(generator.getCommand());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//} catch (Exception e) {
				// TODO other error?
				//e.printStackTrace();
			//}
        	//call parser to parse stuff
            //use generator.getCommand() to get String input
            updateHistory(generator.getCommand());
            generator.setText("");
        }));
    }
    private void addHandlers(){
        generator.getBackgroundPicker().setOnAction((event) ->{
            generator.changeBackgroundColor(generator.getBackgroundPicker().getValue());
        });
        generator.getCommandHistory().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
        generator.getCurrCommands().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
        generator.getCurrVariables().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
        generator.getLanguageChooser().setOnAction((event) -> {
                    language = (String) generator.getLanguageChooser().getSelectionModel().getSelectedItem();
        });

        generator.getCommandHistory().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent m){
                String command = generator.getCommandHistory().getSelectionModel().getSelectedItem();
                generator.setText(command);
            }
        });

        generator.getPenColorPicker().setOnAction((event) ->{
            Color c = generator.getPenColorPicker().getValue();
            generator.setPenColor(c);
        });
    }
}
