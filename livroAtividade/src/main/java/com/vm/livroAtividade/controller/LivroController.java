package com.vm.livroAtividade.controller;

import com.vm.livroAtividade.model.LivroModel;
import com.vm.livroAtividade.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "/livros")
@RestController
@CrossOrigin(origins = "*")
public class LivroController {

    @Autowired
    private LivroService livroService;
    @GetMapping
    public List<LivroModel> listarLivro(){
       return this.livroService.listarLivro();
    }

    @PostMapping
    public LivroModel saveLivro(@RequestBody LivroModel livroModel){
        return this.livroService.saveLivro(livroModel);
    }

    @PutMapping("/{id}")
    public LivroModel updateLivro(@PathVariable Long id, @RequestBody LivroModel livroModel){
        return this.livroService.updateLivro(id, livroModel);
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable Long id){
        this.livroService.deleteLivro(id);
    }

}
