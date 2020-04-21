package com.bbs.test.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bbs.test.domain.BoardVO;
import com.bbs.test.domain.Criteria;
import com.bbs.test.domain.PageMaker;
import com.bbs.test.service.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(Criteria cri, Model model) {
		
		List<BoardVO> boardList = boardService.getBoardList(cri);
		
		int total = boardService.totalCnt(cri);
		// Model 정보 저장
		model.addAttribute("boardList",boardList);
		model.addAttribute("paging",new PageMaker(cri,total));
		return "boardList"; // View 이름 리턴
	}
	
	// 글 상세 조회
	@RequestMapping("/getContent.do")
	public String getBoard(BoardVO vo, Model model, @ModelAttribute("cri") Criteria cri) throws Exception{
		model.addAttribute("board", boardService.getContent(vo)); // Model 정보 저장
		boardService.updateCnt(vo.getIdx());
		return "content"; // View 이름 리턴
	}
	
	// 글 쓰기
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST) 
	public String insertBoard(BoardVO vo) throws IOException {
			
			boardService.insertBoard(vo); 
			return "redirect:getBoardList.do"; 
	}
	
	// 글 쓰기 페이지 이동
	@RequestMapping("/writeBoard.do") 
	public String moveInsertBoard()throws Exception{
		
		return "insertBoard";
	}
	 
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, @ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		
		if(boardService.updateBoard(vo)) {
			rttr.addFlashAttribute("result","success");
		}
		
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("pageNum",cri.getPageNum());
		
		return "redirect:getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/getDateRemove.do")
	@ResponseBody
	public void getDateRemove(@ModelAttribute("reg_date") String reg_date, Model model) throws Exception {
		try {
			boardService.getDateRemove(reg_date);
			model.addAttribute("data", "YES");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}