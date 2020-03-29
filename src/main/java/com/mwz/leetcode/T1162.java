package com.mwz.leetcode;

import sun.tools.tree.AddExpression;

import java.util.*;

public class T1162 {

    private static int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxDistance(int[][] grid) {
        int max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, findMinLandDistance(grid, i, j));
                }
            }
        }
        return max;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int findMinLandDistance(int[][] grid, int i0, int j0) {
        int len = -1;
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();

        Node start = new Node(i0, j0);
        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()) {
            len++;

            int size = q.size();
            for (int s = 0; s < size; s++) {
                Node poll = q.poll();
                int x0 = poll.x;
                int y0 = poll.y;

                if (grid[x0][y0] == 1) {
                    return len;
                }

                for (int k = 0; k < 4; k++) {
                    int x = x0 + d[k][0];
                    int y = y0 + d[k][1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length) {
                        Node add = new Node(x, y);
                        if (!visited.contains(add)) {
                            q.offer(add);
                            visited.add(add);
                        }
                    }
                }
            }
        }

        return -1;
    }

}
