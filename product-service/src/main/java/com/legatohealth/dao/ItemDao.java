package com.legatohealth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legatohealth.bean.Item;

public interface ItemDao  extends JpaRepository<Item, Integer>{

}
