package fi.Lumilahti.projektityo.Matkapaivakirja.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Matka;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Osallistuja;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.OsallistujaRepository;

@Controller
public class OsallistujaController {
	
	@Autowired
	private OsallistujaRepository orepository;
	
	
	
	public void naytaOsallistujat() {
		List<Osallistuja> osallistujat =orepository.findByLempinimi("");
	}

	@RequestMapping(value= {"/osallistujalista"})
	public String osallistujaLista(Model model) {
		model.addAttribute("osallistujat", orepository.findAll());
		
		return "osallistujalista";
	}
	
	@RequestMapping(value="/lisaaosallistuja")
	public String lisaaOsallistuja(Model model) { 
		model.addAttribute("osallistuja", new Osallistuja());
		
		return "lisaaosallistuja";
		
	}	
	
	@RequestMapping(value="/saveOsallistuja", method = RequestMethod.POST)
	public String save(Osallistuja osallistuja) {
		orepository.save(osallistuja);
		return "redirect:osallistujalista";
	}
	
	@RequestMapping(value="/deleteosallistuja/{id}", method =RequestMethod.GET)
	public String deleteOsallistuja(@PathVariable("id") Long id, Model model) {
		orepository.deleteById(id);
		return "redirect:../osallistujalista";
	}

	//muuta matkan tietoja
	@RequestMapping(value="/editosallistuja/{id}")
	public String addOsallistuja(@PathVariable("id") Long osallistujaId, Model model) {
		model.addAttribute("osallistuja", orepository.findById(osallistujaId));
		return "muutaosallistuja";
	}
}
