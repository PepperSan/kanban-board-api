package org.peppermode.kanbanapi.service;

import lombok.RequiredArgsConstructor;
import org.peppermode.kanbanapi.domain.Board;
import org.peppermode.kanbanapi.dto.BoardDto;
import org.peppermode.kanbanapi.dto.ColumnDto;
import org.peppermode.kanbanapi.dto.TaskDto;
import org.peppermode.kanbanapi.repo.BoardColumnRepository;
import org.peppermode.kanbanapi.repo.BoardRepository;
import org.peppermode.kanbanapi.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardColumnRepository boardColumnRepository;
    private final TaskRepository taskRepository;

    public List<Board> getAll() {
        return boardRepository.findAll();
    }

    public List<BoardDto> getAllBoards() {
        return boardRepository.findAll()
                .stream()
                .map(b -> new BoardDto(b.getId(), b.getName()))
                .toList();
    }

    public BoardDto createDto(String name) {
        Board saved = boardRepository.save(new Board(name));
        return new BoardDto(saved.getId(), saved.getName());
    }

    public List<ColumnDto> getColumns(Long boardId) {
        return boardColumnRepository.findByBoardId(boardId)
                .stream()
                .map(c -> new ColumnDto(c.getId(), c.getName()))
                .toList();
    }

    public List<TaskDto> getTasks(Long columnId) {
        return taskRepository.findByBoardColumnId(columnId)
                .stream()
                .map(t -> new TaskDto(
                        t.getId(),
                        t.getTitle(),
                        t.getDescription(),
                        t.getPriority()
                ))
                .toList();
    }


}

