package com.daiderong.test.dubbo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.daiderong.test.dubbo.model.User;
import com.daiderong.test.dubbo.service.UserService;

/**
 * 用户 注册 ，列表等 测试Controller
 * @ClassName: UserTestController
 * @author daiderong
 * @date 2017年8月8日 下午6:13:07
 *
 */
@Controller
public class UserTestController {

	@Value(value = "register")
	private String registerView;
	@Value(value = "userlist")
	private String userlistView;

	@Reference
	private UserService userService;

	@RequestMapping(value = "register.htm", method = RequestMethod.GET)
	public String register(User user) {

		return registerView;
	}

	@RequestMapping(value = "register.htm", method = RequestMethod.POST)
	@ResponseBody
	public String registerSubmit(User user) {

		// 判断是否存在
		User oldUser = userService.getByUsername(user.getUsername());
		if (oldUser != null) {
			return "exists user!!!";
		}
		userService.register(user);
		return "success";
	}

	@RequestMapping(value = "userlist.htm")
	public String userlist(Model model) {

		List<User> list = userService.loadAll();
		model.addAttribute("userlist", list);
		return userlistView;
	}

}
