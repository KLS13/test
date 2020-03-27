package com.test.bbs.contorller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.bbs.domain.BoardVO;
import com.test.bbs.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping("writePage")
	public String writePage() throws Exception {
		return "/board/write";
	}
	
	@RequestMapping("write")
	public String write(BoardVO vo) throws Exception {
		service.write(vo);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("list")
	public void list() throws Exception {
		
	}

}
