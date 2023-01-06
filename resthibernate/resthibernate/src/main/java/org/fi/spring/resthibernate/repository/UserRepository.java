package org.fi.spring.resthibernate.repository;

import java.util.List;

import org.fi.spring.resthibernate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*public interface UserRepository extends JpaRepository<UserEntity, String> {

}*/
public interface UserRepository 
extends JpaRepository<UserEntity, String> 
{
//public UserEntity findByEmail(String email);
public List<UserEntity> findByEmail(String email);
}
