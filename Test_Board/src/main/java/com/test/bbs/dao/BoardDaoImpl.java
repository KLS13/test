package com.test.bbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.bbs.common.Paging;
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

	@Override
	public List<BoardVO> list(Paging vo) throws Exception {
		
		return sql.selectList(namespace + ".list", vo);
	}

	@Override
	public BoardVO view(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".view", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		sql.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		sql.delete(namespace + ".delete", bno);
		
	}

	@Override
	public int countBoard() {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".countBoard");
	}
	
	
}
