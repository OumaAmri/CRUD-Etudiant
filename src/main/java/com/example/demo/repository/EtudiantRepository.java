package com.example.demo.repository;

import com.example.demo.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;


public interface EtudiantRepository
        extends JpaRepository<Etudiant, Long> {
         public List<Etudiant> findByNom(String n);
         public Page<Etudiant> findByNom(String findByNom, Pageable pageable);
        // @Query("select e from Etudiant e where  e.nom like : x")
         //public Page<Etudiant> chercherEtudiants(@Param("x") String mc, Pageable pageable);
         @Query("select e from Etudiant e where  e.nom like : x")
         public List<Etudiant> chercherEtudiants2(@Param("x") String mc);
        @Query("select e from Etudiant e where e.dateNaissance > :x and e.dateNaissance < :y ")
        public List<Etudiant> chercherEtudiants(@Param("x") Date d1, @Param("y") Date d2);


    }

