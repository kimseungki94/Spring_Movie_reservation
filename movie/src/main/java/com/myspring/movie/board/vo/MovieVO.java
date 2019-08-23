package com.myspring.movie.board.vo;

import org.springframework.stereotype.Component;

@Component("movieVO")
public class MovieVO {
	private String sample;

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}
	@Override
	public String toString() {
		return sample;
	}
	
}
