package challenge.task.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Path implements Cloneable {

	private final ArrayList<Node> nodeList;
	private Set<Node> nodeSet;
	private int totalSum;

	public Path() {
		this.nodeList = new ArrayList<>();
		this.nodeSet = new HashSet<>();
		this.totalSum = 0;
	}

	private Path(final ArrayList<Node> nodeList, final Set<Node> nodeSet, final int totalSum) {
		this.nodeList = nodeList;
		this.nodeSet = nodeSet;
		this.totalSum = totalSum;
	}

	public int addNode(final Node nodeToAdd) {
		if (nodeSet.contains(nodeToAdd)) {
			// throw new IllegalArgumentException("Can't add a Node that already is part of
			// the path.");
			return -1;
		}
		this.nodeList.add(nodeToAdd);
		nodeSet = new HashSet<>(nodeList);

		this.totalSum += nodeToAdd.getValue();

		return this.totalSum;
	}

	public Node getLastNode() {
		return nodeList.get(nodeList.size() - 1);
	}

	@Override
	public Path clone() {
		final ArrayList<Node> nodes = new ArrayList<>(this.nodeList);
		final HashSet<Node> setNodes = new HashSet<>(this.nodeSet);

		return new Path(nodes, setNodes, this.totalSum);
	}

	@Override
	public String toString() {
		final StringBuilder toString = new StringBuilder();
		toString.append("TotalSum = " + totalSum);
		toString.append("Path = ");
		for (int node = 0; node < nodeList.size(); node++) {
			toString.append(nodeList.get(node).getValue() + " => ");
		}

		return toString.toString();
	}

}
