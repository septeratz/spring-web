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

    @Autowired
    private CompanyService service;

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
    public List<Object[]> getEmpsByDept(@RequestParam int deptno) {
        return service.getEmpsbyDeptno(deptno);
    }

    // 사원 부서 이동
    @PostMapping("/dept")
    public String updateEmpDept(@RequestParam int empno, @RequestParam int newDeptno) throws NotExistEmp2Exception {
        service.updateDeptnoByEmpno(empno, newDeptno);
        return "사원 부서 이동 성공";
    }

    // 예외 처리
    @ExceptionHandler(NotExistEmp2Exception.class)
    public String handleNotExistEmp(NotExistEmp2Exception e) {
        return e.getMessage();
    }
}
