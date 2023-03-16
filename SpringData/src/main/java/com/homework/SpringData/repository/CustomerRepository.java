package com.homework.SpringData.repository;

import com.homework.SpringData.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerById(int id);
    Optional<Customer>findCustomerByUsernameStartingWith(String statement);
    @Modifying
    @Query(value="delete from Customer where age<18",nativeQuery = true)
    void deleteCustomerDueToAge();

}
