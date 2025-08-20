package expeditions.graph;

public class Connection {
	
	Node n1;
	Node n2;
	
	/**
	 * Initial 0x000000
	 * there are 3 expeditions. Each one has two bits. if the latter bit is 1, there is a connection here
	 * if the first bit is 0 the connection is from n1 to n2, if 1 then its a connection from n2 to n1
	 */
	int state = 0;

	Connection(Node n1, Node n2) {
		this.n1 = n1;
		this.n2 = n2;
		
	}
	
	void explore(Node src, Node dst, int mover) {
		int x = 2 * ((src == n1) ? 0 : 1) + 1;
		state |= x << mover;
	}
	
	Node getOtherEnd(Node n) {
		return (n == n1) ? n2 : n1;
	}
}
