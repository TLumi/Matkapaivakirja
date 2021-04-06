package fi.Lumilahti.projektityo.Matkapaivakirja.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Kulkuvaline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long kulkuvalineId;
	@Size(min=2, max=30)
	private String kulkuneuvo; 
	private String lisatiedot;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "kulkuvaline")
	private List<Matka> matkat;
	
	public Kulkuvaline ( ) {}

	public Kulkuvaline(String kulkuneuvo, String lisatiedot) {
		this.kulkuneuvo = kulkuneuvo;
		this.lisatiedot = lisatiedot;
		
	}
	
	public Kulkuvaline (String kulkuneuvo, List<Matka>Matkat) {
	this.kulkuneuvo=kulkuneuvo;
	}

	public Long getKulkuvalineId() {
		return kulkuvalineId;
	}

	public void setKulkuvalineId(Long kulkuvalineId) {
		this.kulkuvalineId = kulkuvalineId;
	}

	public String getKulkuneuvo() {
		return kulkuneuvo;
	}

	public void setKulkuneuvo(String kulkuneuvo) {
		this.kulkuneuvo = kulkuneuvo;
	}

	public String getLisatiedot() {
		return lisatiedot;
	}

	public void setLisatiedot(String lisatiedot) {
		this.lisatiedot = lisatiedot;
	}

	public List<Matka> getMatkat() {
		return matkat;
	}

	public void setMatkat(List<Matka> matkat) {
		this.matkat = matkat;
	}

	@Override
	public String toString() {
		return "Kulkuvaline [kulkuvalineId=" + kulkuvalineId + ", kulkuneuvo=" + kulkuneuvo + ", lisatiedot="
				+ lisatiedot + "]";
	}
	
	
	
	
	
	
	

}
