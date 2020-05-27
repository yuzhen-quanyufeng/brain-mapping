package cn.damo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.damo.entity.Users;
import cn.damo.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		model.addAttribute("list", usersService.getAllUsers());
		return "index";
	}
	
	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	public String getById(@RequestParam("id")Integer id,Model model) {
		model.addAttribute("users",usersService.getById(id));
		return "update";
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateUsers",method = RequestMethod.POST)
	public String updateUsers(Users users) {
		return String.valueOf(usersService.updateUsers(users));
	}
	
	@ResponseBody
	@RequestMapping(value = "/addUsers",method = RequestMethod.POST)
	public String addUsers(Users users) {
		return String.valueOf(usersService.addUsers(users));
	}
	
	@ResponseBody
	@RequestMapping(value = "/delUsers",method = RequestMethod.GET)
	public String delUsers(@RequestParam("id")Integer id) {
		return String.valueOf(usersService.delUsers(id));
	}
	
	
	
	
	
}
