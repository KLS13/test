package com.test.bbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
}
