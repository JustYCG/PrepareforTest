package www.csdn.net.dao;

import java.util.List;

import www.csdn.net.domain.User;
/**
 * 
 * ��½��֤����
 *
 */
public interface UserDao {
public User login(String name,String pass);
public boolean insert(User entity);
/**
 * ɾ��ʵ��
 */
public boolean delete(User entity);
	/**
	 * ����ʵ��Ĳ���
	 */
public boolean update(User entity);
	/**
	 * ����������ѯ�����ĳ��ʵ��
	 */
public User findByName(String name);
	
}

