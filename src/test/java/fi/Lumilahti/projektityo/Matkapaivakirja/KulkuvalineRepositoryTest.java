package fi.Lumilahti.projektityo.Matkapaivakirja;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Matka;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Kulkuvaline;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.KulkuvalineRepository;

	@RunWith(SpringRunner.class)
	@DataJpaTest
	
public class KulkuvalineRepositoryTest {

			@Autowired    
		KulkuvalineRepository krepository;
		 
		 @Test
		 public void findByKulkuneuvo() {
			 List<Kulkuvaline> kulkuvalineet = krepository.findByKulkuneuvo("Polkupyörä");
			 
			 assertThat(kulkuvalineet).hasSize(1);
			 assertThat(kulkuvalineet.get(0).getLisatiedot()).isEqualTo("Jopo");
		 }
		 
		 @Test 
			public void deleteKulkuvaline() {
				 
				List<Kulkuvaline> kulkuvalineet = krepository.findByKulkuneuvo("Auto");
				krepository.deleteById(kulkuvalineet.get(0).getKulkuvalineId());
				kulkuvalineet= krepository.findByLisatiedot("keltainen");
				assertThat(kulkuvalineet).hasSize(0);
			}
		 
		 @Test
			public void insertNewKulkuvaline() {
				Kulkuvaline kulkuvaline= new Kulkuvaline( "Ruohonleikkuri", "Ajettava");					
				krepository.save(kulkuvaline);
				assertThat(kulkuvaline.getKulkuvalineId()).isNotNull();
			}
	}



	

