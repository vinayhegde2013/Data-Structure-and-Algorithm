package com.vinay.hegde.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DijkstrasAlgorithm {

	public static void main(String[] args) {
		Node node1 = new Node("A");
		Node node2 = new Node("B");
		Node node3 = new Node("C");
		Node node4 = new Node("D");
		Node node5 = new Node("E");
		Node node6 = new Node("F");

		node1.addDestination(node2, 10);
		node1.addDestination(node3, 15);

		node2.addDestination(node4, 12);
		node2.addDestination(node6, 15);

		node3.addDestination(node5, 10);

		node4.addDestination(node5, 2);
		node4.addDestination(node6, 1);

		node6.addDestination(node5, 5);

		Graph graph = new Graph();

		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		graph.addNode(node4);
		graph.addNode(node5);
		graph.addNode(node6);

	}

	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
		source.setDistance(0);

		Set<Node> visitedNodes = new HashSet<>();
		Set<Node> unvisitedNodes = new HashSet<>();

		unvisitedNodes.add(source);

		while (unvisitedNodes.size() != 0) {
			Node currentNode = getLowestDistanceNode(unvisitedNodes);
			unvisitedNodes.remove(currentNode);
			for (Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
				Node adjacentNode = adjacencyPair.getKey();
				Integer edgeWeight = adjacencyPair.getValue();
				if (!visitedNodes.contains(adjacentNode)) {
					CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
					unvisitedNodes.add(adjacentNode);
				}
			}
			visitedNodes.add(currentNode);
		}
		return graph;
	}

	private static Node getLowestDistanceNode(Set<Node> unvisitedNodes) {
		Node lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Node node : unvisitedNodes) {
			int nodeDistance = node.getDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}

	private static void CalculateMinimumDistance(Node currentNode, Integer edgeWeigh, Node sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		if (sourceDistance + edgeWeigh < currentNode.getDistance()) {
			currentNode.setDistance(sourceDistance + edgeWeigh);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			shortestPath.add(sourceNode);
			currentNode.setShortestPath(shortestPath);
		}
	}

	public static class Graph {

		private Set<Node> nodes = new HashSet<>();

		public void addNode(Node node1) {
			nodes.add(node1);
		}

		public Set<Node> getNodes() {
			return nodes;
		}

		public void setNodes(Set<Node> nodes) {
			this.nodes = nodes;
		}

	}

	public static class Node {

		private String name;

		private List<Node> shortestPath = new LinkedList<>();

		private Integer distance = Integer.MAX_VALUE;

		Map<Node, Integer> adjacentNodes = new HashMap<>();

		public void addDestination(Node destination, int distance) {
			adjacentNodes.put(destination, distance);
		}

		public Map<Node, Integer> getAdjacentNodes() {
			return adjacentNodes;
		}

		public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
			this.adjacentNodes = adjacentNodes;
		}

		public Node(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Node> getShortestPath() {
			return shortestPath;
		}

		public void setShortestPath(List<Node> shortestPath) {
			this.shortestPath = shortestPath;
		}

		public Integer getDistance() {
			return distance;
		}

		public void setDistance(Integer distance) {
			this.distance = distance;
		}

	}
}
