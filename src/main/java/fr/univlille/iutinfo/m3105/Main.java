package fr.univlille.iutinfo.m3105;

import fr.univlille.iutinfo.m3105.modelQ1.Thermogeekostat;
import fr.univlille.iutinfo.m3105.viewQ1.TextView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Thermogeekostat thermo = new Thermogeekostat();
		new TextView( thermo);
	}

}
