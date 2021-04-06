package fi.Lumilahti.projektityo.Matkapaivakirja.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.TiedostoModel;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.TiedostoModelRepository;

@Controller

public class LiiteController {
	@Autowired
	private TiedostoModelRepository tmrepository;

	 @Value("${upload.path}")
	    private String uploadFolder;
	    
	    @GetMapping("/lataaliite")
	    public String index() {
	        return "lataa";
	    }

	    @PostMapping("/lataa")
	    public String LataaTiedosto(@RequestParam("tiedosto") MultipartFile tiedosto, Model model) {
	    	
	        if (tiedosto.isEmpty()) {
	        	model.addAttribute("viesti", "Lataus epäonnistui");
	            return "lataustilanne";
	        }

	        try {
	        	byte[] bytes = tiedosto.getBytes();
	            TiedostoModel tiedostoModel = new TiedostoModel(tiedosto.getOriginalFilename(), tiedosto.getContentType(), bytes);
	            tmrepository.save(tiedostoModel);
	    
	            return "redirect:/tiedostot";
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "tiedostolista";
	    }
	    
	    @GetMapping("/tiedostot")
	    public String tiedostoLista(Model model) {
	    	model.addAttribute("tiedostot", tmrepository.findAll());  	
	    	return "tiedostolista";
	    }
	    
		@GetMapping("/tiedosto/{id}")
		public ResponseEntity<byte[]> getTiedosto(@PathVariable Long id) {
			Optional<TiedostoModel> fileOptional = tmrepository.findById(id);
			
			if(fileOptional.isPresent()) {
				TiedostoModel tiedosto = fileOptional.get();
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + tiedosto.getFileName() + "\"")
						.body(tiedosto.getTiedosto());	
			}
			
			return ResponseEntity.status(404).body(null);
		}    
	    
	}