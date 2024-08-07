package com.MASalmanss.writers_club.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;


    @CreationTimestamp
    private Date createdTime;

    @UpdateTimestamp
    private Date updatedTime;

    @Column(updatable = false)
    private Long pageSize;

    private Boolean isComplicated;

    @OneToMany(mappedBy = "booke" , cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "book" , cascade = CascadeType.ALL)
    private List<Page> pages;

    @OneToOne
    @JoinColumn(name = "theme_id" ,referencedColumnName = "id")
    private Theme theme;


}
