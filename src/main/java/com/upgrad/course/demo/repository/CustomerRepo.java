package com.upgrad.course.demo.repository;

import com.upgrad.course.demo.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

 /**This class acts as a Repository class for CustomerEntity
 * extends from CrudRepository that contains all the CRUD methods passes CustomerEntity class type and type of primary id.
 * */

@Repository
public interface CustomerRepo extends CrudRepository<CustomerEntity, Integer> {
}
