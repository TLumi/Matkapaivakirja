package fi.Lumilahti.projektityo.Matkapaivakirja.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MatkaRepository extends CrudRepository <Matka, Long> {
	
	List<Matka>findByKuvaus(String kuvaus);
	List<Matka>findByPaiva(String paiva);


	
}
