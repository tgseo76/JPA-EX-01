package jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name="name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


//    DATE, 날짜
//    TIME, 시간
//    TIMESTAMP; 날짜시간
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob //large object 문자열 clob 그외 blob
    private String description;

    public Member() {
    }
}
