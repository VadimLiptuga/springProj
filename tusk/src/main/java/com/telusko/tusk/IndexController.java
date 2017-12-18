package com.telusko.tusk;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.tusk.dao.FeedbackDao;
import com.telusko.tusk.entity.Feedback;

@Controller
public class IndexController {
	
	@Autowired
	FeedbackDao fdao;
	
	Feedback feedback;
	
	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest  request, HttpServletResponse response) {
		int i = Integer.parseInt(request.getParameter("t1"));
		int j = Integer.parseInt(request.getParameter("t2"));
		int k = i + j;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result", k);
		
		return mv;
	}
	
	@RequestMapping("/feedback.htm")
	public String feedback() {
		return "feedback.jsp";
	}
	
	@RequestMapping("/addFeedback")
	//public String addFeedback(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("reg") String reg, @RequestParam("code") String code, @RequestParam("msg") String msg, @RequestParam("rating") int rating) {
	public String addFeedback(@ModelAttribute("feedback") Feedback feedback) {
		//feedback = new Feedback(name, email, reg, code, rating);
		fdao.addFeedback(feedback);
		return "welcome.jsp";
	
	}

}
