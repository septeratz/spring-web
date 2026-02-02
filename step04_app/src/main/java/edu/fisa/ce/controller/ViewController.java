package edu.fisa.ce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fisa.ce.exception.NotExistEmp2Exception;
import edu.fisa.ce.model.domain.dto.Emp2DTO;
import edu.fisa.ce.model.entity.Dept;
import edu.fisa.ce.service.CompanyService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ViewController {

    @Autowired
    private CompanyService companyService;

    // 1. 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam("ename") String ename, HttpSession session) {
        try {
            // DB 조회
            Emp2DTO emp = companyService.getEmp(ename);
            
            // 세션 저장
            session.setAttribute("loginUser", emp);
            System.out.println("로그인 성공: " + emp.getEname());
            
            return "redirect:/"; // 메인으로 이동
            
        } catch (NotExistEmp2Exception e) {
            System.out.println("로그인 실패");
            return "redirect:/?error=fail"; // 에러 표시를 위해 파라미터 전달
        }
    }

    // 2. 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 날리기
        return "redirect:/";
    }

    // 3. 부서 목록 보기 (로그인 체크 필수)
    @GetMapping("/dept/list")
    public String getDeptList(HttpSession session, Model model) {
    	
    		// 1. 세션 체크
        if (session.getAttribute("loginUser") == null) {
            return "redirect:/?error=login_required";
        }

        // 2. [수정] 가짜 List 대신 Service를 통해 진짜 DB 데이터 가져오기
        List<Dept> list = companyService.getAllDepts();
        
        // 3. 모델에 담아서 JSP로 전송
        model.addAttribute("deptList", list);

        return "deptList";
    }
}