package com.coderscampus.assignment8;

import java.util.List;

public class Assignment8App {

	public static void main(String[] args) {
		
		NumbersService numbersService = new NumbersService();
		List<Integer> numbers = numbersService.getListOfNumbers();
		numbersService.printNumbersMap(numbers);
		numbersService.closeExecutor();
	}
}
