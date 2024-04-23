import java.util.*;

public class ShortestPathFinder {
    public static List<Node> findShortestPath(Graph graph, Node start, Node finish) {
        Map<Node, Node> parentMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == finish) {
                return constructPath(parentMap, start, finish);
            }

            for (Node neighbor : current.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        return new ArrayList<>();
    }

    private static List<Node> constructPath(Map<Node, Node> parentMap, Node start, Node finish) {
        List<Node> path = new ArrayList<>();
        Node current = finish;

        while (current != start) {
            path.add(current);
            current = parentMap.get(current);
        }

        path.add(start);
        Collections.reverse(path);
        return path;
    }
}
