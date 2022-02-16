package com.legato.paymentservice.service;

import java.util.List;

import com.legato.paymentservice.beans.Item;

public interface ItemService {
	
	public List<Item> fetchAllItems();

}