package com.xuxx.spike.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuxx.spike.dao.IUserDao;
import com.xuxx.spike.entity.User;
import com.xuxx.spike.service.IUserService;
import com.xuxx.spike.vo.user.UserVO;

@Service
@org.apache.dubbo.config.annotation.Service(interfaceClass = IUserService.class)
public class IUserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;

	public void insertUser(User user) {
		userDao.add(user);
	}

	public User queryUserById(String id) {
		return userDao.getById(id);
	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public void deleteUserById(String id) {
		userDao.delete(id);
	}

	public List<User> queryUserByVO(UserVO userVO) {
		return userDao.listByVO(userVO);
	}

	public User queryUserByUserAccount(String userAccount) {
		return userDao.getByUserAccount(userAccount);
	}
}
