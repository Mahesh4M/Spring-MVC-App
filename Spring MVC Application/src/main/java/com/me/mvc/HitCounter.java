package com.me.mvc;

public class HitCounter 
{
	private int hits;

	public HitCounter()
	{
		System.out.println("HitCounter instantiatied");
	}
	
	
	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
}
