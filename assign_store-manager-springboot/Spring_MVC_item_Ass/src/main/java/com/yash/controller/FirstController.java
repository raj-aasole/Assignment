package com.yash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController 
{
	 @RequestMapping(value="/m1")
	 public String m1()
	 {
		 System.out.println("Hello namdev and nilesh");
		// System.out.println("hello namdev and nilesh");
		 return "index";
		 // controller return the name of view page which need to be shown
	 }
	 
	 
}
 