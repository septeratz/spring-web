package edu.fisa.ce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
	
	@GetMapping("ce")
	public String m1() {
		System.out.println("test");
		
		return "한글";
	}
	
	/* 요청시 처리 후 출력은 test.jsp에게 위임
	 */
	@GetMapping("/ce2")
	public ModelAndView m2() {
		System.out.println("m2()");
		ModelAndView mv = new ModelAndView();
		
		// request.setAttribute("message", "메시지");
		mv.addObject("message", "메시지");
		mv.setViewName("test"); // 화면 지정, test.jsp
		
		// forward(request, response);
		return mv; // jsp로 web page 이동: forwarding
	}
	@GetMapping("/test")
    public String testPage() {
		System.out.println("---");
        return "test라는 단순 문자열"; 
    }
}
