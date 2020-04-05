package com.bbs.test.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.test.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Inject
	private BoardService boardService;
}
