import java.util.ArrayList;
import java.util.List;

public class Node {
    private int x;
    private int y;
    private char cellType;
    private double heuristicCost;
    private double totalCost;
    private Node parent;
    private List<Node> neighbors;

    public Node(int x, int y, char cellType) {
        this.x = x;
        this.y = y;
        this.cellType = cellType;
        this.heuristicCost = 0;
        this.totalCost = 0;
        this.parent = null;
        this.neighbors = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getCellType() {
        return cellType;
    }

    public double getHeuristicCost() {
        return heuristicCost;
    }

    public void setHeuristicCost(double heuristicCost) {
        this.heuristicCost = heuristicCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public String getCoordinates() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public String toString() {
        return getCoordinates();
    }
}
