package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data.SQLDBDao;


@Controller
public class GuiController {

	@Autowired
	private SQLDBDao dao;
	
	
	@RequestMapping(path="process.do", 
			params="param", 
			method=RequestMethod.POST)
	public ModelAndView getEmployeeById(String param) {
		List<List<String>> results = dao.getQueryResults(param);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("results", results);
		mv.addObject("headers", dao.getHeaders(param));
		return mv;
	}


}
