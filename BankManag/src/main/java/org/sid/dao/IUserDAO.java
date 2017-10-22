package org.sid.dao;

import org.sid.entities.User;

public interface IUserDAO {
	
	public User addUser(User user);
	public User updateUser(User user);
	public void removeUser(User user);
	
	public String login(String username, String password);

}
