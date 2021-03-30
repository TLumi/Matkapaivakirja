package fi.Lumilahti.projektityo.Matkapaivakirja.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OsallistujaRepository extends CrudRepository <Osallistuja, Long>{
	 List <Osallistuja> findByLempinimi(String lempinimi);
	 List <Osallistuja> findByEtunimiAndSukunimiAndLempinimi(String etunimi, String sukunimi, String lempinimi);

}
