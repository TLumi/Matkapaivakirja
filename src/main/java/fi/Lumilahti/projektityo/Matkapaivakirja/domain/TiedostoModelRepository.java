package fi.Lumilahti.projektityo.Matkapaivakirja.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TiedostoModelRepository extends CrudRepository <TiedostoModel, Long> {
	 List <TiedostoModel> findByNimi(String Nimi); 
	 List <TiedostoModel> findByNimiAndTyyppiAndTiedosto(String nimi, String tyyppi, byte[] tiedosto);
	 
	 
}





