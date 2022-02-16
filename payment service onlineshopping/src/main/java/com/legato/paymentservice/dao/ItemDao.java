package com.legato.paymentservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legato.paymentservice.beans.Item;

public interface ItemDao  extends JpaRepository<Item, Integer>{

}