package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.test.Playlist.Song;

class TestPlaylist {

	Playlist playlist;
	@BeforeEach
	void setUp() throws Exception {
		playlist = new Playlist();
	}

	@Test
	void test() {
		
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
    
        first.setNextSong(second);
        second.setNextSong(first);
        
        assertTrue(first.isRepeatingPlaylist());
    
	}

}
