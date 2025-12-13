package org.peppermode.kanbanapi.repo;


import org.peppermode.kanbanapi.domain.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardColumnRepository extends JpaRepository<BoardColumn, Long> {
    List<BoardColumn> findByBoardId(Long boardId);
}


