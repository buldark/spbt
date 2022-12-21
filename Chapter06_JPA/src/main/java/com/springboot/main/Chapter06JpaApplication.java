package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.springboot.main", "main.controller", "user.*"})
@EntityScan("user.bean")
@EnableJpaRepositories("user.dao")
@SpringBootApplication
public class Chapter06JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter06JpaApplication.class, args);
	}

}

/*
@EntityScan
어노테이션으로 엔티티 클래스를 스캔할 곳을 지정하는데 사용한다.
메인 어플리케이션 패키지 내에 엔티티 클래스가 없는 경우 어노테이션을 사용해서 패키지밖에 존재하는 
엔티티를 지정할 수 있다.
기본적으로 @EnableAutoConfiguration 어노테이션에 의해서 지정한 곳에서 엔티티를 스캔한다.

@EnableJpaRepositories
- JpaRepository에 대한 설정정보를 자동적으로 로딩하고 이 정보를 토대로 Repository 빈을 등록하는 역할을 한다

Optional 클래스란?
- Optional이란 'null일 수도 있는 객체'를 감싸는 일종의 Wrapper 클래스이다.
*/

/*
 쿼리 메소드
JPA에서 제공하는 CrudRepository, 또는 JpaRepository를 이용해서 기본적인 CRUD 기능을 수행했다.
일반적으로 JPA를 이용해서 목록 기능을 구현할 때는 JPQL(Java Persistence Query Language)을 이용하면 된다. JPQL은 검색 대상이 테이블이 아닌 엔티티 라는 것만 제외하고는 기본 구조와 문법이 기존의 SQL과 유사하다.

스프링 JPA에서는 복잡한 JPQL을 대신해서 처리할 수 있는 쿼리 메소드라는 기능을 제공한다.
쿼리 메소드는 메소드의 이름으로 필요한 쿼리를 만들어주는 기능이다.

쿼리 메소드를 작성할 때 엔티티 이름은 생략할 수 있다.
현재 사용하는 Repository 인터페이스에서 선언된 타입 정보를 기준으로 자동 엔티티 이름이 적용된다.

쿼리 메소드의 리턴 타입은 Page<T>, Slice<T>, List<T> 이며 모두 Collection<T> 타입이다.
이 중에서 가장 많이 사용하는 것은 Page<T>, List<T>로서, 단순히 목록을 검색하려면 List<T>를 사용하고 페이징 처리를 하려면 Page<T>를 사용하면 된다.
 
 */
/*
 @Query 어노테이션
일반적인 쿼리는 지금까지 학습한 스프링 데이터 JPA의 쿼리 메소드만으로도 충분하다. 
하지만 복잡한 쿼리를 사용하거나 연관관계에 기반한 조인 검색을 처리하기 위해서는 
JPQL(Java Persistence Query Language)을 사용해야 한다. 
또는 성능상 어쩔 수 없이 특정 데이터베이스에 종속적인 네이티브 쿼리를 사용해야하는 경우도 있다.

JPQL은 일반적인 SQL과 유사한 문법을 가지고 있지만 검색 대상이 테이블이 아니라 
영속성 컨텍스트에 등록된 엔티티이다. 따라서 FROM 절에 엔티티 이름과 컬럼 대신 엔티티가 가지고 있는
 변수를 조회하기 때문에 SELECT나 WHERE 절에서 사용하는 변수 이름은 대소문자를 
 구분하여 정확하게 지정해야 한다.
 */








