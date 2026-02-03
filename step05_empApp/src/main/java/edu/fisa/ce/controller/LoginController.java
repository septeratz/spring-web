package edu.fisa.ce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.fisa.ce.service.CompanyService;

@SessionAttributes({"empno", "ename"})
@Controller
public class LoginController {
	/* CompanyController와 LoginController에는 같은 타입의 변수가 선언되어 있음
	 * 질문?
	 * 	CompanyServiceImpl 객체가 동일한 객체를 나눠 쓰는 것인지? 아니면 각 Controller마다 다른 객체를 쓰는 것인지?
	 */
    @Autowired
    private CompanyService service;
    /* 로그인 성공 - 세션에 데이터 저장
     * 	: 사번, 이름 다 저장
     * 로그인 실패 - 실패 처리 화면으로 이동 
     * 
     * @PostMapping 선언된 구조의 반환은 client의 
     */
    
    //로그인 (empno, ename)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginCheck(@RequestParam("empno") int empno, 
    							@RequestParam("ename") String ename, Model session) {
    		
//    		System.out.println("alldeptget.jsp로 이동 전 " + service.loginCheck(empno, ename));
    		boolean result = service.loginCheck(empno, ename);
    		if (result == true) {
    			// 세션에 데이터 저장
        		session.addAttribute("empno", empno);
        		session.addAttribute("ename", ename);
        		// alldeptget.jsp로 이동
        		return "redirect:/alldeptget.jsp";
    		} else {
        		return "redirect:/failview.jsp";
    		}
    		
    		
    }

}
