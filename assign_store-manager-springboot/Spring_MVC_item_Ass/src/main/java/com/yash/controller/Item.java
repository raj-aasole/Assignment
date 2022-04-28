package com.yash.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Item
{
	@RequestMapping("/item")
	public String itempage()
	{
		return "item";
	}
	@RequestMapping("/addItem")
	public String ItemSubmit(HttpServletRequest req,Model m )
	{
		
		String ITMname = req.getParameter("itmName");
		String ITMprice = req.getParameter("itmPrice");
		String ITMquantity = req.getParameter("itmQuantity");
		String ITMdiscount = req.getParameter("itmDiscount");
		int price = Integer.parseInt(ITMprice);
		int c = Integer.parseInt(ITMdiscount);
		int z = Integer.parseInt(ITMquantity);
		int x= price*z;
		int d = (x * c) / 100;
		int discountprice= x-d;

		m.addAttribute("ITMN", ITMname);
		m.addAttribute("ITMP", ITMprice);
		m.addAttribute("ITMQT", ITMquantity);
		m.addAttribute("ITMD", ITMdiscount);
		m.addAttribute("ITMDP", discountprice);
	
		return "show";
	}
}
