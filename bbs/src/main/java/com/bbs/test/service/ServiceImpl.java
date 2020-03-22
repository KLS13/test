package com.bbs.test.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bbs.test.dao.BBSDao;
import com.bbs.test.dto.BBSDto;

@Service
public class ServiceImpl implements Servicebbs {

	@Inject
	private BBSDao dao;

	@Override
	public int bbsListCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BBSDto> bbsList() throws Exception {
		// TODO Auto-generated method stub
		return dao.bbsList();
	}

	@Override
	public void writeCommit(BBSDto bdto) throws Exception {
		
		dao.writeCommit(bdto);
		
	}

	@Override
	public BBSDto view(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.view(bno);
	}

	@Override
	public void remove(int bno) throws Exception {
		
		dao.remove(bno);
		
	}
	
}
