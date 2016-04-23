package finote.project.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionHistory {
	private String id;
	private Date tgl;
	private String fromOrTo;
	private String deskripsi;
	private double kredit;
	private double debit;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTgl() {
		return tgl;
	}
	
	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}
	public String getFromOrTo() {
		return fromOrTo;
	}
	public void setFromOrTo(String fromOrTo) {
		this.fromOrTo = fromOrTo;
	}
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	public double getKredit() {
		return kredit;
	}
	public void setKredit(double kredit) {
		this.kredit = kredit;
	}
	public double getDebit() {
		return debit;
	}
	public void setDebit(double debit) {
		this.debit = debit;
	}
	
	
}
