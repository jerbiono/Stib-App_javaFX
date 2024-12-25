/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.view;

import Presenter.Presenter;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import stib.dto.StationDto;
import org.controlsfx.control.SearchableComboBox;
import stib.dto.FavoryDto;
import stib.model.ModelApp;
import stib.model.Node;

/**
 *
 * @author nadou
 */
public class FxmlController {

    @FXML
    private SearchableComboBox<String> sourcesChoices;
    @FXML
    private SearchableComboBox<String> destinationsChoices;
    @FXML
    private TableView<Node> TableStationsData;
    @FXML
    private TableColumn<Node, String> StationNameColumn;
    @FXML
    private TableColumn<Node, String> StationLinesColumn;
    @FXML
    private TextField favouriteName;
    @FXML
    private TableView<FavoryDto> favoriteTable;
    @FXML
    private TableColumn<FavoryDto, String> favoriteColumn;
    @FXML
    private Label updateError;
    @FXML
    private Label deleteError;
    @FXML
    private Label deleteDone;
    @FXML
    private Label updateDone;
    @FXML
    private Label errorFavoriteSelect;
    private String selectedStationSource;
    private String selectedStationDestination;
    private Presenter presenter;
    private int indexScroll = 0;
    private int stationsCount;

    /**
     * Executed at the beginning.
     */
    public void initialize() {
        ModelApp model = new ModelApp();
        this.presenter = new Presenter(this, model);
        model.registerObserver(presenter);
        presenter.SearchAllFavorys();
        stationsCount = presenter.getStationCount();
        fillSourceDestComboBox(presenter.getStationsData());
        this.StationNameColumn.setCellValueFactory(new PropertyValueFactory<>("StationName"));
        this.StationLinesColumn.setCellValueFactory(new PropertyValueFactory<>("Lines"));
        this.favoriteColumn.setCellValueFactory(new PropertyValueFactory<>("Key"));
        updateFavoryTable();

    }

    /**
     * Allows to add stations names to the comboBox view.
     */
    void fillSourceDestComboBox(List<StationDto> stationData) {
        ObservableList<String> stationsNames = FXCollections.observableArrayList();
        for (StationDto station : stationData) {
            stationsNames.add(station.getStationName());
        }
        this.sourcesChoices.getItems().setAll(stationsNames);
        this.destinationsChoices.getItems().setAll(stationsNames);
        this.sourcesChoices.getSelectionModel().select(0);
        this.destinationsChoices.getSelectionModel().select(this.stationsCount - 1);

    }

    /**
     * Executed when the user click on the graphic search button.
     */
    @FXML
    private void searchStationsPath() {
        updateSelectedSourceDest();
        this.presenter.CalculatePath(this.selectedStationSource, this.selectedStationDestination);
    }

    @FXML
    private void updateFavoriteName() {
        deleteError.setVisible(false);
        deleteDone.setVisible(false);
        errorFavoriteSelect.setVisible(false);
        updateSelectedSourceDest();
        if (!favouriteName.getText().isEmpty()) {
            updateError.setVisible(false);
            updateDone.setVisible(true);
            FavoryDto favorite = new FavoryDto(selectedStationSource, selectedStationDestination, favouriteName.getText());
            this.presenter.AddFavory(favorite);
        } else {
            updateError.setVisible(true);
            updateDone.setVisible(false);
        }

    }

    @FXML
    private void deleteFavoriteName() {
        updateError.setVisible(false);
        updateDone.setVisible(false);
        errorFavoriteSelect.setVisible(false);
        updateSelectedSourceDest();
        if (!favouriteName.getText().isEmpty()) {

            String favoriteName = favouriteName.getText();
            if (this.presenter.deleteFavory(favoriteName)) {
                deleteError.setVisible(false);
                deleteDone.setVisible(true);
            } else {
                deleteError.setVisible(true);

            }
        } else {
            deleteError.setVisible(true);
            deleteDone.setVisible(false);
        }
    }

    @FXML
    private void executeFavory() {

        FavoryDto favoryToExcute = this.favoriteTable.getSelectionModel().getSelectedItem();
        if (favoryToExcute != null) {
            presenter.CalculatePath(favoryToExcute.getStationSource(), favoryToExcute.getStationDest());

        } else {
            errorFavoriteSelect.setVisible(true);
        }
    }

    /**
     * Allows to update source and destination selection values.
     */
    private void updateSelectedSourceDest() {
        this.selectedStationSource = this.sourcesChoices.getSelectionModel().getSelectedItem();
        this.selectedStationDestination = this.destinationsChoices.getSelectionModel().getSelectedItem();
    }

    /**
     * Allows to update the data of the table view of stations path.
     */
    public void updateTableStationData() {
        this.TableStationsData.getItems().clear();
        errorFavoriteSelect.setVisible(false);
        if (presenter.getShortestPath() == null || presenter.getShortestPath().isEmpty()) {
            indexScroll++;
            this.TableStationsData.getItems().add(new Node(new StationDto(-1, "Not Available !!"), new ArrayList<>(List.of(-1))));
        } else {
            for (int i = 0; i < presenter.getShortestPath().size(); i++) {
                indexScroll++;
                this.TableStationsData.getItems().add(presenter.getShortestPath().get(i));
            }
        }
        this.TableStationsData.scrollTo(indexScroll);
        presenter.getShortestPath().clear();
    }

    /**
     * Update the favory Table.
     */
    public void updateFavoryTable() {
        favouriteName.clear();
        this.favoriteTable.getItems().clear();
        this.presenter.getAllFavorys().forEach(favory -> {
            this.favoriteTable.getItems().add(favory);
        });
    }

}
