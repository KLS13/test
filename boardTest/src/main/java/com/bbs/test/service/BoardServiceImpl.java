package com.bbs.test.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bbs.test.dao.BoardDao;
import com.bbs.test.domain.BoardVO;
import com.bbs.test.domain.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao dao;
	
	@Override
	public List<BoardVO> getBoardList(Criteria paging) {
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
	public int totalCnt(Criteria cri) {
		return dao.totalCnt(cri);
	}

	@Override
	public void updateCnt(int idx) {
		dao.updateCnt(idx);
		
	}
}

