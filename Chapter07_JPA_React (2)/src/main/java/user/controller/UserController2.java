package user.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;//내장 톰캣 사용 / 외장 톰캣- 


@Controller
@RequestMapping(value="user")
public class UserController2 {
	
	@GetMapping(value="uploadForm")
	public String uploadForm() {
		return "user/uploadForm";
	}
	
//	@PostMapping(value="upload")
//	@ResponseBody
//	public void upload(@RequestParam MultipartFile img) {
//		//가상폴더
//		String filePath ="D:\\spring\\workspace\\chapter06_SpringWebMaven\\src\\main\\webapp\\WEB-INF\\storage";
//		//드라이브 경로일때는 \\ 1개는 \t나\n같이 씀
//		//String filePath ="D:/spring/workspace/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage";
//		//  /로 쓰는것도 가능
//		String fileName = img.getOriginalFilename();//파일이름 가져와
//		
//		File file = new File(filePath, fileName);
//		
//		try {
//			//FileCopyUtils.copy(img.getInputStream(),new FileOutputStream(file));//복사
//			img.transferTo(file);
//			
//		} catch (IOException e) {			
//			e.printStackTrace();
//		} 
//	}
	
	
//name= "img" 1개일 경우	
//	@PostMapping(value="upload")
//	@ResponseBody
//	public String upload(@RequestParam MultipartFile img, HttpSession session) {
//		//실제폴더
//		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
//		String fileName = img.getOriginalFilename();//파일이름 가져와
//		System.out.println("실제폴더 = " + filePath);		
//		
//		File file = new File(filePath, fileName);
//		
//		try {
//			//FileCopyUtils.copy(img.getInputStream(),new FileOutputStream(file));//복사
//			img.transferTo(file);
//			
//		} catch (IOException e) {			
//			e.printStackTrace();
//		} 
//		
//		return "<img src ='../storage/" + fileName + "' width='300' height ='300' />";
//		
//		//DB
//	}
	
	

//name= "img" 2개 이상일 경우, 배열로 받아온다.
//	@PostMapping(value="upload")
//	@ResponseBody
//	public void upload(@RequestParam MultipartFile[] img, HttpSession session) {
//		//실제폴더
//		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
//		String fileName;
//		File file;
//		
//		if(img[0] != null) {
//			fileName= img[0].getOriginalFilename();
//			file = new File(filePath, fileName);
//			
//			try {
//				img[0].transferTo(file);
//			}catch (IOException e) {			
//			e.printStackTrace();
//			} 
//		}//if
//		
//		if(img[1] != null) {
//			fileName= img[1].getOriginalFilename();
//			file = new File(filePath, fileName);
//			
//			try {
//				img[1].transferTo(file);
//			}catch (IOException e) {			
//			e.printStackTrace();
//			} 
//		}//if		
//	}
	
//한 번에 여러개 파일 선택
	@PostMapping(value="upload")
	@ResponseBody
	public void upload(@RequestParam("img[]") List<MultipartFile> list, HttpSession session) {
		//실제폴더
		String filePath = session.getServletContext().getRealPath("/storage");
		String fileName;
		File file;
		
		for(MultipartFile img : list) {
			fileName= img.getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img.transferTo(file);
			}catch (IOException e) {			
				e.printStackTrace();
			} 
		}//for
				
		
	}
	
	
	//produces="text/html; charset=UTF-8"한글 안깨지게
//name= "img" 1개일 경우	
		@PostMapping(value="upload2", produces="text/html; charset=UTF-8" )
		@ResponseBody
		public String upload2(@RequestParam MultipartFile img, HttpSession session) {
			//실제폴더
			String filePath = session.getServletContext().getRealPath("/storage");
			String fileName = img.getOriginalFilename();//파일이름 가져와
			System.out.println("실제폴더 = " + filePath);		
				
			File file = new File(filePath, fileName);
				
			try {
				//FileCopyUtils.copy(img.getInputStream(),new FileOutputStream(file));//복사
				img.transferTo(file);
					
			} catch (IOException e) {			
				e.printStackTrace();
			} 
				
			return "<img src='../storage/" + fileName + "' width='300' height='300' />";
				
				
		}
	
		
}
