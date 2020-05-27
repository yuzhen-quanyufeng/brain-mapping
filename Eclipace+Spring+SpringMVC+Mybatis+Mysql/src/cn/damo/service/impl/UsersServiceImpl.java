package cn.damo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.damo.dao.UsersDao;
import cn.damo.entity.Users;
import cn.damo.service.UsersService;

@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersDao usersDao;


	@Override
	public List<Users> getAllUsers(){
		List<Users> list = null;
		try {
			list = usersDao.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class,readOnly = false)
	public Integer addUsers(Users users) {
		Integer result = 0;
		try {
			result = usersDao.addUsers(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class,readOnly = false)
	public Integer delUsers(Integer id) {
		Integer result = 0;
		try {
			result = usersDao.delUsers(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class,readOnly = false)
	public Integer updateUsers(Users users) {
		Integer result = 0;
		try {
			result = usersDao.updateUsers(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Users getById(Integer id) {
		Users users = null;
		try {
			users = usersDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

}
