package controller.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value="hello",method=RequestMethod.GET)
	public String helloMethod(Model model) {
		
		model.addAttribute("demo","hello world");
		return "hello";
		
	}
	
	@RequestMapping(value="/helloTest",method=RequestMethod.POST)
	public ModelAndView helloTestMethod(ModelMap model,@RequestParam String name) {
		
		model.addAttribute("demo","hello world"+name.toString());
		
		return new ModelAndView("hello");
		
	}
	
	
}
