package com.test.fundamental;

public class HashTable<K, V> {
    private static int INITIAL_SIZE = 16;
    private HashEntry<K,V>[] entries = new HashEntry[INITIAL_SIZE];
    public void put(K key, V value) {
        int hash = getHash(key);
        final HashEntry<K,V> hashEntry = new HashEntry<K,V>(key, value);
        if(entries[hash] == null) {
            entries[hash] = hashEntry;
        }
        // If there is already an entry at current hash
        // position, add entry to the linked list.
        else {
            HashEntry temp = entries[hash];
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashEntry;
        }
    }

    /**
     * Returns 'null' if the element is not found.
     */
    public V get(K key) {
        int hash = getHash(key);
        if(entries[hash] != null) {
            HashEntry<K, V> temp = entries[hash];

            // Check the entry linked list for march
            // for the given 'key'
            while( !temp.key.equals(key)
                    && temp.next != null ) {
                temp = temp.next;
            }
            return temp.value;
        }

        return null;
    }

    private int getHash(K key) {
        // piggy backing on java string
        // hashcode implementation.
        return key.hashCode() % INITIAL_SIZE;
    }

    public static class HashEntry<K, V> {
        K key;
        V value;
        // Linked list of same hash entries.
        HashEntry next;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "[" + key.toString() + ", " + value.toString() + "]";
        }
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : entries) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }


}