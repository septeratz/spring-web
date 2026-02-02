/* Spring API를 활용한 WebPage 이동 */

package edu.fisa.ce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MySubController {
	
	@RequestMapping(value = "step03" ,method = RequestMethod.GET )
	public String step03() {
		System.out.println("step03 ---");
		return "forward:/test.jsp";
		
	}
	
	// redirect로 test.jsp 호출
	/* application.yml에 설정된 위치가 아니라 일반 jsp 경로의 파일로도 이동 가능
	 * 
	 * ModelAndView API 필요성이 없기 때문에, 즉 요청 객체에 새 데이터를 저장할 필요가 없는 경우
	 * 단순 String 반환으로 jsp로 redirect 이동으로 구현
	 */
	@RequestMapping(value = "step02" ,method = RequestMethod.GET )
	public String step02() {
		System.out.println("step02 ---");
		// http://localhost:81/fisa/test.jsp
		return "redirect:/test.jsp";
		
	}
	
	// index.html의 2번 링크 실행 - get 방식
	/* ModelAndView API 활용, ce1.jsp 이동
	 * 
	 */
	@RequestMapping(value = "/step01",method = RequestMethod.GET)
	public ModelAndView step01() {
		System.out.println("step01 ---");
		ModelAndView mv = new ModelAndView();
		// 요청 객체에 짝꿍 이름 저장
		mv.addObject("name", "소연");
		
		// view 지정
		mv.setViewName("ce1");
		return mv;
	}

}
