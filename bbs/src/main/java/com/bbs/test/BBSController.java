package com.bbs.test;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbs.test.dto.BBSDto;
import com.bbs.test.service.Servicebbs;

@Controller
@RequestMapping("/board/*")
public class BBSController {
	
	@Inject
	private Servicebbs service;
	
	@RequestMapping(value= "list",  method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		
		model.addAttribute("list", service.bbsList());
		return "board/list";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write() throws Exception {
	
	}
	
	@RequestMapping(value = "/writeCommit", method = RequestMethod.POST)
	public String writeCommit(BBSDto bdto) throws Exception {
		
		service.writeCommit(bdto);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public void view(@RequestParam("bno") int bno, Model model) throws Exception {
		
		model.addAttribute("view",service.view(bno));
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.GET)
	public String remove(@RequestParam("bno") int bno, Model model) throws Exception {
		
		service.remove(bno);
		
		return "redirect:/board/list";
	}

}
