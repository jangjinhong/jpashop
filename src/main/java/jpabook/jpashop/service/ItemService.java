package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Transactional // 3. 코드 끝난뒤 트랜잭션 커밋이 됨
    public void udpateItem(Long itemId, int price, String name, int setStockQuantity) {
        Item findItem = itemRepository.findOne(itemId); // 1. 영속상태 엔티티 찾아옴
        findItem.setPrice(price);    // 2. 영속상태 엔티티에 파마리터 값 세팅
        findItem.setName(name);
        findItem.setStockQuantity(setStockQuantity);
        // 4. 그러면 JPA가 flush를 날림
        // 5. 영속성 컨텍스트에 있는 엔티티 중, 변경내용의 엔티티를 찾음
        // 6. 변경값으로 업데이트하여 업데이트 쿼리 자동 생성 -> DB에 날림
        // 그래서 따로 save() 등의 리포지토리 메서드를 호출할 필요가 없음
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
