package com.rover.RoverBot.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rover.RoverBot.DAO.BotDAO;
import com.rover.RoverBot.DTO.BotRequest;
import com.rover.RoverBot.DTO.Move;
import com.rover.RoverBot.DTO.Position;
import com.rover.RoverBot.Util.BotFunctionality;

@Service
public class BotServiceImpl implements BotService {

	private static final Logger log = LoggerFactory.getLogger(BotServiceImpl.class);

	@Autowired
	BotDAO botDAO;
	private static HashMap<Integer, String> degreeToDirection = new HashMap<Integer, String>();
	private static HashMap<String, Integer> directionToDegree = new HashMap<String, Integer>();
	static {
		degreeToDirection.put(0, "N");
		degreeToDirection.put(90, "E");
		degreeToDirection.put(180, "S");
		degreeToDirection.put(270, "W");

		directionToDegree.put("N", 0);
		directionToDegree.put("E", 90);
		directionToDegree.put("S", 180);
		directionToDegree.put("W", 270);
	}

	@Override
	public List<Position> getPosition() {
		// TODO Auto-generated method stub
		return botDAO.getPosition();
	}

	@Override
	public Position moveAndAddPosition(BotRequest botRequest) {
		BotFunctionality.sortMovesByOrder(botRequest);
		Position position = botRequest.getPosition();
		Integer currentDegree = directionToDegree.get(position.getDirection());
		Integer currentX = position.getX();
		Integer currentY = position.getY();
		for (Move move : botRequest.getMoves()) {
			currentDegree = (currentDegree + move.getR()) % 360;
			switch (currentDegree) {
			case 0:
				currentY = currentY + move.getF();
				break;
			case 90:
				currentX = currentX + move.getF();
				break;
			case 180:
				currentY = currentY - move.getF();
				break;
			case 270:
				currentX = currentX - move.getF();
				break;

			default:
				break;
			}
		}
		position.setDirection(degreeToDirection.get(currentDegree));
		position.setX(currentX);
		position.setY(currentY);
		log.info(position.toString());
		botDAO.moveAndAddPosition(position);
		return position;
	}

}
