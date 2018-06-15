package it.simone.webApp.controller;

import java.sql.Timestamp;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.simone.webApp.model.User;
import it.simone.webApp.service.ServiceUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	ServiceUser serv;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}." + locale);

		salvaUser();

		// List<User> lista = serv.getUserbByField("nome", "simone");
		// List<User> lista = serv.getUser();

		// Map<String, Object> values = new HashMap<String, Object>();
		// values.put("nome", "simone");
		// values.put("cognome", "bedotti2");
		// List<User> lista = null;
		// try {
		// lista = serv.getUserbByFields(values);
		// } catch (Exception e) {
		// logger.error(e.getMessage());
		// }
		//
		// if (lista != null && lista.size() > 0) {
		// for (User user : lista) {
		// logger.info(user);
		// }
		// } else {
		// logger.info("nessun elemento trovato");
		// }
		return "home";
	}

	private void salvaUser() {
		User us = new User();
		us.setNome("simoneaadd");
		us.setCognome("bedotti2");
		us.setMail("nuova");
		us.setData_creazione(new Timestamp(System.currentTimeMillis()));
		logger.info("ora salvo il nuovo utente");
		boolean error = false;
		try {
			serv.saveUser(us);

		} catch (ConstraintViolationException e) {
			logger.error("user già presente");
			error = true;
		}
	}

}
