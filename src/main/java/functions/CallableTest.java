package functions;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class CallableTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Supplier<Double> random1 = () -> Math.random();
		Callable<Double> random2 = () -> Math.random();
		
		//System.out.println(random1.get());
		//System.out.println(random2.call());
		test(random2);

	}
	
	private static void test(Callable callable) throws Exception {
		
		System.out.println(callable.call());
	}

}
