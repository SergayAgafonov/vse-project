package com.example.jkhdiplom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class AdminAccount {

    @FXML private AnchorPane PGlav;
    @FXML private ScrollPane PTar;

    @FXML private Pane PNews;
    @FXML private Pane IzmPane;
    @FXML private Pane AddPane;
    @FXML private Pane PIzmUslW;
    @FXML private Pane PAddUslW;
    @FXML private Pane PAddTarW1;
    @FXML private Pane PIzmTarW1;
    @FXML private Pane PAddTarW2;
    @FXML private Pane PIzmTarW2;
    @FXML private Pane PAddTarW3;
    @FXML private Pane PIzmTarW3;
    @FXML private Pane PAddTarW4;
    @FXML private Pane PIzmTarW4;
    @FXML private Pane PIzmSpZW;
    @FXML private Pane PSpisokZ;
    @FXML private Pane PAddSpisZ;
    @FXML private Pane PIzmSpisZW;

    @FXML private Pane PAddUsl;
    @FXML private Pane PDellUsl;
    @FXML private Pane PIzmUsl;
    @FXML private Pane PAddUslS;
    @FXML private Pane PDellUslS;
    @FXML private Pane PIzmUslS;
    @FXML private Pane PAddUslP;
    @FXML private Pane PDellUslP;
    @FXML private Pane PIzmUslP;
    @FXML private Pane PAddUslK;
    @FXML private Pane PDellUslK;
    @FXML private Pane PIzmUslK;

    @FXML private Pane PAddUslWind;
    @FXML private Pane PAddUslWind2;
    @FXML private Pane PAddUslWind3;
    @FXML private Pane PAddUslWind4;
    @FXML private Pane PBackUslWind;
    @FXML private Pane PBackUslWind2;
    @FXML private Pane PBackUslWind3;
    @FXML private Pane PBackUslWind4;
    @FXML private Pane PIzmUslWind;
    @FXML private Pane PIzmUslWind2;
    @FXML private Pane PIzmUslWind3;
    @FXML private Pane PIzmUslWind4;
    @FXML private Pane PBackIzmUslWind;
    @FXML private Pane PBackIzmUslWind2;
    @FXML private Pane PBackIzmUslWind3;
    @FXML private Pane PBackIzmUslWind4;

    @FXML private ScrollPane PNewsN;
    @FXML private ScrollPane PDopUsl;
    @FXML private Pane PSpZ1;

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

    @FXML private TableView<DBtableSpZ> tableSpZ;
    @FXML private TableColumn<DBtableSpZ, Integer> IDSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClAdrEmSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClNameSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClPatrSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClFamSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClPSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClDatSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClTelSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClCitySpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClStSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClOblSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClRegSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClNumHSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClNumKvSpZ;
    @FXML private TableColumn<DBtableSpZ, String> ClNumLCSpZ;

    @FXML private TableView<DBtableSpisZ> tableSpisZ;
    @FXML private TableColumn<DBtableSpisZ, Integer> IDSpisZ;
    @FXML private TableColumn<DBtableSpisZ, String> ClFIOSpisZ;
    @FXML private TableColumn<DBtableSpisZ, String> ClNumHomeSpisZ;
    @FXML private TableColumn<DBtableSpisZ, String> ClNumKvSpisZ;
    @FXML private TableColumn<DBtableSpisZ, String> ClNumTelSpisZ;
    @FXML private TableColumn<DBtableSpisZ, String> ClVidUslSpisZ;
    @FXML private TableColumn<DBtableSpisZ, String> ClPrimSpisZ;
    @FXML private TableColumn<DBtableSpisZ, String> ClDatZSpisZ;
    @FXML private TableColumn<DBtableSpisZ, String> ClStatusSpisZ;

    @FXML private ImageView imageScreen;
    @FXML private Label lbOpis;
    @FXML private Label nameNews;
    @FXML private Label wtextIzm;
    @FXML private Label wtextadd;
    @FXML private Label wtextAddUsl;

    @FXML private TextField tfNews;
    @FXML private TextField tfDate;
    @FXML private TextField tfOpis;
    @FXML private TextField tfPict;

    @FXML private TextField tfNewsAd;
    @FXML private TextField tfDateAd;
    @FXML private TextField tfOpisAd;
    @FXML private TextField tfPictAd;

    @FXML private TextField tfUslAdd;
    @FXML private TextField tfPrAdd;
    @FXML private TextField tfIzmUslW;
    @FXML private TextField tfIzmPrW;

    @FXML private TextField tfUslAdd2;
    @FXML private TextField tfPrAdd2;
    @FXML private TextField tfIzmUslW2;
    @FXML private TextField tfIzmPrW2;

    @FXML private TextField tfUslAdd3;
    @FXML private TextField tfPrAdd3;
    @FXML private TextField tfIzmUslW3;
    @FXML private TextField tfIzmPrW3;

    @FXML private TextField tfUslAdd4;
    @FXML private TextField tfPrAdd4;
    @FXML private TextField tfIzmUslW4;
    @FXML private TextField tfIzmPrW4;

    @FXML private TextField tfResAdd1;
    @FXML private TextField tfTarAdd1;
    @FXML private TextField tfNrAdd1;
    @FXML private TextField tfResSnabAdd1;

    @FXML private TextField tfResIzm1;
    @FXML private TextField tfTarIzm1;
    @FXML private TextField tfNrIzm1;
    @FXML private TextField tfResSnabIzm1;

    @FXML private TextField tfResAdd2;
    @FXML private TextField tfTarAdd2;
    @FXML private TextField tfNrAdd2;
    @FXML private TextField tfResSnabAdd2;

    @FXML private TextField tfResIzm2;
    @FXML private TextField tfTarIzm2;
    @FXML private TextField tfNrIzm2;
    @FXML private TextField tfResSnabIzm2;

    @FXML private TextField tfResAdd3;
    @FXML private TextField tfTarAdd3;
    @FXML private TextField tfNrAdd3;
    @FXML private TextField tfResSnabAdd3;

    @FXML private TextField tfResIzm3;
    @FXML private TextField tfTarIzm3;
    @FXML private TextField tfNrIzm3;
    @FXML private TextField tfResSnabIzm3;

    @FXML private TextField tfResAdd4;
    @FXML private TextField tfTarAdd4;
    @FXML private TextField tfNrAdd4;
    @FXML private TextField tfResSnabAdd4;

    @FXML private TextField tfResIzm4;
    @FXML private TextField tfTarIzm4;
    @FXML private TextField tfNrIzm4;
    @FXML private TextField tfResSnabIzm4;

    @FXML private TextField tfNameSpZ;
    @FXML private TextField tfCtSpZ;
    @FXML private TextField tfOtchSpZ;
    @FXML private TextField tfStSpZ;
    @FXML private TextField tfFamSpZ;
    @FXML private TextField tfRaySpZ;
    @FXML private TextField tfOblSpZ;
    @FXML private TextField tfDRSpZ;
    @FXML private TextField tfNHSpZ;
    @FXML private TextField tfTelSpZ;
    @FXML private TextField tfNKSpZ;
    @FXML private TextField tfEMSpZ;
    @FXML private TextField tfNLCSpZ;
    @FXML private TextField tfPolSpZ;

    @FXML private ComboBox cmUsl;
    @FXML private ComboBox cmStatus;
    @FXML private Label lbError;
    @FXML private TextField tfFIO;
    @FXML private TextField tfNumHome;
    @FXML private TextField tfNumKv;
    @FXML private TextField tfNumTel;
    @FXML private TextField tfPrim;
    @FXML private DatePicker DtPick;


    @FXML private ComboBox cmUslIzm;
    @FXML private ComboBox cmStatusIzm;
    @FXML private Label lbErrorIzm;
    @FXML private TextField tfFIOIzm;
    @FXML private TextField tfNumHomeIzm;
    @FXML private TextField tfNumKvIzm;
    @FXML private TextField tfNumTelIzm;
    @FXML private TextField tfPrimIzm;
    @FXML private DatePicker DtPickIzm;

    public int codeProp;
    public int CodeNews;
    public int CodeUsl;
    public int CodeOtop;
    public int CodeHol;
    public int CodeElect;
    public int CodeGor;
    public int CodeSpZ;
    public int CodeSpisZ;

    private DBtable selectedTable1 = new DBtable();
    private DBtableOtop selectedTable2 = new DBtableOtop();
    private DBtableUsl selectedTable3 = new DBtableUsl();
    private DBtableHol selectedTable4 = new DBtableHol();
    private DBtableEl selectedTable5 = new DBtableEl();
    private DBtableGor selectedTable6 = new DBtableGor();
    private DBtableSpZ selectedTable7 = new DBtableSpZ();
    private DBtableSpisZ selectedTable8 = new DBtableSpisZ();

    private final ObservableList<DBtable> tableNews = FXCollections.observableArrayList();
    private final ObservableList<DBtableOtop> tableOt = FXCollections.observableArrayList();
    private final ObservableList<DBtableHol> tableH = FXCollections.observableArrayList();
    private final ObservableList<DBtableEl> tableEl = FXCollections.observableArrayList();
    private final ObservableList<DBtableGor> tableG = FXCollections.observableArrayList();
    private final ObservableList<DBtableUsl> tableU = FXCollections.observableArrayList();
    private final ObservableList<DBtableSpZ> tableSZ = FXCollections.observableArrayList();
    private final ObservableList<DBtableSpisZ> tableSpsZ = FXCollections.observableArrayList();
    private final ObservableList<String> UslData = FXCollections.observableArrayList();
    private final ObservableList<String> UslDataIzm = FXCollections.observableArrayList();

    private final String[] listStatus = {"Выполнено", "В процессе выполнения", "Принято"};
    private String selectcmStatus = "Статус";
    private String selectcmUsl = "";

    @FXML void initialize() throws SQLException {

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

        IDSpZ.setCellValueFactory(new PropertyValueFactory<>("IDSpZ"));
        ClAdrEmSpZ.setCellValueFactory(new PropertyValueFactory<>("ClAdrEmSpZ"));
        ClNameSpZ.setCellValueFactory(new PropertyValueFactory<>("ClNameSpZ"));
        ClPatrSpZ.setCellValueFactory(new PropertyValueFactory<>("ClPatrSpZ"));
        ClFamSpZ.setCellValueFactory(new PropertyValueFactory<>("ClFamSpZ"));
        ClPSpZ.setCellValueFactory(new PropertyValueFactory<>("ClPSpZ"));
        ClDatSpZ.setCellValueFactory(new PropertyValueFactory<>("ClDatSpZ"));
        ClTelSpZ.setCellValueFactory(new PropertyValueFactory<>("ClTelSpZ"));
        ClCitySpZ.setCellValueFactory(new PropertyValueFactory<>("ClCitySpZ"));
        ClStSpZ.setCellValueFactory(new PropertyValueFactory<>("ClStSpZ"));
        ClOblSpZ.setCellValueFactory(new PropertyValueFactory<>("ClOblSpZ"));
        ClRegSpZ.setCellValueFactory(new PropertyValueFactory<>("ClRegSpZ"));
        ClNumHSpZ.setCellValueFactory(new PropertyValueFactory<>("ClNumHSpZ"));
        ClNumKvSpZ.setCellValueFactory(new PropertyValueFactory<>("ClNumKvSpZ"));
        ClNumLCSpZ.setCellValueFactory(new PropertyValueFactory<>("ClNumLCSpZ"));

        fillComboBoxUsl();
        fillComboBoxUslIzm();

        IDSpisZ.setCellValueFactory(new PropertyValueFactory<>("IDSpisZ"));
        ClFIOSpisZ.setCellValueFactory(new PropertyValueFactory<>("ClFIOSpisZ"));
        ClNumHomeSpisZ.setCellValueFactory(new PropertyValueFactory<>("ClNumHomeSpisZ"));
        ClNumKvSpisZ.setCellValueFactory(new PropertyValueFactory<>("ClNumKvSpisZ"));
        ClNumTelSpisZ.setCellValueFactory(new PropertyValueFactory<>("ClNumTelSpisZ"));
        ClVidUslSpisZ.setCellValueFactory(new PropertyValueFactory<>("ClVidUslSpisZ"));
        ClPrimSpisZ.setCellValueFactory(new PropertyValueFactory<>("ClPrimSpisZ"));
        ClDatZSpisZ.setCellValueFactory(new PropertyValueFactory<>("ClDatZSpisZ"));
        ClStatusSpisZ.setCellValueFactory(new PropertyValueFactory<>("ClStatusSpisZ"));

        tableN.setRowFactory(tv -> {
            TableRow<DBtable> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                selectedTable1 = tableN.getSelectionModel().getSelectedItem();
                showOpis(selectedTable1.getIDCode());
                codeProp = selectedTable1.getIDCode();
                if (event.getClickCount() == 2) ;
                PNewsN.setVisible(true);
            });
            return row;
        });
    }

    public void btnCloseSpZ(javafx.scene.input.MouseEvent mouseEvent) {
        PSpZ1.setVisible(false);
    }

    public void btnCloseNews(javafx.scene.input.MouseEvent mouseEvent) {
        PNewsN.setVisible(false);
    }

    public void BtnClNews(javafx.scene.input.MouseEvent mouseEvent) {
        PNews.setVisible(false);
    }

    public void BtnClTar (javafx.scene.input.MouseEvent mouseEvent) {
        PTar.setVisible(false);
    }

    public void btnClDopUsl(javafx.scene.input.MouseEvent mouseEvent) {
        PDopUsl.setVisible(false);
    }

    public void ClickP1(javafx.scene.input.MouseEvent mouseEvent) {
        PTar.setVisible(true);
    }

    public void ClickP4(MouseEvent mouseEvent) {
        PNews.setVisible(true);
    }

    public void ClickP5(MouseEvent mouseEvent) {
        PDopUsl.setVisible(true);
        PAddUsl.setVisible(true);
        PDellUsl.setVisible(true);
        PIzmUsl.setVisible(true);
        PAddUslS.setVisible(false);
        PDellUslS.setVisible(false);
        PIzmUslS.setVisible(false);
        PAddUslP.setVisible(false);
        PDellUslP.setVisible(false);
        PIzmUslP.setVisible(false);
        PAddUslK.setVisible(false);
        PDellUslK.setVisible(false);
        PIzmUslK.setVisible(false);
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
            System.out.println("Ошибка с таблицей");
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
            System.out.println("Ошибка с таблицей");
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
            System.out.println("Ошибка с таблицей");
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
            System.out.println("Ошибка с таблицей");
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
            System.out.println("Ошибка с таблицей");
        }
    }

    private void tablerefreshUsl() {
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

    private void tablerefreshUsl2() {
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

    private void tablerefreshUsl3() {
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

    private void tablerefreshUsl4() {
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

    private void tablerefreshAuth() {
        tableSZ.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM authorization");
                while (resultSet.next()) {
                    tableSZ.add(new DBtableSpZ(
                            resultSet.getInt("id_user"),
                            resultSet.getString("АдресEMail"),
                            resultSet.getString("Имя"),
                            resultSet.getString("Отчество"),
                            resultSet.getString("Фамилия"),
                            resultSet.getString("Пол"),
                            resultSet.getString("ДатаРождения"),
                            resultSet.getString("Телефон"),
                            resultSet.getString("Город"),
                            resultSet.getString("Улица"),
                            resultSet.getString("ОбластьКрай"),
                            resultSet.getString("Район"),
                            resultSet.getString("НомерДома"),
                            resultSet.getString("НомерКвартиры"),
                            resultSet.getString("НомерЛицСчета")));
                }
            }
            if (!tableSZ.isEmpty()) {
                tableSpZ.setItems(tableSZ);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей списка жителей ЖК");
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
                imageScreen.setImage(new Image("C:\\Users\\Admin\\IdeaProjects\\JKHDiplom\\src\\main\\resources\\image\\" + resultSet.getString("Картинка") + ".jpg"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка с описанием");
        }
    }

    public void ClickUslP1(javafx.scene.input.MouseEvent mouseEvent) {
        PAddUsl.setVisible(true);
        PDellUsl.setVisible(true);
        PIzmUsl.setVisible(true);
        PAddUslS.setVisible(false);
        PDellUslS.setVisible(false);
        PIzmUslS.setVisible(false);
        PAddUslP.setVisible(false);
        PDellUslP.setVisible(false);
        PIzmUslP.setVisible(false);
        PAddUslK.setVisible(false);
        PDellUslK.setVisible(false);
        PIzmUslK.setVisible(false);
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

    public void ClickUslP2(javafx.scene.input.MouseEvent mouseEvent) {
        PAddUsl.setVisible(false);
        PDellUsl.setVisible(false);
        PIzmUsl.setVisible(false);
        PAddUslS.setVisible(true);
        PDellUslS.setVisible(true);
        PIzmUslS.setVisible(true);
        PAddUslP.setVisible(false);
        PDellUslP.setVisible(false);
        PIzmUslP.setVisible(false);
        PAddUslK.setVisible(false);
        PDellUslK.setVisible(false);
        PIzmUslK.setVisible(false);
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
        PAddUsl.setVisible(false);
        PDellUsl.setVisible(false);
        PIzmUsl.setVisible(false);
        PAddUslS.setVisible(false);
        PDellUslS.setVisible(false);
        PIzmUslS.setVisible(false);
        PAddUslP.setVisible(true);
        PDellUslP.setVisible(true);
        PIzmUslP.setVisible(true);
        PAddUslK.setVisible(false);
        PDellUslK.setVisible(false);
        PIzmUslK.setVisible(false);
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
        PAddUsl.setVisible(false);
        PDellUsl.setVisible(false);
        PIzmUsl.setVisible(false);
        PAddUslS.setVisible(false);
        PDellUslS.setVisible(false);
        PIzmUslS.setVisible(false);
        PAddUslP.setVisible(false);
        PDellUslP.setVisible(false);
        PIzmUslP.setVisible(false);
        PAddUslK.setVisible(true);
        PDellUslK.setVisible(true);
        PIzmUslK.setVisible(true);
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

    public void izmenTable(int Code) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM news WHERE id = " + Code);
            while (resultSet.next()) {
                tfNews.setText(resultSet.getString("Новость"));
                tfDate.setText(resultSet.getString("Дата"));
                tfOpis.setText(resultSet.getString("Описание"));
                tfPict.setText(resultSet.getString("Картинка"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void ClickIzm(MouseEvent mouseEvent) {
        IzmPane.setVisible(true);
        selectedTable1 = tableN.getSelectionModel().getSelectedItem();
        izmenTable(selectedTable1.getIDCode());
        CodeNews = selectedTable1.getIDCode();
    }

    public void ClickSohr(MouseEvent mouseEvent) {
        if (!(tfNews.getText().isEmpty() || tfDate.getText().isEmpty()
                || tfOpis.getText().isEmpty() || tfPict.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE news SET Новость = '" + tfNews.getText() + "', Дата = '" + tfDate.getText() + "', Описание = '" +
                                    tfOpis.getText() + "', Картинка = '" + tfPict.getText() + "' WHERE id = " + CodeNews);
                    statement.executeUpdate();
                    tablerefresh();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClickBackIzm(MouseEvent mouseEvent) {
        IzmPane.setVisible(false);
    }

    public static void deleteTable(int Code1) {
        String querry = "DELETE FROM news WHERE `id` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClickDell(MouseEvent mouseEvent) {
        selectedTable1 = tableN.getSelectionModel().getSelectedItem();
        deleteTable(selectedTable1.getIDCode());
        tableN.getItems().remove(selectedTable1);
    }

    public void ClickAdd(MouseEvent mouseEvent) {
        AddPane.setVisible(true);
    }

    public void ClickSohrAdd(MouseEvent mouseEvent) {
        if (!(tfNewsAd.getText().isEmpty() || tfDateAd.getText().isEmpty() || tfOpisAd.getText().isEmpty() || tfPictAd.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into news(Новость, Дата, Описание, Картинка) VALUES(?,?,?,?)");
                    statement.setString(1, tfNewsAd.getText());
                    statement.setString(2, tfDateAd.getText());
                    statement.setString(3, tfOpisAd.getText());
                    statement.setString(4, tfPictAd.getText());
                    statement.executeUpdate();
                }

            } catch (Exception e) {
                System.out.println("Ошибка с заполнением");
            }
        } else wtextadd.setText("Данные в полях некорректны");
    }

    public void ClickBackAdd(MouseEvent mouseEvent) {
        AddPane.setVisible(false);
    }


    /*ОКНО ДОБАВЛЕНИЯ УСЛУГ*/
    public void ClAddUsl(MouseEvent mouseEvent) {
        PAddUslW.setVisible(true);
        PAddUslWind.setVisible(true);
        PBackUslWind.setVisible(true);
        tfUslAdd.setVisible(true);
        tfPrAdd.setVisible(true);
        PAddUslWind2.setVisible(false);
        PBackUslWind2.setVisible(false);
        tfUslAdd2.setVisible(false);
        tfPrAdd2.setVisible(false);
        PAddUslWind3.setVisible(false);
        PBackUslWind3.setVisible(false);
        tfUslAdd3.setVisible(false);
        tfPrAdd3.setVisible(false);
        PAddUslWind4.setVisible(false);
        PBackUslWind4.setVisible(false);
        tfUslAdd4.setVisible(false);
        tfPrAdd4.setVisible(false);
    }

    public void ClBackUslW(MouseEvent mouseEvent) {
        PAddUslW.setVisible(false);
    }

    //ДОБАВЛЕНИЕ УСЛУГ//
    public void ClAddUslW(MouseEvent mouseEvent) {
        PAddUslW.setVisible(false);
        if (!(tfUslAdd.getText().isEmpty() || tfPrAdd.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into uslugi (Услуга, Цена) VALUES(?,?)");
                    statement.setString(1, tfUslAdd.getText());
                    statement.setString(2, tfPrAdd.getText());
                    statement.executeUpdate();
                    tablerefreshUsl();
                }

            } catch (Exception e) {
                System.out.println("Ошибка с заполнением");
            }
        } else wtextadd.setText("Данные в полях некорректны");
    }
    //ДОБАВЛЕНИЕ УСЛУГ//

    //ИЗМЕНЕНИЕ УСЛУГ//
    public void izmenTableUsl(int Code) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM uslugi WHERE id = " + Code);
            while (resultSet.next()) {
                tfIzmUslW.setText(resultSet.getString("Услуга"));
                tfIzmPrW.setText(resultSet.getString("Цена"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void ClIzmUsl(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(true);
        PIzmUslWind.setVisible(true);
        PBackIzmUslWind.setVisible(true);
        tfIzmUslW.setVisible(true);
        tfIzmPrW.setVisible(true);
        PIzmUslWind2.setVisible(false);
        PBackIzmUslWind2.setVisible(false);
        tfIzmUslW2.setVisible(false);
        tfIzmPrW2.setVisible(false);
        PIzmUslWind3.setVisible(false);
        PBackIzmUslWind3.setVisible(false);
        tfIzmUslW3.setVisible(false);
        tfIzmPrW3.setVisible(false);
        PIzmUslWind4.setVisible(false);
        PBackIzmUslWind4.setVisible(false);
        tfIzmUslW4.setVisible(false);
        tfIzmPrW4.setVisible(false);

        selectedTable3 = tableUsl.getSelectionModel().getSelectedItem();
        izmenTableUsl(selectedTable3.getIDUs());
        CodeUsl = selectedTable3.getIDUs();
    }

    public void ClSohrIzmW(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(false);
        if (!(tfIzmUslW.getText().isEmpty() || tfIzmPrW.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE uslugi SET Услуга = '" + tfIzmUslW.getText() + "', Цена = '" + tfIzmPrW.getText() + "' WHERE id = " + CodeUsl);
                    statement.executeUpdate();
                    tablerefreshUsl();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClBackIzmW(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(false);
    }
    //ИЗМЕНЕНИЕ УСЛУГ//

    //УДАЛЕНИЕ УСЛУГ//
    public static void deleteTableUsl(int Code1) {
        String querry = "DELETE FROM uslugi WHERE `id` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClDellUsl(MouseEvent mouseEvent) {
        selectedTable3 = tableUsl.getSelectionModel().getSelectedItem();
        deleteTableUsl(selectedTable3.getIDUs());
        tableUsl.getItems().remove(selectedTable3);
    }
    //УДАЛЕНИЕ УСЛУГ//


    /*ДОБАВЛЕНИЕ УСЛУГ2*/
    public void ClAddUsl2(MouseEvent mouseEvent) {
        PAddUslW.setVisible(true);
        PAddUslWind.setVisible(false);
        PBackUslWind.setVisible(false);
        tfUslAdd.setVisible(false);
        tfPrAdd.setVisible(false);
        PAddUslWind2.setVisible(true);
        PBackUslWind2.setVisible(true);
        tfUslAdd2.setVisible(true);
        tfPrAdd2.setVisible(true);
        PAddUslWind3.setVisible(false);
        PBackUslWind3.setVisible(false);
        tfUslAdd3.setVisible(false);
        tfPrAdd3.setVisible(false);
        PAddUslWind4.setVisible(false);
        PBackUslWind4.setVisible(false);
        tfUslAdd4.setVisible(false);
        tfPrAdd4.setVisible(false);
    }

    public void ClBackUslW2(MouseEvent mouseEvent) {
        PAddUslW.setVisible(false);
    }

    public void ClAddUslW2(MouseEvent mouseEvent) {
        PAddUslW.setVisible(false);
        if (!(tfUslAdd2.getText().isEmpty() || tfPrAdd2.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into uslugisant (Услуга, Цена) VALUES(?,?)");
                    statement.setString(1, tfUslAdd2.getText());
                    statement.setString(2, tfPrAdd2.getText());
                    statement.executeUpdate();
                    tablerefreshUsl2();
                }

            } catch (Exception e) {
                System.out.println("Ошибка с заполнением");
            }
        } else wtextadd.setText("Данные в полях некорректны");
    }
    //ДОБАВЛЕНИЕ УСЛУГ2//

    //ИЗМЕНЕНИЕ УСЛУГ2//
    public void izmenTableUsl2(int Code) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM uslugisant WHERE id = " + Code);
            while (resultSet.next()) {
                tfIzmUslW2.setText(resultSet.getString("Услуга"));
                tfIzmPrW2.setText(resultSet.getString("Цена"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void ClIzmUsl2(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(true);
        PIzmUslWind.setVisible(false);
        PBackIzmUslWind.setVisible(false);
        tfIzmUslW.setVisible(false);
        tfIzmPrW.setVisible(false);
        PIzmUslWind2.setVisible(true);
        PBackIzmUslWind2.setVisible(true);
        tfIzmUslW2.setVisible(true);
        tfIzmPrW2.setVisible(true);
        PIzmUslWind3.setVisible(false);
        PBackIzmUslWind3.setVisible(false);
        tfIzmUslW3.setVisible(false);
        tfIzmPrW3.setVisible(false);
        PIzmUslWind4.setVisible(false);
        PBackIzmUslWind4.setVisible(false);
        tfIzmUslW4.setVisible(false);
        tfIzmPrW4.setVisible(false);

        selectedTable3 = tableUsl.getSelectionModel().getSelectedItem();
        izmenTableUsl2(selectedTable3.getIDUs());
        CodeUsl = selectedTable3.getIDUs();
    }

    public void ClSohrIzmW2(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(false);
        if (!(tfIzmUslW2.getText().isEmpty() || tfIzmPrW2.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE uslugisant SET Услуга = '" + tfIzmUslW2.getText() + "', Цена = '" + tfIzmPrW2.getText() + "' WHERE id = " + CodeUsl);
                    statement.executeUpdate();
                    tablerefreshUsl2();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClBackIzmW2(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(false);
    }
    //ИЗМЕНЕНИЕ УСЛУГ2//

    //УДАЛЕНИЕ УСЛУГ2//
    public static void deleteTableUsl2(int Code1) {
        String querry = "DELETE FROM uslugisant WHERE `id` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClDellUsl2(MouseEvent mouseEvent) {
        selectedTable3 = tableUsl.getSelectionModel().getSelectedItem();
        deleteTableUsl2(selectedTable3.getIDUs());
        tableUsl.getItems().remove(selectedTable3);
    }
    //УДАЛЕНИЕ УСЛУГ2//

    //ДОБАВЛЕНИЕ УСЛУГ3//
    public void ClAddUsl3(MouseEvent mouseEvent) {
        PAddUslW.setVisible(true);
        PAddUslWind.setVisible(false);
        PBackUslWind.setVisible(false);
        tfUslAdd.setVisible(false);
        tfPrAdd.setVisible(false);
        PAddUslWind2.setVisible(false);
        PBackUslWind2.setVisible(false);
        tfUslAdd2.setVisible(false);
        tfPrAdd2.setVisible(false);
        PAddUslWind3.setVisible(true);
        PBackUslWind3.setVisible(true);
        tfUslAdd3.setVisible(true);
        tfPrAdd3.setVisible(true);
        PAddUslWind4.setVisible(false);
        PBackUslWind4.setVisible(false);
        tfUslAdd4.setVisible(false);
        tfPrAdd4.setVisible(false);
    }

    public void ClBackUslW3(MouseEvent mouseEvent) {
        PAddUslW.setVisible(false);
    }

    public void ClAddUslW3(MouseEvent mouseEvent) {
        PAddUslW.setVisible(false);
        if (!(tfUslAdd3.getText().isEmpty() || tfPrAdd3.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into uslugiplot (Услуга, Цена) VALUES(?,?)");
                    statement.setString(1, tfUslAdd3.getText());
                    statement.setString(2, tfPrAdd3.getText());
                    statement.executeUpdate();
                    tablerefreshUsl3();
                }

            } catch (Exception e) {
                System.out.println("Ошибка с заполнением");
            }
        } else wtextadd.setText("Данные в полях некорректны");
    }
    //ДОБАВЛЕНИЕ УСЛУГ3//

    //ИЗМЕНЕНИЕ УСЛУГ3//
    public void izmenTableUsl3(int Code) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM uslugiplot WHERE id = " + Code);
            while (resultSet.next()) {
                tfIzmUslW3.setText(resultSet.getString("Услуга"));
                tfIzmPrW3.setText(resultSet.getString("Цена"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void ClIzmUsl3(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(true);
        PIzmUslWind.setVisible(false);
        PBackIzmUslWind.setVisible(false);
        tfIzmUslW.setVisible(false);
        tfIzmPrW.setVisible(false);
        PIzmUslWind2.setVisible(false);
        PBackIzmUslWind2.setVisible(false);
        tfIzmUslW2.setVisible(false);
        tfIzmPrW2.setVisible(false);
        PIzmUslWind3.setVisible(true);
        PBackIzmUslWind3.setVisible(true);
        tfIzmUslW3.setVisible(true);
        tfIzmPrW3.setVisible(true);
        PIzmUslWind4.setVisible(false);
        PBackIzmUslWind4.setVisible(false);
        tfIzmUslW4.setVisible(false);
        tfIzmPrW4.setVisible(false);

        selectedTable3 = tableUsl.getSelectionModel().getSelectedItem();
        izmenTableUsl3(selectedTable3.getIDUs());
        CodeUsl = selectedTable3.getIDUs();
    }

    public void ClSohrIzmW3(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(false);
        if (!(tfIzmUslW3.getText().isEmpty() || tfIzmPrW3.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE uslugiplot SET Услуга = '" + tfIzmUslW3.getText() + "', Цена = '" + tfIzmPrW3.getText() + "' WHERE id = " + CodeUsl);
                    statement.executeUpdate();
                    tablerefreshUsl3();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClBackIzmW3(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(false);
    }
    //ИЗМЕНЕНИЕ УСЛУГ3//

    //УДАЛЕНИЕ УСЛУГ3//
    public static void deleteTableUsl3(int Code1) {
        String querry = "DELETE FROM uslugiplot WHERE `id` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClDellUsl3(MouseEvent mouseEvent) {
        selectedTable3 = tableUsl.getSelectionModel().getSelectedItem();
        deleteTableUsl3(selectedTable3.getIDUs());
        tableUsl.getItems().remove(selectedTable3);
    }
    //УДАЛЕНИЕ УСЛУГ3//

    //ДОБАВЛЕНИЕ УСЛУГ4//
    public void ClAddUsl4(MouseEvent mouseEvent) {
        PAddUslW.setVisible(true);
        PAddUslWind.setVisible(false);
        PBackUslWind.setVisible(false);
        tfUslAdd.setVisible(false);
        tfPrAdd.setVisible(false);
        PAddUslWind2.setVisible(false);
        PBackUslWind2.setVisible(false);
        tfUslAdd2.setVisible(false);
        tfPrAdd2.setVisible(false);
        PAddUslWind3.setVisible(false);
        PBackUslWind3.setVisible(false);
        tfUslAdd3.setVisible(false);
        tfPrAdd3.setVisible(false);
        PAddUslWind4.setVisible(true);
        PBackUslWind4.setVisible(true);
        tfUslAdd4.setVisible(true);
        tfPrAdd4.setVisible(true);
    }

    public void ClBackUslW4(MouseEvent mouseEvent) {
        PAddUslW.setVisible(false);
    }

    public void ClAddUslW4(MouseEvent mouseEvent) {
        PAddUslW.setVisible(false);
        if (!(tfUslAdd4.getText().isEmpty() || tfPrAdd4.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into uslugiklint (Услуга, Цена) VALUES(?,?)");
                    statement.setString(1, tfUslAdd4.getText());
                    statement.setString(2, tfPrAdd4.getText());
                    statement.executeUpdate();
                    tablerefreshUsl4();
                }

            } catch (Exception e) {
                System.out.println("Ошибка с заполнением");
            }
        } else wtextadd.setText("Данные в полях некорректны");
    }
    //ДОБАВЛЕНИЕ УСЛУГ4//

    //ИЗМЕНЕНИЕ УСЛУГ4//
    public void izmenTableUsl4(int Code) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM uslugiklint WHERE id = " + Code);
            while (resultSet.next()) {
                tfIzmUslW4.setText(resultSet.getString("Услуга"));
                tfIzmPrW4.setText(resultSet.getString("Цена"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void ClIzmUsl4(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(true);
        PIzmUslWind.setVisible(false);
        PBackIzmUslWind.setVisible(false);
        tfIzmUslW.setVisible(false);
        tfIzmPrW.setVisible(false);
        PIzmUslWind2.setVisible(false);
        PBackIzmUslWind2.setVisible(false);
        tfIzmUslW2.setVisible(false);
        tfIzmPrW2.setVisible(false);
        PIzmUslWind3.setVisible(false);
        PBackIzmUslWind3.setVisible(false);
        tfIzmUslW3.setVisible(false);
        tfIzmPrW3.setVisible(false);
        PIzmUslWind4.setVisible(true);
        PBackIzmUslWind4.setVisible(true);
        tfIzmUslW4.setVisible(true);
        tfIzmPrW4.setVisible(true);

        selectedTable3 = tableUsl.getSelectionModel().getSelectedItem();
        izmenTableUsl4(selectedTable3.getIDUs());
        CodeUsl = selectedTable3.getIDUs();
    }

    public void ClSohrIzmW4(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(false);
        if (!(tfIzmUslW4.getText().isEmpty() || tfIzmPrW4.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE uslugiklint SET Услуга = '" + tfIzmUslW4.getText() + "', Цена = '" + tfIzmPrW4.getText() + "' WHERE id = " + CodeUsl);
                    statement.executeUpdate();
                    tablerefreshUsl4();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClBackIzmW4(MouseEvent mouseEvent) {
        PIzmUslW.setVisible(false);
    }
    //ИЗМЕНЕНИЕ УСЛУГ4//

    //УДАЛЕНИЕ УСЛУГ4//
    public static void deleteTableUsl4(int Code1) {
        String querry = "DELETE FROM uslugiklint WHERE `id` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClDellUsl4(MouseEvent mouseEvent) {
        selectedTable3 = tableUsl.getSelectionModel().getSelectedItem();
        deleteTableUsl4(selectedTable3.getIDUs());
        tableUsl.getItems().remove(selectedTable3);
    }
    //УДАЛЕНИЕ УСЛУГ4//

    //ДОБАВЛЕНИЕ ТАРИФА 1//
    public void ClAddTar1(MouseEvent mouseEvent) {
        PAddTarW1.setVisible(true);
    }

    public void ClBackTarW1(MouseEvent mouseEvent) {
        PAddTarW1.setVisible(false);
    }

    public void ClAddTarW1(MouseEvent mouseEvent) {
        PAddTarW1.setVisible(false);
        if (!(tfResAdd1.getText().isEmpty() || tfTarAdd1.getText().isEmpty() || tfNrAdd1.getText().isEmpty() || tfResSnabAdd1.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into otoplenie (Ресурс, Тариф, Нормативно_правового_акта, Ресурсоснабжающее_предприятие) VALUES(?,?,?,?)");
                    statement.setString(1, tfResAdd1.getText());
                    statement.setString(2, tfTarAdd1.getText());
                    statement.setString(3, tfNrAdd1.getText());
                    statement.setString(4, tfResSnabAdd1.getText());
                    statement.executeUpdate();
                    tablerefreshOtop();
                }

            } catch (Exception e) {
                System.out.println("Ошибка с заполнением");
            }
        } else wtextAddUsl.setText("Данные в полях некорректны");
    }
    //ДОБАВЛЕНИЕ ТАРИФА 1//

    //ИЗМЕНЕНИЕ ТАРИФА 1//
    public void izmenTableTar1(int Code) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM otoplenie WHERE id = " + Code);
            while (resultSet.next()) {
                tfResIzm1.setText(resultSet.getString("Ресурс"));
                tfTarIzm1.setText(resultSet.getString("Тариф"));
                tfNrIzm1.setText(resultSet.getString("Нормативно_правового_акта"));
                tfResSnabIzm1.setText(resultSet.getString("Ресурсоснабжающее_предприятие"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void ClIzmTar1(MouseEvent mouseEvent) {
        PIzmTarW1.setVisible(true);
        selectedTable2 = tableOtop.getSelectionModel().getSelectedItem();
        izmenTableTar1(selectedTable2.getOtopID());
        CodeOtop = selectedTable2.getOtopID();
    }

    public void ClSohrIzmTarW1(MouseEvent mouseEvent) {
        PIzmTarW1.setVisible(false);
        if (!(tfResIzm1.getText().isEmpty() || tfTarIzm1.getText().isEmpty() || tfNrIzm1.getText().isEmpty() || tfResSnabIzm1.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE otoplenie SET Ресурс = '" + tfResIzm1.getText() + "', Тариф = '" + tfTarIzm1.getText() +
                                    "', Нормативно_правового_акта = '" + tfNrIzm1.getText() + "', Ресурсоснабжающее_предприятие = '" + tfResSnabIzm1.getText() + "' WHERE id = " + CodeOtop);
                    statement.executeUpdate();
                    tablerefreshOtop();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClBackIzmTarW1(MouseEvent mouseEvent) {
        PIzmTarW1.setVisible(false);
    }

    //ИЗМЕНЕНИЕ ТАРИФА 1//

    //УДАЛЕНИЕ ТАРИФА 1//
    public static void deleteTableTar1(int Code1) {
        String querry = "DELETE FROM otoplenie WHERE `id` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClDellTar1(MouseEvent mouseEvent) {
        selectedTable2 = tableOtop.getSelectionModel().getSelectedItem();
        deleteTableTar1(selectedTable2.getOtopID());
        tableOtop.getItems().remove(selectedTable2);
    }
    //УДАЛЕНИЕ ТАРИФА 1//

    //ДОБАВЛЕНИЕ ТАРИФА 2//
    public void ClAddTar2(MouseEvent mouseEvent) {
        PAddTarW2.setVisible(true);
    }

    public void ClBackTarW2(MouseEvent mouseEvent) {
        PAddTarW2.setVisible(false);
    }

    public void ClAddTarW2(MouseEvent mouseEvent) {
        PAddTarW2.setVisible(false);
        if (!(tfResAdd2.getText().isEmpty() || tfTarAdd2.getText().isEmpty() || tfNrAdd2.getText().isEmpty() || tfResSnabAdd2.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into holvodsnab (Ресурс, Тариф, Нормативно_правового_акта, Ресурсоснабжающее_предприятие) VALUES(?,?,?,?)");
                    statement.setString(1, tfResAdd2.getText());
                    statement.setString(2, tfTarAdd2.getText());
                    statement.setString(3, tfNrAdd2.getText());
                    statement.setString(4, tfResSnabAdd2.getText());
                    statement.executeUpdate();
                    tablerefreshHol();
                }

            } catch (Exception e) {
                System.out.println("Ошибка с заполнением");
            }
        } else wtextAddUsl.setText("Данные в полях некорректны");
    }
    //ДОБАВЛЕНИЕ ТАРИФА 2//

    //ИЗМЕНЕНИЕ ТАРИФА 2//
    public void izmenTableTar2(int Code) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM holvodsnab WHERE id = " + Code);
            while (resultSet.next()) {
                tfResIzm2.setText(resultSet.getString("Ресурс"));
                tfTarIzm2.setText(resultSet.getString("Тариф"));
                tfNrIzm2.setText(resultSet.getString("Нормативно_правового_акта"));
                tfResSnabIzm2.setText(resultSet.getString("Ресурсоснабжающее_предприятие"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void ClIzmTar2(MouseEvent mouseEvent) {
        PIzmTarW2.setVisible(true);
        selectedTable4 = tableHol.getSelectionModel().getSelectedItem();
        izmenTableTar2(selectedTable4.getHolID());
        CodeHol = selectedTable4.getHolID();
    }

    public void ClSohrIzmTarW2(MouseEvent mouseEvent) {
        PIzmTarW2.setVisible(false);
        if (!(tfResIzm2.getText().isEmpty() || tfTarIzm2.getText().isEmpty() || tfNrIzm2.getText().isEmpty() || tfResSnabIzm2.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE holvodsnab SET Ресурс = '" + tfResIzm2.getText() + "', Тариф = '" + tfTarIzm2.getText() +
                                    "', Нормативно_правового_акта = '" + tfNrIzm2.getText() + "', Ресурсоснабжающее_предприятие = '" + tfResSnabIzm2.getText() + "' WHERE id = " + CodeHol);
                    statement.executeUpdate();
                    tablerefreshHol();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClBackIzmTarW2(MouseEvent mouseEvent) {
        PIzmTarW2.setVisible(false);
    }
    //ИЗМЕНЕНИЕ ТАРИФА 2//

    //УДАЛЕНИЕ ТАРИФА 2//
    public static void deleteTableTar2(int Code1) {
        String querry = "DELETE FROM holvodsnab WHERE `id` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClDellTar2(MouseEvent mouseEvent) {
        selectedTable4 = tableHol.getSelectionModel().getSelectedItem();
        deleteTableTar2(selectedTable4.getHolID());
        tableHol.getItems().remove(selectedTable4);
    }
    //УДАЛЕНИЕ ТАРИФА 2//

    //ДОБАВЛЕНИЕ ТАРИФА 3//
    public void ClAddTar3(MouseEvent mouseEvent) {
        PAddTarW3.setVisible(true);
    }

    public void ClBackTarW3(MouseEvent mouseEvent) {
        PAddTarW3.setVisible(false);
    }

    public void ClAddTarW3(MouseEvent mouseEvent) {
        PAddTarW3.setVisible(false);
        if (!(tfResAdd3.getText().isEmpty() || tfTarAdd3.getText().isEmpty() || tfNrAdd3.getText().isEmpty() || tfResSnabAdd3.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into electrosnab (Ресурс, Тариф, Нормативно_правового_акта, Ресурсоснабжающее_предприятие) VALUES(?,?,?,?)");
                    statement.setString(1, tfResAdd3.getText());
                    statement.setString(2, tfTarAdd3.getText());
                    statement.setString(3, tfNrAdd3.getText());
                    statement.setString(4, tfResSnabAdd3.getText());
                    statement.executeUpdate();
                    tablerefreshEl();
                }

            } catch (Exception e) {
                System.out.println("Ошибка с заполнением");
            }
        } else wtextAddUsl.setText("Данные в полях некорректны");
    }
    //ДОБАВЛЕНИЕ ТАРИФА 3//

    //ИЗМЕНЕНИЕ ТАРИФА 3//
    public void izmenTableTar3(int Code) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM electrosnab WHERE id = " + Code);
            while (resultSet.next()) {
                tfResIzm3.setText(resultSet.getString("Ресурс"));
                tfTarIzm3.setText(resultSet.getString("Тариф"));
                tfNrIzm3.setText(resultSet.getString("Нормативно_правового_акта"));
                tfResSnabIzm3.setText(resultSet.getString("Ресурсоснабжающее_предприятие"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void ClIzmTar3(MouseEvent mouseEvent) {
        PIzmTarW3.setVisible(true);
        selectedTable5 = tableElectr.getSelectionModel().getSelectedItem();
        izmenTableTar3(selectedTable5.getElectID());
        CodeElect = selectedTable5.getElectID();
    }

    public void ClSohrIzmTarW3(MouseEvent mouseEvent) {
        PIzmTarW3.setVisible(false);
        if (!(tfResIzm3.getText().isEmpty() || tfTarIzm3.getText().isEmpty() || tfNrIzm3.getText().isEmpty() || tfResSnabIzm3.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE electrosnab SET Ресурс = '" + tfResIzm3.getText() + "', Тариф = '" + tfTarIzm3.getText() +
                                    "', Нормативно_правового_акта = '" + tfNrIzm3.getText() + "', Ресурсоснабжающее_предприятие = '" + tfResSnabIzm3.getText() + "' WHERE id = " + CodeElect);
                    statement.executeUpdate();
                    tablerefreshEl();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClBackIzmTarW3(MouseEvent mouseEvent) {
        PIzmTarW3.setVisible(false);
    }
    //ИЗМЕНЕНИЕ ТАРИФА 3//

    //УДАЛЕНИЕ ТАРИФА 3//
    public static void deleteTableTar3(int Code1) {
        String querry = "DELETE FROM electrosnab WHERE `id` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClDellTar3(MouseEvent mouseEvent) {
        selectedTable5 = tableElectr.getSelectionModel().getSelectedItem();
        deleteTableTar3(selectedTable5.getElectID());
        tableElectr.getItems().remove(selectedTable5);
    }
    //УДАЛЕНИЕ ТАРИФА 3//

    //ДОБАВЛЕНИЕ ТАРИФА 4//
    public void ClAddTar4(MouseEvent mouseEvent) {
        PAddTarW4.setVisible(true);
    }

    public void ClBackTarW4(MouseEvent mouseEvent) {
        PAddTarW4.setVisible(false);
    }

    public void ClAddTarW4(MouseEvent mouseEvent) {
        PAddTarW4.setVisible(false);
        if (!(tfResAdd4.getText().isEmpty() || tfTarAdd4.getText().isEmpty() || tfNrAdd4.getText().isEmpty() || tfResSnabAdd4.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("INSERT into gorvodsnab (Ресурс, Тариф, Нормативно_правового_акта, Ресурсоснабжающее_предприятие) VALUES(?,?,?,?)");
                    statement.setString(1, tfResAdd4.getText());
                    statement.setString(2, tfTarAdd4.getText());
                    statement.setString(3, tfNrAdd4.getText());
                    statement.setString(4, tfResSnabAdd4.getText());
                    statement.executeUpdate();
                    tablerefreshG();
                }

            } catch (Exception e) {
                System.out.println("Ошибка с заполнением");
            }
        } else wtextAddUsl.setText("Данные в полях некорректны");
    }
    //ДОБАВЛЕНИЕ ТАРИФА 4//

    //ИЗМЕНЕНИЕ ТАРИФА 4//
    public void izmenTableTar4(int Code) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM gorvodsnab WHERE id = " + Code);
            while (resultSet.next()) {
                tfResIzm4.setText(resultSet.getString("Ресурс"));
                tfTarIzm4.setText(resultSet.getString("Тариф"));
                tfNrIzm4.setText(resultSet.getString("Нормативно_правового_акта"));
                tfResSnabIzm4.setText(resultSet.getString("Ресурсоснабжающее_предприятие"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void ClIzmTar4(MouseEvent mouseEvent) {
        PIzmTarW4.setVisible(true);
        selectedTable6 = tableGor.getSelectionModel().getSelectedItem();
        izmenTableTar4(selectedTable6.getGorID());
        CodeGor = selectedTable6.getGorID();
    }

    public void ClSohrIzmTarW4(MouseEvent mouseEvent) {
        PIzmTarW4.setVisible(false);
        if (!(tfResIzm4.getText().isEmpty() || tfTarIzm4.getText().isEmpty() || tfNrIzm4.getText().isEmpty() || tfResSnabIzm4.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE gorvodsnab SET Ресурс = '" + tfResIzm4.getText() + "', Тариф = '" + tfTarIzm4.getText() +
                                    "', Нормативно_правового_акта = '" + tfNrIzm4.getText() + "', Ресурсоснабжающее_предприятие = '" + tfResSnabIzm4.getText() + "' WHERE id = " + CodeGor);
                    statement.executeUpdate();
                    tablerefreshG();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClBackIzmTarW4(MouseEvent mouseEvent) {
        PIzmTarW4.setVisible(false);
    }
    //ИЗМЕНЕНИЕ ТАРИФА 4//

    //УДАЛЕНИЕ ТАРИФА 4//
    public static void deleteTableTar4(int Code1) {
        String querry = "DELETE FROM gorvodsnab WHERE `id` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClDellTar4(MouseEvent mouseEvent) {
        selectedTable6 = tableGor.getSelectionModel().getSelectedItem();
        deleteTableTar4(selectedTable6.getGorID());
        tableGor.getItems().remove(selectedTable6);
    }
    //УДАЛЕНИЕ ТАРИФА 4//


    //ОКНО СПИСОК ЖИЛЬЦОВ//
    public void ClickSpP(javafx.scene.input.MouseEvent mouseEvent) {
        PSpZ1.setVisible(true);
        tableSZ.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM authorization");
                while (resultSet.next()) {
                    tableSZ.add(new DBtableSpZ(
                            resultSet.getInt("id_user"),
                            resultSet.getString("АдресEMail"),
                            resultSet.getString("Имя"),
                            resultSet.getString("Отчество"),
                            resultSet.getString("Фамилия"),
                            resultSet.getString("Пол"),
                            resultSet.getString("ДатаРождения"),
                            resultSet.getString("Телефон"),
                            resultSet.getString("Город"),
                            resultSet.getString("Улица"),
                            resultSet.getString("ОбластьКрай"),
                            resultSet.getString("Район"),
                            resultSet.getString("НомерДома"),
                            resultSet.getString("НомерКвартиры"),
                            resultSet.getString("НомерЛицСчета")));
                }
            }
            if (!tableSZ.isEmpty()) {
                tableSpZ.setItems(tableSZ);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей");
        }
    }

    //ИЗМЕНЕНИЕ//
    public void izmenTableSpZ(int Code) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM authorization WHERE id_user = " + Code);
            while (resultSet.next()) {
                tfNameSpZ.setText(resultSet.getString("Имя"));
                tfCtSpZ.setText(resultSet.getString("Город"));
                tfOtchSpZ.setText(resultSet.getString("Отчество"));
                tfStSpZ.setText(resultSet.getString("Улица"));
                tfFamSpZ.setText(resultSet.getString("Фамилия"));
                tfRaySpZ.setText(resultSet.getString("Район"));
                tfOblSpZ.setText(resultSet.getString("ОбластьКрай"));
                tfDRSpZ.setText(resultSet.getString("ДатаРождения"));
                tfNHSpZ.setText(resultSet.getString("НомерДома"));
                tfTelSpZ.setText(resultSet.getString("Телефон"));
                tfNKSpZ.setText(resultSet.getString("НомерКвартиры"));
                tfEMSpZ.setText(resultSet.getString("АдресEMail"));
                tfNLCSpZ.setText(resultSet.getString("НомерЛицСчета"));
                tfPolSpZ.setText(resultSet.getString("Пол"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void ClIzmSpZ(MouseEvent mouseEvent) {
        PIzmSpZW.setVisible(true);
        selectedTable7 = tableSpZ.getSelectionModel().getSelectedItem();
        izmenTableSpZ(selectedTable7.getIDSpZ());
        CodeSpZ = selectedTable7.getIDSpZ();
    }

    public void ClSohrIzmSpZ(MouseEvent mouseEvent) {
        PIzmSpZW.setVisible(false);
        if (!(tfNameSpZ.getText().isEmpty() || tfCtSpZ.getText().isEmpty() || tfOtchSpZ.getText().isEmpty() || tfStSpZ.getText().isEmpty() || tfFamSpZ.getText().isEmpty()
                || tfRaySpZ.getText().isEmpty() || tfOblSpZ.getText().isEmpty() || tfDRSpZ.getText().isEmpty() || tfNHSpZ.getText().isEmpty() || tfTelSpZ.getText().isEmpty()
                || tfNKSpZ.getText().isEmpty() || tfEMSpZ.getText().isEmpty() || tfNLCSpZ.getText().isEmpty() || tfPolSpZ.getText().isEmpty())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE authorization SET Имя = '" + tfNameSpZ.getText() + "', Город = '" + tfCtSpZ.getText() +
                                    "', Отчество = '" + tfOtchSpZ.getText() + "', Улица = '" + tfStSpZ.getText() +
                                    "', Фамилия = '" + tfFamSpZ.getText() + "', Район = '" + tfRaySpZ.getText() +
                                    "', ОбластьКрай = '" + tfOblSpZ.getText() + "', ДатаРождения = '" + tfDRSpZ.getText() +
                                    "', НомерДома = '" + tfNHSpZ.getText() + "', Телефон = '" + tfTelSpZ.getText() +
                                    "', НомерКвартиры = '" + tfNKSpZ.getText() + "', АдресEMail = '" + tfEMSpZ.getText() +
                                    "', НомерЛицСчета = '" + tfNLCSpZ.getText() + "', Пол = '" + tfPolSpZ.getText() + "' WHERE id_user = " + CodeSpZ);
                    statement.executeUpdate();
                    tablerefreshAuth();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClBackIzmSpZ(MouseEvent mouseEvent) {
        PIzmSpZW.setVisible(false);
    }
    //ИЗМЕНЕНИЕ//

    //УДАЛЕНИЕ//
    public static void deleteTableSpZ(int Code1) {
        String querry = "DELETE FROM authorization WHERE `id_user` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClDellSpZ(MouseEvent mouseEvent) {
        selectedTable7 = tableSpZ.getSelectionModel().getSelectedItem();
        deleteTableSpZ(selectedTable7.getIDSpZ());
        tableSpZ.getItems().remove(selectedTable7);
    }
    //УДАЛЕНИЕ//

    //ОКНО СПИСОК ЖИЛЬЦОВ//

    public void ClExGM (javafx.scene.input.MouseEvent mouseEvent) {
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
        PGlav.getScene().getWindow().hide();
    }
    //СПИСОК ЗАЯВОК//
    public void ClickSpZ(javafx.scene.input.MouseEvent mouseEvent) {
        PSpisokZ.setVisible(true);
        tableSpsZ.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM zayavkijil");
                while (resultSet.next()) {
                    tableSpsZ.add(new DBtableSpisZ(
                            resultSet.getInt("id"),
                            resultSet.getString("ФИО"),
                            resultSet.getString("НомерДома"),
                            resultSet.getString("НомерКвартиры"),
                            resultSet.getString("Телефон"),
                            resultSet.getString("ВидУслуги"),
                            resultSet.getString("Примечание"),
                            resultSet.getString("ДатаЗаявки"),
                            resultSet.getString("Статус")));
                }
            }
            if (!tableSpsZ.isEmpty()) {
                tableSpisZ.setItems(tableSpsZ);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей");
        }
    }

    public void ClAddSpisZ(javafx.scene.input.MouseEvent mouseEvent) {PAddSpisZ.setVisible(true);
        cmStatus.getItems().addAll(listStatus);
        cmStatus.setValue("Статус");
        cmStatus.setOnAction(this::getcmStatus);}

    public void ClBackSpisZ(javafx.scene.input.MouseEvent mouseEvent) {PAddSpisZ.setVisible(false);}

    public void ClSohrAddSpisZ(javafx.scene.input.MouseEvent mouseEvent) {
        PAddSpisZ.setVisible(false);
    if (!(tfFIO.getText().isEmpty() || tfNumHome.getText().isEmpty()
                || tfNumKv.getText().isEmpty() || tfNumTel.getText().isEmpty() || tfPrim.getText().isEmpty())) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")){
                PreparedStatement statement = conn.prepareStatement
                        ("INSERT into zayavkijil(ФИО, НомерДома, НомерКвартиры, Телефон, ВидУслуги, Примечание, ДатаЗаявки, Статус) VALUES(?,?,?,?,?,?,?,?)");
                statement.setString(1, tfFIO.getText());
                statement.setString(2, tfNumHome.getText());
                statement.setString(3, tfNumKv.getText());
                statement.setString(4, tfNumTel.getText());
                statement.setString(5, selectcmUsl);
                statement.setString(6, tfPrim.getText());
                statement.setString(7, String.valueOf(java.sql.Date.valueOf(DtPick.getValue())));
                statement.setString(8, selectcmStatus);
                statement.executeUpdate();
                tablerefreshSpisZ();
            }}
        catch (Exception e) {
            System.out.println("Ошибка с заполнением");
        }}
            else {lbError.setText("Проверьте, все ли поля заполнены верно");}}

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

    public void ClVernSpisZ(javafx.scene.input.MouseEvent mouseEvent) {
        PSpisokZ.setVisible(false);}

    private void tablerefreshSpisZ() {
        tableSpsZ.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM zayavkijil");
                while (resultSet.next()) {
                    tableSpsZ.add(new DBtableSpisZ(
                            resultSet.getInt("id"),
                            resultSet.getString("ФИО"),
                            resultSet.getString("НомерДома"),
                            resultSet.getString("НомерКвартиры"),
                            resultSet.getString("Телефон"),
                            resultSet.getString("ВидУслуги"),
                            resultSet.getString("Примечание"),
                            resultSet.getString("ДатаЗаявки"),
                            resultSet.getString("Статус")));
                }
            }
            if (!tableSpsZ.isEmpty()) {
                tableSpisZ.setItems(tableSpsZ);
            }
        } catch (Exception e) {
            System.out.println("Ошибка с таблицей списка заявок на оказание услуг");
        }
    }

    public static void deleteTableSpisZ(int Code1) {
        String querry = "DELETE FROM zayavkijil WHERE `id` = " + Code1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                    "root", "MySQL");
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ClDellSpisZ(MouseEvent mouseEvent) {
        selectedTable8 = tableSpisZ.getSelectionModel().getSelectedItem();
        deleteTableSpisZ(selectedTable8.getIDSpisZ());
        tableSpisZ.getItems().remove(selectedTable8);
    }

    public void izmenTableSpisZ(int Code) {
        cmStatusIzm.getItems().addAll(listStatus);
        cmStatusIzm.setValue("Статус");
        cmStatusIzm.setOnAction(this::getcmStatus);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM zayavkijil WHERE id = " + Code);
            while (resultSet.next()) {
                tfFIOIzm.setText(resultSet.getString("ФИО"));
                tfNumHomeIzm.setText(resultSet.getString("НомерДома"));
                tfNumKvIzm.setText(resultSet.getString("НомерКвартиры"));
                tfNumTelIzm.setText(resultSet.getString("Телефон"));
                DtPickIzm.setValue(LocalDate.parse(resultSet.getString("ДатаЗаявки")));
                tfPrimIzm.setText(resultSet.getString("Примечание"));
                cmUslIzm.setValue(resultSet.getString("ВидУслуги"));
                cmStatusIzm.setValue(resultSet.getString("Статус"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка изменения");
        }
    }

    public void fillComboBoxUslIzm() throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                "root", "MySQL")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Услуга FROM uslugi");
            while (resultSet.next()){
                UslDataIzm.add(resultSet.getString("Услуга"));
            }
            cmUslIzm.getItems().addAll( UslDataIzm);
            cmUslIzm.setValue("Вид услуги");
            cmUslIzm.setOnAction(this::getcmUsl);
        }catch (Exception e){
            System.out.println("Ошибка с боксом");
        }}

    public void ClIzmSpisZ(MouseEvent mouseEvent) {
        PIzmSpisZW.setVisible(true);
        selectedTable8 = tableSpisZ.getSelectionModel().getSelectedItem();
        izmenTableSpisZ(selectedTable8.getIDSpisZ());
        CodeSpisZ = selectedTable8.getIDSpisZ();
    }

    public void ClSohrIzmSpisZ(MouseEvent mouseEvent) {
        PIzmSpisZW.setVisible(false);
        if (!(tfFIOIzm.getText().isEmpty() || tfNumHomeIzm.getText().isEmpty()
                || tfNumKvIzm.getText().isEmpty() || tfNumTelIzm.getText().isEmpty() || tfPrimIzm.getText().isEmpty()))  {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jkh",
                        "root", "MySQL")) {
                    PreparedStatement statement = conn.prepareStatement
                            ("UPDATE zayavkijil SET ФИО = '" + tfFIOIzm.getText() + "', НомерДома = '" + tfNumHomeIzm.getText() +
                                    "', НомерКвартиры = '" + tfNumKvIzm.getText() + "', Телефон = '" + tfNumTelIzm.getText() +
                                    "', ДатаЗаявки = '" + DtPickIzm.getValue() +
                                    "', Примечание = '" + tfPrimIzm.getText() +
                                    "', ВидУслуги = '" + cmUslIzm.getValue()+
                                    "', Статус = '" + cmStatusIzm.getValue()
                                    + "' WHERE id = " + CodeSpisZ);
                    statement.executeUpdate();
                    tablerefreshSpisZ();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else wtextIzm.setText("Данные в полях некорректны");
    }

    public void ClBackIzmSpisZ(MouseEvent mouseEvent) {
        PIzmSpisZW.setVisible(false);
    }

    private void getcmUsl(Event event) {selectcmUsl = (String) cmUsl.getValue();}
    private void getcmStatus(Event event) {selectcmStatus = (String) cmStatus.getValue();}
    //СПИСОК ЗАЯВОК//
}