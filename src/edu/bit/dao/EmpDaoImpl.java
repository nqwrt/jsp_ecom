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

	// ���� �۾� �޼ҵ� �߰�

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		// ����Ŭ ����̹� �ε�
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

			// �����͸� ��ĭ ������ �����Ͱ� ������ true�� �����Ѵ�.
			// ResultSet�� ������ ==> List<Emp> ������ �ű��.

			while (rs.next()) {

				EmpDto e = new EmpDto();

				// count�ؼ� ���Ӵ� ���ڵ常ŭ while���� ����. ���鼭 emp �� ��ü�� ����
				// ����ٰ� result ��ü���� �Űܾߵ�

	
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
