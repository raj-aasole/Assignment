package com.yash.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yash.demo.dao.autherDao;
import com.yash.demo.model.Auther;

@Controller
public class AutherController {
	@Autowired
	autherDao objadao;
	
	@RequestMapping(value="/")
	public String m() {
		
		System.out.println("hello index method working");
		return"index";
			}
	// Methods for auther...

	   @RequestMapping(value="/savea")
	   public String  m1(){
		return "autherpage";
	   		}
	   
		@RequestMapping(value="/saveauther", method= RequestMethod.POST)
		public ModelAndView saveAuther(@ModelAttribute Auther auther) {
			ModelAndView objmv= new ModelAndView();
			
			if(objadao.addAuther(auther)==1) {
				objmv.setViewName("successauther");
				objmv.addObject("auther", auther);
				return objmv;
			}
			else {
				objmv.setViewName("autherpage");
				return objmv;
			}
		}
		@RequestMapping(value="/showallauther")
		public ModelAndView allAuther() {
			List<Auther> ali= objadao.getAllAuther();
			ModelAndView mv= new ModelAndView();
			mv.addObject("ali", ali);
			mv.setViewName("AllAuther");
			return mv;
			
		}
		//edit method 
		
		@RequestMapping(value="/editauther/{auid}")
		public ModelAndView showEditForm(@PathVariable (name="auid") int auid) {
			ModelAndView mav= new ModelAndView("edit_form");
		    Auther auther = objadao.get(auid);
		    mav.addObject("auther", auther);
		    return mav;
		}
		
		
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(@ModelAttribute("auther") Auther auther) {
		    objadao.update(auther); 
		    return "redirect:/showallauther";
		}
		// delete method
		@RequestMapping(value="/delete/{auid}")
		public String delete(@PathVariable(name = "auid") int auid) {
		    objadao.delete(auid);
		    return "redirect:/showallauther";      
		}
}
