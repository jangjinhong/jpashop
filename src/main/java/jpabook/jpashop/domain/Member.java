package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@ToString
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // Member, Order => 1 회원이 n개 주문 일대다 관계이므로
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
