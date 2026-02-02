/* Spring API를 활용하여 세션, 쿠키 개발 및 활용 기술
 * index.html 
 * 	-> MySubControllerTracking: 세션 또는 쿠키 생성
 * 		-> JSP: 세션 또는 쿠키 활용
 * 세션 삭제(logout) 로직까지 진행
 */
package edu.fisa.ce;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.fisa.ce.model.domain.Emp2;



@Controller
// 공통 url 선언
@RequestMapping("/ce") // http://ip:port/fisa/ce/??
@SessionAttributes({"id"}) // 세션에 사용하고자 하는 key 선언 및 등록하는 어노테이션
public class MySubControllerTracking {
	// 입력된 data(web query string, getParameter())
	// 가입
	
	/* login이라 가정
	 * id/pw값 받고 세션에 저장 -> webapp/welcome.jsp로 redirect로 이동
	 * 이동된 jsp에서 id값 활용
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginCheck(@RequestParam("id") String id,
							@RequestParam("pw") int pw, Model session) {
		System.out.println("loginCheck() --- " + id + " " + pw);
		
		
		session.addAttribute("id", id);
		
		return "redirect:/welcome.jsp";
	}
	
	/* @SessionAttributes({"id"}) / Model session / session.setAttribute("id", id);
	 * -> 세션을 무효화
	 * 
	 */
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(SessionStatus session, @ModelAttribute("id") String id) {
		System.out.println("logout() --- ");
		
		session.setComplete();
		
		return "redirect:/welcome.jsp";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ModelAndView add(Emp2 emp) {
		System.out.println(emp);
		// 요청 객체에 저장, jsp 출력
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", emp); // toString lombok 내장되어 있어서 이렇게 넣어도 그대로 들어감
		mv.addObject("loc", "상암");
		
		// 한명의 직원 정보 출력 화면
		mv.setViewName("emponeinfoview");
		
		return mv;
	}

}
