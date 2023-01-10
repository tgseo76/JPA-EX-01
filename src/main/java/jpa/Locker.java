package jpa;

import javax.persistence.*;

@Entity
public class Locker {
//member와 1:1매핑
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne(mappedBy = "locker") //있으면 양방향 없으면 단방향
    private Member member;
}
