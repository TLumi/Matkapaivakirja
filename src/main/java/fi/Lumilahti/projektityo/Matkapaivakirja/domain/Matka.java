package fi.Lumilahti.projektityo.Matkapaivakirja.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Matka {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String paiva, kuvaus;
	private String matkakuvaus, saa, km;
	

	@ManyToOne
	@JsonIgnore
	// @JoinColumn(name="osallistujaId")
	private Osallistuja osallistuja;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="kulkuvalineId")
	private Kulkuvaline kulkuvaline;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="tiedostoId")
	private TiedostoModel tiedostoModel;
	
	public Matka() {

	}
	
	public Matka(String paiva, String kuvaus)
	{
		this.paiva = paiva;
		this.kuvaus = kuvaus;
	}
	

	public Matka(String paiva, String kuvaus,  String matkakuvaus, String saa, String km, Osallistuja osallistuja, Kulkuvaline kulkuvaline) {
				
		this.paiva = paiva;
		this.kuvaus = kuvaus;
		this.matkakuvaus = matkakuvaus;
		this.saa = saa;
		this.km = km;
		this.osallistuja = osallistuja;
		this.kulkuvaline=kulkuvaline;
	}
	
	
//	public Matka(String paiva, String kuvaus,  String matkakuvaus, String saa, String km) {
		
//		this.paiva = paiva;
//		this.kuvaus = kuvaus;
//		this.matkakuvaus = matkakuvaus;
//		this.saa = saa;
//		this.km = km;
		
//	}
	public Matka(String paiva, String kuvaus,  String matkakuvaus, String saa, String km, Osallistuja osallistuja, Kulkuvaline kulkuvaline, TiedostoModel tiedostoModel) {
		
		this.paiva = paiva;
		this.kuvaus = kuvaus;
		this.matkakuvaus = matkakuvaus;
		this.saa = saa;
		this.km = km;
		this.osallistuja = osallistuja;
		this.kulkuvaline=kulkuvaline;
		this.tiedostoModel=tiedostoModel;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPaiva() {
		return paiva;
	}

	public void setPaiva(String paiva) {
		this.paiva = paiva;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public String getMatkakuvaus() {
		return matkakuvaus;
	}

	public void setMatkakuvaus(String matkakuvaus) {
		this.matkakuvaus = matkakuvaus;
	}

	public String getSaa() {
		return saa;
	}

	public void setSaa(String saa) {
		this.saa = saa;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	
	public Kulkuvaline getKulkuvaline() {
		return kulkuvaline;
	}
	
	public void setKulkuvaline(Kulkuvaline kulkuvaline) {
		this.kulkuvaline = kulkuvaline;
	}
		
	public Osallistuja getOsallistuja() {
		return osallistuja;
	}

	public void setOsallistuja(Osallistuja osallistuja) {
		this.osallistuja = osallistuja;
	}
	public TiedostoModel getTideostoModel() {
		return tiedostoModel;
	}

	public void setTiedostoModel (TiedostoModel tiedostoModel) {
		this.tiedostoModel = tiedostoModel;
	}
	
	
	@Override
	public String toString() {
	//	if (this.kulkuvaline == null && this.osallistuja == null)
	//		return "Matka [id=" + id + ", paiva=" + paiva + ", kuvaus=" + kuvaus 
	//					+ ", matkakuvaus=" + matkakuvaus + ", saa=" + saa + ", km=" + km +  "]";
	
	//	 else  
				return "Matka [id=" + id + ", paiva=" + paiva + ", kuvaus=" + kuvaus + ", matkakuvaus=" + matkakuvaus + ", saa=" + saa + ", km=" + km + ", osallistuja=" + this.getOsallistuja() + ", kulkuvaline=" + this.getKulkuvaline()
				+ "]";
		
	}
	

}
