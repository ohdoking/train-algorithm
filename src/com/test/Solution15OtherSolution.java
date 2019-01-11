package com.test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Solution15OtherSolution {

  private static enum Move {
    RIGHT {
      @Override
      Point move(Point p, String[][] fighters) {
        return new Point(p.x, p.y == fighters[p.x].length - 1 ? 0 : p.y + 1);
      }
    }, LEFT {
      @Override
      Point move(Point p, String[][] fighters) {
        return new Point(p.x, p.y == 0 ? fighters[p.x].length - 1 : p.y - 1);
      }
    }, UP {
      @Override
      Point move(Point p, String[][] fighters) {
        return new Point(p.x == 0 ? p.x : p.x - 1, p.y);
      }
    }, DOWN {
      @Override
      Point move(Point p, String[][] fighters) {
        return new Point(p.x == fighters.length - 1 ? p.x : p.x + 1, p.y);
      }
    };

    abstract Point move(Point start, String[][] fighters);
  }

  public static String[] streetFighterSelection(String[][] fighters, Point position, List<Move> moves) {
    Point start = null;
    String[] names = new String[moves.size()];
    int i = 0;
    for (Move move : moves) {
      start = move.move(start == null ? position : start, fighters);
      names[i++] = fighters[start.x][start.y];
    }
    return names;
  }

  public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
    return streetFighterSelection(fighters, new Point(position[0], position[1]), new ArrayList<Move>() {
      {
        for (String m : moves) {
          add(Move.valueOf(m.toUpperCase()));
        }
      }
    });
  }
}