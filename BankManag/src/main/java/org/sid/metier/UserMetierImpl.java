package org.sid.metier;

import org.sid.dao.IUserDAO;
import org.sid.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserMetierImpl implements IUserMetier {
	
	private IUserDAO daou;
	
	@Override
	public User addUser(User user) {
		return daou.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		return daou.updateUser(user);
	}

	@Override
	public void removeUser(User user) {
		daou.removeUser(user);
		
	}

	@Override
	public String login(String username, String password) {
		return daou.login(username, password);
	}

	public IUserDAO getDaou() {
		return daou;
	}

	public void setDaou(IUserDAO daou) {
		this.daou = daou;
	}

}
