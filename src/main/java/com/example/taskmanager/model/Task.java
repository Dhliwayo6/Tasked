package com.example.taskmanager.model;

import com.example.taskmanager.enums.Priority;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "task", nullable = false, length = 255)
    private String task;

    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @Column(name = "complete")
    private Boolean complete;

    @Column(name = "priority")
    private Priority priority;

    @Column(name = "comments", nullable = true)
    private String comments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"password", "verificationCode", "verificationExpiry",
            "authorities", "accountNonExpired", "accountNonLocked",
            "credentialsNonExpired", "enabled"})
    private User user;

    public Task() {
        this.dateCreated = LocalDate.now();
    }
}
