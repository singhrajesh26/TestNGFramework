package com.udemy.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectGroupBy {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("Apple");
		list.add("Orange");
		list.add("Cat");
		list.add("Rat");
		list.add("Areoplane");
		list.add("Boy");
		list.add("Delta");
		list.add("Rose");
		
		Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(s -> s.length()));
		
		System.out.println(collect);

	}

}
