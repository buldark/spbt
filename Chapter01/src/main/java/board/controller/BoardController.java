package board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;

@RestController
public class BoardController {
	
	public BoardController() {
		System.out.println("BoardController 기본 생성자");
	}
	
	@GetMapping(value = "/board/hello")
	public String hello(String name) {
		return "안녕하세요 " + name + "님";
	}
	
	@GetMapping(value = "/board/getBoard")
	public BoardDTO getBoard() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(1);
		boardDTO.setName("허균");
		boardDTO.setSubject("홍길동전");
		boardDTO.setContent("동에 번쩍 서에 번쩍");
		boardDTO.setLogtime(new Date());
		
		return boardDTO;
	}
	
	@GetMapping(value = "/board/getBoardList")
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(1);
		boardDTO.setName("허균");
		boardDTO.setSubject("홍길동전");
		boardDTO.setContent("동에 번쩍 서에 번쩍");
		boardDTO.setLogtime(new Date());
		list.add(boardDTO);
		
		boardDTO = new BoardDTO();
		boardDTO.setSeq(2);
		boardDTO.setName("김수정");
		boardDTO.setSubject("아기공룡 둘리");
		boardDTO.setContent("빙하타고 내려와 고길동 집에서 산다..구박 받으며..ㅠㅠ");
		boardDTO.setLogtime(new Date());
		list.add(boardDTO);
		
		return list;		
	}
}

/*
사용자가 정의한 클래스들이 자동으로 빈으로 등록되기 때문에 스프링 부트에서는 패키지 이름을 주의해서 작성해야 한다.
만약 루트 패키지인 "com.example" 가 아닌 다른 패키지에 클래스를 작성하면 스프링 컨테이너는 해당 클래스를 빈으로 등록하지 않는다. 
다른 패키지의 클래스까지 스캔 대상에 포함 시키려면 메인 클래스에 @ComponentScan을 추가하여 패키지를 직접 지정하면 된다.

@RestController
@RestController는 JSP 같은 뷰를 별도로 만들지 않는다.
대신에 컨트롤러 메소드가 리턴하는 데이터 자체를 클라이언트로 보낸다.
클라이언트에 전달되는 데이터는 문자열, DTO, 컬렉션 형태의 자바 객체인데, 자동으로 JSON으로 변환하여 처리하게 된다.
*/















