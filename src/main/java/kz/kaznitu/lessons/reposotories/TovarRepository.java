package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Tovar;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TovarRepository extends CrudRepository<Tovar,Long> {
    Optional<Tovar> findById(Long id);
}
