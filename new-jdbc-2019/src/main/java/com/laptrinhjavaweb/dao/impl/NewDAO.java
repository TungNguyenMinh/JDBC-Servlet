package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		ResultSet resultSet = null;
		try {
			String sql = "INSERT INTO news (title, content, categoryid) VALUES (?, ?, ?)";
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newModel.getTitle());
			statement.setString(2, newModel.getContent());
			statement.setLong(3, newModel.getCategoryId());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				return resultSet.getLong(1);
			}
			return null;
		} catch (SQLException e) {
			return null;
		}
	}
}
