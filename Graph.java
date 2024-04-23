import java.util.*;

public class Graph {
    private Map<String, Node> nodes;
    private Node startNode;
    private Node finishNode;

    public Graph() {
        nodes = new HashMap<>();
        startNode = null;
        finishNode = null;
    }

    public void addNode(Node node) {
        nodes.put(node.getCoordinates(), node);
        if (node.getCellType() == 'S') {
            startNode = node;
        } else if (node.getCellType() == 'F') {
            finishNode = node;
        }
    }

    public Node getNode(int x, int y) {
        String key = "(" + x + "," + y + ")";
        return nodes.getOrDefault(key, null);
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getFinishNode() {
        return finishNode;
    }
}
