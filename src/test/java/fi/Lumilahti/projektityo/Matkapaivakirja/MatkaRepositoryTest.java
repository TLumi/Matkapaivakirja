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

@RunWith(SpringRunner.class)
@DataJpaTest

public class MatkaRepositoryTest {
	 @Autowired
	    private MatkaRepository mrepository;
	 
	 @Test
	 public void findByKuvausShouldReturnMatka() {
		 List<Matka> matkat = mrepository.findByKuvaus("Automatka Helsingistä Lappeenrantaan");
		 
		 assertThat(matkat).hasSize(1);
		 assertThat(matkat.get(0).getSaa()).isEqualTo("aurinkoa");
	 }
}
