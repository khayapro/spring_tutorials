package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Basic(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private String name;

    @UpdateTimestamp
    @Column(name = "last_updated_date")
    private LocalDateTime lastUpdateDate;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    /**
     * Default constructor required by JPA
     */
    protected Course() {
        super();
    }

    public Course(final String name) {
        this.name = name;
    }

}
