package com.example.jkhdiplom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GlavnayaController {

    @FXML private Pane PGlav;
    @FXML private Pane PNews;
    @FXML private ScrollPane PTar;
    @FXML private ScrollPane PPrZas;
    @FXML private ScrollPane PNewsN;
    @FXML private ScrollPane PDopUsl;

    @FXML private TableView<DBtable> tableN;
    @FXML private TableColumn<DBtable, Integer> CodeID;
    @FXML private TableColumn<DBtable, String> TbDate;
    @FXML private TableColumn<DBtable, String> TbNews;

    @FXML private TableView<DBtableOtop> tableOtop;
    @FXML private TableColumn<DBtableOtop, Integer> OtopID;
    @FXML private TableColumn<DBtableOtop, String> OtopRes;
    @FXML private TableColumn<DBtableOtop, String> OtopTar;
    @FXML private TableColumn<DBtableOtop, String> OtopNorm;
    @FXML private TableColumn<DBtableOtop, String> OtopResP;

    @FXML private TableView<DBtableHol> tableHol;
    @FXML private TableColumn<DBtableHol, Integer> HolID;
    @FXML private TableColumn<DBtableHol, String> HolRes;
    @FXML private TableColumn<DBtableHol, String> HolTar;
    @FXML private TableColumn<DBtableHol, String> HolNorm;
    @FXML private TableColumn<DBtableHol, String> HolResP;

    @FXML private TableView<DBtableEl> tableElectr;
    @FXML private TableColumn<DBtableEl, Integer> ElectID;
    @FXML private TableColumn<DBtableEl, String> ElectRes;
    @FXML private TableColumn<DBtableEl, String> ElectTar;
    @FXML private TableColumn<DBtableEl, String> ElectNorm;
    @FXML private TableColumn<DBtableEl, String> ElectResP;

    @FXML private TableView<DBtableGor> tableGor;
    @FXML private TableColumn<DBtableGor, Integer> GorID;
    @FXML private TableColumn<DBtableGor, String> GorRes;
    @FXML private TableColumn<DBtableGor, String> GorTar;
    @FXML private TableColumn<DBtableGor, String> GorNorm;
    @FXML private TableColumn<DBtableGor, String> GorResP;

    @FXML private TableView<DBtableUsl> tableUsl;
    @FXML private TableColumn<DBtableUsl, Integer> UsID;
    @FXML private TableColumn<DBtableUsl, String> Usluga;
    @FXML private TableColumn<DBtableUsl, String> Price;

    @FXML private ImageView imageScreen;
    @FXML private Label lbOpis;
    @FXML private Label nameNews;
    public int codeProp;

    private DBtable selectedTable1 = new DBtable();
    private DBtableOtop selectedTable2 = new DBtableOtop();

    private final ObservableList<DBtable> tableNews = FXCollections.observableArrayList();
    private final ObservableList<DBtableOtop> tableOt = FXCollections.observableArrayList();
    private final ObservableList<DBtableHol> tableH = FXCollections.observableArrayList();
    private final ObservableList<DBtableEl> tableEl = FXCollections.observableArrayList();
    private final ObservableList<DBtableGor> tableG = FXCollections.observableArrayList();
    private final ObservableList<DBtableUsl> tableU = FXCollections.observableArrayList();

    @FXML void initialize() {

        CodeID.setCellValueFactory(new PropertyValueFactory<>("CodeID"));
        TbNews.setCellValueFactory(new PropertyValueFactory<>("TbNews"));
        TbDate.setCellValueFactory(new PropertyValueFactory<>("TbDate"));

        tablerefresh();

        OtopID.setCellValueFactory(new PropertyValueFactory<>("OtopID"));
        OtopRes.setCellValueFactory(new PropertyValueFactory<>("OtopRes"));
        OtopTar.setCellValueFactory(new PropertyValueFactory<>("OtopTar"));
        OtopNorm.setCellValueFactory(new PropertyValueFactory<>("OtopNorm"));
        OtopResP.setCellValueFactory(new PropertyValueFactory<>("OtopResP"));

        tablerefreshOtop();

        HolID.setCellValueFactory(new PropertyValueFactory<>("HolID"));
        HolRes.setCellValueFactory(new PropertyValueFactory<>("HolRes"));
        HolTar.setCellValueFactory(new PropertyValueFactory<>("HolTar"));
        HolNorm.setCellValueFactory(new PropertyValueFactory<>("HolNorm"));
        HolResP.setCellValueFactory(new PropertyValueFactory<>("HolResP"));

        tablerefreshHol();

        ElectID.setCellValueFactory(new PropertyValueFactory<>("ElectID"));
        ElectRes.setCellValueFactory(new PropertyValueFactory<>("ElectRes"));
        ElectTar.setCellValueFactory(new PropertyValueFactory<>("ElectTar"));
        ElectNorm.setCellValueFactory(new PropertyValueFactory<>("ElectNorm"));
        ElectResP.setCellValueFactory(new PropertyValueFactory<>("ElectResP"));

        tablerefreshEl();

        GorID.setCellValueFactory(new PropertyValueFactory<>("GorID"));
        GorRes.setCellValueFactory(new PropertyValueFactory<>("GorRes"));
        GorTar.setCellValueFactory(new PropertyValueFactory<>("GorTar"));
        GorNorm.setCellValueFactory(new PropertyValueFactory<>("GorNorm"));
        GorResP.setCellValueFactory(new PropertyValueFactory<>("GorResP"));

        UsID.setCellValueFactory(new PropertyValueFactory<>("UsID"));
        Usluga.setCellValueFactory(new PropertyValueFactory<>("Usluga"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tablerefreshG();

        tableN.setRowFactory( tv -> {
            TableRow<DBtable> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                selectedTable1 = tableN.getSelectionModel().getSelectedItem();
                showOpis(selectedTable1.getIDCode());
                codeProp = selectedTable1.getIDCode();
                if (event.getClickCount() == 2);
                PNewsN.setVisible(true);
            });
            return row;
        });
    }

    public void BtnClNews(javafx.scene.input.MouseEvent mouseEvent) {
        PNews.setVisible(false);
    }

    public void btnCloseNews(javafx.scene.input.MouseEvent mouseEvent) {
        PNewsN.setVisible(false);
    }

    public void BtnClTar(javafx.scene.input.MouseEvent mouseEvent) {
        PTar.setVisible(false);
    }

    public void BtnClPrZas(javafx.scene.input.MouseEvent mouseEvent) {
        PPrZas.setVisible(false);
    }

    public void ClVernUsl (javafx.scene.input.MouseEvent mouseEvent) {
        PDopUsl.setVisible(false);
    }

    public void ClickP1(javafx.scene.input.MouseEvent mouseEvent) {PTar.setVisible(true);}

    public void ClickP3(MouseEvent mouseEvent) {
        PPrZas.setVisible(true);
    }

    public void ClickP4(MouseEvent mouseEvent) {
        PNews.setVisible(true);
    }

    public void ClickP5(MouseEvent mouseEvent) {
        PDopUsl.setVisible(true);
        tableU.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM uslugi");
                while (resultSet.next()) {
                    tableU.add(new DBtableUsl(
                            resultSet.getInt("id"),
                            resultSet.getString("Услуга"),
                            resultSet.getString("Цена")));
                }
            }
            if (!tableU.isEmpty()) {
                tableUsl.setItems(tableU);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей");
        }
    }

    public void ClickPAuth(MouseEvent mouseEvent){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("authorization.fxml"));

        try{
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        PGlav.getScene().getWindow().hide();
    }

    public void ClickPReg(MouseEvent mouseEvent){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("registration.fxml"));

        try{
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        PGlav.getScene().getWindow().hide();
    }

    private void tablerefresh() {
        tableNews.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM news");
                while (resultSet.next()) {
                    tableNews.add(new DBtable(
                            resultSet.getInt("id"),
                            resultSet.getString("Новость"),
                            resultSet.getString("Дата")));
                }
            }
            if (!tableNews.isEmpty()) {
                tableN.setItems(tableNews);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей новостей");
        }
    }

    private void tablerefreshOtop() {
        tableOt.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM otoplenie");
                while (resultSet.next()) {
                    tableOt.add(new DBtableOtop(
                            resultSet.getInt("id"),
                            resultSet.getString("Ресурс"),
                            resultSet.getString("Тариф"),
                            resultSet.getString("Нормативно_правового_акта"),
                            resultSet.getString("Ресурсоснабжающее_предприятие")));
                }
            }
            if (!tableOt.isEmpty()) {
                tableOtop.setItems(tableOt);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей отопления");
        }
    }

    private void tablerefreshHol() {
        tableH.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM holvodsnab");
                while (resultSet.next()) {
                    tableH.add(new DBtableHol(
                            resultSet.getInt("id"),
                            resultSet.getString("Ресурс"),
                            resultSet.getString("Тариф"),
                            resultSet.getString("Нормативно_правового_акта"),
                            resultSet.getString("Ресурсоснабжающее_предприятие")));
                }
            }
            if (!tableH.isEmpty()) {
                tableHol.setItems(tableH);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей холодного водоснабжения и водоотведения");
        }
    }

    private void tablerefreshEl() {
        tableEl.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM electrosnab");
                while (resultSet.next()) {
                    tableEl.add(new DBtableEl(
                            resultSet.getInt("id"),
                            resultSet.getString("Ресурс"),
                            resultSet.getString("Тариф"),
                            resultSet.getString("Нормативно_правового_акта"),
                            resultSet.getString("Ресурсоснабжающее_предприятие")));
                }
            }
            if (!tableEl.isEmpty()) {
                tableElectr.setItems(tableEl);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей электроснабжения");
        }
    }

    private void tablerefreshG() {
        tableG.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM gorvodsnab");
                while (resultSet.next()) {
                    tableG.add(new DBtableGor(
                            resultSet.getInt("id"),
                            resultSet.getString("Ресурс"),
                            resultSet.getString("Тариф"),
                            resultSet.getString("Нормативно_правового_акта"),
                            resultSet.getString("Ресурсоснабжающее_предприятие")));
                }
            }
            if (!tableG.isEmpty()) {
                tableGor.setItems(tableG);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей горячего водоснабжения");
        }
    }

    private void showOpis(int Code) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh", "root", "MySQL");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM news WHERE `id` = " + Code);
            while (resultSet.next()) {
                nameNews.setText(resultSet.getString("Новость"));
                lbOpis.setText(resultSet.getString("Описание"));
                imageScreen.setImage(new Image("C:\\Users\\Admin\\IdeaProjects\\JKHDiplom\\src\\main\\resources\\" + resultSet.getString("Картинка") + ".jpg"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка с описанием новости");
        }
    }

    public void ClickUslP1(javafx.scene.input.MouseEvent mouseEvent) {
        tableU.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM uslugi");
                while (resultSet.next()) {
                    tableU.add(new DBtableUsl(
                            resultSet.getInt("id"),
                            resultSet.getString("Услуга"),
                            resultSet.getString("Цена")));
                }
            }
            if (!tableU.isEmpty()) {
                tableUsl.setItems(tableU);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей услуг");
        }
    }

    public void ClickUslP2(javafx.scene.input.MouseEvent mouseEvent) {
        tableU.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM uslugisant");
                while (resultSet.next()) {
                    tableU.add(new DBtableUsl(
                            resultSet.getInt("id"),
                            resultSet.getString("Услуга"),
                            resultSet.getString("Цена")));
                }
            }
            if (!tableU.isEmpty()) {
                tableUsl.setItems(tableU);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей");
        }
    }

    public void ClickUslP3(javafx.scene.input.MouseEvent mouseEvent) {
        tableU.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM uslugiplot");
                while (resultSet.next()) {
                    tableU.add(new DBtableUsl(
                            resultSet.getInt("id"),
                            resultSet.getString("Услуга"),
                            resultSet.getString("Цена")));
                }
            }
            if (!tableU.isEmpty()) {
                tableUsl.setItems(tableU);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей");
        }
    }

    public void ClickUslP4(javafx.scene.input.MouseEvent mouseEvent) {
        tableU.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM uslugiklint");
                while (resultSet.next()) {
                    tableU.add(new DBtableUsl(
                            resultSet.getInt("id"),
                            resultSet.getString("Услуга"),
                            resultSet.getString("Цена")));
                }
            }
            if (!tableU.isEmpty()) {
                tableUsl.setItems(tableU);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей");
        }
    }
}