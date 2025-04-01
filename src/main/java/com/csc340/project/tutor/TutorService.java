package com.csc340.project.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    /**
     * Fetch all Tutors.
     *
     * @return the list of all Tutors.
     */
    public List<Tutor> getAllTutors() {

        return tutorRepository.findAll();
    }

    /**
     * Fetch a unique tutor by ID.
     *
     * @param tutorId the unique Tutor id.
     * @return a unique Tutor.
     */
    public Tutor getTutorById(int tutorId) {
        return tutorRepository.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Tutor with ID " + tutorId +
                        " not found."));
    }

    /**
     * Add a new Tutor.
     *
     * @param tutor The Tutor to be added.
     */
    public Tutor addTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    /**
     * Update an existing Tutor.
     *
     * @param tutorId      The ID of the Tutor to update.
     * @param updatedTutor The updated Tutor object.
     */
    public Tutor updateTutor(int tutorId, Tutor updatedTutor) {

        Optional<Tutor> existingTutor = tutorRepository.findById(tutorId);

        if (existingTutor.isPresent()) {
            Tutor tutor = existingTutor.get();
            tutor.setUsername(updatedTutor.getUsername());
            tutor.setPassword(updatedTutor.getPassword());
            tutor.setDescription(updatedTutor.getDescription());
            tutor.setCourses(updatedTutor.getCourses());
            tutor.setSocials(updatedTutor.getSocials());
            tutor.setRating(updatedTutor.getRating());
            tutor.setPhoto(updatedTutor.getPhoto());

            return tutorRepository.save(tutor);
        }

        return null;
    }

    /**
     * Delete a tutor by ID.
     *
     * @param tutorId the ID of the tutor to delete.
     */
    public void deleteTutorById(int tutorId) {
        tutorRepository.deleteById(tutorId);
    }


}

