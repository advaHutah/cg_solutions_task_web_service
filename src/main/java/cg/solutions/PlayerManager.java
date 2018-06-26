package cg.solutions;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class PlayerManager {

	private TreeSet<Player> playerIdTS;
	private TreeSet<Player> playerNameTS;

	public PlayerManager() {
	
		this.playerIdTS = new TreeSet<Player>(Comparator.comparingLong(Player::getId));
		this.playerNameTS = new TreeSet<Player>(Comparator.comparing(Player::getName).thenComparing(Player::getId));	}
	public void addPlayer(Player newPlayer)
	{
		this.playerIdTS.add(newPlayer);
		this.playerNameTS.add(newPlayer);
	}
	
	public TreeSet<Player> getPlayerIdTS() {
		return playerIdTS;
	}
	
	public TreeSet<Player> getPlayerNameTS() {
		return playerNameTS;
	}

}
