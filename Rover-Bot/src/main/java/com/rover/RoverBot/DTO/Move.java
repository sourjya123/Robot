package com.rover.RoverBot.DTO;

public class Move {

	private String O;
	private Integer L;
	private Integer F;
	private Integer R;
	private Integer B;

	public Move() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Move(String o, Integer l, Integer f, Integer r, Integer b) {
		super();
		O = o;
		L = l;
		F = f;
		R = r;
		B = b;
		
		if(this.R==null) {
			if(this.L!=null) {
				this.R=360-this.L;
			}
			else {
				this.R=0;
			}
		}
		if(this.F==null) {
			if (this.B!=null) {
				this.F=this.B*(-1);
			}
			else {
				this.F=0;
			}
		}

	}

	public String getO() {
		return O;
	}

	public void setO(String o) {
		O = o;
	}

	public Integer getL() {
		return L;
	}

	public void setL(Integer l) {
		L = l;
	}

	public Integer getF() {
		return F;
	}

	public void setF(Integer f) {
		F = f;
	}

	public Integer getR() {
		return R;
	}

	public void setR(Integer r) {
		R = r;
	}

	public Integer getB() {
		return B;
	}

	public void setB(Integer b) {
		B = b;
	}

	@Override
	public String toString() {
		return "Move [O=" + O + ", L=" + L + ", F=" + F + ", R=" + R + ", B=" + B + "]";
	}

}
