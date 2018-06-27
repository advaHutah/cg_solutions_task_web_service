package cg.solutions;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {

	private long id;
	private String name;
    
	@JsonCreator
	public Player() {}
    
	@JsonCreator
	public Player(long id, String name) {
		this.name = name;
		this.id = id;
	}

	@JsonProperty
	public long getId() {
		return id;
	}

	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public String getName() {
		return name;
	}
}
