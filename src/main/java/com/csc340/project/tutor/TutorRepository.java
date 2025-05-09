package com.csc340.project.tutor;

import com.csc340.project.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides the actual database transactions.
 */
@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer> {

    Tutor findByUsername(String username);

}
