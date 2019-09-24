package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet {

	@Inject
	private INewService newService;

	private static final long serialVersionUID = -915988021506484384L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newModel = newService.save(newModel);
		System.out.println(newModel);
	}

	/*
	 * @Override protected void doPut(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * 
	 * }
	 * 
	 * @Override protected void doDelete(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * 
	 * }
	 */
}
