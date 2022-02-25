package com.skyfall.money.manager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@ToString
@Table(name = "expense")
public class Expense extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;

    private String description;

    private String category;

    private Date date;
}
