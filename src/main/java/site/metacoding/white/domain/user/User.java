package site.metacoding.white.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // VO 벨류 오브젝트 : 있는 그대로의 데이터를 가져오기 위한 개체
public class User {
    @Id // 프라이머리키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

}
