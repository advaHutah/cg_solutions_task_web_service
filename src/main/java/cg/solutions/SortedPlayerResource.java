package cg.solutions;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/player")
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
	public Collection<Player> sortedPlayer(@QueryParam("sort") @NotNull SortOption sort) {		
		if(sort.equals(SortOption.ID))
			return manager.getPlayerIdTS();
		else if(sort.equals(SortOption.NAME))
			return manager.getPlayerNameTS();
		return null;
	}

	@POST
	@Path("/{name}")
	public Player createNewPlayer(@PathParam("name") Optional<String> name) {
		Player newPlayer = new Player(counter.incrementAndGet(), name.orElse(defaultName));
		manager.addPlayer(newPlayer);
		return newPlayer;
	}
}


