package functions;

import java.util.function.Function;

public class UseOfFunctons {

	public static void main(String[] args) {
		
		Function<String, Integer> strLen = (s) -> s.length();
		
		Function<Integer, Integer> plus2 = (i) -> i +2;
		
		Function<Integer, Integer> square = (i) -> i*i;
		
		System.out.println(
				
				//23 and square is 529
			//	strLen.andThen(square).apply("My name is Rajesh Kumar") 	
				
				// first it will execute compose body then plus2
				// 64  & + 2 = 66
				plus2.compose(square).apply(8)
				
				);

	}

}
