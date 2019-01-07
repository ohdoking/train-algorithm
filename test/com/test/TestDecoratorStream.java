package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDecoratorStream {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() throws IOException{
		byte[] message = new byte[]{0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64, 0x21};
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            DecoratorStream decoratorStream = new DecoratorStream(baos, "First line: ");
            decoratorStream.write(message);
            
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(baos.toByteArray()), "UTF-8"))) {
            	assertEquals("First line: Hello, world!", reader.readLine());
            }
        }
	}
	
	@Test
	void testMuitipleWrite() throws IOException{
		byte[] message = new byte[]{0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64, 0x21};
		byte[] message2 = new byte[]{0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64, 0x21};
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			DecoratorStream decoratorStream = new DecoratorStream(baos, "First line: ");
			decoratorStream.write(message);
			decoratorStream.write(message2);
			
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(baos.toByteArray()), "UTF-8"))) {
				assertEquals("First line: Hello, world!Hello, world!", reader.readLine());
			}
		}
	}

}
