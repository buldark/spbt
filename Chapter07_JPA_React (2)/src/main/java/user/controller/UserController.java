package user.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import user.bean.UserDTO;
import user.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(path="user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping(path="getUserList")	
	public List<UserDTO> getUserList(){
		//DB연결가능하지만 비추
		List<UserDTO> list = userService.getUserList();
		System.out.println(list.get(0).getId());
		return list;
		
	}
	
	
	//첫번째 - writeForm.js - if(sw===1) 첫번째와 연결 
//	@PostMapping(value="write")	
//	public void write(@RequestBody UserDTO userDTO) {
//		userService.write(userDTO);		
//	}
	
	
	//2번째와 연결
	@PostMapping(path="write")	
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);		
	}
	
	@GetMapping(path="isExistId")	
	public String isExistId(@RequestParam String id) {
		return userService.isExistId(id);
	}
	@GetMapping(path="getUser")	
	public Optional<UserDTO>  getUser(@RequestParam String id) {
		return userService.getUser(id);
	}
	@PutMapping(path="update")	
	public void update(@ModelAttribute UserDTO userDTO) {
		userService.update(userDTO);		
	}
	@DeleteMapping(path="delete")	
	public void delete(@RequestParam String id) {
		userService.delete(id);		
	}
	

	@GetMapping(value="search")	
	public List<UserDTO> search(@RequestParam Map<String,String> map) {//searchOption, keyword
		System.out.println(map);
		return userService.search(map);
	}
	/*	
	
	
	@GetMapping(value="list")
	public String list() {
		return "user/list";
	}
	@PostMapping(value="getUserList")	
	public List<UserDTO> getUserList(){
		//DB연결가능하지만 비추
		return userService.getUserList();
	}

	@GetMapping(value="updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	
	@PostMapping(value="update")	
	public void update(@ModelAttribute UserDTO userDTO) {
		userService.update(userDTO);		
	}
	@GetMapping(value="deleteForm")
	public String deleteForm() {
		return "user/deleteForm";
	}
	
	*/
}
