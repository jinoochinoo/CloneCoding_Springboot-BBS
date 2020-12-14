package com.jinwoo.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jinwoo.blog.model.Board;

//DAO
//자동 bean 등록 // @Repository 생략 가능
public interface BoardRepository extends JpaRepository<Board, Integer>{
}
