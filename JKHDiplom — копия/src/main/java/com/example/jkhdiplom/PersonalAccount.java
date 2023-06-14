package com.example.jkhdiplom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class PersonalAccount {

    @FXML private Label lbName;
    @FXML private Label lbOtch;
    @FXML private Label lbFam;
    @FXML private Label lbPol;
    @FXML private Label lbDr;
    @FXML private Label lbTel;
    @FXML private Label lbNH;
    @FXML private Label lbNK;
    @FXML private Label lbObl;
    @FXML private Label lbCt;
    @FXML private Label lbRay;
    @FXML private Label lbSt;
    @FXML private Label lbNLC;
    @FXML private Label lbEMail;
    @FXML private Label lbPriv;
    @FXML private CheckBox chSmPass;
    @FXML private TextField tfPass;
    @FXML private TextField tfRePass;
    @FXML private Label lbPassSm;
    @FXML private Label lbRePassSm;
    @FXML private Pane pPodtv;
    @FXML private Label lbErP;
    @FXML private CheckBox chOtprZayv;
    @FXML private Pane pOtprZayv;
    @FXML private ComboBox cmUsl;
    @FXML private Label lbError;
    @FXML private TextField tfFIO;
    @FXML private TextField tfNumHome;
    @FXML private TextField tfNumKv;
    @FXML private TextField tfNumTel;
    @FXML private TextField tfPrim;
    @FXML private DatePicker DtPick;
    @FXML private AnchorPane pLK;

    private final ObservableList<String> UslData = FXCollections.observableArrayList();

    private String selectcmUsl = "";

    @FXML
    void initialize() throws SQLException {

        DataAcc(AutorizationController.idAcc);
        sTime();
        fillComboBoxUsl();
    }
    private void sTime(){
        int time = Integer.parseInt(String.valueOf(java.time.LocalDateTime.now()).substring(11, 13));
        if (9<=time && time<=10) {
            lbPriv.setText("Доброе утро");
        }
        else if (11<=time && time<=17) {
            lbPriv.setText("Добрый день");
        }
        else if (18<=time && time<=23) {
            lbPriv.setText("Добрый вечер");
        }
    }

    private void DataAcc ( int Code){
        System.out.println(Code);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Имя, Отчество, Фамилия, Пол, ДатаРождения, Телефон, НомерДома, НомерКвартиры, Город, ОбластьКрай, Район, Улица, НомерЛицСчета, АдресEMail FROM authorization WHERE id_user = " + Code);
            while (resultSet.next()) {
                lbName.setText(resultSet.getString("Имя"));
                lbOtch.setText(resultSet.getString("Отчество"));
                lbFam.setText(resultSet.getString("Фамилия"));
                lbPol.setText(resultSet.getString("Пол"));
                lbDr.setText(resultSet.getString("ДатаРождения"));
                lbTel.setText(resultSet.getString("Телефон"));
                lbNH.setText(resultSet.getString("НомерДома"));
                lbNK.setText(resultSet.getString("НомерКвартиры"));
                lbCt.setText(resultSet.getString("Город"));
                lbObl.setText(resultSet.getString("ОбластьКрай"));
                lbRay.setText(resultSet.getString("Район"));
                lbSt.setText(resultSet.getString("Улица"));
                lbNLC.setText(resultSet.getString("НомерЛицСчета"));
                lbEMail.setText(resultSet.getString("АдресEMail"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }

    public void CBPass (ActionEvent event) {
        if (chSmPass.isSelected()){
            tfPass.setVisible(true);
            tfRePass.setVisible(true);
            lbPassSm.setVisible(true);
            lbRePassSm.setVisible(true);
            pPodtv.setVisible(true);
        }
        else {
            tfPass.setVisible(false);
            tfRePass.setVisible(false);
            lbPassSm.setVisible(false);
            lbRePassSm.setVisible(false);
            pPodtv.setVisible(false);
        }
    }

    public void OtprZayv (ActionEvent event) {
        if (chOtprZayv.isSelected()){
            pOtprZayv.setVisible(true);
        }
        else {
            pOtprZayv.setVisible(false);
        }
    }

    public void ClPodtv (javafx.scene.input.MouseEvent mouseEvent) {
        if(!(tfPass.getText().isEmpty() || tfRePass.getText().isEmpty())
                && Objects.equals(tfPass.getText(), tfRePass.getText())){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE authorization SET Пароль = '" + tfPass.getText() + "' WHERE id_user = " + AutorizationController.idAcc);
                    statement.executeUpdate();
                }
            } catch (Exception e) {
                System.out.println("Ошибка с изменением пароля");
            }
            lbErP.setText("");}
        else if (!(chSmPass.isSelected())) {
            lbErP.setText("");}
        else {lbErP.setText("Проверьте пароль");}
    }

    public void fillComboBoxUsl() throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Услуга FROM uslugi");
            while (resultSet.next()){
                UslData.add(resultSet.getString("Услуга"));
            }
            cmUsl.getItems().addAll( UslData);
            cmUsl.setValue("Вид услуги");
            cmUsl.setOnAction(this::getcmUsl);
        }catch (Exception e){
            System.out.println("Ошибка с боксом");
        }}

    private void getcmUsl(Event event) {selectcmUsl = (String) cmUsl.getValue();}

    public void ClBackOtrZayv (javafx.scene.input.MouseEvent mouseEvent) {pOtprZayv.setVisible(false);}

    public void ClSohrOtprZayv (javafx.scene.input.MouseEvent mouseEvent) {pOtprZayv.setVisible(false);
        if (!(tfFIO.getText().isEmpty() || tfNumHome.getText().isEmpty()
                || tfNumKv.getText().isEmpty() || tfNumTel.getText().isEmpty() || tfPrim.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")){
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into zayavkijil(ФИО, НомерДома, НомерКвартиры, Телефон, ВидУслуги, Примечание, ДатаЗаявки) VALUES(?,?,?,?,?,?,?)");
                    statement.setString(1, tfFIO.getText());
                    statement.setString(2, tfNumHome.getText());
                    statement.setString(3, tfNumKv.getText());
                    statement.setString(4, tfNumTel.getText());
                    statement.setString(5, selectcmUsl);
                    statement.setString(6, tfPrim.getText());
                    statement.setString(7, String.valueOf(java.sql.Date.valueOf(DtPick.getValue())));
                    statement.executeUpdate();
                }}
        catch (Exception e) {
            System.out.println("Ошибка с заполнением");
        }}
            else {lbError.setText("Проверьте, все ли поля заполнены верно");}}


    public void ClExit (javafx.scene.input.MouseEvent mouseEvent) {
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
        pLK.getScene().getWindow().hide();
    }
}
