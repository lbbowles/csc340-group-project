package com.csc340.project.message;

import com.csc340.project.customer.Customer;
import com.csc340.project.customer.CustomerRepository;
import com.csc340.project.posting.Posting;
import com.csc340.project.posting.PostingService;
import com.csc340.project.tutor.Tutor;
import com.csc340.project.tutor.TutorRepository;
import com.csc340.project.tutor.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private TutorService tutorService;

    @Autowired
    private PostingService postingService;


    public void sendFromTutor(Integer tutorId, Integer customerId, Integer postId, String content) {
        Tutor tutor = tutorService.getTutorById(tutorId);
        Customer customer = postingService.getCustomerByPost(postId);
        Posting post = postingService.getPostingById(postId);

        Message message = new Message();
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());
        message.setTutorSender(tutor);
        message.setCustomerRecipient(customer);
        message.setRelatedPost(post);

        messageRepository.save(message);
    }

    public void sendFromCustomer(Integer customerId, Integer tutorId,  Integer postId, String content) {
        Tutor tutor = tutorService.getTutorById(tutorId);
        Customer customer = postingService.getCustomerByPost(postId);
        Posting post = postingService.getPostingById(postId);

        Message message = new Message();
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());
        message.setCustomerSender(customer);
        message.setTutorRecipient(tutor);
        message.setRelatedPost(post);

        messageRepository.save(message);
    }


    public List<Message> getThread(Integer postId) {
        Posting post = postingService.getPostingById(postId);
        return messageRepository.findByRelatedPostOrderByTimestampAsc(post);
    }

}
