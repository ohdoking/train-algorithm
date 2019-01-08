package com.test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CaesarCipherTest {

	@Test
	public void test() {
		String u = "I should have known that you would have a perfect answer for me!!!";
		List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
		assertEquals(v, CaesarCipher.movingShift(u, 1));
		assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 1), 1)); 
	}
	
	@Test
	public void test2() {
		String u = "uaoQop jx eh osr okaKv vzagzwpxagokBKriipmc U";
		int shift = 2;
		List<String> v = Arrays.asList("wdsVuw sh", " qu dii h", "evGs uzbi", "caudhoxuM", "Wewxfdu O");
		assertEquals(v, CaesarCipher.movingShift(u, shift));
		assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, shift), shift)); 
	}
	
	@Test
	public void test3() {
		String u = " uoxIirmoveNreefckgieaoiEcooqo";
		int shift = 2;
		List<String> v = Arrays.asList(" xscOp", "zvygqA", "ftuwud", "adaxmh", "Edqrut");
		assertEquals(v, CaesarCipher.movingShift(u, shift));
		assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, shift), shift)); 
	}
}