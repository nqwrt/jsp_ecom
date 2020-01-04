package edu.bit.dao;

import java.util.List;

import edu.bit.dto.EmpDto;

public interface EmpDao {
	public List<EmpDto> select();
	//public int delete(int empno);
	//public int update(Emp emp);
}
