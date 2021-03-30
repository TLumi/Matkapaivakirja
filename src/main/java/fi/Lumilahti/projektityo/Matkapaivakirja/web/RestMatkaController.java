package fi.Lumilahti.projektityo.Matkapaivakirja.web;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Kulkuvaline;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.KulkuvalineRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Matka;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.MatkaRepository;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.Osallistuja;
import fi.Lumilahti.projektityo.Matkapaivakirja.domain.OsallistujaRepository;

@RestController

public class RestMatkaController {
	
	
	@Autowired
	private MatkaRepository repository;
	
	@Autowired
	private OsallistujaRepository orepository;
	
	@Autowired
	private KulkuvalineRepository krepository;
	
	//palauta kaikki matkat
			
	@RequestMapping(value="/matkat", method = RequestMethod.GET)
	public @ResponseBody List<Matka> matkaListaRest() {	
	        return (List<Matka>) repository.findAll();
	    } 
	

	//palauttaa kaikki osallistujat
	
	@RequestMapping(value="/osallistujat", method = RequestMethod.GET)
	public @ResponseBody List<Osallistuja> osallistujaListaRest() {	
	        return (List<Osallistuja>) orepository.findAll();
	    } 

	// palauttaa kulkuvälineet
	
	@RequestMapping(value="/kulkuvalineet", method = RequestMethod.GET)
	public @ResponseBody List<Kulkuvaline> kulkuvalineListaRest() {	
	        return (List<Kulkuvaline>) krepository.findAll();
	    } 
	
	
	//palauttaa matkan id:n perusteella
	
	@RequestMapping(value="/matka/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Matka> findMatkaRest(@PathVariable("id") Long matkaId) {	
        return repository.findById(matkaId);
	    } 
	
	
	@RequestMapping(value="/osallistuja/{osallistujaId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Osallistuja> findOsallistujaRest(@PathVariable("id") Long osallistujaId) {	
        return orepository.findById(osallistujaId);
	    } 
	
	@RequestMapping(value="/kulkuvaline/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Kulkuvaline> findKulkuvalineRest(@PathVariable("id") Long kulkuvalineId) {	
        return krepository.findById(kulkuvalineId);
	    } 



}
