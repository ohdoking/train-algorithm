package com.test;

/**
 * Contacts
 *
 * @author ohdoking
 *
 * using Trie
 */
public class Solution26 {

    class Node{
        private int NUMBER_OF_CHARCTERS = 26;
        Node[] children = new Node[NUMBER_OF_CHARCTERS];
        int size = 0;

        private int getCharacterIndex(char c){
            return c - 'a';
        }

        public Node getNode(char c){
            return children[getCharacterIndex(c)];
        }

        public void setNode(char c, Node node){
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
            int charCode = getCharacterIndex(current);
            Node child = getNode(current);
            if(child == null){
                Node node = new Node();
                setNode(current, node);
            }
            child.add(s, index++);


        }

        public int findCount(String s, int index){
            if(s.length() == index){
                return size;
            }

            Node child = getNode(s.charAt(index));
            if(child == null){
                return 0;
            }

            return child.findCount(s, index++);


        }
    }
}
