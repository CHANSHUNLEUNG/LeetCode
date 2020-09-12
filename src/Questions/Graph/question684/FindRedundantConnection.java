package Questions.Graph.question684;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (uf.connect(u, v)) {
                return edge;
            }
            uf.union(u, v);
        }
        return new int[]{-1, -1};
    }

    private class UF {
        int[] id;

        UF(int size) {
            id = new int[size];
            for (int index = 0; index < size; index++) {
                id[index] = index;
            }
        }

        void union(int u, int v) {
            int uRoot = id[u];
            int vRoot = id[v];
            if (uRoot == vRoot) {
                return;
            }
            for (int index = 0; index < id.length; index++) {
                if (id[index] == uRoot) {
                    id[index] = id[v];
                }
            }
        }

        int find(int u) {
            return id[u];
        }

        boolean connect(int u, int v) {
            return find(u) == find(v);
        }
    }

}
