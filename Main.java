import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Graph graph = MapParser.parseMap("map.txt");

       
        Node start = graph.getStartNode();
        Node goal = graph.getFinishNode();

        
        List<Node> shortestPath = AStar.findShortestPath(graph, start, goal);

       
        if (!shortestPath.isEmpty()) {
            System.out.println("Shortest Path from Start to Finish:");
            for (Node node : shortestPath) {
                System.out.println("Move to: " + node.getCoordinates());
            }
        } else {
            System.out.println("No path found from Start to Finish.");
        }
    }
}
