package com.yash.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yash.demo.dao.PublisherDao;
import com.yash.demo.model.Publisher;

 @Controller
public class PublisherController {
	
	@Autowired
	PublisherDao pd;
		
		
		 @RequestMapping(value="/savep")
		   public String  m3(){
			return "publisherpage";
		   		}
		 
		   
			@RequestMapping(value="/savepublisher", method= RequestMethod.POST)
			public ModelAndView saveAuther(@ModelAttribute Publisher publisher) {
				ModelAndView objmv= new ModelAndView();
				
				if(pd.addPublishe(publisher)==1) {
					objmv.setViewName("successpublisher");
					objmv.addObject("publisher", publisher);
					return objmv;
				}
				else {
					objmv.setViewName("publisherpage");
					return objmv;
				}
			}
			@RequestMapping(value="/showallpublisher")
			public ModelAndView allpublisher() {
				List<Publisher> pli= pd.getAllPublisher();
				ModelAndView mv= new ModelAndView();
				mv.addObject("pli", pli);
				mv.setViewName("AllPublisher");
				return mv;
				
			}
			
			//edit method 
			
			@RequestMapping(value="/editpublisher/{pubid}")
			public ModelAndView showEditForm(@PathVariable (name="pubid") int pubid) {
				ModelAndView mav= new ModelAndView("edit_form_p");
			    Publisher publisher = pd.get(pubid);
			    mav.addObject("publisher", publisher);
			    return mav;
			}
			
			
			@RequestMapping(value = "/updatep", method = RequestMethod.POST)
			public String update(@ModelAttribute("publisher") Publisher publisher) {
			    pd.update(publisher); 
			    return "redirect:/showallpublisher";
			}
			
			// delete method
			@RequestMapping(value="/deletep/{pubid}")
			public String delete(@PathVariable(name = "pubid") int pubid) {
			    pd.delete(pubid);
			    return "redirect:/showallpublisher";      
			}
			
}

