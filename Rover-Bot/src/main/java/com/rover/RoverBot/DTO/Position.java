package com.rover.RoverBot.DTO;

import com.opencsv.bean.CsvBindByName;

public class Position {

	@CsvBindByName
	private String Direction;
	@CsvBindByName
	private Integer X;
	@CsvBindByName
	private Integer Y;

	public Position() {
		// TODO Auto-generated constructor stub
	}

	public Position(String Direction, Integer X, Integer Y) {
		this.Direction = Direction;
		this.X = X;
		this.Y = Y;
	}

	public Position(Object Direction, Object X, Object Y) {
		this.Direction = (String) Direction;
		this.X = (Integer) X;
		this.Y = (Integer) Y;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String Direction) {
		this.Direction = Direction;
	}

	public Integer getX() {
		return X;
	}

	public void setX(Integer X) {
		this.X = X;
	}

	public Integer getY() {
		return Y;
	}

	public void setY(Integer Y) {
		this.Y = Y;
	}

	@Override
	public String toString() {
		return "Position [Direction=" + Direction + ", X=" + X + ", Y=" + Y + "]";
	}

}
