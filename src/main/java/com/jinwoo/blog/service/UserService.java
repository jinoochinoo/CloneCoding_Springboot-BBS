package com.jinwoo.blog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jinwoo.blog.model.RoleType;
import com.jinwoo.blog.model.User;
import com.jinwoo.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔 통해 Bean 등록
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword(); // original 비밀번호
		String encPassword = encoder.encode(rawPassword); // hash 비밀번호
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	@Transactional
	public void 회원수정(User user) {
		User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원 찾기 실패");
		}); // SELECT 통해 DB 저장된 User 오브젝트 불러오기
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		persistance.setPassword(encPassword);  // password 해쉬 통과한 값으로 수정
		persistance.setEmail(user.getEmail()); // email 그냥 수정
		//영속화된 persistance 객체 변화 -> 더티 체킹 -> update 처리
			} 
}