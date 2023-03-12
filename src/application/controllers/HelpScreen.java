package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class HelpScreen implements Initializable {
	
	@FXML
	private Button btnBack;
	
	@FXML
	private Button btnGameRules;
	
	@FXML
	private Text txtGameRules;
		
	@FXML
	protected void onBtnBackClicked(ActionEvent event) {
		Scene menuScreen = Main.menuScreen;
		Main.mainStage.setScene(menuScreen);
		Main.mainStage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String gameRules = "Lorem ipsum dolor sit amet. Ex consectetur iure qui odio nulla ut sint voluptatem ut autem consequatur. Qui perferendis molestiae vel numquam sapiente qui explicabo galisum sed repudiandae expedita vel eligendi eligendi et nulla enim. Ex dolor autem id illum porro aut omnis dicta eum modi amet in rerum soluta. \\nEt unde autem et ipsa dignissimos vel molestias inventore est dicta atque id voluptas repellat? 33 sint enim rem alias rerum aut deleniti alias a animi ipsa. Id consectetur repellat sit tempora laborum sit quam corrupti 33 alias labore. Sed quas omnis aut harum fugit est blanditiis dicta qui ducimus reiciendis. /nEt adipisci voluptas et internos optio ut dolorem quia ut consequatur aliquam. Eos beatae dolorem id esse veniam qui culpa possimus ut repellat quas id expedita molestias id dolores Quis! /nAd impedit mollitia id suscipit unde et culpa adipisci. Ex consequuntur quos est velit tenetur et perferendis libero. Hic accusamus omnis cum aspernatur ipsum et officiis magni quo quia odio nam repellendus voluptas et quibusdam rerum. \\nSit omnis enim est tenetur facere qui nisi accusantium. Et distinctio eius et quod voluptates id quidem quae sed rerum magni. Non nemo aliquam ea optio doloremque est dolore obcaecati et eaque laboriosam. Aut quam doloribus et tempora quam qui facilis praesentium est tempora optio eum culpa facilis id quia itaque! /n";    
		txtGameRules.setText(gameRules);
	}
}
