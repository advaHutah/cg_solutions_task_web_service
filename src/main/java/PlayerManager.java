import java.util.Comparator;
import java.util.TreeSet;

public class PlayerManager {

	private TreeSet<Player> playerIdTS;
	private TreeSet<Player> playerNameTS;

	public PlayerManager() {
		this.playerIdTS = new TreeSet<Player>(new IdComparator());
		this.playerNameTS = new TreeSet<Player>(new NameComparator());
	}
	
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

	class IdComparator implements Comparator<Player> {

		public int compare(Player p1, Player p2) {
			return p1.getId() < p1.getId() ? -1 : p1.getId() == p2.getId() ? 0 : 1;
		}
	}

	class NameComparator implements Comparator<Player> {

		public int compare(Player p1, Player p2) {
			return p1.getName().compareToIgnoreCase(p2.getName());
		}
	}
}
