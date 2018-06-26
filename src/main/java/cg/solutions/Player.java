package cg.solutions;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {

	private long id;
	private String name;
    
	@JsonCreator
	public Player() {}
    
	@JsonCreator
	public Player(long id, String name) {
		this.name = name;// TODO check it not null
		this.id = id;// TODO check if it right
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
