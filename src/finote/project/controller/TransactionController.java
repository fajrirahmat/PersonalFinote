package finote.project.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import finote.project.main.Main;
import finote.project.model.TransactionHistory;

public class TransactionController implements Initializable{
	private ObservableList<TransactionHistory> transactionData = FXCollections.observableArrayList();
	private ObservableList<String> operations = FXCollections.observableArrayList();

	@FXML
	private TableView<TransactionHistory> tableTransactionHistory;
	
	@FXML 
	private TableColumn< TransactionHistory , String> tableColId;
	
	@FXML
	private TableColumn< TransactionHistory , String> tableColTgl;
	
	@FXML
	private TableColumn< TransactionHistory , String> colFromOrTo;
	
	@FXML
	private TableColumn< TransactionHistory , String> colDeskripsi;
	
	@FXML
	private TableColumn< TransactionHistory , String> colKredit;
	
	@FXML
	private TableColumn< TransactionHistory , String> colDebit;
	
	@FXML
	private TextField txtFromOrTo;
	
	@FXML
	private TextField txtDescription;
	
	@FXML
	private TextField txtJumlah;
	
	@FXML
	private ComboBox<String> cmbOperasi;
	
	@FXML
	private TextField txtTransactionId;

	private Main mainApp;
	
	public TransactionController() {
		// TODO Auto-generated constructor stub
		
	}
	
	@FXML
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TransactionHistory transaction = new TransactionHistory();
		transaction.setTgl(new Date());
		transaction.setId("001");
		transaction.setDeskripsi("Coba output transaction");
		transaction.setFromOrTo("Fulan");
		transaction.setDebit(0.0);
		transaction.setKredit(1000.0);
		
		transactionData.add(transaction);
		operations.addAll("+","-");
		
		tableTransactionHistory.setItems(transactionData);
		cmbOperasi.setItems(operations);
		
		tableColId.setCellValueFactory(new PropertyValueFactory<TransactionHistory, String>("id"));	
		tableColTgl.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TransactionHistory,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(
					CellDataFeatures<TransactionHistory, String> param) {
				SimpleStringProperty property = new SimpleStringProperty();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				property.setValue(format.format(param.getValue().getTgl()));
				return property;
			}
		});
		colFromOrTo.setCellValueFactory(new PropertyValueFactory<TransactionHistory, String>("fromOrTo"));
		colDeskripsi.setCellValueFactory(new PropertyValueFactory<TransactionHistory, String>("deskripsi"));
		colKredit.setCellValueFactory(new PropertyValueFactory<TransactionHistory, String>("kredit"));
		colDebit.setCellValueFactory(new PropertyValueFactory<TransactionHistory, String>("debit"));
		
		tableTransactionHistory.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TransactionHistory>() {

			@Override
			public void changed(
					ObservableValue<? extends TransactionHistory> observable,
					TransactionHistory oldValue, TransactionHistory newValue) {
				
			}
		});
		
	}

	public ObservableList<TransactionHistory> getTransactionData() {
		return transactionData;
	}
	
	@FXML
	private void onAddNewTransaction(ActionEvent evt){
		TransactionHistory transaction = new TransactionHistory();
		transaction.setTgl(new Date());
		transaction.setId(generateId());
		transaction.setDeskripsi(txtDescription.getText());
		transaction.setFromOrTo(txtFromOrTo.getText());
		
		String operation = cmbOperasi.getSelectionModel().getSelectedItem();
		
		if("+".equals(operation)){
			transaction.setDebit(Double.valueOf(txtJumlah.getText()));
			transaction.setKredit(0.0);
		}else{
			transaction.setKredit(Double.valueOf(txtJumlah.getText()));
			transaction.setDebit(0.0);
		}

		transactionData.add(transaction);
	}
	
	private String generateId(){
		return String.valueOf(System.currentTimeMillis());
	}
		
	@FXML
	private void onBtnDeleteTransaction(){
		int selectedIndex = tableTransactionHistory.getSelectionModel().getSelectedIndex();
		if(selectedIndex >= 0){
			tableTransactionHistory.getItems().remove(selectedIndex);
		}else{
			System.out.println("There is no item selected");
		}
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	

}
