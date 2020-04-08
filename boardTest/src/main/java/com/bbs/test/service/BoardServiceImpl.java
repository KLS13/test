package com.bbs.test.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bbs.test.dao.BoardDao;
import com.bbs.test.domain.BoardVO;
import com.bbs.test.domain.PagingCriteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao dao;
	
	@Override
	public List<BoardVO> getBoardList(PagingCriteria paging) {
		return dao.getBoardList(paging);
	}
	
	@Override
	public BoardVO getContent(BoardVO vo) {
		return dao.getContent(vo);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		dao.deleteBoard(vo);
	}

	@Override
	public int totalCnt() {
		return dao.totalCnt();
	}
}

