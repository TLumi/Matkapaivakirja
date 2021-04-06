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

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Kulkuvaline;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.KulkuvalineRepository;


@Controller
public class KulkuvalineController {

	@Autowired
	private KulkuvalineRepository krepository;
	
	@RequestMapping(value= {"/kulkuvalinelista"})
	public String kulkuvalineLista(Model model) {
		model.addAttribute("kulkuvalineet", krepository.findAll());
		
		return "kulkuvalinelista";
	}
	
	@RequestMapping(value="/lisaakulkuvaline")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String lisaaKulkuvaline(Model model) { 
		model.addAttribute("kulkuvaline", new Kulkuvaline());
	
		return "lisaakulkuvaline";
		
		
	}
	@PostMapping("/lisaakulkuvaline")
	public String Kulkuvalinelisatty(@Valid Kulkuvaline kulkuvaline, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "lisaakulkuvaline";
	}	model.addAttribute("kulkuvaline", new Kulkuvaline());
	return "kulkuvalinelista";
	}
	
	
	
	@RequestMapping(value="/saveKulkuvaline", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String save(@Valid Kulkuvaline kulkuvaline, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "lisaakulkuvaline";
		}
			krepository.save(kulkuvaline);
			return "redirect:kulkuvalinelista";
	}
	
	
	@RequestMapping(value="/deletekulkuvaline/{id}", method =RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteKulkuvaline(@PathVariable("id") Long kulkuvalineId, Model model) {
		krepository.deleteById(kulkuvalineId);
		return "redirect:../kulkuvalinelista";
	}

	//muuta matkan tietoja
	@RequestMapping(value="/editkulkuvaline/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addKulkuvaline(@PathVariable("id") Long kulkuvalineId, Model model) {
		model.addAttribute("kulkuvaline", krepository.findById(kulkuvalineId));
		return "muutakulkuvaline";
	}
	@RequestMapping(value="/savemuutettuKulkuvaline", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String savemuutettuk(@Valid Kulkuvaline kulkuvaline, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
		
			return "muutaokulkuvaline";
			}
		krepository.save(kulkuvaline);
		return "redirect:kulkuvalinelista";
	}
}
