package com.legato.paymentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legato.paymentservice.beans.Item;
import com.legato.paymentservice.dao.ItemDao;

@Service
public class ItemServiceImpl  implements ItemService{
	
	@Autowired
	private ItemDao dao;

	@Override
	public List<Item> fetchAllItems() {
		
		return dao.findAll();
	}

}