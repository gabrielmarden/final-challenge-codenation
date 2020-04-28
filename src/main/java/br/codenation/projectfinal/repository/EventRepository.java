package br.codenation.projectfinal.repository;

import br.codenation.projectfinal.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Long> {

    Optional<Event> findById(Long id);

    @Query(value="select e.* from evento as e where e.level = :level", nativeQuery = true)
    List<Event> findEventByLevel(@Param("level")String level);

}
