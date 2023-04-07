package JDBC_STUDY.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BbsService {
	PostDao postDao= new PostDao();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void getPost() {
		
		try {
			System.out.print("작성 글 번호 > ");
			int no = Integer.parseInt(br.readLine().strip());
			PostDto target = new PostDto();
			target.setNo(no);
			System.out.print(postDao.getOneBbs(target));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getPostList() {
		try {
			for(PostDto post: postDao.getAllBbs()) {
				System.out.print(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllWriterNames() {
		try {
			for(String writer: postDao.getAllWriterName()) {
				System.out.println(writer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getMemberPostList(){
		try {
			postDao.getMemberPostList().forEach((strWriterId, dtoPostList)-> {
				for(PostDto post : dtoPostList) {
					System.out.print(strWriterId +": " + post.toString());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getMemberPostCount(){
		postDao.getMemberPostCount().forEach((strWriterId, intCnt)-> {
			System.out.println(strWriterId + ": " + intCnt);
		});
	}
	
	public void post() throws IOException {
		System.out.print("제목 > ");
		String title = br.readLine().strip();
		System.out.print("아이디 > ");
		String id = br.readLine().strip();
		System.out.print("내용 > ");
		String content = br.readLine().strip();
		PostDto currentPost = new PostDto();
		currentPost.setTitle(title);
		currentPost.setWriter_id(id);
		currentPost.setContent(content);
		
		try {
			postDao.postBbs(currentPost, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
