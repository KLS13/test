package com.bbs.test.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bbs.test.domain.BoardVO;
import com.bbs.test.domain.PagingCriteria;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Inject
	private SqlSession sql;

	private static String namespace = "com.bbs.test.dao.mapper.boardMapper";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertBoard() 기능 처리");
		sql.insert(namespace + ".insertBoard", vo);
	}

	public boolean updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		return sql.update(namespace + ".updateBoard", vo) == 1;
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 deleteBoard() 기능 처리");
		sql.delete(namespace + ".deleteBoard", vo);
	}

	public BoardVO getContent(BoardVO vo) {
		System.out.println("===> Mybatis로 getContent() 기능 처리");
		return (BoardVO) sql.selectOne(namespace + ".getContent", vo);
	}

	public List<BoardVO> getBoardList(PagingCriteria paging) {
		System.out.println("===> Mybatis로 getBoardList() 기능 처리");
		return sql.selectList(namespace + ".getBoardList",paging);
	}
	
	public int totalCnt() {
		System.out.println("===> Mybatis로 totalCnt");
		return sql.selectOne(namespace + ".getTotalCnt");
	}

	@Override
	public void updateCnt(int idx) {
		System.out.println("===> Mybatis로 조회수 증가");
		sql.update(namespace + ".updateCnt", idx); 
		
	}

}
