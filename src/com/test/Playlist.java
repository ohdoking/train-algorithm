package com.test;
/**
 * 
 * @author ohdoking
 * 
 * A playlist is considered a repeating playlist if any of the songs contain a reference to a previous song in the playlist. 
 * Otherwise, the playlist will end with the last song which points to null.
 * 
 * Implement a function isRepeatingPlaylist that, efficiently with respect to time used, 
 * returns true if a playlist is repeating or false if it is not.
 * 
 * For example, the following code prints "true" as both songs point to each other.
 * 
 * Floyd's cycle-finding algorithm,
 */
public class Playlist {
    public static class Song {
        private String name;
        private Song nextSong;
 
        private String firstSong;
        
        public Song(String name) {
            this.name = name;
        }
    
        public void setNextSong(Song nextSong) {
            this.nextSong = nextSong;
        }
    
        public boolean isRepeatingPlaylist() {
        	if(nextSong == null){ // list does not exist..so no loop either
        		return false;
        	}

            Song slow, fast; // create two references.

            slow = fast = nextSong; // make both refer to the start of the list

            while(true) {

                slow = slow.nextSong;          // 1 hop

                if(fast.nextSong != null) {
                	fast = fast.nextSong.nextSong; // 2 hops
                	
                	// if either hits null..no loop
                	if(slow == null || fast == null){
                    	return false;
                    }

                	// if the two ever meet...we must have a loop
                    if(slow == fast) {
                    	return true;
                    } 
                }
                // next node null => no loop
                else {
                	return false;          
                }

                
            }
        }
    }
    
    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
    
        first.setNextSong(second);
        second.setNextSong(first);
    
        System.out.println(first.isRepeatingPlaylist());
    }
}