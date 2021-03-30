package fi.Lumilahti.projektityo.Matkapaivakirja.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.KulkuvalineRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Matka;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.MatkaRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.OsallistujaRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.TiedostoModelRepository;


@Controller
public class MatkaController {
	
	@Autowired
	private MatkaRepository repository;
	
	@Autowired
	private OsallistujaRepository orepository;
	
	@Autowired 
	private KulkuvalineRepository krepository;
	
	@Autowired 
	private TiedostoModelRepository tmrepository;
	
	public void naytaMatkat() {
		List<Matka> matkat = repository.findByKuvaus("");
	}
	
	// Näytä matkalista ja valintaruutu
	@RequestMapping(value= {"/ ", "/matkalista"})
	public String matkaLista(Model model) {
		model.addAttribute("matkat", repository.findAll());
		return "matkalista";
	}
	
	//Lisätään uusi matka	
	@RequestMapping(value="/lisaa")
	public String lisaaMatka(Model model) { 
		model.addAttribute("matka", new Matka());
		model.addAttribute("kulkuvalineet", krepository.findAll());
		model.addAttribute("osallistujat", orepository.findAll());
		
		return "lisaamatka";
	}
	
	//tallentaa lisätyn tai muutetun matkan tiedot
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Matka matka) {
		repository.save(matka);
		return "redirect:matkalista";
	}
	
	//poista matka
	@RequestMapping(value="/delete/{id}", method =RequestMethod.GET)
	public String deleteMatka(@PathVariable("id") Long matkaId, Model model) {
		repository.deleteById(matkaId);
		return "redirect:../matkalista";
	}

	//muuta matkan tietoja
	@RequestMapping(value="/edit/{id}")
	public String addMatka(@PathVariable("id") Long matkaId, Model model) {
		model.addAttribute("matka", repository.findById(matkaId));
		model.addAttribute("kulkuvalineet", krepository.findAll());
		model.addAttribute("osallistujat", orepository.findAll());
		return "muutamatka";
	}
	
	
	
}
