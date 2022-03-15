package com.comp301.a02adventure;

public class PlayerImpl implements Player {
  private String name;
  private Position pos;
  private Inventory inv;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    pos = new PositionImpl(startX, startY);
    this.name = name;
    inv = new InventoryImpl();
  }

  @Override
  public Position getPosition() {
    return pos;
  }

  @Override
  public Inventory getInventory() {
    return inv;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void move(Direction direction) {
    pos = pos.getNeighbor(direction);
  }
}
