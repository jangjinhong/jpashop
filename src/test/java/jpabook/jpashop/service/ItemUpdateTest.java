package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemUpdateTest {

    @Autowired EntityManager em;

    @Test
    public void updateTest() throws Exception {
        Book book = em.find(Book.class, 1L);

        //transaction
        book.setName("asdf");

        /* [transaction commit 시점]
        * transaction이 commit되면 JPA가 변경내용을 찾아 업데이트 쿼리를 자동생성하여 DB에 반영한다
        * 이를 """변경 감지""""(dirty checking) 라고 한다. flush할 때 일어남.
        * 이 매커니즘을 통해 기본적으로 JPA의 엔티티를 바꿀 수 있다. */

    }
}
