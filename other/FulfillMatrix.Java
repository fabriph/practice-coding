import java.io.*;
import java.util.*;
/*
[
  0,0,0
  0,1,0
  1,1,1
]
calculate distance from zeroes to 1s:
[
  0,0,0
  0,1,0
  1,2,1
]
*/

class Main {
  public static void bfs(int[][] matrix, Pair position, int distance) {
    if (!position.isValid(matrix) || matrix[position.x][position.y] == 0) {
      return;
    }
    if (matrix[position.x][position.y] <= distance) {
      return;
    }
    matrix[position.x][position.y] = distance;
    bfs_spread(matrix, position, distance + 1);
  }

  private static void bfs_spread(int[][] matrix, Pair position, int distance) {
    bfs(matrix, new Pair(position.x + 1, position.y), distance);
    bfs(matrix, new Pair(position.x - 1, position.y), distance);
    bfs(matrix, new Pair(position.x, position.y + 1), distance);
    bfs(matrix, new Pair(position.x, position.y - 1), distance);
  }
  
  public static void version2(int[][] matrix) {
    List<Pair> zeroes = getAllZeroes(matrix);
    maxOutOnes(matrix);
    for (Pair p : zeroes) {
      bfs_spread(matrix, p, 1);
    }
  }

  private static void maxOutOnes(int[][] matrix) {
    for (int x = 0; x < matrix.length; x++) {
      for (int y = 0; y < matrix[x].length; y++) {
        if (matrix[x][y] == 1) {
          matrix[x][y] = Integer.MAX_VALUE;
        }
      }
    }
  }
  
  private static List<Pair> getAllZeroes(int[][] matrix) {
    // could have iterated directly instead of creating a list
    List<Pair> list =  new LinkedList<>();
    for (int x = 0; x < matrix.length; x++) {
      for (int y = 0; y < matrix[x].length; y++) {
        if (matrix[x][y] == 0) {
          list.add(new Pair(x, y));
        }
      }
    }
    if (list.isEmpty()) {
      throw new RuntimeException("No zeros in the matrix");
    }
    return list;
  }

  public static void main(String[] args) {
    int[][] matrix0 = new int[][] {
      new int[] {0, 0, 0},
      new int[] {0, 0, 0},
      new int[] {0, 0, 0}
    };

    int[][] matrix1 = new int[][] {
      new int[] {0, 0, 0},
      new int[] {0, 1, 0},
      new int[] {1, 1, 1}
    };

    int[][] matrix2 = new int[][] {
      new int[] {0, 1, 1, 0, 1, 0},
      new int[] {0, 1, 1, 1, 0, 1},
      new int[] {0, 1, 1, 1, 1, 1},
      new int[] {0, 1, 1, 1, 0, 1},
      new int[] {0, 1, 1, 1, 0, 1},
      new int[] {1, 1, 1, 0, 0, 0}
    };

    //int[][] matrix = matrix0;
    //int[][] matrix = matrix1;
    int[][] matrix = matrix2;
    
    printMatrix(matrix);
    version2(matrix);
    System.out.println("");
    printMatrix(matrix);

  }
  
  private static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(String.valueOf(matrix[i][j]) + " ");
      }
      System.out.println("");
    }
  }
  
  private static class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public boolean isValid(int[][] matrix) {
      return 0 <= x && 0 <= y && x < matrix.length && y < matrix[0].length;
    }

    public String toString() {
      return "( "+ this.x + ", " + this.y + " )";
    }
  }
}
