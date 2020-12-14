package com.jinwoo.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jinwoo.blog.config.auth.PrincipalDetail;
import com.jinwoo.blog.dto.ResponseDto;
import com.jinwoo.blog.model.Board;
import com.jinwoo.blog.model.Reply;
import com.jinwoo.blog.service.BoardService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;

	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		boardService.글쓰기(board, principal.getUser());	
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
		// http 상태 200 뜨면 정상 // result 정상이면 1, 비정상이면 -1
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		boardService.글삭제하기(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
			boardService.글수정하기(id, board);
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto<Integer> replySave(@RequestBody Reply reply, 
			@PathVariable int boardId,
			@AuthenticationPrincipal PrincipalDetail principal) {
		boardService.댓글쓰기(reply, boardId, principal.getUser());	
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
		// http 상태 200 뜨면 정상 // result 정상이면 1, 비정상이면 -1
	}
	
	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
		boardService.댓글삭제(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);	
		}
}
