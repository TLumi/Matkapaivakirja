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
	    
	    @GetMapping("/")
	    public String index() {
	        return "lataa";
	    }

	    @PostMapping("/lataa")
	    public String fileUpload(@RequestParam("file") MultipartFile file, Model model) {
	    	// Image Base64.getEncoder().encodeToString(file.file)
	    	// <img  th:src="@{'data:image/jpeg;base64,'+${file.file}}" />
	        if (file.isEmpty()) {
	        	model.addAttribute("msg", "Upload failed");
	            return "uploadstatus";
	        }

	        try {
	            TiedostoModel tiedostoModel = new TiedostoModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	            tmrepository.save(tiedostoModel);
	    
	            return "redirect:/tiedostot";
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "uploadstatus";
	    }
	    
	    @GetMapping("/tiedostot")
	    public String fileList(Model model) {
	    	model.addAttribute("files", tmrepository.findAll());  	
	    	return "tiedostolista";
	    }
	    
		@GetMapping("/tiedosto/{id}")
		public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
			Optional<TiedostoModel> fileOptional = tmrepository.findById(id);
			
			if(fileOptional.isPresent()) {
				TiedostoModel file = fileOptional.get();
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
						.body(file.getFile());	
			}
			
			return ResponseEntity.status(404).body(null);
		}    
	    
	}