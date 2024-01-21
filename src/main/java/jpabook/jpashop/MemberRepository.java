package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @PersistenceContext //스프링 컨테이너에 엔티티 매니저 자동 주입. 걍 쓰면 됨
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();  //id만 반환. 저장은 커맨트성 이므로 리턴 값을 거의 만들지 않음
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
