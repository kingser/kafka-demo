package com.yc.kafkademo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * 描述:
 *
 * @author YC
 * @create 2018-10-07 17:09
 */
@Data
@Entity
@Table(name="person")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private int age;

    private String nation;

    private String address;
}
