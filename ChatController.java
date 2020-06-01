package kr.co.bk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chat/*")
public class ChatController {

	@RequestMapping("chat.do")
	public String Chat() throws Exception {

		return "chat/chat";

	}
}
