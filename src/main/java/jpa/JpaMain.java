package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//META-INF패키지 안에있는 xml파일의 <persistence-unit name="hello"> name값
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        Member member= new Member();
//        member.setId(2L);
//        member.setName("Hello2");
//
//        em.persist(member);
//
//        tx.commit();
//
//        em.close();
//        emf.close();
        try {
            Member member = new Member();
            member.setId(3L);
            member.setName("Hello3");

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();


    }
}
