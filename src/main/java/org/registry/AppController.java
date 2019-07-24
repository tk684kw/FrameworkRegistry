package org.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private FrameworkService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model, @RequestParam(defaultValue="") String name) {
		model.addAttribute("listFrameworks", service.findByName(name));
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewFrameworkPage(Model model) {
		model.addAttribute("framework", new Framework());
		
		return "new_framework";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveFramework(@ModelAttribute("framework") Framework framework) {
		service.save(framework);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditFrameworkPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_framework");
		mav.addObject("framework", service.get(id));
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteFramework(@PathVariable(name = "id") int id) {
		service.delete(id);
		
		return "redirect:/";		
	}
}
