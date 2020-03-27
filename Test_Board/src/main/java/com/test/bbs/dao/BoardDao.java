package com.test.bbs.dao;

import com.test.bbs.domain.BoardVO;

public interface BoardDao {

	public void write(BoardVO vo) throws Exception;
}
