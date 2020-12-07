package com.example.demo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Test {
    @Id
    @GeneratedValue

    private Long id2;
    private String nom2;
    private Date dateNaissance2;
    private String email;
}
