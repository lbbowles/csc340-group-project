package com.csc340.project.posting;

import com.csc340.project.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Integer> {

    // Heavy inspiration SP25-MVC-DEMO

    // Select all postings where the tutor_id matches the given tutorId.
    @Query(value = "SELECT * FROM postings WHERE tutor_id = :tutorId", nativeQuery = true)
    List<Posting> findAllByTutor(@Param("tutorId") Integer tutorId);

    // Select only the tutor_id from the postings table where the post_id matches the given postId.
    @Query(value = "SELECT tutor_id FROM postings WHERE post_id = :postId", nativeQuery = true)
    Integer getTutorIdFromPost(@Param("postId") Integer postId);

    // Allows searching of specific courses for easier access
    @Query(value = "SELECT * FROM postings WHERE course LIKE :course", nativeQuery = true)
    List<Posting> searchLike(@Param("course") String course);

    // Find available courses
    List<Posting> findByStatusFalse();

    // Find customer ID linked to a post
    @Query("SELECT p.customer FROM Posting p WHERE p.postId = :postId")
    Customer findCustomerByPostId(@Param("postId") Integer postId);

    // Find all posts customer has joined
    @Query("SELECT p FROM Posting p WHERE p.customer.customerId = :customerId")
    List<Posting> findAllByCustomerId(@Param("customerId") int customerId);





}
