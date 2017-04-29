package br.com.softwareit.vacinaki.controllers;

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
import br.com.softwareit.vacinaki.daos.VacinaDao;
import br.com.softwareit.vacinaki.models.Epoca;
import br.com.softwareit.vacinaki.models.Vacina;

@Controller
@RequestMapping("/vacina")
@Transactional
public class VacinaController {

	@Autowired
	private VacinaDao vacinaDao;
	
	@Autowired
	private EpocaDao epocaDao;

	@RequestMapping("/form")
	public ModelAndView form(Vacina vacina) {
		ModelAndView modelAndView = new ModelAndView("vacina/form-add");
		modelAndView.addObject("listaEpocas", epocaDao.all());
//		modelAndView.addObject("epoca", new Epoca());
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Vacina vacina, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(vacina);
		}
		
		vacina.setEpoca(epocaDao.findById(vacina.getIdEpoca()));
		
		vacinaDao.save(vacina);
		return new ModelAndView("redirect:/vacina");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("vacina/form-update");
		Vacina vacina = vacinaDao.findById(id);
		vacina.setEpoca(epocaDao.findById(vacina.getIdEpoca()));
		modelAndView.addObject("vacina", vacina);
		modelAndView.addObject("listaEpocas", epocaDao.all());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(
			@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("vacina/list");
		modelAndView.addObject("paginatedList", vacinaDao.paginated(page, 10));
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Vacina vacina = vacinaDao.findById(id);
		vacinaDao.remove(vacina);
		return "redirect:/vacina";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id,
			@Valid Vacina vacina, BindingResult bindingResult) {
		vacina.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("vacina/form-update");
		}
		vacina.setEpoca(epocaDao.findById(vacina.getIdEpoca()));
		vacinaDao.update(vacina);
		return new ModelAndView("redirect:/vacina");
	}
}
