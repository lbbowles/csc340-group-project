package com.csc340.project.posting;

import com.csc340.project.tutor.Tutor;
import com.csc340.project.tutor.TutorService;

//Ability to have customer join a posting
import com.csc340.project.customer.*;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/postings")
public class PostingController {

    @Autowired
    private PostingService service;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private CustomerService customerService;

    /**
     * Return all postings, non-tutor specific.  Obviously a get, return the list from the db.
     * URL: GET http://localhost:8080/postings
     */
    @GetMapping("/all")
    public String showPostings(Model model) {
        List<Posting> postings = service.getAllPostings();
        model.addAttribute("postings", postings);
        return "all-posts";
    }

    /**
     * Return all postings, tutor specific.
     * URL: GET http://localhost:8080/postings/tutor/{tutorId}
     */
    @GetMapping("/tutor/{tutorId}")
    public String showTutorPosts(@PathVariable Integer tutorId, Model model) {
        // Creating a list of all the posts the tutor has made.
        List<Posting> postings = service.getPostingsByTutor(tutorId);
        // Pass the id we ascertained via path to get all tutor information (we want username as well on the page)
        Tutor tutor = tutorService.getTutorById(tutorId);

        // Add attributes.
        model.addAttribute("postings", postings);
        model.addAttribute("tutorId", tutorId);
        model.addAttribute("tutor", tutor);
        return "tutor-posts";

    }

    /**
     * Post a new posting to the database.
     * URL: http://localhost:8080/postings/{tutorID}/create
     */
    @GetMapping("/{tutorId}/create")
    public String showCreatePostForm(@PathVariable Integer tutorId, Model model) {
        Tutor tutor = tutorService.getTutorById(tutorId);
        model.addAttribute("tutor", tutor);
        return "post-create";
    }

    @PostMapping("/{tutorId}/create")
    public String createPosting(@PathVariable Integer tutorId, @ModelAttribute Posting posting) {
        service.createPosting(tutorId, posting);
        return "redirect:/postings/tutor/" + tutorId;
    }


    /**
     * Update a current posting within the database.
     * URL: http://localhost:8080/postings/{tutorID}/{postID}/update
     */
    @GetMapping("/{tutorId}/{postId}/update")
    public String showUpdateForm(@PathVariable int tutorId, @PathVariable int postId, Model model) {
        Posting posting = service.getPostingById(postId);
        model.addAttribute("posting", posting);
        model.addAttribute("tutor", tutorService.getTutorById(tutorId));
        return "update-posts";
    }

    @PostMapping("/{tutorId}/{postId}/update")
    public String updatePost(@PathVariable int tutorId, @PathVariable int postId, Posting post) {

        service.updatePosting(tutorId, postId, post);
        return "redirect:/postings/tutor/" + tutorId;
    }

    /**
     * Delete a current posting within the database.
     * URL: http://localhost:8080/postings/{postId}/delete
     */
    @GetMapping("/{postId}/delete")
    public String deletePostById(@PathVariable int postId) {
        //Call upon PostingService to get the id, then delete the post.
        int tutorId = service.getTutorIdFromPost(postId);
        service.deletePostById(postId);
        // Why tutorId is needed here.
        return "redirect:/postings/tutor/" + tutorId;
    }

    // Mapping to add a student to a post and change the status so that it no longer appears on the 'all posts' page
    @PostMapping("/{customerId}/{postId}/join")
    public String joinPost(@PathVariable int customerId, @PathVariable int postId) {

        service.addStudent(customerId, postId);

        return "all-posts";
    }

    // Allow specific searches for courses, example: "BIO" or "CSC"
    @GetMapping("/search")
    public String searchPostings(HttpSession session, @RequestParam("course") String course, Model model) {
        List<Posting> searchResults = service.getPostingBySearch("%" + course + "%");

        //For later functionality with being able to join class.
        Customer customer = (Customer) session.getAttribute("customer");
        model.addAttribute("customer", customer);

        model.addAttribute("results", searchResults);
        model.addAttribute("searchTerm", course);
        return "posts-searched";
    }


}
