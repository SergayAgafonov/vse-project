package com.example.jkhdiplom;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistrationController {

    @FXML private TextField codefield;
    @FXML private Label codepic;
    @FXML private Label wtext;
    @FXML private TextField loginfl;
    @FXML private TextField passwordfl;
    @FXML private TextField passfl;
    @FXML private TextField emailfl;
    @FXML private TextField namefl;
    @FXML private TextField otchfl;
    @FXML private TextField famfl;
    @FXML private ComboBox<String> polbox;
    @FXML private TextField daterfl;
    @FXML private TextField telfl;
    @FXML private TextField cityfl;
    @FXML private TextField homestfl;
    @FXML private TextField oblfl;
    @FXML private TextField rfl;
    @FXML private TextField numhomefl;
    @FXML private TextField numkvfl;
    @FXML private TextField numlicsfl;
    @FXML private AnchorPane pRegWind;

    private final String[] pollist = {"Мужской", "Женский"};
    private String selectPol = "Пол";

    @FXML void initialize() {

        codeRefresh();

        polbox.getItems().addAll(pollist);
        polbox.setValue("Пол");
        polbox.setOnAction(this::getPol);
    }

    public void btnReg (MouseEvent mouseEvent) {
        if (!(loginfl.getText().isEmpty() || passwordfl.getText().isEmpty() || emailfl.getText().isEmpty() || namefl.getText().isEmpty()
                || otchfl.getText().isEmpty() || famfl.getText().isEmpty() || daterfl.getText().isEmpty() || telfl.getText().isEmpty() || cityfl.getText().isEmpty()
                || homestfl.getText().isEmpty() || oblfl.getText().isEmpty() || rfl.getText().isEmpty() || numhomefl.getText().isEmpty() || numkvfl.getText().isEmpty()
                || numlicsfl.getText().isEmpty()) && Objects.equals(passwordfl.getText(), passfl.getText())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into authorization(Логин, Пароль, АдресEMail, Имя, Отчество, Фамилия, Пол, ДатаРождения, Телефон, Город, Улица, ОбластьКрай, Район, НомерДома, НомерКвартиры, НомерЛицСчета) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    statement.setString(1, loginfl.getText());
                    statement.setString(2, passwordfl.getText());
                    statement.setString(3, emailfl.getText());
                    statement.setString(4, namefl.getText());
                    statement.setString(5, otchfl.getText());
                    statement.setString(6, famfl.getText());
                    statement.setString(7, polbox.getValue());
                    statement.setString(8, daterfl.getText());
                    statement.setString(9, telfl.getText());
                    statement.setString(10, cityfl.getText());
                    statement.setString(11, homestfl.getText());
                    statement.setString(12, oblfl.getText());
                    statement.setString(13, rfl.getText());
                    statement.setString(14, numhomefl.getText());
                    statement.setString(15, numkvfl.getText());
                    statement.setString(16, numlicsfl.getText());
                    statement.executeUpdate();

                }

            } catch (Exception e) {
                System.out.println("Ошибка с заполнением");
            }
        } else wtext.setText("Данные в полях некорректны");
    }

    public void btnAuth (MouseEvent mouseEvent)  {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("authorization.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent room = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(room));
        stage.show();
        pRegWind.getScene().getWindow().hide();
    }

    public void glavnoeMenuButton (MouseEvent mouseEvent) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("glavnaya.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent room = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(room));
        stage.show();
        pRegWind.getScene().getWindow().hide();
    }

    private void getPol(javafx.event.ActionEvent ActionEvent) {
        selectPol = polbox.getValue();
    }

    private void codeRefresh(){

        String simCode = "qwertyuiopasdfghjkzxcvbnmQWERTYUOASDFGHJKLZXCVBNM1234567890";
        Random random = new Random();
        char sim;
        String code = "";
        int index;
        for (int i = 0; i < 4; i++) {
            index = random.nextInt(simCode.length());
            sim = simCode.charAt(index);
            code += sim;
        }
        codepic.setText(code);}
}
