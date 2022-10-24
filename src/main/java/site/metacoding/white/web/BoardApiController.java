package site.metacoding.white.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.domain.board.Board;
import site.metacoding.white.domain.board.BoardRepository;
import site.metacoding.white.service.BoardService;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping(value = { "/board/{id}", "/board" })
    public Object findById(@PathVariable(required = false) Long id) {
        if (id != null) {
            return boardService.findById(id);
        }
        return boardService.findAll();

    }

    @PutMapping("/board/{id}")
    public String update(@PathVariable Long id, @RequestBody Board board) {
        boardService.update(id, board);
        return "ok";
    }

    @DeleteMapping("/board/{id}")
    public String delete(@PathVariable Long id) {
        boardService.deleteById(id);
        return "ok";
    }

    @PostMapping("/board")
    public String save(@RequestBody Board board) {
        boardService.save(board);
        return "Ok";
    }
}
