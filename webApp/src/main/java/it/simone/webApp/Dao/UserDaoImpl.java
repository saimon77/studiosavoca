package it.simone.webApp.Dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.simone.webApp.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveUser(User us) {
		logger.info("sono in save dao");
		Session s = getSession();
		s.save(us);

	}

	@Override
	public List<User> getUser() {
		Session s = getSession();
		List<User> list = null;
		Criteria cr = s.createCriteria(User.class);

		list = cr.list();
		return list;
	}

	@Override
	public List<User> getUserById(int id) {
		Session s = getSession();
		List<User> list = null;
		SQLQuery q = s.createSQLQuery("select * from user where id=" + id);
		q.addEntity(User.class);
		list = q.list();
		return list;
	}

	@Override
	public List<User> getUserbByField(String field, Object value) {
		List<User> lista = null;
		Criteria cr = getSession().createCriteria(User.class);
		cr.add(Restrictions.eq(field, User.getType(field).cast(value)));
		lista = cr.list();

		return lista;
	}

	@Override
	public List<User> getUserbByFields(Map<String, Object> values) throws Exception {
		if (values == null || values.isEmpty())
			throw new Exception("valori non presenti");

		List<User> lista = null;

		Criteria cr = getSession().createCriteria(User.class);
		cr.add(Restrictions.allEq(values));
		lista = cr.list();
		return lista;
	}

}
