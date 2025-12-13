package org.peppermode.kanbanapi.controller;

import lombok.RequiredArgsConstructor;
import org.peppermode.kanbanapi.domain.Board;
import org.peppermode.kanbanapi.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public Board create(@RequestParam String name) {
        return boardService.create(name);
    }

    @GetMapping
    public List<Board> getAll() {
        return boardService.getAll();
    }
}

