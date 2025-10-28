package com.vm.livroAtividade.repository;

import com.vm.livroAtividade.model.LivroModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
