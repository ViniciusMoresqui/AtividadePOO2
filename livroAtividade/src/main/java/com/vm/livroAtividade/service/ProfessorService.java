package com.vm.livroAtividade.service;

import com.vm.livroAtividade.model.ProfessorModel;
import com.vm.livroAtividade.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorModel> listarProfessor(){
        return this.professorRepository.findAll();
    }

    public ProfessorModel saveProfessor(ProfessorModel professorModel){
        return this.professorRepository.save(professorModel);
    }

    public ProfessorModel updateProfessor(Long id, ProfessorModel professorModel) {
        ProfessorModel professorExistente = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com id " + id));

        professorExistente.setClasse(professorModel.getClasse());
        professorExistente.setMateria(professorModel.getMateria());

        return professorRepository.save(professorExistente);
    }

    public void deleteProfessor(Long id){
        this.professorRepository.deleteById(id);
    }

}
