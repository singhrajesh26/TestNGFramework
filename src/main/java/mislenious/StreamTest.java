package mislenious;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> arrList = new ArrayList<>();
		
		arrList.add(7);
		arrList.add(17);
		arrList.add(10);
		arrList.add(24);
		arrList.add(5);
		arrList.add(29);
		
		//Optional<Integer> reduce = arrList.stream().filter(a -> a%2==0).reduce((a, b) -> a*b);
		
		// arrList.stream().sorted().forEach(a -> System.out.println(a));
		
		Optional<Integer> max = arrList.stream().max(Integer::compare);
		
		System.out.println(max);
		
		
	}

}
