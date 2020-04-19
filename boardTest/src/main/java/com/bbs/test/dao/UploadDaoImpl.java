package com.bbs.test.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UploadDaoImpl implements UploadDao {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.bbs.test.dao.mapper.uploadMapper";
	
}
