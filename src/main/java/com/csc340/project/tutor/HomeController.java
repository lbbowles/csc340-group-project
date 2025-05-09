package com.csc340.project.tutor;

import com.csc340.project.customer.CustomerService;
import com.csc340.project.message.MessageService;
import com.csc340.project.posting.Posting;
import com.csc340.project.posting.PostingService;
import com.csc340.project.customer.Customer;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private TutorService tutorService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private PostingService postingService;
    @Autowired
    private CustomerService customerService;

    // Original Code by Logan
//    @GetMapping("/")
//    public String showLandingPage() {
//        return "landing-page";
//    }

    // Adrian's codes
    @GetMapping("/")
    public String showLandingPage(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "landingPageUser";
        }

        Tutor tutor = (Tutor) session.getAttribute("tutor");
        if (tutor != null) {
            model.addAttribute("tutor", tutor);
            return "landingPageUser";
        }

        return "landing-page";
    }


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("tutor", new Tutor());
        model.addAttribute("customer", new Customer());
        return "login-tutor";
    }

//    //Original Code by Logan
//    //Should be inclusive for both tutors and students
//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password, Model model) {
//        Tutor tutor = tutorService.getTutorByUsername(username);
//        Customer customer = customerService.getCustomerByUsername(username);
//
//        if (tutor != null && tutor.getPassword().equals(password)) {
//            model.addAttribute("tutor", tutor);
//            return "tutor-page";
//        } else {
//            if (customer != null && customer.getPassword().equals(password)) {
//                model.addAttribute("customer", customer);
//                return "user-profile";
//            }
//            model.addAttribute("error", "Invalid username or password");
//            return "login-tutor";
//        }
//
//    }

    //adrian's codes
    @PostMapping("/login")
    public String login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            Model model,
            HttpSession session) {

        Tutor tutor = tutorService.getTutorByUsername(username);
        Customer customer = customerService.getCustomerByUsername(username);

        if (tutor != null && tutor.getPassword().equals(password)) {
            session.setAttribute("tutor", tutor);
            model.addAttribute("tutor", tutor);
            return "redirect:/tutor-profile";
        } else if (customer != null && customer.getPassword().equals(password)) {
            session.setAttribute("customer", customer);
            model.addAttribute("customer", customer);
            return "user-profile";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login-tutor";
        }
    }

    @GetMapping("/register")
    public String showRegisterChoice(){
        return "register-choice";
    }

    //Get into a Customer's profile
    @GetMapping("/user-profile")
    public String showUserProfile(Model model, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            model.addAttribute("customer", customer);
            int customerId = customer.getCustomerId();
            List<Posting> customerPosts = postingService.getPostingsByCustomer(customerId);
            model.addAttribute("customer", customer);
            model.addAttribute("customerPosts", customerPosts);
            return "user-profile";
        }

        Tutor tutor = (Tutor) session.getAttribute("tutor");
        if (tutor != null) {
            model.addAttribute("tutor", tutor);
            return "tutor-page";
        }

        // If no user is logged in, redirect to login page
        return "redirect:/login";
    }

    // get into a Tutor's Profile
    @GetMapping("/tutor-profile")
    public String showTutorProfile(Model model, HttpSession session) {
        Tutor tutor = (Tutor) session.getAttribute("tutor");
        if (tutor != null) {
            model.addAttribute("tutor", tutor);
            return "tutor-page";
        }

        return "redirect:/login";
    }
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Clears session
        return "redirect:/login"; // Or wherever you want
    }
}
