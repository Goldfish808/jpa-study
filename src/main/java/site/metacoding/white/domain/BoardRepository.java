package site.metacoding.white.domain;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final EntityManager sM;

    public void save(Board board) {
        sM.persist(board); // Insert 쿼리문이 동작하면서 Insert를 해줌

    }
}
