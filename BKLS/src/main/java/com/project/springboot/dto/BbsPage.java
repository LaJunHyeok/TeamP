package com.project.springboot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BbsPage {
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
