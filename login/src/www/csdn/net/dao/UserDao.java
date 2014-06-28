package www.csdn.net.dao;

import java.util.List;

import www.csdn.net.domain.User;
/**
 * 
 * 登陆验证方法
 *
 */
public interface UserDao {
public User login(String name,String pass);
public boolean insert(User entity);
/**
 * 删除实体
 */
public boolean delete(User entity);
	/**
	 * 更新实体的操作
	 */
public boolean update(User entity);
	/**
	 * 根据主键查询具体的某个实体
	 */
public User findByName(String name);
	
}

