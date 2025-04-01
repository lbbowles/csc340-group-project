package com.csc340.project.posting;
// Works with tutor, import relevant packages for db interactions.
import com.csc340.project.tutor.Tutor;
import com.csc340.project.tutor.TutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostingService {

    // Utilize related repositories.
    @Autowired
    private PostingRepository postingRepository;
    @Autowired
    private TutorRepository tutorRepository;

    // Get all postings (non-tutor specific), useful for homepage.
    public List<Posting> getAllPostings() {
        return postingRepository.findAll();
    }

    // Create Posting, pass a tutorId and information for posting.
    public Posting createPosting(Integer tutorId, Posting posting) {
        // Throw error to console if a related tutor is not found, this is why our imports were necessary.
        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow(()
                -> new RuntimeException("Tutor with ID " + tutorId + " not found."));

        // Otherwise if a tutor is found, save the posting.  First by calling the setter in posting and then saving it to db.
        posting.setTutor(tutor);
        return postingRepository.save(posting);
    }


    // Update Posting
    public Posting updatePosting(Integer tutorId, Integer postId, Posting posting) {
        // Throw error to console if a related tutor is not found, this is why our imports were necessary.
        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow(()
                -> new RuntimeException("Tutor with ID " + tutorId + " not found."));
        // Throw error to console if a related postId is not found
        Posting post = postingRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post with ID " + postId + " not found."));

        // If the above conditions are accuarte, update the post with new values
        post.setTitle(posting.getTitle());
        post.setCourse(posting.getCourse());
        post.setPostDescription(posting.getPostDescription());
        post.setRate(posting.getRate());
        post.setStatus(posting.isStatus());
        post.setStudentId(posting.getStudentId());

        // Save and return the updated post
        return postingRepository.save(post);


    }

    // Delete Posting
    public void deletePostById(Integer postId) {
        postingRepository.deleteById(postId);
    }

}
