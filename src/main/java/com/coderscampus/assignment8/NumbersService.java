package com.coderscampus.assignment8;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


public class NumbersService {

	ExecutorService executor = Executors.newCachedThreadPool();
	Assignment8 assignment = new Assignment8();

	public List<Integer> getListOfNumbers() {
		List<CompletableFuture<List<Integer>>> numTasks = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			CompletableFuture<List<Integer>> numTask = CompletableFuture.supplyAsync(() -> assignment.getNumbers(), executor);
			numTasks.add(numTask);
		}
//		CompletableFuture<Void> allFutures = CompletableFuture.allOf(numTasks.toArray(new CompletableFuture[numTasks.size()]));
//		allFutures.join();
		List<Integer> singleList =  numTasks.stream()
											.flatMap(task -> task.join().stream())
											.collect(Collectors.toList());

			return singleList;
		
	}

	public void printNumbersMap(List<Integer> singleList) {
		Map<Integer, Long> numbersMap = singleList.stream()
				  								  .collect(Collectors.groupingBy(number -> number, Collectors.counting()));
		String entryList = numbersMap.entrySet().stream()
							 .map(entry -> entry.getKey() + "=" + entry.getValue())
							 .collect(Collectors.joining(","));
		System.out.println(entryList);
							 
	
	}

}
