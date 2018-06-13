package it.simone.webApp.Dao;

import java.util.List;
import java.util.Map;

import it.simone.webApp.model.User;

public interface UserDao {

	public void saveUser(User us);

	public List<User> getUser();

	public List<User> getUserById(int id);

	public List<User> getUserbByField(String field, Object value);

	public List<User> getUserbByFields(Map<String, Object> values) throws Exception;

}
