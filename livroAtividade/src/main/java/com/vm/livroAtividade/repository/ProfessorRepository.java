package com.vm.livroAtividade.repository;

import com.vm.livroAtividade.model.ProfessorModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {
}
