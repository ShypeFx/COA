package fr.univlille.iutinfo.m3105.viewQ1;

import fr.univlille.iutinfo.m3105.modelQ1.Thermogeekostat;
import fr.univlille.iutinfo.m3105.utils.Observer;
import fr.univlille.iutinfo.m3105.utils.Subject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class TextView extends Stage implements ITemperatureView, Observer {
	
	TextField textF;
	Thermogeekostat model;
	Button b1 = new Button("-");
	Button b2 = new Button("+");
	Slider slider = new Slider();
	
	public TextView(Thermogeekostat model) {
		
		this.model = model;
		FlowPane root = new FlowPane();
		Stage stage = new Stage();
		Text t = new Text(" Température en degrés : ");
		VBox vbox = new VBox(10);
		HBox hbox = new HBox(10);
		
		model.attach(this);
		
		b1.setMinSize(35.0,35.0);
		
		b2.setMinSize(35.0,35.0);
		textF = new TextField(getDisplayedValue() + "");
		
		slider.setMin(-60);
		slider.setMax(90);
		slider.setValue(0);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setPrefWidth(300);
		
		hbox.getChildren().addAll(b1,textF,b2);
		vbox.getChildren().addAll(hbox,slider);
		root.getChildren().addAll(t,vbox);
		
		Scene scene = new Scene(root,400,200);
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
        
        slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				changeText(newValue.doubleValue());	
				model.setTemperature(newValue.doubleValue());
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
		slider.setValue(model.getTemperature());
	}

	@Override
	public void update(Subject subj, Object data) {
		textF.setText(data+"");
	}

}
