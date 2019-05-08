package com.xuxx.spike.service;

import java.util.List;

import com.xuxx.spike.entity.User;
import com.xuxx.spike.vo.user.UserVO;


public interface IUserService {
	
	public void insertUser(User user);
	
	public User queryUserById(String id);
	
	public void updateUser(User user);
	
	public void deleteUserById(String id);
	
	public List<User> queryUserByVO(UserVO userVO);
	
	public User queryUserByUserAccount(String userAccount);
	
}
