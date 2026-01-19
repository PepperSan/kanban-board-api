package org.peppermode.kanbanapi.service;

import lombok.RequiredArgsConstructor;
import org.peppermode.kanbanapi.domain.Board;
import org.peppermode.kanbanapi.dto.BoardDto;
import org.peppermode.kanbanapi.repo.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board create(String name) {
        Board board = new Board(name);
        return boardRepository.save(board);
    }

    public List<Board> getAll() {
        return boardRepository.findAll();
    }

    public List<BoardDto> getAllBoards() {
        return boardRepository.findAll()
                .stream()
                .map(b -> new BoardDto(b.getId(), b.getName()))
                .toList();
    }
}

