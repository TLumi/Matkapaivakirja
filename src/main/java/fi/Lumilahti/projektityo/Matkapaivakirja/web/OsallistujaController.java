package fi.Lumilahti.projektityo.Matkapaivakirja.web;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
	public String osallistujaList(Model model) {
		model.addAttribute("osallistujat", orepository.findAll());
		
		return "osallistujalista";
	}
	
	@RequestMapping(value="/lisaaosallistuja")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String lisaaOsallistuja( Model model) { 
		model.addAttribute("osallistuja", new Osallistuja());
		
		return "lisaaosallistuja";
		
	}	
	@PostMapping("/lisaaosallistuja")
	public String Osallistujalisatty(@Valid Osallistuja osallistuja, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "lisaaosallistuja";
	}	model.addAttribute("osallistuja", new Osallistuja());
	return "osallistujalista";
	}
	
	@RequestMapping(value="/saveOsallistuja", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String save(@Valid Osallistuja osallistuja, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
		
			return "lisaaosallistuja";
			}
		orepository.save(osallistuja);
		return "redirect:osallistujalista";
	}
	
	
	
	@RequestMapping(value="/deleteosallistuja/{id}", method =RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteOsallistuja(@PathVariable("id") Long id, Model model) {
		orepository.deleteById(id);
		return "redirect:../osallistujalista";
	}


	@RequestMapping(value="/editosallistuja/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addOsallistuja(@PathVariable("id") Long osallistujaId, Model model) {
		model.addAttribute("osallistuja", orepository.findById(osallistujaId));
		return "muutaosallistuja";
	}
	@RequestMapping(value="/savemuutettuOsallistuja", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String savemuutettu(@Valid Osallistuja osallistuja, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
		
			return "muutaosallistuja";
			}
		orepository.save(osallistuja);
		return "redirect:osallistujalista";
	}
	
}
