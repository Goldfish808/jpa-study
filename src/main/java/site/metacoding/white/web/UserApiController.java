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
import site.metacoding.white.service.BoardService;
import site.metacoding.white.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/login")
    public String login(@RequestBody User user) {
        session.setAttribute("principal", userService.login(user));
        return "ok";
    }

    @PostMapping("/join")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "Ok";
    }

}
