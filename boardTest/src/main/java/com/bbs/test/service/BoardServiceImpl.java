package com.bbs.test.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bbs.test.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao dao;

}
