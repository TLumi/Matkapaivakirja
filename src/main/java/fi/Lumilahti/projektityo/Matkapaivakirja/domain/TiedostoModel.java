package fi.Lumilahti.projektityo.Matkapaivakirja.domain;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class TiedostoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fileName, mimeType;

	@Lob
	private byte[] tiedosto;
	
	public TiedostoModel() {}
	
	public TiedostoModel(String fileName, String mimeType, byte[] tiedosto) {
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.tiedosto = tiedosto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getTiedosto() {
		return tiedosto;
	}

	public void setTiedosto(byte[] tiedosto) {
		this.tiedosto = tiedosto;
	}


}
