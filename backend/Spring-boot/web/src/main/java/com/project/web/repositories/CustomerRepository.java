package com.project.web.repositories;

import com.project.web.domain.CustomerDTO;
import com.project.web.entities.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository
 */
@Repository //저장소 Mapper
public interface CustomerRepository extends CrudRepository<Customer,Long>{
    
    public Customer findByCustomerIdAndPassword(String Id , String pws);

}