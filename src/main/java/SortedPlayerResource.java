import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

@Path("playing")
@Produces(MediaType.APPLICATION_JSON)
public class SortedPlayerResource {
	private final String defaultName;
	private final AtomicLong counter;
	private TreeSet<Player> playerTS;

	public SortedPlayerResource(String defaultName) {
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
		playerTS = new TreeSet<Player>();// TODO get comparator
	}

	@GET
	public List<Player> sortedPlayer() {
		// TODO
		return null;

	}

	@POST
	@Timed
	public Player addPlayer(@QueryParam("name") Optional<String> name) {
		Player newPlayer = new Player(counter.incrementAndGet(), name.orElse(defaultName));
		playerTS.add(newPlayer);
		return newPlayer;
	}
}

class IdComparator implements Comparator<Player> {

	public int compare(Player p1, Player p2) {
		return p1.getId() < p1.getId() ? -1 : p1.getId() == p2.getId() ? 0 : 1;
	}

	class NameComparator implements Comparator<Player> {

		public int compare(Player p1, Player p2) {
			return p1.getName().compareToIgnoreCase(p2.getName());
		}
	}
}
