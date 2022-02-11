package com.legatohealth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legatohealth.bean.Item;
import com.legatohealth.dao.ItemDao;

@Service
public class ItemServiceImpl  implements ItemService{
	
	@Autowired
	private ItemDao dao;

	@Override
	public List<Item> fetchAllItems() {
		
		return dao.findAll();
	}

}
