package cn.damo.dao;

import java.util.List;

import cn.damo.entity.Users;

public interface UsersDao {

	public List<Users> getAllUsers();
	
	public Integer addUsers(Users users);
	
	public Integer delUsers(Integer id);
	
	public Integer updateUsers(Users users);
	
	public Users getById(Integer id);
	
}
