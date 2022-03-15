package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private List<Item> list;

  public InventoryImpl() {
    list = new ArrayList<Item>(0);
  }

  @Override
  public boolean isEmpty() {
    return list.size() == 0;
  }

  @Override
  public int getNumItems() {
    return list.size();
  }

  @Override
  public List<Item> getItems() {
    List<Item> copy = new ArrayList<>(list);
    return copy;
  }

  @Override
  public void addItem(Item item) {
    list.add(item);
  }

  @Override
  public void removeItem(Item item) {
    list.remove(item);
    while (list.contains(item)) {
      list.remove(item);
    }
  }

  @Override
  public void clear() {
    list.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    List<Item> holder = new ArrayList<Item>();
    holder = other.getItems();
    other.clear();
    list.addAll(holder);
  }
}
