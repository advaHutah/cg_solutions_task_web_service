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

@Path("/root")
@Produces(MediaType.APPLICATION_JSON)
public class SortedPlayerResource {
	private final String defaultName;
	private final AtomicLong counter;
	private PlayerManager manager ;

	public SortedPlayerResource(String defaultName) {
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
		this.manager = new PlayerManager();
		
	}

	@GET
	public TreeSet<Player> sortedPlayer(@QueryParam("sort") String sort) {
		if(sort.equals("id"))
			return manager.getPlayerIdTS();
		else if(sort.equals("name"))
			return manager.getPlayerNameTS();
		else
			System.out.println("Error");
		return null;
	}

	@POST
	@Timed
	public Player createNewPlayer(@QueryParam("name") Optional<String> name) {
		Player newPlayer = new Player(counter.incrementAndGet(), name.orElse(defaultName));
		manager.addPlayer(newPlayer);
		return newPlayer;
	}
}


