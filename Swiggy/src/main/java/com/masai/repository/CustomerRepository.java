package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> , PagingAndSortingRepository<Customer, Integer>{

}
