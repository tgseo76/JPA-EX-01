package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//META-INF패키지 안에있는 xml파일의 <persistence-unit name="hello"> name값
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);
            
            //조회
            System.out.println("조회");

            em.flush(); //영속성 컨텍스트의 내용을 db에 반영
            em.clear(); //영속성컨텍스트 비우기

            Member findMember = em.find(Member.class,member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            System.out.println("-----------------------------------");
            for (Member m: members  ) {
                System.out.println("m = "+m.getUsername());
            }




            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();


    }
}
