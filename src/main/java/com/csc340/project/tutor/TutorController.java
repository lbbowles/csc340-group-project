package com.csc340.project.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    @Autowired
    private TutorService service;

    /**
     * Get all tutors in the database.
     * URL: http://localhost:8080/tutors/all
     */
    @GetMapping("/all")
    public ResponseEntity<List<Tutor>> getAllTutors() {
        return new ResponseEntity<>(service.getAllTutors(), HttpStatus.OK);
    }

    /**
     * Get a tutor by ID.
     * URL: http://localhost:8080/tutors/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getTutorById(id), HttpStatus.OK);
    }

    /**
     * Create a new tutor.
     * URL: POST http://localhost:8080/tutors/create
     */
    @PostMapping("/create")
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        Tutor newTutor = service.addTutor(tutor);
        return new ResponseEntity<>(newTutor, HttpStatus.CREATED);
    }

    /**
     * Update an existing tutor.
     * URL: PUT http://localhost:8080/tutor/update/{id}
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Integer id, @RequestBody Tutor tutor) {
        Tutor updatedTutor = service.updateTutor(id, tutor);
        return new ResponseEntity<>(updatedTutor, HttpStatus.OK);
    }

    /**
     * Delete a tutor by ID.
     * URL: http://localhost:8080/tutors/delete/{tutorId}
     */
    @DeleteMapping("/delete/{tutorId}")
    public ResponseEntity<List<Tutor>> deleteTutorById(@PathVariable int tutorId) {
        service.deleteTutorById(tutorId);
        return new ResponseEntity<>(service.getAllTutors(), HttpStatus.OK);
    }
}
