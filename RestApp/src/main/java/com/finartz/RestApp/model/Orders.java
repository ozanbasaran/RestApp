package com.finartz.RestApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "orders")
public class Orders extends BaseDTO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @Column(name = "total_price")
    private Float totalPrice;

    @OneToOne
    @JoinColumn(name = "basket_id", referencedColumnName = "id", nullable = false)
    private Basket basket;

    @OneToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private CreditCard creditCard;


}
