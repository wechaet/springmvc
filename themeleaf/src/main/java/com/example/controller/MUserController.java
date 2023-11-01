package com.example.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.example.po.Address;
import com.example.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.po.MUser;
import com.example.service.MUserServiceI;

@Controller
@RequestMapping("/")
public class MUserController {
	@Autowired
	private MUserServiceI muserService;

	@RequestMapping(value="/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value="/addUserPage")
	public String addUserPage(Model model) {
		return "addUser";
	}


	@RequestMapping(value="/listUser")
	public String listUser(HttpServletRequest request) {
		
		List <MUser> list = muserService.getAll();
		request.setAttribute("userlist", list);
		return "listUser";
	}
	
	@RequestMapping(value="/addUser")
	public String addUser(MUser muser) {
			
		String id = UUID.randomUUID().toString();
		muser.setId(id);
		muserService.insert(muser);
		return "redirect:/listUser";
	}
	
	@RequestMapping(value="/deleteUser")
	public String deleteUser(String id) {
		
		muserService.delete(id);
		return "redirect:/listUser";
	}
	
	@RequestMapping(value="/updateUserUI")
	/*public String updateUserUI(String id, HttpServletRequest request) {
		
		MUser muser = muserService.selectByPrimaryKey(id);
		request.setAttribute("user", muser);
		return "updateUser";
	}*/
	public String updateUserUI(String id, Model model) {

		MUser muser = muserService.selectByPrimaryKey(id);
		model.addAttribute("user", muser);
		return "updateUser";
	}

	@RequestMapping(value="/updateUser")
	public String updateUser(MUser muser) {
		
		muserService.update(muser);
		return "redirect:/listUser";
	}
}
