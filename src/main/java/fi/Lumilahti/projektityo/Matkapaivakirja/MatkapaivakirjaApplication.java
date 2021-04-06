package fi.Lumilahti.projektityo.Matkapaivakirja;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Kulkuvaline;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.KulkuvalineRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Matka;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.MatkaRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.OsallistujaRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Osallistuja;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.TiedostoModel;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.TiedostoModelRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.User;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.UserRepository;




@SpringBootApplication
public class MatkapaivakirjaApplication {
	private static final Logger log = LoggerFactory.getLogger(MatkapaivakirjaApplication.class);

	
	
	public static void main(String[] args) {
		SpringApplication.run(MatkapaivakirjaApplication.class, args);
	}
	@Bean
	public CommandLineRunner MatkaDemo(MatkaRepository repository, KulkuvalineRepository krepository, OsallistujaRepository orepository, TiedostoModelRepository tmrepository, UserRepository urepository) {
		return (args) -> {
			log.info("save matkat");
			
			krepository.save(new Kulkuvaline("Auto", "keltainen"));
			krepository.save(new Kulkuvaline("Polkupyörä", "Jopo"));
			
			orepository.save(new Osallistuja ("Tuula", "Lumilahti", "TL"));
			orepository.save(new Osallistuja ("Tiina", "Testi", "Tikru"));
			
			System.out.println("tallenna matkat kantaan");
			repository.save(new Matka("21.2.2021", "Automatka Helsingistä Lappeenrantaan",  "Hieno päivä ja reissu Lappeenrantaan", "aurinkoa", "230", orepository.findByEtunimiAndSukunimiAndLempinimi("Tuula", "Lumilahti", "TL").get(0), krepository.findByKulkuneuvoAndLisatiedot("Auto", "keltainen") .get(0)));			
			repository.save(new Matka("21.2.2021", "Helsingistä Tampereelle pyörällä",  "Hieno päivä ja hyvät huoltojoukot", "aurinkoa", "230", orepository.findByEtunimiAndSukunimiAndLempinimi("Tiina", "Testi", "Tikru").get(0), krepository.findByKulkuneuvoAndLisatiedot("Polkupyörä", "Jopo") .get(0)));			
			
	//		tmrepository.save(new TiedostoModel("UsersOMISTAJADocumentsOpiskelu_v22020_04_17_008678 venytys.JPG", "jpg"));
			
			
			
			System.out.println("fetch all matka");
			for (Osallistuja osallistuja : orepository.findAll()) {
				System.out.println(osallistuja.toString());
			}
			for (Kulkuvaline kulkuvaline: krepository.findAll()) {
				System.out.println(kulkuvaline.toString());
			}
			for (Matka matka : repository.findAll()){
				System.out.println(matka.toString());
			}
			
			User user1 = new User("user", "$2a$10$crc625f8IgRI62PCVDL7gOmG69x8JVGi1.TiDlOrIgs00RHVD2yYi", "USER");
			User user2 = new User("admin", "$2a$10$fgVgXxpIXdXpsZ6Fo4NiEOIu0/.aNC4z1Ej2xa1P8eUiQiGEBw6CO", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
		
		
	}
	
}
