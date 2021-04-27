package fi.Lumilahti.projektityo.Matkapaivakirja;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Matka;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.MatkaRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.OsallistujaRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.KulkuvalineRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class MatkaRepositoryTest {
	 @Autowired
	     MatkaRepository mrepository;
	 
	 @Autowired
     OsallistujaRepository OsallistujaRepository;
	 
	 @Autowired
     KulkuvalineRepository KulkuvalineRepository;
	 
	 @Test
	 public void findByKuvausShouldReturnMatka() {
		 List<Matka> matkat = mrepository.findByKuvaus("Automatka Helsingistä Lappeenrantaan");
		 
		 assertThat(matkat).hasSize(1);
		 assertThat(matkat.get(0).getSaa()).isEqualTo("aurinkoa");
	 }
	 @Test 
		public void deleteMatka() {
			 
			List<Matka> matkat = mrepository.findByKuvaus("Automatka Helsingistä Lappeenrantaan");
			mrepository.deleteById(matkat.get(0).getId());
			matkat= mrepository.findByPaiva("21.2.2021");
			assertThat(matkat).hasSize(1);
		}
	 
	 @Test
		public void insertNewMatka() {
			Matka matka = new Matka("22.2.2021", "Helsingistä Tampereelle pyörällä",  "Hieno päivä ja hyvät huoltojoukot", "aurinkoa", "230", 
					OsallistujaRepository.findByLempinimi("Tikru").get(0),
					KulkuvalineRepository.findByKulkuneuvoAndLisatiedot("Polkupyörä", "Jopo") .get(0));
					
			mrepository.save(matka);
			assertThat(matka.getId()).isNotNull();
		}

}
