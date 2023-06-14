package com.example.jkhdiplom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AutorizationController {

    @FXML private TextField codefield;
    @FXML private Label codepic;
    @FXML private Label wtext;
    @FXML private Button glavnoeMenuButton;
    @FXML private TextField tflogin;
    @FXML private TextField tfpass;
    @FXML private Button signUpButton;
    @FXML private Button registrButton;
    @FXML private AnchorPane PAut;
    public static int idAcc;

    @FXML
    void initialize() {
        codeRefresh();

        tfpass.textProperty().addListener((observableValue, s, t1)->
                codefield.setEditable(true));
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
        PAut.getScene().getWindow().hide();
    }

    public void registrButton(MouseEvent mouseEvent) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("registration.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent room = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(room));
        stage.show();
        PAut.getScene().getWindow().hide();
    }

    public void signUpButton(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            String login = tflogin.getText();
            String password = tfpass.getText();
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                System.out.println("Подключение к бд");
                wtext.setText("Неверный логин или пароль!");
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM authorization");
                while (resultSet.next()) {
                    if (resultSet.getString("Логин").equals(login) &&
                            resultSet.getString("Пароль").equals(password)  &&
                            (codefield.getText().equals(codepic.getText()))) {
                        String role = resultSet.getString("Роль");
                        if(Objects.equals(role, "admin")){{
                            loader.setLocation(getClass().getResource("adminAccount.fxml"));
                            Parent root = null;
                            try {
                                root = loader.load();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Stage stage = new Stage();
                            assert root != null;
                            stage.setScene(new Scene(root));
                            stage.show();
                            PAut.getScene().getWindow().hide();
                            break;}}
                    }
                }

                Statement statement3 = conn.createStatement();
                ResultSet resultSet3 = statement3.executeQuery("SELECT * FROM authorization");
                while (resultSet3.next()) {
                    if (resultSet3.getString("Логин").equals(login) &&
                            resultSet3.getString("Пароль").equals(password) &&
                            (codefield.getText().equals(codepic.getText()))){
                        idAcc = resultSet3.getInt("id_user");
                        loader.setLocation(getClass().getResource("personalAccount.fxml"));
                        Parent root = null;
                        try {
                            root = loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        assert root != null;
                        stage.setScene(new Scene(root));
                        stage.show();
                        PAut.getScene().getWindow().hide();
                        break;}}
            }
        } catch (Exception ex) {
            System.out.println("Ошибка доступа к БД");
        }
        codeRefresh();
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
