package com.example.demo;

import com.example.demo.entities.Etudiant;
import com.example.demo.repository.EtudiantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import java.text.*;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

        public static void main(String[] args) throws ParseException {
    
            ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
    
           EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
           DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
           etudiantRepository.save(new Etudiant("oumayma", df.parse("22-05-1997"), "oumayma@gmqil.com","gdshjfg.jpg"));
            etudiantRepository.save(new Etudiant("test", df.parse("22-05-1998"), "test@gmqil.com","gdshjfg.jpg"));
            etudiantRepository.save(new Etudiant("test2", df.parse("22-05-2000"), "test2@gmqil.com","gdshjfg.jpg"));
            etudiantRepository.save(new Etudiant("oumayma", df.parse("22-05-1997"), "oumayma@gmqil.com","gdshjfg.jpg"));
            etudiantRepository.save(new Etudiant("test", df.parse("22-05-1998"), "test@gmqil.com","gdshjfg.jpg"));
            etudiantRepository.save(new Etudiant("test2", df.parse("22-05-2000"), "test2@gmqil.com","gdshjfg.jpg"));
            Page<Etudiant> etudiants;
            etudiants = etudiantRepository.findAll(PageRequest.of(0, 3));// afficher toute la liste
            etudiants.forEach(e ->System.out.println(e.getNom()) );
          /*  Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
            Page<Etudiant> etudiants2;
            etudiants2 = etudiantRepository.chercherEtudiants("%f%", PageRequest.of(1, 3));
            etudiants2.forEach(e ->System.out.println(e.getNom()) );*/
            List<Etudiant> etudiants2;
            etudiants2 = etudiantRepository.chercherEtudiants2("%f%");
            etudiants2.forEach(e ->System.out.println(e.getNom()) );

            List<Etudiant> etudiants3;
            etudiants3=etudiantRepository.chercherEtudiants(df.parse("22-05-1997"),df.parse("22-05-2000") );
            etudiants3.forEach(e ->System.out.println(e.getNom()) );


        }


}
