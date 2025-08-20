package expeditions.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Node {

	Map<Node, Connection> connections = new HashMap<>();
	NodeType type;
	String name;	
	int cycle = 0;
	
	public Node(NodeType type, String name) {
		super();
		this.type = type;
		this.name = name;
	}

	public void connect(Node other) {
		Connection conn = new Connection(this, other);
		this.connections.put(other, conn);
		other.connect(conn);
	}
	
	public void connect(Connection conn) {
		this.connections.put(conn.n1 == this ? conn.n2 : conn.n1, conn);
	}
	
	public List<Node> getExpeditionConnections(int id) {
		return connections.values().stream()
				.filter(c -> (c.state & (0xFF << (id * 2))) != 0)
				.map(c -> c.getOtherEnd(this))
				.collect(Collectors.toList());
	}
	
	public static enum NodeType {
		DESTINATION, START, BOUNCE, TICKET;
	}

	@Override
	public String toString() {
		return "Node[type=" + type + ", name=" + name + "]";
	}
	
	
	
}
