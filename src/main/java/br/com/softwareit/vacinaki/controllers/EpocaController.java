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
import br.com.softwareit.vacinaki.models.Epoca;
import br.com.softwareit.vacinaki.models.enuns.TempoEnum;

@Controller
@RequestMapping("/epoca")
@Transactional
public class EpocaController {

	@Autowired
	private EpocaDao epocaDao;

	@RequestMapping("/form")
	public ModelAndView form(Epoca epoca) {
		ModelAndView modelAndView = new ModelAndView("epoca/form-add");
		modelAndView.addObject("listaUnidadesTempo", TempoEnum.values());
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Epoca epoca, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(epoca);
		}
		epocaDao.save(epoca);
		return new ModelAndView("redirect:/epoca");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("epoca/form-update");
		modelAndView.addObject("epoca", epocaDao.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(
			@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("epoca/list");
		modelAndView.addObject("paginatedList", epocaDao.paginated(page, 10));
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Epoca epoca = epocaDao.findById(id);
		epocaDao.remove(epoca);
		return "redirect:/epoca";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id,
			@Valid Epoca epoca, BindingResult bindingResult) {
		epoca.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("epoca/form-update");
		}
		epocaDao.update(epoca);
		return new ModelAndView("redirect:/epoca");
	}
}
