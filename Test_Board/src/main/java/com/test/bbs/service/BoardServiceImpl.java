package com.test.bbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.test.bbs.common.Paging;
import com.test.bbs.dao.BoardDao;
import com.test.bbs.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDao dao;

	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
		
	}

	@Override
	public List<BoardVO> list(Paging vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(vo);
	}

	@Override
	public BoardVO view(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.view(bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
		
	}

	@Override
	public int countBoard() {
		// TODO Auto-generated method stub
		return dao.countBoard();
	}
}
