package site.metacoding.white.domain.user;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final EntityManager sM;

    @Transactional
    public void save(User user) {
        sM.persist(user);
    }

    public User findByUsername(String username) {
        return sM.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

}
