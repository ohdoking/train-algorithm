package com.test;
public class CalculatorTest {

	public enum CalculatorType implements Calculator {

	    PLUS((value, value2) -> value+value2),
	    MINUS((value, value2) -> value-value2),
	    MULTIPLE((value, value2) -> value*value2),
	    DEVIDE((value, value2) -> value/value2);

	    private ThreeParameterFunction<Long, Long, Long> expression;

	    CalculatorType(ThreeParameterFunction<Long, Long, Long> expression) {
	        this.expression = expression;
	    }

	    public long calculate(long value, long value2){
	        return expression.apply(value, value2);
	    }
	}
	
	
	public static void main(String[] args) {
		
		CalculatorType ct = CalculatorType.PLUS;
		System.out.println(ct.calculate(40,20));
		
		ct = CalculatorType.MINUS;
		System.out.println(ct.calculate(40,20));
		
		ct = CalculatorType.MULTIPLE;
		System.out.println(ct.calculate(40,20));
		
		ct = CalculatorType.DEVIDE;
		System.out.println(ct.calculate(40,20));
	}
}

/**
 * @FunctionalInterface annotation is used to ensure that the functional interface can’t have more than one abstract method. 
 * In case more than one abstract methods are present, 
 * the compiler flags an ‘Unexpected @FunctionalInterface annotation’ message. 
 * However, it is not mandatory to use this annotation.
 * 
 * 
 * @author ohdoking
 *
 * @param <One>
 * @param <Two>
 * @param <Result>
 */
@FunctionalInterface
interface ThreeParameterFunction<One, Two, Result> {
    public Result apply(One one, Two two);
}

interface Calculator {
	public long calculate(long value, long value2);
}