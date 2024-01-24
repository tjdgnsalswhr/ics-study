package com.springboot.api.data.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

// 예제 6.6, 예제 6.30, 6.31, 6.32, 6.33, 6.34, 6.35, 6.36, 6.37
// 엔티티는 데이터베이스 테이블에 대응됨
@Entity                     // 해당 클래스가 엔티티임을 명시, 클래스는 테이블과 일대일로 매핑, 인스턴스는 테이블에서 하나의 레코드가 됨
@Getter                     //
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "name")
@Table(name = "product")    // 엔티티 자체가 테이블과 매핑되므로 특별한 경우가 아니면 필요없는 어노테이션, 클래스의 이름과 테이블의 이름을 다르게 지정할때 사용, 사용하지 않으면 클래스 이름이 테이블 이름
public class Product {

    @Id   // 엔티티 클래스의 필드는 테이블의 칼럼과 매핑, ID 어노테이션은 테이블의 기본값으로 사용, 모든 엔티티는 @ID 필요
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // @Id와 함께 사용, 이게 붙어있는 필드의 값을 어떻게 자동 생성할지 결정
    // 직접할당
    // AUTO (어노테이션의 기본값, 사용하는 데이터베이스에 맞게 자동 생성)
    // IDENTITY (기본값 생성을 데이터베이스에 위임, 데이터베이스의 AUTO_INCREMENT 사용)
    // SEQUENCE (@SequenceGenerator 어노테이션으로 식별자 생성기 설정, 자동 주입)
    private Long number;

    @Column(nullable = false)   // 엔티티 클래스의 필드는 자동으로 테이블 칼럼 매핑, 별다른 설정을 하지 않으며 명시 안해도 됨, 필드에 설정을 더하고 싶을때 사용
    // name : 데이터베이스 칼럼명 설정, 명시 안하면 필드명으로 자동 지정
    // nullable : null 처리 가능한지 명시
    // length : 데이터베이스에 저장하는 최대 길이 설정
    // unique : 해당 칼럼 유니크로 설정
    private String name;

    // 반대로, @Transient 어노테이션을 사용하면 클래스의 필드를 테이블의 칼럼으로 사용하지 않도록 할 수도 있음. (필요한가?)

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}