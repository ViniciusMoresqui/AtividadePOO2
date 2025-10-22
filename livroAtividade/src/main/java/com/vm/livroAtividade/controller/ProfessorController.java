package com.vm.livroAtividade.controller;

import com.vm.livroAtividade.model.ProfessorModel;
import com.vm.livroAtividade.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "/professor")
@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;
    @GetMapping
    public List<ProfessorModel> listarProfessor(){
       return this.professorService.listarProfessor();
    }

    @PostMapping
    public ProfessorModel saveProfessor(@RequestBody ProfessorModel professorModel){
        return this.professorService.saveProfessor(professorModel);
    }

    @PutMapping("/{id}")
    public ProfessorModel updateProfessor(@PathVariable Long id,@RequestBody ProfessorModel professorModel){
        return this.professorService.updateProfessor(id, professorModel);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id){
        this.professorService.deleteProfessor(id);
    }

}
