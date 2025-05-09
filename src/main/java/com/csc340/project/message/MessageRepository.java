package com.csc340.project.message;

import com.csc340.project.posting.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByRelatedPostOrderByTimestampAsc(Posting relatedPost);
}
