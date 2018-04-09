package com.ajay.springboot;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserRecord, Integer> {

	/*public List<UserRecord> findAll();
	public UserRecord findOne(int id);
	public void  save(User user);
	public void  delete(int id);*/
}
