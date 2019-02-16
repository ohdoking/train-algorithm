package com.test;

/**
 * Contacts
 *
 * @author ohdoking
 *
 * using Trie
 */
public class Solution26 {


        private int NUMBER_OF_CHARACTERS = 26;
        Solution26[] children = new Solution26[NUMBER_OF_CHARACTERS];
        int size = 0;

        private int getCharacterIndex(char c){
            return c - 'a';
        }

        public Solution26 getNode(char c){
            return children[getCharacterIndex(c)];
        }

        public void setNode(char c, Solution26 node){
            children[getCharacterIndex(c)] = node;
        }

        public void add(String s){
            add(s, 0);
        }

        public void add(String s, int index){
            size++;
            if(s.length() == index){
                return;
            }
            char current = s.charAt(index);
            Solution26 child = getNode(current);
            if(child == null){
                child = new Solution26();
                setNode(current, child);
            }
            child.add(s, index + 1);
        }

        public boolean contains(String s){
            return contains(s, getNode(s.charAt(0)), 1);
        }

        public boolean contains(String s, Solution26 child, int index){
            if(child == null){
                if(s.length() == index){
                    return true;
                }
                return false;
            }
            child = child.getNode(s.charAt(index));
            return contains(s, child, index + 1);
        }

        public int findCount(String s, int index){
            if(s.length() == index){
                return size;
            }

            Solution26 child = getNode(s.charAt(index));
            if(child == null){
                return 0;
            }

            return child.findCount(s, index + 1);
        }
}
