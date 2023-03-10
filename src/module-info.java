module GameTestWithJavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.controllers to javafx.graphics, javafx.fxml;

    exports application.controllers;
}
