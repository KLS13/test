package com.bbs.test.service;

import java.util.List;

import com.bbs.test.domain.BoardVO;
import com.bbs.test.domain.PagingCriteria;

public interface BoardService {
		// 글 목록 조회
		List<BoardVO> getBoardList(PagingCriteria paging);
		
		// 글 상세 조회
		BoardVO getContent(BoardVO vo);
		
		// 글 등록
		void insertBoard(BoardVO vo);

		// 글 수정
		boolean updateBoard(BoardVO vo);

		// 글 삭제
		void deleteBoard(BoardVO vo);
		
		//글 갯수
		int totalCnt();
		
		void updateCnt(int idx);
}