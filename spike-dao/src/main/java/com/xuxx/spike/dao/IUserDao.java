package com.xuxx.spike.dao;

import java.util.List;

import com.xuxx.spike.entity.User;
import com.xuxx.spike.vo.user.UserVO;

public interface IUserDao {
	public void add(User user);
	public User getById(String id);
	public void update(User user);
	public void delete(String id);
	public List<User> listByVO(UserVO userVO);
	public User getByUserAccount(String userAccount);
 }
