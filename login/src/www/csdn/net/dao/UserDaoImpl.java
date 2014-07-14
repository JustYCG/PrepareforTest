package www.csdn.net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.xml.ws.Response;

import www.csdn.net.domain.User;
import www.csdn.net.util.DBManger;

public class UserDaoImpl implements UserDao {
	public User login(String name, String pass) {
		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBManger.getConnection();
			String sql = "select id,name,pass,logintime from user where name = ? and pass=? ";
			System.out.println(sql);
			ps = con.prepareStatement(sql);
			int index = 1;
			ps.setString(index++, name);
			ps.setString(index++, pass);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setLoginTime(rs.getTimestamp("logintime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.dbClose(rs, ps, con);
		}
		return user;
	}

	public boolean insert(User entity) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManger.getConnection();
			String sql = "insert into user(name,pass,logintime) values (?,?,?)";
			ps = con.prepareStatement(sql);
			int index = 1;
			ps.setString(index++, entity.getName());
			ps.setString(index++, entity.getPass());
			ps.setDate(index++, new java.sql.Date(System.currentTimeMillis()));
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
			}
			DBManger.dbClose1(ps, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean delete(User entity) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBManger.getConnection();
			String name = entity.getName();
			String sql = "delete from user where name=?";
			ps = con.prepareStatement(sql);
			System.out.println(sql);
			int index = 1;
			ps.setString(1, name);
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
			}
			DBManger.dbClose1(ps, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(User entity) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManger.getConnection();
			String pass = entity.getPass();
			String name = entity.getName();
			String sql = "update user set pass =? where name =?";
			ps = con.prepareStatement(sql);
			int index = 1;
			ps.setString(1, pass);
			ps.setString(2, name);
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
			}
			DBManger.dbClose1(ps, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public User findByName(String name) {
		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBManger.getConnection();
			String sql = "select * from user where name =?";
			ps = con.prepareStatement(sql);
			int index = 1;
			ps.setString(1, name);
		    rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setLoginTime(rs.getTimestamp("logintime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.dbClose(rs, ps, con);
		}
		return user;
	}
}
