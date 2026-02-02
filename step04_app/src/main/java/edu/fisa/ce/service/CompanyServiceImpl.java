package edu.fisa.ce.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fisa.ce.dao.DeptRepository;
import edu.fisa.ce.dao.Emp2Repository;
import edu.fisa.ce.exception.NotExistEmp2Exception;
import edu.fisa.ce.model.domain.dto.Emp2DTO;
import edu.fisa.ce.model.entity.Dept;
import edu.fisa.ce.model.entity.Emp2;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private Emp2Repository empDao;
	
	@Autowired
	private DeptRepository deptDao;

	// ? 잘 파악하고, 대체 API 찾아보기
	private ModelMapper mapper = new ModelMapper();

	@Override
	@Transactional
	public Emp2DTO addEmp(Emp2DTO emp) {
		Emp2 entity = mapper.map(emp, Emp2.class);
		Emp2 savedEntity = empDao.save(entity);
		log.info("*** 사원 등록 완료: empno={} ***", savedEntity.getEmpno());
		return mapper.map(savedEntity, Emp2DTO.class);
	}

	@Override
	public Emp2DTO getEmp(String ename) throws NotExistEmp2Exception {
		Emp2DTO emp = mapper.map(empDao.findByEname(ename), Emp2DTO.class);
		return emp;
	}

	@Override
	public List<Object[]> getEmpsbyDeptno(int deptno) {
		List<Object[]> emps = empDao.findByDeptno(deptno);
		return emps;
	}

	// 사번으로 부서 번호 수정하는 메소드
	@Override
	@Transactional
	public boolean updateDeptnoByEmpno(int empno, int newDeptno) throws NotExistEmp2Exception {
		log.info("*** 사번으로 부서 이동했습니다 ***");
		int result = empDao.updateByEmpnoDeptno(empno, newDeptno);
		if (result != 1) {
			throw new NotExistEmp2Exception("사번에 일치되는 사원이 없습니다");
		}
		return true;
	}
	
	// [추가됨] 실제 DB에서 모든 부서 긁어오기
    @Override
    public List<Dept> getAllDepts() {
        // SELECT * FROM dept 와 동일
        return deptDao.findAll(); 
    }

}
