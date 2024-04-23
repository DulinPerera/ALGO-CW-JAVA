//Name: Dulin Perera 
//Student ID: 20221379/w1956119

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
                    Node node = new Node(x + 1, y + 1, symbol); 
                    graph.addNode(node);

                    if (symbol != '0') {
                        Node left = graph.getNode(x, y + 1); 
                        Node top = graph.getNode(x + 1, y); 

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

