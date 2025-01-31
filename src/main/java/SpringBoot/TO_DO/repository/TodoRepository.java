package SpringBoot.TO_DO.repository;

import SpringBoot.TO_DO.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<ToDo , Long> {
}
