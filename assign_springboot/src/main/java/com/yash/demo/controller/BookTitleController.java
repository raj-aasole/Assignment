package com.yash.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yash.demo.dao.bookTitleDao;
import com.yash.demo.model.Booktitle;


@Controller
public class BookTitleController {
	@Autowired
	bookTitleDao btd;
	
	
	 @RequestMapping(value="/saveb")
	   public String  m2(){
		return "booktitlepage";
	   		}
	   
		@RequestMapping(value="/savebooktitle", method= RequestMethod.POST)
		public ModelAndView saveBooktitle(@ModelAttribute Booktitle bt) {
			ModelAndView objmv= new ModelAndView();
			
			if(btd.addBooktitle(bt)==1) {
				objmv.setViewName("successbooktitle");
				objmv.addObject("booktitle", bt);
				return objmv;
			}
			else {
				objmv.setViewName("booktitlepage");
				return objmv;
			}
		}
		@RequestMapping(value="/showallbooktitle")
		public ModelAndView allbooktitle() {
			List<Booktitle> bli= btd.getAllbooktitle();
			ModelAndView mv= new ModelAndView();
			mv.addObject("bli", bli);
			mv.setViewName("Allbooktitle");
			return mv;
			
		}
		//edit method 
		
		@RequestMapping(value="/editbooktitle/{btid}")
		public ModelAndView showEditForm(@PathVariable (name="btid") int btid) {
			ModelAndView mav= new ModelAndView("edit_form_b");
		    Booktitle booktitle = btd.get(btid);
		    mav.addObject("booktitle", booktitle);
		    return mav;
		}
		
		
		@RequestMapping(value = "/updateb", method = RequestMethod.POST)
		public String update(@ModelAttribute("booktitle") Booktitle booktitle) {
		    btd.update(booktitle); 
		    return "redirect:/showallbooktitle";
		}
		
		// delete method
		@RequestMapping(value="/deleteb/{btid}")
		public String delete(@PathVariable(name = "btid") int btid) {
		    btd.delete(btid);
		    return "redirect:/showallbooktitle";      
		}
		
}
