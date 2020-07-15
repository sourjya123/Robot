package com.rover.RoverBot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rover.RoverBot.DTO.BotRequest;
import com.rover.RoverBot.DTO.Move;
import com.rover.RoverBot.DTO.Position;
import com.rover.RoverBot.Util.LinkedHashMapToDto;
import com.rover.RoverBot.exception.BotErrorCode;
import com.rover.RoverBot.exception.DirectionNotFoundException;
import com.rover.RoverBot.exception.RotationNotFoundException;
import com.rover.RoverBot.service.BotService;

@RestController
@RequestMapping("robot")
public class RobotController {

	@Autowired
	private BotService botService;

	private static final Logger log = LoggerFactory.getLogger(RobotController.class);

	@SuppressWarnings("unchecked")
	@PostMapping("/position")
	public ResponseEntity<Object> postPositionOfBot(@RequestBody HashMap<String, Object> requestBody) {
		log.info("Request Body", requestBody);
		BotRequest botRequest = new BotRequest();
		Position position = LinkedHashMapToDto
				.setPositionFromRequest((LinkedHashMap<String, Object>) requestBody.get("Position"));

		if (!position.getDirection().equals("N") && !position.getDirection().equals("E")
				&& !position.getDirection().equals("W") && !position.getDirection().equals("S")) {

			throw new DirectionNotFoundException(BotErrorCode.DIRECTION_NOT_FOUND, position.getDirection());
		}

		ArrayList<Move> moves = LinkedHashMapToDto
				.setMovesFromRequest((ArrayList<LinkedHashMap<String, Object>>) requestBody.get("Move"));

		for (Move move : moves) {
			if (move.getL() != null && move.getL() != 0 && move.getL() != 90 && move.getL() != 180 && move.getL() != 270
					&& move.getL() != 360)
				throw new RotationNotFoundException(BotErrorCode.ROTATION_NOT_FOUND, move.getL().toString());
			if (move.getR() != 0 && move.getR() != 90 && move.getR() != 180 && move.getR() != 270 && move.getR() != 360)
				throw new RotationNotFoundException(BotErrorCode.ROTATION_NOT_FOUND, move.getR().toString());
		}

		botRequest.setPosition(position);
		botRequest.setMoves(moves);

		position = botService.moveAndAddPosition(botRequest);
		log.info("Response", position.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(position);
	}

	@GetMapping("/position/from-file")
	public ResponseEntity<Object> getPositionOfBot() {

		List<Position> position = botService.getPosition();
		log.info("Response", position.get(0));
		return ResponseEntity.ok(position.get(0));
	}

}
