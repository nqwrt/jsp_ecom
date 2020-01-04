package edu.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.dao.EmpDaoImpl;
import edu.bit.dto.EmpDto;

public class EmpServiceImpl implements EmpService{

	@Override
	public void empServiceAll(HttpServletRequest req, HttpServletResponse res) {
		
		EmpDaoImpl empDao = new EmpDaoImpl();
		List<EmpDto> empAll = empDao.select();
		
		req.setAttribute("emps", empAll);
		
		System.out.println(empAll);
		System.out.println(empAll.size());
		
		
	}
	
}
