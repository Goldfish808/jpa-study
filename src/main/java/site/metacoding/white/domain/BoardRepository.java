package site.metacoding.white.domain;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final EntityManager sM;

    @Transactional
    public void save(Board board) {
        sM.persist(board);
    }

    public void deleteById(Long id) {
        sM.createQuery("DELETE from Board b where b.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public Board findById(Long id) {
        Board boardPS = sM.createQuery("select b from Board b where b.id =:id", Board.class)
                .setParameter("id", id)
                .getSingleResult();
        return boardPS;
    }

    public List<Board> findAll() {
        List<Board> boardPS = sM.createQuery("select b from Board b", Board.class)
                .getResultList();
        return boardPS;
    }
}
