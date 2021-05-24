package com.huongdanjava.springboot.internationalization;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String home() {
		return "home";
	}
}