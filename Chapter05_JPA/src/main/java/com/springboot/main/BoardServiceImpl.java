package com.springboot.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void write() {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setId("hong");
//		boardDTO.setName("허균");
//		boardDTO.setSubject("홍길동전");
//		boardDTO.setContent("불쌍한 사람들을 도우는 의적!!");
//		
//		boardDAO.save(boardDTO);
		
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setId("neo");
//		boardDTO.setName("네오");
//		boardDTO.setSubject("네오는 고양이");
//		boardDTO.setContent("네오의 남자친구는 프로도!!");
//		
//		boardDAO.save(boardDTO);
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId("frodo");
		boardDTO.setName("프로도");
		boardDTO.setSubject("프로드는 강아지");
		boardDTO.setContent("네오의 눈치를 많이 본다!!");
		
		boardDAO.save(boardDTO);
		
	}

	@Override
	public List<BoardDTO> getBoardList() {
		return boardDAO.findAll();
	}

}











