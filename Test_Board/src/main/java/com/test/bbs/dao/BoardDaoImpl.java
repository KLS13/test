package com.test.bbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.bbs.domain.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.test.bbs.dao.mapper.board";

	@Override
	public void write(BoardVO vo) throws Exception {
		sql.insert(namespace + ".write", vo);
		
	}
	
	
}
