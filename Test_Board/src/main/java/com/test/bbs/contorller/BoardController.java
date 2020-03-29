package com.test.bbs.contorller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public void list(Model model) throws Exception {
		List<BoardVO> list = service.list();
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("view")
	public void view(@RequestParam("bno") int bno,Model model) throws Exception {
		
		BoardVO view = service.view(bno);
		model.addAttribute("view", view);
	}
	
	
	@RequestMapping("updatePage")
	public String updateView(BoardVO vo, Model model) throws Exception{
		
		
		model.addAttribute("view", service.view(vo.getBno()));
		
		return "board/updatePage";
	}
	
	// 게시판 수정
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BoardVO vo) throws Exception{
	
		
		service.update(vo);
		
		return "redirect:/board/list";
	}

	// 게시판 삭제
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(BoardVO vo) throws Exception{
		
		service.delete(vo.getBno());
		
		return "redirect:/board/list";
	}

}
