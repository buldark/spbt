package user.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usertable")
public class UserDTO {
	
	@Column(name = "name", nullable= false, unique = true, length = 30 )
	private String name;
	
	@Id//@Id로 설정하면 primary key로 설정된다
	@Column(name="id", length = 30)
	private String id;
	
	@Column(name="pwd", nullable= false, length = 30)
	private String pwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
