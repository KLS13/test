package com.bbs.test.domain;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
		private int idx;
		private String title,writer,content;
		private Date regDate;
		private int cnt;
		private String fileName;
		private MultipartFile uploadFile;
		
		public MultipartFile getUploadFile() {
			return uploadFile;
		}
		public void setUploadFile(MultipartFile uploadFile) {
			this.uploadFile = uploadFile;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Date getRegDate() {
			return regDate;
		}
		public void setRegDate(Date regDate) {
			this.regDate = regDate;
		}
		public int getCnt() {
			return cnt;
		}
		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
		

		@Override
		public String toString() {
			return "BoardVO [idx=" + idx + ", title=" + title + ", writer=" + writer + ","
					+ " content=" + content + ", regDate="
					+ regDate + ", cnt=" + cnt + ", fileName=" + fileName + "]";
		}
	}