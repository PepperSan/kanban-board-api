package org.peppermode.kanbanapi.repo;

import org.peppermode.kanbanapi.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByBoardColumnId(Long boardColumnId);
}

