package com.sample;

public class ZipCodeRange {
	private String from;
	private String to;
	
	ZipCodeRange(String from, String to) {
		this.from = from;
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	ZipCodeRange() {
		this.from = "0";
		this.to = "0";
	}
	
	
	@Override
	public String toString() {
		return "ZipCodeRange [from=" + from + ", to=" + to + "]";
	}

	
}
