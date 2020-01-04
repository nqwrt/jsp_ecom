package edu.bit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.bit.dto.EmpDto;

public class EmpDaoImpl implements EmpDao {

	// 연결 작업 메소드 추가

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		// 오라클 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";		
		return DriverManager.getConnection(url, user, password);
	}
	
	@Override
	public List<EmpDto> select() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {

			conn = getConnection();
			String sql = "select * from emp order by empno asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			List<EmpDto> emps = new ArrayList<>();

			// 포인터를 한칸 내려서 데이터가 있으면 true를 리턴한다.
			// ResultSet의 데이터 ==> List<Emp> 쪽으로 옮긴다.

			while (rs.next()) {

				EmpDto e = new EmpDto();

				// count해서 나왓던 레코드만큼 while문이 돌음. 돌면서 emp 빈 객체를 만듬
				// 여기다가 result 실체값을 옮겨야됨

	
				e.setEname(rs.getString("ename"));
				e.setSal(rs.getDouble("sal"));

				emps.add(e);

			}

			return emps;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (ps != null)
					conn.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
