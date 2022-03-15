package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {

  private Map map;
  private Player player;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException();
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    if (player.getInventory().getNumItems() == map.getNumItems()) {
      return true;
    }
    return false;
  }

  @Override
  public void printCellInfo() {
    System.out.println("Location: " + map.getCell(player.getPosition()).getName());
    System.out.println(map.getCell(player.getPosition()).getDescription());
    if (map.getCell(player.getPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (map.getCell(player.getPosition()).getChest() != null) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    map.getCell(player.getPosition()).visit();
  }

  @Override
  public void openChest() {
    if (map.getCell(player.getPosition()).getChest() == null) {
      System.out.println("No chest to open, sorry!");
      return;
    }
    if (map.getCell(player.getPosition()).getChest().getNumItems() == 0) {
      System.out.println("The chest is empty.");
    }
    if (map.getCell(player.getPosition()).getChest().getNumItems() != 0) {
      System.out.println(
          "You collected these items: " + map.getCell(player.getPosition()).getChest().getItems());
      player.getInventory().transferFrom(map.getCell(player.getPosition()).getChest());
    }
  }

  @Override
  public boolean canMove(Direction direction) {

    if (direction.name().equalsIgnoreCase("North")) {
      if (player.getPosition().getY() + 1 >= map.getHeight()) {
        return false;
      }
      if (map.getCell(player.getPosition().getX(), player.getPosition().getY() + 1) != null) {
        return true;
      }
    }

    if (direction.name().equalsIgnoreCase("South")) {
      if (player.getPosition().getY() < 1) {
        return false;
      }
      if (map.getCell(player.getPosition().getX(), player.getPosition().getY() - 1) != null) {
        return true;
      }
    }
    if (direction.name().equalsIgnoreCase("East")) {
      if (player.getPosition().getX() + 1 >= map.getWidth()) {
        return false;
      }
      if (map.getCell(player.getPosition().getX() + 1, player.getPosition().getY()) != null) {
        return true;
      }
    }
    if (direction.name().equalsIgnoreCase("West")) {
      if (player.getPosition().getX() < 1) {
        return false;
      }
      if (map.getCell(player.getPosition().getX() - 1, player.getPosition().getY()) != null) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void move(Direction direction) {
    if (!canMove(direction)) {
      System.out.println("You can't go that way! Try another direction.");
      return;
    }
    if (direction.name().equalsIgnoreCase("North")) {
      if (canMove(direction)) {
        player.move(direction);
        printCellInfo();
      }
    }

    if (direction.name().equalsIgnoreCase("South")) {
      if (canMove(direction)) {
        player.move(direction);
        printCellInfo();
      }
    }
    if (direction.name().equalsIgnoreCase("East")) {
      if (canMove(direction)) {
        player.move(direction);
        printCellInfo();
      }
    }
    if (direction.name().equalsIgnoreCase("West")) {
      if (canMove(direction)) {
        player.move(direction);
        printCellInfo();
      }
    }
  }
}
