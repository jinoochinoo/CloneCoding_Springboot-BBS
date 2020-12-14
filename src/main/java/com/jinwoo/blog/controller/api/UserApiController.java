package com.jinwoo.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jinwoo.blog.dto.ResponseDto;
import com.jinwoo.blog.model.User;
import com.jinwoo.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { // username, password, email 갖춘 user
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
		// http 상태 200 뜨면 정상 // result 정상이면 1, 비정상이면 -1
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){
		// JSON 데이터 받기 위해 @RequestBody 반드시 설정!!
		userService.회원수정(user);
		// 트랜젝션 종료와 동시와 DB 변경, but 세션값 그대로 남아서 별도 처리 필요
		
		// 세션 처리
	//	System.out.println(user.getUsername());
		//System.out.println(user.getPassword());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
