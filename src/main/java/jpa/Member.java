package jpa;

import jdk.jfr.Name;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne //맴버입자에서는 many team입장에서는 one
    @JoinColumn(name = "TEAM_ID")  // TEAM의 PK값 -> MEMBER.TEAM_ID(FK)
    private Team team;

    @OneToOne //일대일
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

//    @ManyToMany //다대다
//    @JoinColumn(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();
    @OneToMany(mappedBy = "member") //다대다 변환
    private List<MemberProduct> memberProducts = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
