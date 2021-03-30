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
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long tiedostoId;
	private String nimi, tyyppi;
	
	@Lob
	private byte [] tiedosto;
	

	@JsonIgnore
	@OneToMany(cascade =CascadeType.ALL, mappedBy= "tiedostoModel") 
	private List<Matka> matkat;

	public TiedostoModel(String nimi, String tyyppi, byte[] tiedosto) {
		this.nimi = nimi;
		this.tyyppi = tyyppi;
		this.tiedosto = tiedosto;
	}
	
	public TiedostoModel(String nimi, String tyyppi) {
		this.nimi = nimi;
		this.tyyppi = tyyppi;}
		

	public TiedostoModel() {
			
	}
	
	public TiedostoModel(String nimi, List<Matka> matkat) {
		this.nimi = nimi;
	}

	public long getTiedostoId() {
		return tiedostoId;
	}

	public void setTiedostoId(long tiedostoId) {
		this.tiedostoId = tiedostoId;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public byte[] getTiedosto() {
		return tiedosto;
	}

	public void setTiedosto(byte[] tiedosto) {
		this.tiedosto = tiedosto;
	}
	
	public List<Matka> getMatkat() {
		return matkat;
	}

	public void setMatkat(List<Matka> matkat) {
		this.matkat = matkat;
	}

	@Override
	public String toString() {
		return "TiedostoModel [tiedostoId=" + tiedostoId + ", nimi=" + nimi + ", tyyppi=" + tyyppi + ", tiedosto="
				+ Arrays.toString(tiedosto) + "]";
	}
	
	
	
	

}
