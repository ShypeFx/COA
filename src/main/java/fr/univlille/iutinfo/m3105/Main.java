package fr.univlille.iutinfo.m3105;

import fr.univlille.iutinfo.m3105.modelQ1.Thermogeekostat;
import fr.univlille.iutinfo.m3105.modelQ2.Echelle;
import fr.univlille.iutinfo.m3105.modelQ2.Temperature;
import fr.univlille.iutinfo.m3105.viewQ1.SlideView;
import fr.univlille.iutinfo.m3105.viewQ3.TextView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Temperature temp = new Temperature(Echelle.CELSIUS);
		Temperature temp2 = new Temperature(Echelle.KELVIN);
		Temperature temp3 = new Temperature(Echelle.FAHRENHEIT);
		temp.biconnectTo(temp2);
		temp.biconnectTo(temp3);
		temp2.biconnectTo(temp3);
		new TextView(temp);
		new TextView(temp2);	
	}

}
