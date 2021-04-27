package fi.Lumilahti.projektityo.Matkapaivakirja.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface KulkuvalineRepository  extends CrudRepository <Kulkuvaline, Long>{
	List <Kulkuvaline> findByKulkuneuvo(String kulkuneuvo); 
	List <Kulkuvaline> findByKulkuneuvoAndLisatiedot(String kulkuneuvo, String lisatiedot); 
	Optional <Kulkuvaline> findById(Long id);
	List <Kulkuvaline> findByLisatiedot(String lisatiedot);
}
