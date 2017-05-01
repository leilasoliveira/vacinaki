package br.com.softwareit.vacinaki.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.softwareit.vacinaki.daos.EpocaDao;
import br.com.softwareit.vacinaki.daos.PaginatorQueryHelper;
import br.com.softwareit.vacinaki.daos.VacinaDao;
import br.com.softwareit.vacinaki.models.PaginatedList;
import br.com.softwareit.vacinaki.models.Vacina;

@Controller
@RequestMapping("/vacina")
@Transactional
public class VacinaController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private VacinaDao vacinaDao;
	
	@Autowired
	private EpocaDao epocaDao;

	@RequestMapping("/form")
	public ModelAndView form(Vacina vacina) {
		ModelAndView modelAndView = new ModelAndView("vacina/form-add");
		modelAndView.addObject("listaEpocas", epocaDao.all());
		return modelAndView;

	}

	@RequestMapping(params ="more" , method = RequestMethod.POST)
	public ModelAndView saveAndAddMore(@Valid Vacina vacina, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(vacina);
		}
		
		vacina.setEpoca(epocaDao.findOne(vacina.getIdEpoca()));
		vacinaDao.save(vacina);
		return new ModelAndView("redirect:/vacina/form");
	}
	
	@RequestMapping(params = "save", method = RequestMethod.POST)
	public ModelAndView save(@Valid Vacina vacina, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(vacina);
		}
		
		vacina.setEpoca(epocaDao.findOne(vacina.getIdEpoca()));
		
		vacinaDao.save(vacina);
		return new ModelAndView("redirect:/vacina");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("vacina/form-update");
		Vacina vacina = vacinaDao.findOne(id);
		vacina.setEpoca(epocaDao.findOne(vacina.getIdEpoca()));
		modelAndView.addObject("vacina", vacina);
		modelAndView.addObject("listaEpocas", epocaDao.all());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(
			@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("vacina/list");
		
		modelAndView.addObject("paginatedList", all(page, 10));
		return modelAndView;
	}
	
	private PaginatedList all(int page, int resultsPerPage) {
		TypedQuery<Vacina> listQuery = manager.createQuery("select v from Vacina v join v.epoca e order by v.nome asc, e.ordem asc", Vacina.class);
		
		TypedQuery<Number> countQuery = manager.createQuery(
	            "select count(1) from Vacina v join v.epoca e", Number.class);
		
		return new PaginatorQueryHelper().list(listQuery, countQuery, page, resultsPerPage);
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Vacina vacina = vacinaDao.findOne(id);
		vacinaDao.delete(vacina);
		return "redirect:/vacina";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id,
			@Valid Vacina vacina, BindingResult bindingResult) {
		vacina.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("vacina/form-update");
		}
		vacina.setEpoca(epocaDao.findOne(vacina.getIdEpoca()));
		vacinaDao.save(vacina);
		return new ModelAndView("redirect:/vacina");
	}
}
