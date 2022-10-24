package site.metacoding.white.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
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
}
