package com.example.demo.web;

import com.example.demo.entities.Etudiant;
import com.example.demo.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/etudiant")
public class EtudiantControlleur {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @RequestMapping(value = "/index")
    public String index(Model model){
        Page<Etudiant> etds=etudiantRepository.findAll(PageRequest.of(0,10));
       // int pagesCount= etds.getTotalPages();
       // int[] pages = new int[pagesCount];
       // for (int i=0;i<=pagesCount;i++) pages[i]=i;
       // model.addAttribute("pages",pages);
        model.addAttribute("etudiants",etds);
        return "etudiants";
    }

}
