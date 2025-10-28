package com.vm.livroAtividade.service;

import com.vm.livroAtividade.model.LivroModel;
import com.vm.livroAtividade.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> listarLivro(){
        return this.livroRepository.findAll();
    }

    public LivroModel saveLivro(LivroModel professorModel){
        return this.livroRepository.save(professorModel);
    }

    public LivroModel updateLivro(Long id, LivroModel livroModel) {
        LivroModel livroExistente = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com id " + id));

        livroExistente.setTitulo(livroModel.getTitulo());
        livroExistente.setAutor(livroModel.getAutor());
        livroExistente.setGenero(livroModel.getGenero());

        return livroRepository.save(livroExistente);
    }

    public void deleteLivro(Long id){
        this.livroRepository.deleteById(id);
    }

}
