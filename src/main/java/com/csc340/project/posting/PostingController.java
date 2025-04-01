package com.csc340.project.posting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/postings")
public class PostingController {

    @Autowired
    private PostingService service;

    /**
     * Return all postings, non-tutor specific.  Obviously a get, return the list from the db.
     * URL: GET http://localhost:8080/postings
     */
    @GetMapping
    public ResponseEntity<List<Posting>> getAllPostings() {
        List<Posting> postings = service.getAllPostings();
        return new ResponseEntity<>(postings, HttpStatus.OK);
    }

    /**
     * Post a new posting to the database.
     * URL: http://localhost:8080/postings/{tutorID}/create
     */
    @PostMapping("/{tutorId}/create")
    public ResponseEntity<Posting> createPosting(@PathVariable Integer tutorId, @RequestBody Posting posting) {
        // With the tutor ID given as part of path, call createPosting and use the raw body to fill rest of posting requirements.
        Posting newPosting = service.createPosting(tutorId, posting);
        return new ResponseEntity<>(newPosting, HttpStatus.CREATED);
    }

    //update

    /**
     * Update a current posting within the database.
     * URL: http://localhost:8080/postings/{tutorID}/{postID}/update
     */
    @PutMapping("/{tutorId}/{postId}/update")
    public ResponseEntity<Posting> updatePosting(@PathVariable Integer tutorId, @PathVariable Integer postId, @RequestBody Posting posting) {
        // After the path has appropriate input data, call to applicable function in postingService.
        Posting updatedPosting = service.updatePosting(tutorId, postId, posting);
        return new ResponseEntity<>(updatedPosting, HttpStatus.OK);
    }

    //delete a posting.  I will make it more secure later in service but I have somewhere to goooooo.

    /**
     * Delete a current posting within the database.
     * URL: http://localhost:8080/postings/{postId}/delete
     */
    @DeleteMapping("/{postId}/delete")
    public ResponseEntity<String> deletePosting(@PathVariable Integer postId) {
        service.deletePostById(postId);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }

    // Add ability to add student.  Add here, add in service.  Check if student exists, if he does add and switch to true.

}
