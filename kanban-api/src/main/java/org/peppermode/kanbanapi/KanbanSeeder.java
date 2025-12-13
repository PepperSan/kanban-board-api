package org.peppermode.kanbanapi;

import lombok.RequiredArgsConstructor;
import org.peppermode.kanbanapi.domain.Board;
import org.peppermode.kanbanapi.domain.BoardColumn;
import org.peppermode.kanbanapi.domain.Task;
import org.peppermode.kanbanapi.repo.BoardColumnRepository;
import org.peppermode.kanbanapi.repo.BoardRepository;
import org.peppermode.kanbanapi.repo.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KanbanSeeder implements CommandLineRunner {

    private final BoardRepository boardRepository;
    private final TaskRepository taskRepository;
    private final BoardColumnRepository boardColumnRepository;

    @Override
    public void run(String... args) {
        Board board = new Board("My first board");
        boardRepository.save(board);

        BoardColumn todo = new BoardColumn("TODO", board);
        BoardColumn done = new BoardColumn("DONE", board);

        board.getBoardColumns().add(todo);
        board.getBoardColumns().add(done);

        // 1) сначала сохранить board + колонки (чтобы у колонок появились id)
        boardRepository.save(board);

        // 2) СУПЕР-надёжно: взять колонки заново из репы (они точно managed)
        BoardColumn todoManaged = boardColumnRepository.findByBoardId(board.getId())
                .stream()
                .filter(c -> "TODO".equals(c.getName()))
                .findFirst()
                .orElseThrow();

        Task t1 = new Task("Task 1", "first task", 1, todoManaged);
        Task t2 = new Task("Task 2", "second task", 2, todoManaged);

        taskRepository.save(t1);
        taskRepository.save(t2);

        System.out.println("Seed done. Board id = " + board.getId());
    }

}

