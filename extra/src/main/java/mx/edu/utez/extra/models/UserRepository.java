package mx.edu.utez.extra.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User getById(Long id);
    List<User> findByBirthdayBefore(LocalDate date);

}
