package it.simone.webApp.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.simone.webApp.Dao.UserDao;
import it.simone.webApp.model.User;

@Service
public class ServiceUserImpl implements ServiceUser {

	private static final Logger logger = Logger.getLogger(ServiceUserImpl.class);

	@Autowired
	private UserDao dao;

	@Override
	@Transactional
	public void saveUser(User us) {
		logger.info("sono in save service");
		dao.saveUser(us);

	}

	@Override
	@Transactional
	public List<User> getUser() {
		return dao.getUser();
	}

	@Override
	@Transactional
	public List<User> getUserById(int id) {
		return dao.getUserById(id);
	}

	@Override
	@Transactional
	public List<User> getUserbByField(String field, Object value) {
		return dao.getUserbByField(field, value);
	}

	@Override
	@Transactional
	public List<User> getUserbByFields(Map<String, Object> values) throws Exception {
		return dao.getUserbByFields(values);
	}

}
