import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapParser {
    public static Graph parseMap(String filename) {
        Graph graph = new Graph();

        String filePath = filename;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int y = 0;

            while ((line = reader.readLine()) != null) {
                for (int x = 0; x < line.length(); x++) {
                    char symbol = line.charAt(x);
                    Node node = new Node(x + 1, y + 1, symbol); // Adjusting x and y to start from 1
                    graph.addNode(node);

                    if (symbol != '0') {
                        Node left = graph.getNode(x, y + 1); // Adjusting left neighbor coordinates
                        Node top = graph.getNode(x + 1, y); // Adjusting top neighbor coordinates

                        if (left != null && left.getCellType() != '0') {
                            node.addNeighbor(left);
                            left.addNeighbor(node);
                        }
                        if (top != null && top.getCellType() != '0') {
                            node.addNeighbor(top);
                            top.addNeighbor(node);
                        }
                    }
                }
                y++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graph;
    }
}

