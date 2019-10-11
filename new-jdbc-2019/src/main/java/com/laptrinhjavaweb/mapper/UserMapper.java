package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel user = new UserModel();
		try {
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setFullName(resultSet.getString("fullname"));
			user.setRoleId(resultSet.getLong("roleid"));
			user.setCreatedDate(resultSet.getTimestamp("createddate"));
			user.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				user.setModifiledDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				user.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return user;
		} catch (SQLException e) {
			return null;
		}
	}
}
