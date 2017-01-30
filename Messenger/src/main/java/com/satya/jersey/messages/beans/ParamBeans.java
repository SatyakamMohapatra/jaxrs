package com.satya.jersey.messages.beans;

import javax.ws.rs.QueryParam;

public class ParamBeans {
	 private @QueryParam("year")int year;
	 private @QueryParam("start") int start;
	 private @QueryParam("limit") int limit;
	 
	 
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
	 	this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}	 
}
