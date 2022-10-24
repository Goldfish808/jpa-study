package site.metacoding.white.web;

import javax.servlet.http.HttpSession;

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
import site.metacoding.white.domain.user.User;
import site.metacoding.white.dto.BoardRequestDto.BoardSaveDto;
import site.metacoding.white.service.BoardService;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;
    private final HttpSession session;

    @PostMapping("/v2/board")
    public String saveV2(@RequestBody BoardSaveDto boardSaveDto) {
        User principal = (User) session.getAttribute("principal");
        // Insert into board (title, content, user_id) value(?, ?, ?) ==> 우리가 기대하는 쿼리
        // boardSaveDto.newInstance();
        boardSaveDto.getServiceDto().getUser();
        boardService.save(boardSaveDto);
        return "Ok";
    }

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
    public String save(@RequestBody BoardSaveDto boardSaveDto) {
        boardService.save(boardSaveDto);
        return "Ok";
    }
}
