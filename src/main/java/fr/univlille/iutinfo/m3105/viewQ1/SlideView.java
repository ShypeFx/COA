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

public class SlideView extends Stage implements ITemperatureView, Observer{
	TextField textF;
	Thermogeekostat model;
	Slider slider = new Slider();
	
	public SlideView(Thermogeekostat model) {
		
		this.model = model;
		FlowPane root = new FlowPane();
		Stage stage = new Stage();
		VBox vbox = new VBox(10);
		HBox hbox = new HBox(10);
		
		model.attach(this);

			
		slider.setMin(-60);
		slider.setMax(90);
		slider.setValue(0);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setPrefWidth(280);
				
		vbox.getChildren().addAll(hbox,slider);
		root.getChildren().addAll(vbox);
		
		Scene scene = new Scene(root,400,200);
        stage.setScene(scene);
        stage.show();
       
        
        slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				double val = newValue.doubleValue();
				val = Math.round(val*10.0) / 10.0;
				model.setTemperature(val);
				update(model);
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
		slider.setValue(model.getTemperature());
		
	}

	@Override
	public void update(Subject subj, Object data) {
		slider.setValue(model.getTemperature());
	}
}
