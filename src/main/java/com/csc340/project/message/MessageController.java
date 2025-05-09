package com.csc340.project.message;

import com.csc340.project.customer.Customer;
import com.csc340.project.customer.CustomerService;
import com.csc340.project.posting.Posting;
import com.csc340.project.posting.PostingService;
import com.csc340.project.tutor.Tutor;
import com.csc340.project.tutor.TutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService service;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PostingService postingService;

    @Autowired
    private TutorService tutorService;


    /**
     * View a message thread relevant to a post
     * URL: http://localhost:8080/messages/thread/{postId}
     */
    @GetMapping("/thread/{postId}")
    public String showMessages(@PathVariable Integer postId, Model model) {

        List<Message> thread = service.getThread(postId);

        Posting posting = postingService.getPostingById(postId);
        Tutor tutor = posting.getTutor();
        Customer customer = posting.getCustomer();

        model.addAttribute("thread", thread);
        model.addAttribute("post", posting);
        model.addAttribute("customer", customer);
        model.addAttribute("tutor", tutor);

        return "message-thread";
    }



    /**
     * Tutor sends a message to a thread
     */
    @PostMapping("/tutor/send")
    public String sendMessageFromTutor(@RequestParam Integer tutorId,
                                       @RequestParam Integer customerId,
                                       @RequestParam Integer postId,
                                       @RequestParam String content) {

        service.sendFromTutor(tutorId, customerId, postId, content);
        return "redirect:/postings/tutor/" + tutorId;
    }

    /**
     * Customer sends a message to a thread
     */
    @PostMapping("/student/send")
    public String sendMessageFromStudent(@RequestParam Integer customerId,
                                         @RequestParam Integer tutorId,
                                         @RequestParam Integer postId,
                                         @RequestParam String content){

        service.sendFromCustomer(customerId, tutorId, postId, content);
        return "redirect:/user-profile";
    }


}
