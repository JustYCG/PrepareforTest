package www.csdn.net.service;

import java.util.List;

import www.csdn.net.dao.UserDao;
import www.csdn.net.dao.UserDaoImpl;
import www.csdn.net.domain.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	public User login(String name, String pass) {
		User entity = userDao.login(name, pass);
		return entity;
	}

	public boolean insert(User entity) {
		return userDao.insert(entity);
	}

	public boolean delete(User entity) {
		// TODO Auto-generated method stub
		return userDao.delete(entity);
	}

	public User findByName(String name){
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return userDao.update(entity);
	}
}
