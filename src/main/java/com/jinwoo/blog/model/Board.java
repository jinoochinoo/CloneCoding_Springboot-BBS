package com.jinwoo.blog.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content;
	
	private int count; // 조회수
	
	@ManyToOne(fetch = FetchType.EAGER) // 연관관계 설정 // Many = board, User = One
	@JoinColumn(name="userId") // FK, Foreign Key
	private User User; // DB 오브젝트 저장 불가, 조인 컬럼 이용해서 접근
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, 
			cascade = CascadeType.REMOVE) // 글 삭제할 때 댓글 같이 삭제되도록 설정
	@JsonIgnoreProperties({"board"})
	@OrderBy("id desc")
	private java.util.List<Reply> replys;
	
	@CreationTimestamp
	private Timestamp  createDate;
	
	
}
