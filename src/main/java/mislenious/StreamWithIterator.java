package mislenious;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamWithIterator {

	public static void main(String[] args) {
		ArrayList<String> arrList = new ArrayList<>();

		arrList.add("Alpha");
		arrList.add("Beta");
		arrList.add("Gama");
		arrList.add("Delta");
		arrList.add("Phi");
		arrList.add("Omega");
		arrList.add("Tera");

		Stream<String> stream = arrList.stream();

		/*
		 * Iterator<String> iterator = stream.iterator();
		 * 
		 * System.out.println("Start of the Stream" + LocalDateTime.now());
		 * 
		 * arrList.parallelStream().forEach(n -> System.out.println(n));
		 * 
		 * System.out.println("Finish of First Stream" +LocalDateTime.now());
		 * 
		 * while(iterator.hasNext()) System.out.println(iterator.next());
		 * 
		 * 
		 * arrList.stream().forEach(n -> System.out.println(n));
		 * 
		 * System.out.println("Finish of second Stream" +LocalDateTime.now());
		 */

		Spliterator<String> splitItr = arrList.spliterator();
		
		Spliterator<String> splitItr2 = splitItr.trySplit();
		
		splitItr2.forEachRemaining(n -> System.out.println(n));
		
		System.out.println("\nStart of the Stream");
		
		splitItr.forEachRemaining(n -> System.out.println(n));
		
		
	}

}
