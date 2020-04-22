package br.codenation.projectfinal.repository;

import br.codenation.projectfinal.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento,Long> {

    Optional<Evento> findById(Long id);

    @Query(value="select e.* from evento as e where e.level = :level", nativeQuery = true)
    List<Evento> findEventoByLevel(@Param("level")String level);

}
