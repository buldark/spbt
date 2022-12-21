package user.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void write(UserDTO userDTO) {
		//DB
		//id 컬럼이 primary key로 설정되어 있기 때문에
		//똑같은 아이디가 없으면 insert가 수행이 되고, 아이디 있으면 update로 수행된다.
		userDAO.save(userDTO);
	}

	@Override
	public List<UserDTO> getUserList() {
		//DB
		return userDAO.findAll();
	}

	@Override
	public String isExistId(String id) {
		//DB
		Optional<UserDTO> userDTO = userDAO.findById(id);
		System.out.println(userDTO); //값이 없으면 Optional.empty 출력된다.
		
		if(userDTO.isPresent()) //값이 없으면 false
			return "exist";
		else
			return "non_exist";
	}

	@Override
	public Optional<UserDTO> getUser(String id) {
		//DB
		return userDAO.findById(id);
	}

	@Override
	public void update(UserDTO userDTO) {
		//DB
		userDAO.save(userDTO);
	}
	
	@Override
	public void delete(String id) {
		//DB
		//deleteById()는 내부적으로 findById()를 수행하고 delete를 수행한다.
		//만약 아이디가 없으면 EmptyResultDataAccessException이 발생한다.
		
		//delete()는 findById() 수행하지 않고 바로 delete를 수행한다.
		userDAO.deleteById(id);
	}

	/* 1. 첫번쨰 -쿼리 메소드
	@Override
	public List<UserDTO> search(Map<String, String> map) {
		String searchOption =map.get("searchOption");
		String keyword = map.get("keyword");
		if(searchOption.equals("name"))
			return userDAO.findByNameContaining(keyword);
		else 
			return userDAO.findByIdContaining(keyword);
		
	}
*/
	
//두번째 -@Query 어노테이션
	@Override
	   public List<UserDTO> search(Map<String, String> map) {
	      String searchOption = map.get("searchOption");
	      String keyword = map.get("keyword");
	      
	      if(searchOption.equals("name"))
	         return userDAO.getUserSearchName(keyword);
	      else
	         return userDAO.getUserSearchId(keyword);
	   }

}

/*
@Query 어노테이션
일반적인 쿼리는 지금까지 학습한 스프링 데이터 JPA의 쿼리 메소드만으로도 충분하다. 
하지만 복잡한 쿼리를 사용하거나 연관관계에 기반한 조인 검색을 처리하기 위해서는 
JPQL(Java Persistence Query Language)을 사용해야 한다. 
또는 성능상 어쩔 수 없이 특정 데이터베이스에 종속적인 네이티브 쿼리를 사용해야하는 경우도 있다.

JPQL은 일반적인 SQL과 유사한 문법을 가지고 있지만 검색 대상이 테이블이 아니라 
영속성 컨텍스트에 등록된 엔티티이다. 따라서 FROM 절에 엔티티 이름과 컬럼 대신 엔티티가 가지고 있는
 변수를 조회하기 때문에 SELECT나 WHERE 절에서 사용하는 변수 이름은 대소문자를 구분하여 정확하게 지정해야 한다.
*/









