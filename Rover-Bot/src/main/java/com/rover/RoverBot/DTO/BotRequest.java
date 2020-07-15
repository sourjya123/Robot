package com.rover.RoverBot.DTO;

import java.util.ArrayList;

public class BotRequest {

	public BotRequest() {
		// TODO Auto-generated constructor stub
	}
	private Position position;
	private ArrayList<Move> moves;
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public ArrayList<Move> getMoves() {
		return moves;
	}
	public void setMoves(ArrayList<Move> moves) {
		this.moves = moves;
	}
	
	@Override
	public String toString() {
		return "BotRequest [position=" + position + ", moves=" + moves + "]";
	}
	
}
