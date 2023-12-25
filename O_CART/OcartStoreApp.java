
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class OcartStoreApp extends Application {

    private Phone[] phones = {
            	new Phone("IPhone 15 pro", "Apple", "phone/iphone 15 pro.png"),
            	new Phone("Samsumg Galaxy S24 ultra", "Samsung", "phone/Samsumg Galaxy S24 ultra.png"),
            	new Phone("IQOO 11 pro", "IQOO", "phone/IQOO 11 pro.png"),
	    	new Phone("Oneplus 11 pro", "Oneplus", "phone/Oneplus 11 pro.png"),
		new Phone("Oneplus nord 3", "Oneplus", "phone/Oneplus nord 3.png"),
		new Phone("Google Pixel 8a pro", "Googel", "phone/pixel.png"),
		new Phone("Huawei P50 Pro", "Huawei", "phone/Huawai p50 pro.png"),
		new Phone("Vivo X70 Pro+", "Vivo", "phone/Vivo X90pro.png"),
		new Phone("Xiaomi Mi 11 Ultra", "Xiaomi", "phone/Xiaomi 11 Ultra.png"),
		new Phone("Samsumg Galaxy Z Fold 2", "Samsumg", "phone/samsumg galaxy z fold 2.png"),
		new Phone("Iphone 14 Mini", "Apple", "phone/iphone_14 mini.png"),
		new Phone("Oneplus pad", "Oneplus", "phone/Oneplus pad.png")
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox phoneList = new VBox(10);
        phoneList.setPadding(new Insets(20));

        for (Phone phone : phones) {
            HBox phoneBox = new HBox(10);
            phoneBox.setPadding(new Insets(10));

            ImageView imageView = new ImageView(new Image(new File(phone.getImagePath()).toURI().toString()));
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            Label nameLabel = new Label(phone.getName());
            Label brandLabel = new Label("Brand: " + phone.getBrand());
            Button buyButton = new Button("Buy");

            phoneBox.getChildren().addAll(imageView, nameLabel, brandLabel, buyButton);
            phoneList.getChildren().add(phoneBox);

            buyButton.setOnAction(e -> {
                Stage orderStage = new Stage();
                VBox orderBox = new VBox(10);
                orderBox.setPadding(new Insets(20));

                // Input fields for order details

		TextField name = new TextField();
                name.setPromptText("Name");

		TextField BiddingAmount = new TextField();
                BiddingAmount.setPromptText("Bidding Amount");

                TextField quantityField = new TextField();
                quantityField.setPromptText("Quantity");

                TextField addressField = new TextField();
                addressField.setPromptText("Address");

                

                Button checkoutButton = new Button("Proceed");

                // Add all elements to the VBox
                orderBox.getChildren().addAll(name,BiddingAmount, addressField, quantityField, checkoutButton);

                checkoutButton.setOnAction(event -> {
                    // Perform checkout operations here
                    orderStage.close();
                    // Show a pop-up message with congratulations
                    displayCongratsPopup();
                });

                Scene orderScene = new Scene(orderBox, 400, 300);
                orderStage.setTitle("Order Information");
                orderStage.setScene(orderScene);
                orderStage.show();
            });
        }

        // Encapsulate the VBox in a ScrollPane
        ScrollPane scrollPane = new ScrollPane(phoneList);
        scrollPane.setFitToWidth(true);

        // Calculate content height and set window size accordingly
        int contentHeight = phones.length * 130; // Height estimation for each phone entry
        int windowHeight = Math.min(contentHeight + 100, 500); // Limit window height to 600

	Scene scene = new Scene(scrollPane, 500, windowHeight);
	scene.setFill(Color.rgb(200,0,0)); // Setting a dark gray background color
        
	primaryStage.setTitle("Ocart - Smartphone Store");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayCongratsPopup() {
        Stage popupStage = new Stage();
        VBox popupBox = new VBox(10);
        popupBox.setPadding(new Insets(20));

        Label congratsLabel = new Label("Congratulations! Your order has been placed.");
        Button closeButton = new Button("Close");

        closeButton.setOnAction(e -> popupStage.close());

        popupBox.getChildren().addAll(congratsLabel, closeButton);

        Scene popupScene = new Scene(popupBox, 300, 150);
        popupStage.setTitle("Order Confirmation");
        popupStage.setScene(popupScene);
        popupStage.show();
    }
}

class Phone {
    private String name;
    private String brand;
    private String imagePath;

    public Phone(String name, String brand, String imagePath) {
        this.name = name;
        this.brand = brand;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getImagePath() {
        return imagePath;
    }
}

