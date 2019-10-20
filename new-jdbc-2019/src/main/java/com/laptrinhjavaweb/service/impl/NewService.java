package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;

	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");// chưa xử lý đăng nhập buff use vào để empty
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiledDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");// chưa xử lý đăng nhập buff use vào để
									// empty
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			// 1. delete comment (khoá ngoại new_id)
			// 2. delete news
			newDao.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	@Override
	public NewModel findOne(long id) {
		NewModel newModel = newDao.findOne(id);
		CategoryModel categoryModel = categoryDao.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}
}
