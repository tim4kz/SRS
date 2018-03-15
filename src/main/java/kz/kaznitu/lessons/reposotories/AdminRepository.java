package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Optional<Admin> findById(Long id);
}
