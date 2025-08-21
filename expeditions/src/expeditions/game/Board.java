package expeditions.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import expeditions.graph.Destination;
import expeditions.graph.Node;
import expeditions.graph.Node.NodeType;

public class Board {
	
	//Stack<Destination> cards;
	List<Player> players;
	
	static Map<String, Node> nodes = new HashMap<>();
	
	
	private Board(int numPlayers) {
		players = new ArrayList<Player>();
		for(int i = 0; i < numPlayers; i++)
			players.add(new Player());
		
		buildBoard();
	}

	
	
	private void buildBoard() {
		nodes.put("start", new Node(NodeType.START, ""));
		for(Destination d : Destination.values())
			nodes.put(d.niceName(), new Node(NodeType.DESTINATION, d.niceName()));
		
		c("start", "Rome");
		c("start", "Athens");
		c("start", "Stonehenge");
		c("start", "Thingvellir");
		c("start", "Svalbard");
		c("Thingvellir", "Stonehenge");
		c("Thingvellir", "Greenland");
		c("Greenland", "Northwest Passage");
		c("Stonehenge", "Newfundland");
		
		c("Athens", "Timgad");
		c("Athens", "Giza");
		c("Athens", "Petra");
		c("Timgad", "Giza");
		c("Timgad", "Timbuktu");
		c("Timgad", "Sahara");
		
		c("Timbuktu", "Elmina");
		c("Sahara", "Douala");
		c("Sahara", "Kush");
		c("Sahara", "Giza");
		c("Giza", "Axum");
		c("Kush", "Virunga");
		c("Axum", "Virunga");
		c("Elmina", "Douala");
		c("Douala", "Virunga");
		
		c("Virunga", "Victoria Falls");
		c("Victoria Falls", "Madagascar");
		
		c("Petra", "Sanaa");
		c("Petra", "Persepolis");
		c("Petra", "Babylon");
		
		c("Sanaa", "Persepolis");
		c("Persepolis", "Taj Mahal");
		c("Babylon", "Harappa");
		c("Babylon", "Caspean Sea");
		c("Taj Mahal", "Sigiriya");
		c("Taj Mahal", "Bagan");
		c("Harappa", "Mount Everest");
		c("Harappa", "Taj Mahal");
		
		c("Sigiriya", "Bagan");
		c("Sigiriya", "Angkor Wat");
		c("Mount Everest", "Xi An");
		c("Bagan", "Xi An");
		c("Angkor Wat", "Sulawesi");
		c("Sulawesi", "Papua");
		c("Papua", "Arnhem Land");
		c("Arnhem Land", "Borobudur");
		c("Arnhem Land", "Great Barrier Reef");
		c("Borobudur", "Bungle Bungle Range");
		c("Bungle Bungle Range", "Uluru");
		c("Uluru", "Perth");
		c("Uluru", "Tasmania");
		c("Tasmania", "Fiordland National Park");
		
		c("Caspian Sea", "Novosibirsk");
		c("Novosibirsk", "Putorana Plateau");
		c("Putorana Plateau", "Zagorsk");
		c("Putorana Plateau", "Sakha");
		c("Sakha", "Kolyma");
		c("Sakha", "Lake Baikal");
		c("Kolyma", "Lake Baikal");
		c("Kolyma", "Bering Strait");
		c("Lake Baikal", "Amur River");
		c("Amur River", "Great Wall");
		c("Great WalL", "Mount Fuji");
		
		c("Mackenzie Delta", "Denali");
		c("Denali", "Crater Lake");
		c("Crater Lake", "Banff");
		c("Crater Lake", "Grand Canyon");
		c("Grand Canyon", "Old Faithful");
		c("Grand Canyon", "Teotihuacan");
		c("Old Faithful", "Niagara Falls");
		c("Banff", "Niagara Falls");
		c("Louisiana", "Niagara Falls");
		c("Louisiana", "Teotihuacan");
		c("Louisiana", "Puerto Rico");
		c("Teotihuacan", "Tikal");
		c("Tikal", "Puerto Rico");
		c("Tikal", "Galapagos Islands");
		c("Tikal", "Angel Falls");
		c("Galapagos Islands", "Pacific Ocean");
		c("Pacific Ocean", "Machu Picchu");
		c("Pacific Ocean", "Rapa Nui");
		c("Machu Picchu", "Amazon Rainforest");
		c("Machu Picchu", "Altiplano");
		c("Angel Falls", "Amazon Rainforest");
		c("Amazon Rainforest", "Altiplano");
		c("Altiplano", "Atacama");
		
		c("Angel Falls", "Marajo");
		c("Marajo", "Aripuana");
		c("Marajo", "Salvador De Bahia");
		c("Aripuana", "Iguazu Falls");
		c("Salvador De Bahia", "Iguazu Falls");
		c("Iguazu Falls", "Atacama");
		
		c("Atacama", "Tierra Del Fuego");
		c("Tierra Del Fuego", "Graham Land");
		
		
		c("Omatako", "Atlantic Ocean");
		c("Atlantic Ocean", "Indian Ocean");
		
		
		
		
	}
	
	/**
	 * Connects two nodes
	 * @param s1 name of the first node
	 * @param s2 name of the second node
	 */
	private void c(String s1, String s2) {
		Node n1 = nodes.get(s1);
		Node n2 = nodes.get(s2);
		
		n1.connect(n2);
	}
}
