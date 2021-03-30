package fi.Lumilahti.projektityo.Matkapaivakirja.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Osallistuja {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String etunimi, sukunimi, lempinimi; 
		
		
	@JsonIgnore
	@OneToMany(cascade =CascadeType.ALL, mappedBy= "osallistuja") 
	private List<Matka> matkat;
	
	
	public Osallistuja() {}

	public Osallistuja(String etunimi, String sukunimi, String lempinimi) {
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.lempinimi = lempinimi;
	
	}
	public Osallistuja(String lempinimi, List<Matka> matkat) {
		this.lempinimi = lempinimi;
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id) {
		this.id = id;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getLempinimi() {
		return lempinimi;
	}

	public void setLempinimi(String lempinimi) {
		this.lempinimi = lempinimi;
	}

	public List<Matka> getMatkat() {
		return matkat;
	}

	public void setMatkat(List<Matka> matkat) {
		this.matkat = matkat;
	}

	@Override
	public String toString() {
		return "Osallistuja [id=" + id + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", lempinimi=" + lempinimi + "]";
	}
		
}
