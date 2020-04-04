package com.test.bbs.contorller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bbs.common.Paging;
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
	@ResponseBody
	public String write(BoardVO vo, Model model) throws Exception {
		
		try {
			service.write(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "YES";
	}
	
	@RequestMapping("list")
	public String boardList(Paging vo, Model model,String nowPage,String cntPerPage) throws Exception {
		
		int total = service.countBoard();
			nowPage = "1";
			cntPerPage = "5";

		vo = new Paging(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		List<BoardVO> list = service.list(vo);
		model.addAttribute("paging", vo);
		model.addAttribute("list", list);
		return "board/list";
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
