package com.bbs.test.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bbs.test.common.Criteria;
import com.bbs.test.dto.BBSDto;

@Repository
public class BBSDaoImpl implements BBSDao {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.bbs.test.dao.mapper.bbs";

	@Override
	public List<BBSDto> bbsList(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".bbsList", cri);
	}

	@Override
	public int bbsListCount() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".listCount"); 
	}

	@Override
	public void writeCommit(BBSDto bdto) throws Exception {
		
		sql.insert(namespace + ".writeCommit", bdto);
		
	}

	@Override
	public BBSDto view(int bno) throws Exception {
		return sql.selectOne(namespace + ".view", bno); 
	}

	@Override
	public void remove(int bno) throws Exception {
		sql.delete(namespace + ".remove", bno);
		
	}

	@Override
	public void modifyCommit(BBSDto bdto) throws Exception {
		sql.update(namespace + ".modifyCommit", bdto);
		
	}
}
