package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		String sql = "SELECT * FROM user WHERE username = ? AND password = ? AND status = ?";
		List<UserModel> users = query(sql, new NewMapper(), userName, password, status);
		return news.isEmpty() ? null : news.get(0);
	}
	
}
