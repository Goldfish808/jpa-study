package site.metacoding.white.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 테이블 id 번호 증가 전략 : 해당 DB( mariaDB ) 의 전략을 따라감
    private Long id;
    private String title;
    @Column(length = 1000)
    private String content;

    private String author;
}