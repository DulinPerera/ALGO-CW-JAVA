import java.util.*;

public class Main {
    public static void main(String[] args) {
        manue();

    }

    public static void manue(){
        System.out.println("Enter option ");
        System.out.println("----------------");
        System.out.println("1:Find Shortest Path using A* ");
        Scanner input= new Scanner(System.in);
        int choice=input.nextInt();
        switch (choice) {
            case 1:
            shortestPath();
                break;
        
            default:
                break;
        }
    }

    public static void shortestPath(){
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
        System.out.println("Done");
    }

}
