package com.rover.RoverBot.Util;

import java.util.Collections;
import java.util.Comparator;

import com.rover.RoverBot.DTO.BotRequest;
import com.rover.RoverBot.DTO.Move;

public class BotFunctionality {
	public static void sortMovesByOrder(BotRequest botRequest) {
		Collections.sort(botRequest.getMoves(),new Comparator<Move>() {

			@Override
			public int compare(Move o1, Move o2) {
				// TODO Auto-generated method stub
				return o1.getO().compareTo(o2.getO());
			}
			
		});
	}
}
