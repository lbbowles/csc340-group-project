package com.csc340.project.tutor;

import com.csc340.project.customer.Customer;
import com.csc340.project.message.MessageService;
import com.csc340.project.posting.Posting;
import com.csc340.project.posting.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/tutors")
public class TutorController {

    @Autowired
    private TutorService service;
    @Autowired
    private MessageService messageService;
    @Autowired
    private PostingService postingService;

    /**
     * Get all tutors in the database.
     * URL: http://localhost:8080/tutors/all
     */
    @GetMapping("/all")
    public String showAllTutors(Model model) {
        List<Tutor> tutors = service.getAllTutors();
        model.addAttribute("tutors", tutors);
        return "all-tutors";
    }

    /**
     * Create a new tutor.
     * URL: POST http://localhost:8080/tutors/create
     */
    @GetMapping("/create")
    public String showCreateTutorForm(Model model) {
        model.addAttribute("tutor", new Tutor());
        return "register-tutor";
    }

    @PostMapping("/create")
    public String createTutor(Tutor tutor) {
        Tutor savedTutor = service.addTutor(tutor);
        return "redirect:/tutors/" + savedTutor.getTutorId();
    }

    /**
     * Get a tutor by ID.
     * URL: http://localhost:8080/tutors/{id}
     */
    @GetMapping("/{tutorId}")
    public String showTutor(@PathVariable Integer tutorId, Model model) {
        model.addAttribute("tutor", service.getTutorById(tutorId));


        //model.addAttribute("message", messageService.getThread(postId));
        return "tutor-page";
    }

    /**
     * Update an existing tutor.
     * URL: PUT http://localhost:8080/tutor/update/{id}
     */
    @GetMapping("/update/{tutorId}")
    public String showUpdateTutorForm(@PathVariable Integer tutorId, Model model) {
        model.addAttribute("tutor", service.getTutorById(tutorId));
        return "update-tutor";
    }

    @PostMapping("/update/{tutorId}")
    public String updateTutor(@PathVariable Integer tutorId, Tutor tutor) {
        Tutor savedTutor = service.updateTutor(tutorId, tutor);
        return "redirect:/tutors/" + savedTutor.getTutorId();
    }

    /**
     * Delete a tutor by ID.
     * URL: http://localhost:8080/tutors/delete/{tutorId}
     */
    @GetMapping("/delete/{tutorId}")
    public String deleteTutorById(@PathVariable int tutorId) {
        service.deleteTutorById(tutorId);
        return "redirect:/";
    }


    // View specifically for the students to look at reviews and tutor information
    @GetMapping("/{tutorId}/view")
    public String showTutorPage(@PathVariable("tutorId") int tutorId, Model model) {
        Tutor tutor = service.getTutorById(tutorId);
        List<Posting> posting = postingService.getPostingsByTutor(tutorId);

        model.addAttribute("posting", posting);
        model.addAttribute("tutor", tutor);
        return "tutor-page-student";
    }
}
