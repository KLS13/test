package com.bbs.test.dao;

import java.util.List;

import com.bbs.test.common.Criteria;
import com.bbs.test.dto.BBSDto;


public interface BBSDao {
	
	public List<BBSDto> bbsList(Criteria cri) throws Exception;
	public int bbsListCount() throws Exception;
	public void writeCommit(BBSDto bdto) throws Exception;
	public BBSDto view(int bno) throws Exception;
	public void remove(int bno) throws Exception;
	public void modifyCommit(BBSDto bdto) throws Exception;

}
