package com.csc340.project.posting;
// Works with tutor, import relevant packages for db interactions.
import com.csc340.project.customer.Customer;
import com.csc340.project.customer.CustomerRepository;
import com.csc340.project.tutor.Tutor;
import com.csc340.project.tutor.TutorRepository;
import com.csc340.project.customer.Customer;

import com.csc340.project.tutor.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostingService {

    @Autowired
    private PostingRepository postingRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TutorService tutorService;

    // Get all postings (non-tutor specific), useful for homepage.
    public List<Posting> getAllPostings() {
        return postingRepository.findAll();
    }

    // Create Posting, pass a tutorId and information for posting.
    public void createPosting(Integer tutorId, Posting posting) {
        // Throw error to console if a related tutor is not found, this is why our imports were necessary.
        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow(()
                -> new RuntimeException("Tutor with ID " + tutorId + " not found."));

        // Otherwise if a tutor is found, save the posting.  First by calling the setter in posting and then saving it to db.
        posting.setTutor(tutor);
        postingRepository.save(posting);
    }


    // Update Posting
    public void updatePosting(Integer tutorId, Integer postId, Posting posting) {
        // Throw error to console if a related tutor is not found, this is why our imports were necessary.
        Posting existing = postingRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post with ID " + postId + " not found."));

        // If the above conditions are accurate, update the existing with new values
        existing.setTitle(posting.getTitle());
        existing.setCourse(posting.getCourse());
        existing.setPostDescription(posting.getPostDescription());
        existing.setRate(posting.getRate());
        existing.setStatus(posting.isStatus());
        existing.setCustomer(posting.getCustomer());

        // Save and return the updated existing
        postingRepository.save(existing);


    }

    public Posting getPostingById(Integer postId) {
        postingRepository.findById(postId);

        return postingRepository.findById(postId).orElse(null);
    }

    // Delete Posting
    public void deletePostById(Integer postId) {
        postingRepository.deleteById(postId);
    }

    public List<Posting> getPostingsByTutor(int tutorId) {
        return postingRepository.findAllByTutor(tutorId);
    }

    public int getTutorIdFromPost(int postId) {
        return postingRepository.getTutorIdFromPost(postId);
    }

    // Update Posting but only to now include a new student and by extension, stop showing it in searches or /all
    public void addStudent(Integer customerId, Integer postId) {
        // Throw error to console if a related tutor is not found, this is why our imports were necessary.
        Posting existing = postingRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post with ID " + postId + " not found."));

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer with ID " + customerId + " not found."));

        // Nothing else about the post needs to change.
        existing.setStatus(true);
        existing.setCustomer(customer);

        // Save and return the updated existing
        postingRepository.save(existing);


    }

    //Query search utilizing like to find courses
    public List<Posting> getPostingBySearch(String searchTerm) {
        return postingRepository.searchLike(searchTerm);
    }

    //Show only courses that are false(do not have a student)
    public List<Posting> getAvailablePostings() {
        return postingRepository.findByStatusFalse();
    }

    //Get the customer linked to a post.
    public Customer getCustomerByPost(Integer postId) {return postingRepository.findCustomerByPostId(postId);}

    //Leave a rating on a post
    public void ratePosting(Integer postId, int score, String comment) {

        Posting post = postingRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setRatingScore(score);
        post.setRatingComment(comment);
        postingRepository.save(post);

        //Recalculate average for the Tutor to appear on their profile.
        //Tutor tutor = post.getTutor();
        //int avg = tutor.getRating();


    }

    public List<Posting> getPostingsByCustomer(int customerId) {
        return postingRepository.findAllByCustomerId(customerId);
    }



}
