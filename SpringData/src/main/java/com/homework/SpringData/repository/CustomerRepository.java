package com.homework.SpringData.repository;

import com.homework.SpringData.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerById(int id);
    Optional<Customer>findCustomerByUsernameStartingWith(String statement);
    @Modifying
    @Query("delete Customer c where c.age<18")
    void deleteCustomerDueToAge();

}
