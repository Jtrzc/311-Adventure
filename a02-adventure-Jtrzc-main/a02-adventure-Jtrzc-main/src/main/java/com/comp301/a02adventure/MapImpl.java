package com.comp301.a02adventure;

public class MapImpl implements Map {

  private int width, height, numItems;
  private CellImpl[][] grid;

  public MapImpl(int width, int height, int numItems) {
    if (width < 1 || height < 1) {
      throw new IllegalArgumentException();
    }
    this.width = width;
    this.height = height;
    this.numItems = numItems;

    grid = new CellImpl[this.width + 1][this.height + 1];
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x < 0 || y < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (x >= width || y >= height) {
      throw new IndexOutOfBoundsException();
    }
    return grid[x][y];
  }
  ;

  @Override
  public Cell getCell(Position position) {
    if (position.getX() < 0 || position.getY() < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (position.getX() >= width || position.getY() >= height) {
      throw new IndexOutOfBoundsException();
    }
    return grid[position.getX()][position.getY()];
  }

  @Override
  public void initCell(int x, int y) {
    if (x < 0 || y < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (x >= width || y >= height) {
      throw new IndexOutOfBoundsException();
    }
    grid[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return numItems;
  }
}
