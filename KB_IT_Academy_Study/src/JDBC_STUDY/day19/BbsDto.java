package JDBC_STUDY.day19;

import java.util.Date;

public class BbsDto {

	private int post_id;
	private String title, writer, post_content;
	private Date regdate;
	
	public BbsDto() {
		super();
	}

	public BbsDto(int post_id, String title, String writer, String post_content, Date regdate) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.writer = writer;
		this.post_content = post_content;
		this.regdate = regdate;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
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

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "post_id=" + post_id + ", title=" + title + ", writer=" + writer + ", post_content="
				+ post_content + ", regdate=" + regdate;
	}
}
