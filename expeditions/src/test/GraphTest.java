package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import expeditions.graph.Expedition;
import expeditions.graph.Node;
import expeditions.graph.Node.NodeType;

public class GraphTest {
	
	static Map<String, Node> nodes = new HashMap<>();
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		nodes.put("start", new Node(NodeType.START, ""));
		mD("Rome");
		mD("Athens");
		mD("Thingvellir");
		mD("Stonehenge");
		mD("Greenland");
		mD("Northwest Passage");
		mD("Newfundland");
		c("start", "Rome");
		c("start", "Athens");
		c("start", "Stonehenge");
		c("start", "Thingvellir");
		c("Thingvellir", "Stonehenge");
		c("Thingvellir", "Greenland");
		c("Greenland", "Northwest Passage");
		c("Stonehenge", "Newfundland");
		c("Northwest Passage", "Newfundland");
		
		Expedition e = new Expedition("Yellow", nodes.get("start"), 0);
		Expedition e1 = new Expedition("Red", nodes.get("start"), 1);
		Expedition e2 = new Expedition("Blue", nodes.get("start"), 2);
//		System.out.println(e.availableMoves());
//		e.explore(nodes.get("Thingvellir"));
//		System.out.println(e.availableMoves());
//		System.out.println();
//		
//		System.out.println(e1.availableMoves());
//		e1.explore(nodes.get("Stonehenge"));
//		System.out.println(e1.availableMoves());
//		System.out.println();
//		
//		System.out.println(e2.availableMoves());
//		e2.explore(nodes.get("Rome"));
//		System.out.println(e2.availableMoves());
//		
//		System.out.println(e.availableMoves());
		
		while(true) {
			System.out.println("(Y)ellow: ");
			System.out.println("\tHeads: " + e.heads());
			System.out.println("\tMoves: "  + e.availableMoves());
			
			System.out.println("(R)ed: ");
			System.out.println("\tHeads: " + e1.heads());
			System.out.println("\tMoves: "  + e1.availableMoves());
			System.out.println("(B)lue: ");
			System.out.println("\tHeads: " + e2.heads());
			System.out.println("\tMoves: "  + e2.availableMoves());
			
			System.out.print("Which Expedition? ");
			String ex = scan.nextLine();
			System.out.print("From? ");
			String src = scan.nextLine();
			System.out.print("Where? ");
			String dst = scan.nextLine();
			
			if(ex.equals("y")) e.explore(nodes.get(src), nodes.get(dst));
			else if(ex.equals("r")) e1.explore(nodes.get(src), nodes.get(dst));
			else e2.explore(nodes.get(src), nodes.get(dst));
			
			
		}
		
	}
	
	static void mD(String name) {
		nodes.put(name, new Node(NodeType.DESTINATION, name));
	}
	
	static void c(String s1, String s2) {
		Node n1 = nodes.get(s1);
		Node n2 = nodes.get(s2);
		
		n1.connect(n2);
	}

}
