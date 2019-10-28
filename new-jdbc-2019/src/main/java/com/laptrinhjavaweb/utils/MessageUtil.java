package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

import com.laptrinhjavaweb.com.constant.SystemConstant;

public class MessageUtil {
	public static void showMessage(HttpServletRequest request) {

		if (request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if (message.equals("insert_success")) {
				messageResponse = "Insert_success";
				alert = "success";
			} else if (message.equals("update_success")) {
				messageResponse = "Update_success";
				alert = "success";
			} else if (message.equals("delete_success")) {
				messageResponse = "Delete_success";
				alert = "success";
			} else if (message.equals("error_system")) {
				messageResponse = "Error_system";
				alert = "danger";
			}
			request.setAttribute("messageResponse", messageResponse);
			request.setAttribute("alert", alert);
		}
	}
}
