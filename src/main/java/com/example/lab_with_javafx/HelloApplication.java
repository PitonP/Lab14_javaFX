package com.example.lab_with_javafx;

import javafx.application.Application;
import javafx.event.EventHandler;
//import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import java.io.IOException;


public class HelloApplication extends Application {
    private Text txt_1;
    CheckBox ribs, vobla, grape;
    RadioButton vodka, beer, wine;
    Label party = new Label ("Скорее определитесь");
    Label blankColumn = new Label ("       ");
    String drink = "", snack = "", resume;


    @Override
    public void start (Stage stage) throws IOException {
        stage.setTitle ("Окна");
        stage.setWidth (500);
        stage.setHeight (300);

        Circle circle = new Circle (70, 110, 30);
        circle.setFill (Color.YELLOWGREEN);

        Text txt = new Text ();
        txt.setText ("D D");
        txt.setFill (Color.BLUE);
        txt.setFont (Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        txt_1 = new Text ("A");
        txt_1.setFont (Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));

        HBox nodeButton = new HBox (20);
        Button buttonM = new Button ("Увеличить кегль");
        Button buttonL = new Button ("Отменить увеличение кегля");
        nodeButton.getChildren().add(buttonM);
        nodeButton.getChildren().add(buttonL);
        buttonM.setOnAction (new buttonMntr());
        buttonL.setOnAction (new buttonR());

        StackPane sPane = new StackPane();
        sPane.getChildren().add(circle);

        // Класс Label
        Label l1 = new Label ("АБСТРАКЦИЯ", circle);
        sPane.getChildren().add(l1);
        l1.setContentDisplay(ContentDisplay.BOTTOM);

        sPane.getChildren().add(txt);
        sPane.getChildren().add(txt_1);

        // Объекты типа флажков
        CheckBox ribs = new CheckBox("Ребрышки");
        CheckBox vobla = new CheckBox("Вобла");
        CheckBox grape = new CheckBox("Виноград");
        EventHandler <ActionEvent> flagHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent actionEvent) {
                if (ribs.isSelected() | vobla.isSelected() | grape.isSelected()) {
                    snack = "На закуску:\n";
                    if (ribs.isSelected()) snack = snack + "Ребрышки \n";
                    if (vobla.isSelected()) snack = snack + "Вобла \n";
                    if (grape.isSelected()) snack = snack + "Виноград \n";
                    party.setText(snack + "А пьем " + drink);
                }
                else {
                    party.setText("Пьем то мы " + drink + ", а вот чем закусываем?");
                }
            }
        };
        ribs.setOnAction(flagHandler);
        vobla.setOnAction(flagHandler);
        grape.setOnAction(flagHandler);

        // Объекты типа переключатель
        RadioButton vodka = new RadioButton("Водка");
        RadioButton beer = new RadioButton("Пиво");
        RadioButton wine = new RadioButton("Вино");
        ToggleGroup radioGroup = new ToggleGroup();
        vodka.setToggleGroup(radioGroup);
        beer.setToggleGroup(radioGroup);
        wine.setToggleGroup(radioGroup);

        EventHandler <ActionEvent> radioHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent actionEvent) {
                if (ribs.isSelected() | vobla.isSelected() | grape.isSelected()) {
                    if (vodka.isSelected()) drink = "водку";
                    if (beer.isSelected()) drink = "пиво";
                    if (wine.isSelected()) drink = "вино";
                    party.setText(snack + "А вот пьем " + drink);
                }
                else {
                    if (vodka.isSelected()) drink = "водку";
                    if (beer.isSelected()) drink = "пиво";
                    if (wine.isSelected()) drink = "вино";
                    party.setText("Чем закусывать то будем?");
                }
            }
        };
        vodka.setOnAction(radioHandler);
        beer.setOnAction(radioHandler);
        wine.setOnAction(radioHandler);

        GridPane menu = new GridPane ();
        menu.addColumn(0, ribs);
        menu.addColumn(0, vobla);
        menu.addColumn(0, grape);
        menu.addColumn(0, party);
        menu.addColumn(1,blankColumn);
        menu.addColumn(2, vodka);
        menu.addColumn(2, beer);
        menu.addColumn(2, wine);

        BorderPane bPane = new BorderPane();
        bPane.setCenter(sPane);
        bPane.setBottom(nodeButton);
        bPane.setLeft(menu);

        Scene scene = new Scene (bPane);  // создание Scene
        stage.setScene(scene);          // размещение  Scene в Stage
        stage.show();
    }
    class buttonMntr implements EventHandler <ActionEvent>{
        @Override
        public void handle (ActionEvent activeEvent) {
            txt_1.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 50));
        }
    }
    class buttonR implements EventHandler <ActionEvent>{
        @Override
        public void handle (ActionEvent activeEvent) {
            txt_1.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 30));
        }
    }
}