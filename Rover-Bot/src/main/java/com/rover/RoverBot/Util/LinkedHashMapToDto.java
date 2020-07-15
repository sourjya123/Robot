package com.rover.RoverBot.Util;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.rover.RoverBot.DTO.Move;
import com.rover.RoverBot.DTO.Position;

public class LinkedHashMapToDto {
	public static ArrayList<Move> setMovesFromRequest(ArrayList<LinkedHashMap<String, Object>> arrayList) {
		ArrayList<Move> moves= new ArrayList<Move>();
		for(LinkedHashMap<String, Object> obj: arrayList) {
			Move move = new Move();
			for(String key:obj.keySet()) {
				switch (key) {
				case "O":
					move.setO((String) obj.get(key));
					break;
				case "L":
					move.setL((Integer) obj.get(key));
					break;
				case "F":
					move.setF((Integer) obj.get(key));
					break;
				case "R":
					move.setR((Integer) obj.get(key));
					break;
				case "B":
					move.setB((Integer) obj.get(key));
					break;
				default:
					break;
				}
			}
			move = new Move(move.getO(),move.getL(),move.getF(),move.getR(),move.getB());
			moves.add(move);
		}
		return moves;
		
	}
	
	public static Position setPositionFromRequest(LinkedHashMap<String, Object> object) {
		Position position = new Position(object.get("Direction"),object.get("X"),object.get("Y"));
		return position;
	}
}
