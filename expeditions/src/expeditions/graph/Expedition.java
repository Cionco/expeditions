package expeditions.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Expedition {

	List<Node> steps = new ArrayList<>();
	String name;
	List<Node> heads = new ArrayList<>();
	int id;
	
	public Expedition(String name, Node start, int id) {
		heads.add(start);
		this.name = name;
		this.id = id;
	}
	
	private int mover() {
		return id * 2;
	}
	
	public Set<Node> availableMoves() {
		Set<Node> result = new HashSet<>();
		
		heads.forEach(h -> result.addAll(h.connections.values().stream()
				.filter(c -> (c.state & (0xFF << mover())) == 0)
				.map(c -> c.getOtherEnd(h))
				.collect(Collectors.toSet())));
		
		return result;
	}
	
	public Set<Node> heads() {
		return new HashSet<>(heads);
	}
	
	public void explore(Node head, Node n) {
		head.connections.get(n).explore(head, n, mover());
		heads.removeIf(r -> (r.cycle & 0x1 << id) == 0 || r == n);
		heads.add(n);
		detectNewCycles();
	}
	
	private void detectNewCycles() {
		// New head is always added to the end of the list
		Node newHead = heads.get(heads.size() - 1);
		List<Node> connections = newHead.getExpeditionConnections(id);
		if(connections.size() == 1) return;
		List<Node> path = new ArrayList<>();
		path.add(newHead);
		for(int i = 0; i < connections.size(); i++)
			detectNewCycles(connections.get(i), new ArrayList<>(path));
	}
	
	private boolean detectNewCycles(Node n, List<Node> path) {
		List<Node> connections = n.getExpeditionConnections(id);
		if(connections.size() == 1) return false;
		connections = connections.stream()
			.filter(c -> c != path.get(path.size() - 1))
			.collect(Collectors.toList());
		
		if(path.contains(n)) {
			System.out.println("Found Cycle: " + path);
			for(Node nn : path) {
				nn.cycle |= 0x1 << id;
				
			}
			return true;
		}
		path.add(n);
		
		for(int i = 0; i < connections.size(); i++)
			detectNewCycles(connections.get(i), path);
		return false;
		
	}
}
