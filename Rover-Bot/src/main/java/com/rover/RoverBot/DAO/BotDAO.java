package com.rover.RoverBot.DAO;

import java.util.List;

import com.rover.RoverBot.DTO.Position;

public interface BotDAO {

	public List<Position> getPosition();
	public void moveAndAddPosition(Position position);
}
