package edu.fisa.ce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fisa.ce.exception.NotExistEmp2Exception;
import edu.fisa.ce.model.domain.dto.Emp2DTO;
import edu.fisa.ce.service.CompanyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController 
@RequestMapping("/emp")
public class CompanyController {

	// ? CompanyService 생성 개수? - 1개, singleton 형식임
    @Autowired
    private CompanyService service;

    // ? @RequestBody Emp2DTO emp의 용도? 필요성? - json 데이터를 객체 변환하는 데에 필수적임
    // 사원 등록
    @PostMapping("/add")
    public String addEmp(@RequestBody Emp2DTO emp) {
    	System.out.println("88888");
    	Emp2DTO savedEmp = service.addEmp(emp);
        log.info("사원 등록 완료: {}", savedEmp);
        return "사원 등록 완료";
    }

    // 사원 조회 
    @GetMapping("/get")
    public Emp2DTO getEmpByEname(@RequestParam("ename") String ename) throws NotExistEmp2Exception {
        return service.getEmp(ename);
    }
 
    // 부서별 직원 조회
    @GetMapping("/dept")
    public List<Object[]> getEmpsByDept(@RequestParam("deptno") int deptno) {
        return service.getEmpsbyDeptno(deptno);
    }

    // 사원 부서 이동
    @PostMapping("/dept")
    public String updateEmpDept(@RequestParam int empno, @RequestParam int newDeptno) throws NotExistEmp2Exception {
        service.updateDeptnoByEmpno(empno, newDeptno);
        return "사원 부서 이동 성공";
    }

    // 예외 전담 처리 메소드
    // 이 메소드로 try~catch 문장을 간소화시킴: spring의 매력
    @ExceptionHandler(NotExistEmp2Exception.class)
    public String handleNotExistEmp(NotExistEmp2Exception e) {
        return e.getMessage();
    }
}
