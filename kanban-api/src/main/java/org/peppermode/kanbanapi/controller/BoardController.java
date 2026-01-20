package org.peppermode.kanbanapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.peppermode.kanbanapi.dto.BoardDto;
import org.peppermode.kanbanapi.dto.ColumnDto;
import org.peppermode.kanbanapi.dto.CreateBoardRequest;
import org.peppermode.kanbanapi.dto.TaskDto;
import org.peppermode.kanbanapi.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<BoardDto> getBoards() {
        return boardService.getAllBoards();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardDto create(@Valid @RequestBody CreateBoardRequest req) {
        return boardService.createDto(req.name());
    }

    @GetMapping("/{boardId}/columns")
    public List<ColumnDto> getColumns(@PathVariable Long boardId) {
        return boardService.getColumns(boardId);
    }

    @GetMapping("/columns/{id}/tasks")
    public List<TaskDto> getTasks(@PathVariable Long id) {
        return boardService.getTasks(id);
    }


}


