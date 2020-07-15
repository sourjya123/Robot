package com.rover.RoverBot.service;

import java.util.List;

import com.rover.RoverBot.DTO.BotRequest;
import com.rover.RoverBot.DTO.Position;

public interface BotService {
	public List<Position> getPosition();
	public Position moveAndAddPosition(BotRequest botRequest);
}
