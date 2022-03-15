package com.comp301.a02adventure;

public class CellImpl implements Cell {

  private String name, description;
  private Position pos;
  private Inventory chest = null;
  private Boolean visit = false;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null || description == null) {
      throw new IllegalArgumentException();
    }
    this.pos = new PositionImpl(x, y);
    this.name = name;
    this.description = description;
  }

  public CellImpl(int x, int y) {
    this.pos = new PositionImpl(x, y);
    this.name = "";
    this.description = "";
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public Position getPosition() {
    return pos;
  }

  @Override
  public Inventory getChest() {
    return chest;
  }

  @Override
  public boolean getIsVisited() {
    return visit;
  }

  @Override
  public boolean hasChest() {
    return chest != null;
  }

  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException();
    }
    this.description = description;
  }

  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException();
    }
    this.chest = chest;
  }

  @Override
  public void visit() {
    visit = true;
  }
}
