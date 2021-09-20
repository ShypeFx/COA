package fr.univlille.iutinfo.m3105.viewQ3;

import fr.univlille.iutinfo.m3105.modelQ1.Thermogeekostat;
import fr.univlille.iutinfo.m3105.modelQ2.Temperature;
import fr.univlille.iutinfo.m3105.utils.Observer;
import fr.univlille.iutinfo.m3105.utils.Subject;
import fr.univlille.iutinfo.m3105.viewQ1.ITemperatureView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextView extends Stage implements ITemperatureView,Observer {
	
	
	private TextField textF = new TextField();
	private Temperature model;
	private Button b1 = new Button("-");
	private Button b2 = new Button("+");
	private Slider slider = new Slider();
	

	public TextView(Temperature model) {
		this.model = model;
		FlowPane root = new FlowPane();
		Stage stage = new Stage();
		Text t = new Text("\n           Temperature en "+model.getEchelle().getName());
		VBox vbox = new VBox(10);
		HBox hbox = new HBox(10);
		textF.setText(getDisplayedValue() + "");
		model.attach(this);
		
		b1.setMinSize(35.0,35.0);
		b2.setMinSize(35.0,35.0);
		
		hbox.getChildren().addAll(b1,textF,b2);
		vbox.getChildren().addAll(t,hbox);
		root.getChildren().addAll(vbox);
		
		Scene scene = new Scene(root,280,80);
		stage.setTitle(""+model.getEchelle().getName());
        stage.setScene(scene);
        stage.show();
        
        
        
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				decrementAction();
			}	
		});
        
        
        b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				incrementAction();
				
			}
		});
        
        
        textF.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				double cpt = Double.parseDouble(textF.getText());
				model.setTemperature(cpt);
			}
			
			
		});
        
	}
	
	
	
	
	

	@Override
	public double getDisplayedValue() {
		return model.getTemperature();
	}

	@Override
	public void incrementAction() {
		model.incrementTemperature();
		
	}

	@Override
	public void decrementAction() {
		model.decrementTemperature();
		
	}
	
	public void changeText(Double val) {
		textF.setText(val+"");
	}

	@Override
	public void update(Subject subj) {
		textF.setText(getDisplayedValue()+"");	
	}

	@Override
	public void update(Subject subj, Object data) {
		textF.setText(data+"");
	}

}
