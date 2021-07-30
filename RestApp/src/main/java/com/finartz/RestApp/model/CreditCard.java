package com.finartz.RestApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "credit_card")
public class CreditCard extends BaseDTO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "card_no")
    private String cardNo;

    private String name;

    @Column(name = "exp_month")
    private int expMonth;

    @Column(name = "exp_year")
    private int expYear;

    private int ccv;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

}
