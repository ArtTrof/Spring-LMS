package com.homework.SpringData.services;

import com.homework.SpringData.entity.Item;
import com.homework.SpringData.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }
    @Transactional
    public void changePriceForVacuumCleaner(){
        itemRepository.setPriceForVacuumCleaner();
    }
}
