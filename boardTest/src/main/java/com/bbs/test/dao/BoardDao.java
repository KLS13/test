package com.bbs.test.dao;

import java.util.List;

import com.bbs.test.domain.BoardVO;
import com.bbs.test.domain.Criteria;

public interface BoardDao {

	// 글 목록 조회
	List<BoardVO> getBoardList(Criteria paging);

	// 글 상세 조회
	BoardVO getContent(BoardVO vo);

	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	boolean updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 갯수
	int totalCnt(Criteria cri);
	
	void updateCnt(int idx);
	
	int getDateRemove(String reg_date);

}
