import java.util.LinkedList;

public class OpenHashing {

    LinkedList<String>[] hashTable; // Construct an array of objects of type linked list to store names by their hash keys.
    int size; // Current size of the hash table

    public OpenHashing(int size) {
        this.size = size;
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    public void add(String name) {
        int hashKey = hash(name);
        LinkedList<String> list = hashTable[hashKey];
        if (list == null) {
            // If the list is null, initialize it
            list = new LinkedList<>();
            hashTable[hashKey] = list;
        }
        if (!list.contains(name)) {
            list.add(name);
            System.out.println("Added " + name + " at index " + hashKey);
        } else {
            System.out.println(name + " already exists!.");
        }
        System.out.println("Hash key for " + name + ": " + hashKey); // Add this line
    }



    public void delete(String name) {
        int hashKey = hash(name);
        LinkedList<String> list = hashTable[hashKey];
        if (list.remove(name)) {
            System.out.println("Deleted " + name + " from index " + hashKey);
        } else {
            System.out.println(name + " not found :(.");
        }
    }

    public void search(String name) {
        int hashKey = hash(name);
        LinkedList<String> list = hashTable[hashKey];
        int position = 0; // Initialize position to 0
        for (String n : list) {
            position++;
            if (n.equals(name)) {
                System.out.println(name + " found at index " + hashKey + ", position " + position);
                return;
            }
        }
        System.out.println(name + " not found.");
    }

    public int getListSize(int index) {
        return hashTable[index].size();
    }

    private int hash(String name) {
        return Math.abs(name.hashCode()) % size;
    }

    // Method to rehash and increase the size of the hash table
    public void rehash(int newSize) {
        LinkedList<String>[] oldTable = hashTable;
        size = newSize;
        hashTable = new LinkedList[size];
        for (LinkedList<String> list : oldTable) {
            for (String name : list) {
                add(name);
            }
        }
        System.out.println("Rehashing completed. New size: " + size);
    }
}
