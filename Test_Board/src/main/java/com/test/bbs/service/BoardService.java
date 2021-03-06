package com.test.bbs.service;

import java.util.List;

import com.test.bbs.common.Paging;
import com.test.bbs.domain.BoardVO;

public interface BoardService {

	public void write(BoardVO vo) throws Exception;
	public List<BoardVO> list(Paging vo) throws Exception;
	public int countBoard();
	public BoardVO view(int bno) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(int bno) throws Exception;
}
