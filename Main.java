//Name: Dulin Perera 
//Student ID: 20221379/w1956119

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = MapParser.parseMap("map.txt");
        Node start = graph.getStartNode();
        Node goal = graph.getFinishNode();
        List<Node> shortestPath = AStar.findShortestPath(graph, start, goal); 
        if (!shortestPath.isEmpty()) {
            System.out.println("Shortest Path from Start to Finish:");

            Node previousNode = start;
            int step = 1;

            for (Node node : shortestPath) {
                if (node == start) {
                    System.out.println(step + ". Start at " + start.getCoordinates());
                } else if (node == goal) {
                    System.out.println(step + ". Move to " + goal.getCoordinates() + " (Finish)");
                } else {
                    String direction = getDirection(previousNode, node);
                    System.out.println(step + ". Move " + direction + " to " + node.getCoordinates());
                }
                step++;
                previousNode = node;
            }
            System.out.println("Done!");
        } else {
            System.out.println("No path found from Start to Finish.");
        }    
    }
    
    private static String getDirection(Node from, Node to) {
        int deltaX = to.getX() - from.getX();
        int deltaY = to.getY() - from.getY();

        if (deltaX == 1 && deltaY == 0) {
            return "right";
        } else if (deltaX == -1 && deltaY == 0) {
            return "left";
        } else if (deltaX == 0 && deltaY == 1) {
            return "down";
        } else if (deltaX == 0 && deltaY == -1) {
            return "up";
        } else {
            return "unknown";
        }
    }

}
