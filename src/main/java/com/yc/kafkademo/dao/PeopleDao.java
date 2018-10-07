package com.yc.kafkademo.dao;

import com.yc.kafkademo.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述:
 *
 * @author YC
 * @create 2018-10-07 17:11
 */
public interface PeopleDao extends JpaRepository <People,Integer>{

}
