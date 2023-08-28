package edu.global.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.ibatis.annotations.Insert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	/*
	 * @Bean //PasswordEncoder passwordEncoder = new BCryptPasswordEncoder() public
	 * PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
	 */

	@Autowired
	private PasswordEncoder passwordEncoder;

	// UserVO(username=admin, password=admin, enabled=1,
	// authList=[AuthVO(username=admin, authority=ROLE_ADMIN),
	// AuthVO(username=admin, authority=ROLE_MANAGER)])

	@Test
	void testGetList() {
		UserVO user = userMapper.getUser("admin");
		System.out.println(user);
	}

	// @Insert("insert into users(username,password,enabled)
	// values(#{username},#{password},#{enabled})")
	// public int insertUser(UserVO userVO);

	// @Insert("insert into AUTHORITIES (username,AUTHORITY)
	// values(#{username},'ROLE_USER')")
	// public void insertAuthorities(UserVO UserVO);

	
	 @Test void testInsertUser() { 
		 UserVO user = new UserVO();
		 user.setUsername("user2"); user.setPassword(passwordEncoder.encode("user2"));
		 user.setEnabled(1);
		  
		 userMapper.insertUser(user); 
		 userMapper.insertAuthorities(user); 
	  }
	 

	// 암호 체크 방법
	@Test
	void testMatchUser() {

		UserVO user = new UserVO();
		user.setUsername("user2");
		user.setPassword(passwordEncoder.encode("user2"));
		user.setEnabled(1);

		passwordEncoder.matches("user2", user.getPassword());

		System.out.println(user);

	}
}
