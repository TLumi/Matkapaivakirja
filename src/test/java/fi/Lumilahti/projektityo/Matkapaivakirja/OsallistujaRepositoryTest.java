package fi.Lumilahti.projektityo.Matkapaivakirja;

	import static org.assertj.core.api.Assertions.assertThat;
	import java.util.List;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
	import org.springframework.test.context.junit4.SpringRunner;

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Matka;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Osallistuja;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.OsallistujaRepository;

	@RunWith(SpringRunner.class)
	@DataJpaTest

	public class OsallistujaRepositoryTest{ 
		@Autowired    
		OsallistujaRepository orepository;
		 
		 @Test
		 public void findByLempinimiShouldReturnEtunimi() {
			 List<Osallistuja> osallistujat = orepository.findByLempinimi("TL");
			 
			 assertThat(osallistujat).hasSize(1);
			 assertThat(osallistujat.get(0).getEtunimi()).isEqualTo("Tuula");
		 }
		 
		 @Test 
			public void deleteOsallistuja() {
				 
				List<Osallistuja> osallistujat = orepository.findByLempinimi("TL");
				orepository.deleteById(osallistujat.get(0).getId());
				osallistujat= orepository.findByLempinimi("TL");
				assertThat(osallistujat).hasSize(0);
			}
		 
		 @Test
			public void insertNewOsallistuja() {
				Osallistuja osallistuja= new Osallistuja( "Teemu", "Testihenkilö", "TT");					
				orepository.save(osallistuja);
				assertThat(osallistuja.getId()).isNotNull();
			}
	}


