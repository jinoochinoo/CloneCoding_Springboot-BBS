package com.jinwoo.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
@Entity // User 클래스 통해 MySQL 테이블 생성
//@DynamicInsert // insert 할 때 null 필드 제외
public class User {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 연결된 프로젝트 DB 넘버링 전략 그대로 수용
	private int id; // 오라클에서 Sequence, MySQL에서 Auto_increment 기능

	@Column(nullable = false, length = 30)
	private String username; 
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	 
	// @ ColumnDefault("user") // null 기본값
	@Enumerated(EnumType.STRING) // DB 전송 시 데이터 타입 명시
	private RoleType role; // Enum 쓰는 거 추천 // ADMIN, USER 두 가지로 제한
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;
	
}
