package com.test;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * DecoratorStream
 * 
 * @author ohdoking
 * 
 * Implement methods in the DecoratorStream class:
 * 
 * write method should write the prefix into the underlying stream member only on the first write invocation. 
 * It should always write the bytes it receives to the underlying stream.
 * The prefix should be written in UTF-8 encoding.
 * 
 * For example, if the DecoratorStream is instantiated with "First line: " as the prefix parameter 
 * and write method is called with UTF-8 byte representation of "Hello, world!", 
 * it should write "First line: Hello, world!" into the underlying stream.
 *
 */
public class DecoratorStream extends OutputStream
{
    private OutputStream stream;
    private String prefix;
    boolean isPrefix = false;

    public DecoratorStream(OutputStream stream, String prefix) {
        super();
        this.stream = stream;
        this.prefix = prefix;
    }

    @Override
    public void write(int b) throws IOException {
        byte[] result = new byte[4];

        result[0] = (byte) (b >> 24);
        result[1] = (byte) (b >> 16);
        result[2] = (byte) (b >> 8);
        result[3] = (byte) (b);

        write(result, 0, 4);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
    	if(!isPrefix) {
    		byte[] utf8Prefix = prefix.getBytes("UTF-8");
    		stream.write(utf8Prefix, 0, utf8Prefix.length);
    		isPrefix = true;
    	}
    	stream.write(b, off, len);
    }
    
    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }
    
}