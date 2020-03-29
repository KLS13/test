package com.test.bbs.service;

import java.util.List;

import com.test.bbs.domain.BoardVO;

public interface BoardService {

	public void write(BoardVO vo) throws Exception;
	public List<BoardVO> list() throws Exception;
	public BoardVO view(int bno) throws Exception;
}
