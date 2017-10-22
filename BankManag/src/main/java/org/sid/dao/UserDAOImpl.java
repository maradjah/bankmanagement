package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.User;

public class UserDAOImpl implements IUserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User addUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		em.merge(user);
		return user;
	}

	@Override
	public void removeUser(User user) {
		em.remove(user);
	}

	@Override
	public String login(String username, String password) {

		String pass = "";
		Query query = em
				.createNativeQuery("select u.password from User u where u.username =:x");
		query.setParameter("x", username);
		pass = (String) query.getSingleResult();
		System.out.println("pass dao : " + pass);

		return pass;
	}
}
