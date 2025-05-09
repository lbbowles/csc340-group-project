package com.csc340.project.tutor;

// Prevent infinite references.
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.csc340.project.posting.Posting;

import java.util.List;

@Entity
@Table(name = "tutors")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tutorId;

    @Column(nullable = false, length = 25)
    private String username;

    @Column(nullable = false, length = 8)
    private String password;

    //Tutor can create a brief description about themselves or about their teaching style - allowing differentiation.
    @Column(length = 100)
    private String description;

    //Allow the tutor to print what courses they are proficient in.
    @Column(length = 200)
    private String courses;

    //Allow the tutor to put the socials they are comfortable tutoring through (Phone-Call, Discord, etc).
    @Column(length = 50)
    private String socials;

    //Rating 1-5, therefore an int.
    @Column
    private int rating;

    //Allowing the user to input a file location will allow the database to store it where it is needed
    @Column(length = 200)
    private String photo;

    //Without id
    public Tutor(String username, String password, String description, String courses, String socials, int rating, String photo) {
        this.username = username;
        this.password = password;
        this.description = description;
        this.courses = courses;
        this.socials = socials;
        this.rating = rating;
        this.photo = photo;
    }

    //With id
    public Tutor(int tutorId, String username, String password, String description, String courses, String socials, int rating, String photo) {
        this.tutorId = tutorId;
        this.username = username;
        this.password = password;
        this.description = description;
        this.courses = courses;
        this.socials = socials;
        this.rating = rating;
        this.photo = photo;
    }

    // Always include a non-argument constructor
    public Tutor() {
    }

    // One tutor can have multiple postings, relates to the Posting.java and related files
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // As the Professor mentioned, this is to mitigate postman returning infinitely as they are referencing one another.
    @JsonManagedReference
    private List<Posting> postings;



    //Getters and Setters
    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getSocials() {
        return socials;
    }

    public void setSocials(String socials) {
        this.socials = socials;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPhoto() {return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    // Functions relevant to postings.

    public List<Posting> getPostings() {
        return postings;
    }

    public void setPostings(List<Posting> postings) {
        this.postings = postings;
    }
}
