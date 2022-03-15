package com.comp301.a02adventure;

public class PositionImpl implements Position {

  private int x, y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public Position getNeighbor(Direction direction) {

    if (direction.name().equalsIgnoreCase("North")) {
      return new PositionImpl(x, y + 1);
    }
    if (direction.name().equalsIgnoreCase("South")) {
      return new PositionImpl(x, y - 1);
    }
    if (direction.name().equalsIgnoreCase("East")) {
      return new PositionImpl(x + 1, y);
    }
    if (direction.name().equalsIgnoreCase("West")) {
      return new PositionImpl(x - 1, y);
    } else {
      return null;
    }
  }
}
