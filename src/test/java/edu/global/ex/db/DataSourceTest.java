package edu.global.ex.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DataSourceTest {

	@Autowired
	private DataSource datasoure; // 커넥션 풀
	
	@Test
	void testDataSource() throws Exception {
		assertNotNull(datasoure);
		
		System.out.println("DS=" + datasoure);
		
		try(Connection conn = datasoure.getConnection()){
			
			System.out.println("Cooooooooonn=" + conn);
			assertThat(conn).isInstanceOf(Connection.class);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select 100 from dual");
			if(rs.next()) {
				assertEquals(100, rs.getLong(1));
			}			
			
		}	
		
	}

}
