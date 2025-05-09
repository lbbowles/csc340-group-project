package com.csc340.project.message;

//Have to import all classes that pertain to the messages.
import com.csc340.project.customer.Customer;
import com.csc340.project.posting.Posting;
import com.csc340.project.tutor.Tutor;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "messages")
public class Message {

    // Message string ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;

    // Content of the message
    private String content;

    // Time message is tabulated
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tutor tutorSender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customerSender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tutor tutorRecipient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customerRecipient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Posting relatedPost;

    // Without id
    public Message(String content, LocalDateTime timestamp, Tutor tutorSender, Customer customerSender, Tutor tutorRecipient, Customer customerRecipient, Posting relatedPost) {
        this.content = content;
        this.timestamp = timestamp;
        this.tutorSender = tutorSender;
        this.customerSender = customerSender;
        this.tutorRecipient = tutorRecipient;
        this.customerRecipient = customerRecipient;
        this.relatedPost = relatedPost;
    }

    // With id
    public Message(int messageId, String content, LocalDateTime timestamp, Tutor tutorSender, Customer customerSender, Tutor tutorRecipient, Customer customerRecipient, Posting relatedPost) {
        this.messageId = messageId;
        this.content = content;
        this.timestamp = timestamp;
        this.tutorSender = tutorSender;
        this.customerSender = customerSender;
        this.tutorRecipient = tutorRecipient;
        this.customerRecipient = customerRecipient;
        this.relatedPost = relatedPost;
    }

    // Always include a no-argument constructor
    public Message() {
    }

    // Getters and Setters

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Tutor getTutorSender() {
        return tutorSender;
    }

    public void setTutorSender(Tutor tutorSender) {
        this.tutorSender = tutorSender;
    }

    public Customer getCustomerSender() {
        return customerSender;
    }

    public void setCustomerSender(Customer customerSender) {
        this.customerSender = customerSender;
    }

    public Tutor getTutorRecipient() {
        return tutorRecipient;
    }

    public void setTutorRecipient(Tutor tutorRecipient) {
        this.tutorRecipient = tutorRecipient;
    }

    public Customer getCustomerRecipient() {
        return customerRecipient;
    }

    public void setCustomerRecipient(Customer customerRecipient) {
        this.customerRecipient = customerRecipient;
    }

    public Posting getRelatedPost() {
        return relatedPost;
    }

    public void setRelatedPost(Posting relatedPost) {
        this.relatedPost = relatedPost;
    }
}
