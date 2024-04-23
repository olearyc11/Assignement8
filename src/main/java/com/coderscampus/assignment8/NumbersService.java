package com.coderscampus.assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumbersService {

	ExecutorService executor = Executors.newCachedThreadPool();
	Assignment8 assignment = new Assignment8();
	
	public List<CompletableFuture<List<Integer>>> getAllNumbers() {
		List<CompletableFuture<List<Integer>>> numTasks = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			CompletableFuture<List<Integer>> numTask = CompletableFuture.supplyAsync(() -> assignment.getNumbers(), executor);
			numTasks.add(numTask);
		}
		return numTasks;
	}
	
	
	
}
