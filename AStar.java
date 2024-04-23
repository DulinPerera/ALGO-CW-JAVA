//Name: Dulin Perera 
//Student ID: 20221379/w1956119

import java.util.*;

public class AStar {
    public static List<Node> findShortestPath(Graph graph, Node start, Node goal) {
        Set<Node> visited = new HashSet<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(Node::getTotalCost));
        Map<Node, Node> parentMap = new HashMap<>();
        Map<Node, Double> gScore = new HashMap<>();
        
        gScore.put(start, 0.0);
        start.setHeuristicCost(calculateHeuristic(start, goal));
        start.setTotalCost(start.getHeuristicCost());
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == goal) {
                return reconstructPath(parentMap, current);
            }

            visited.add(current);

            for (Node neighbor : current.getNeighbors()) {
                if (visited.contains(neighbor)) {
                    continue;
                }

                double tentativeGScore = gScore.getOrDefault(current, Double.MAX_VALUE) + 1;
                if (tentativeGScore < gScore.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    parentMap.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    neighbor.setHeuristicCost(calculateHeuristic(neighbor, goal));
                    neighbor.setTotalCost(tentativeGScore + neighbor.getHeuristicCost());
                    if (!queue.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(); 
    }

    private static List<Node> reconstructPath(Map<Node, Node> parentMap, Node current) {
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    private static double calculateHeuristic(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }
}
