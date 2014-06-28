package www.csdn.net.service;

import java.util.List;

import www.csdn.net.domain.User;

public interface UserService {
	public User login(String name, String pass);

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
	public User findByName(String  name);

}
