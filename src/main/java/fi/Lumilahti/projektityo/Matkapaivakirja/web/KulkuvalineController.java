package fi.Lumilahti.projektityo.Matkapaivakirja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Kulkuvaline;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.KulkuvalineRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Osallistuja;

@Controller
public class KulkuvalineController {

	@Autowired
	
	private KulkuvalineRepository krepository;
	
	@RequestMapping(value= {"/kulkuvalinelista"})
	public String osallistujaLista(Model model) {
		model.addAttribute("kulkuvalineet", krepository.findAll());
		
		return "kulkuvalinelista";
	}
	
	@RequestMapping(value="/lisaakulkuvaline")
	public String lisaaKulkuvaline(Model model) { 
		model.addAttribute("kulkuvaline", new Kulkuvaline());
		
		return "lisaakulkuvaline";
		
	}
	
	
	@RequestMapping(value="/savekulkuvaline", method = RequestMethod.POST)
	public String save(Kulkuvaline kulkuvaline) {
		krepository.save(kulkuvaline);
		return "redirect:kulkuvalinelista";
	}
	
	@RequestMapping(value="/deletekulkuvaline/{id}", method =RequestMethod.GET)
	public String deleteKulkuvaline(@PathVariable("id") Long kulkuvalineId, Model model) {
		krepository.deleteById(kulkuvalineId);
		return "redirect:../kulkuvalinelista";
	}

	//muuta matkan tietoja
	@RequestMapping(value="/editkulkuvaline/{id}")
	public String addKulkuvaline(@PathVariable("id") Long kulkuvalineId, Model model) {
		model.addAttribute("kulkuvaline", krepository.findById(kulkuvalineId));
		return "muutakulkuvaline";
	}
}
