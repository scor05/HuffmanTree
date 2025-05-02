package huffmantree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    private Node<Character> root;
    private Map<Character, String> codes = new HashMap<>();

    public void build(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node<Character>> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getFrecuency));
        for (Map.Entry<Character,Integer> e: freq.entrySet()) {
            pq.add(new Node<>(null, null, e.getKey(), e.getValue())); // Inicializar todos los nodos en la misma fila
        }
        
        while (pq.size() > 1) {
            Node<Character> left = pq.poll(); // poll = dequeue
            Node<Character> right = pq.poll();
            Node<Character> parent = new Node<>(left, right, null, left.getFrecuency() + right.getFrecuency());
            pq.add(parent);
        }
        root = pq.poll();
        generateCodes(root, "");
    }


    private void generateCodes(Node<Character> node, String code) {
        if (node == null) return;
        if (node.getVal() != null) {
            codes.put(node.getVal(), code);
        } else {
            // Las ramas de la izquierda son cero y las ramas de la derecha son 1
            generateCodes(node.getLeft(), code + '0');
            generateCodes(node.getRight(), code + '1');
        }
    }

    public String encode(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(codes.get(c));
        }
        return sb.toString();
    }

    public String decode(String bits) {
        StringBuilder sb = new StringBuilder();
        Node<Character> current = root;
        for (char b : bits.toCharArray()) {
            current = (b == '0') ? current.getLeft() : current.getRight();
            if (current.getVal() != null) {
                sb.append(current.getVal());
                current = root;
            }
        }
        return sb.toString();
    }

    public Map<Character, String> getCodes() {
        return codes;
    }
}
