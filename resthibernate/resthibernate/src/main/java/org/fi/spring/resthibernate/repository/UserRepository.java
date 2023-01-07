package org.fi.spring.resthibernate.repository;

import java.util.List;

import org.fi.spring.resthibernate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*public interface UserRepository extends JpaRepository<UserEntity, String> {

}*/
public interface UserRepository 
extends JpaRepository<UserEntity, String> 
{
//public UserEntity findByEmail(String email);
public List<UserEntity> findByEmail(String email);
public UserEntity findByName(String name);
@Query(value="select objuser from UserEntity objUser where objUser.userName=:uname and objUser.password=:pwd")
public UserEntity authenticateUser(@Param("uname")String userName,@Param("pwd")String password);
//Native Query
@Query(value="select * from users_0018 order by userName DESC",nativeQuery = true)
public List<UserEntity>
getAllRecordsByDescending();
}
