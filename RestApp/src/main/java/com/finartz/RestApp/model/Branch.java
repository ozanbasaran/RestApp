package com.finartz.RestApp.model;

import com.finartz.RestApp.model.enumerated.Status;
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
@Table(name="branch")
public class Branch extends BaseDTO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    private Restaurant restaurant;

    @OneToOne(mappedBy = "branch")
    private Menu menu;

    @OneToOne(mappedBy = "branch", fetch = FetchType.LAZY)
    private Address address;

    private String name;

}

