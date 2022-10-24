package site.metacoding.white.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice.Return;
import site.metacoding.white.domain.board.Board;
import site.metacoding.white.domain.board.BoardRepository;
import site.metacoding.white.domain.user.User;
import site.metacoding.white.domain.user.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional // 트랜젝션이 붙지 않으면 영속화 되어있는 객체가 flush 되지 않음
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true) // 셀렉트 SELECT 하는데에는 readOnly 를 활성화 해줌
    public User login(User user) {
        User userPS = userRepository.findByUsername(user.getUsername());
        if (user.getPassword() == userPS.getPassword()) {
            return userPS;
        } else {
            throw new RuntimeException("패스워드가 잘 못 되었습니다");
        }
    }
}
