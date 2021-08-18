package edu.ifmt.cobrancaifmt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Titulos extends JpaRepository<Titulo, Long> { //titulo é a entidade, e long o id da entidade

}
