package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.test.UserInput.NumericInput;
import com.test.UserInput.TextInput;

class TestUserInput {
	
	TextInput input;
	@BeforeEach
	void setUp() throws Exception {
		input = new NumericInput();
	}

	@Test
	void test() {
		input.add('1');
        input.add('a');
        input.add('0');
        
		assertEquals("10", input.getValue());
	}

}
