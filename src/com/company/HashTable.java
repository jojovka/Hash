package com.company;

public class HashTable {
    private DataItem[] hashArray;
    private int arraySize;

    public HashTable(int size){
        arraySize = size;
        hashArray = new DataItem[arraySize];
        //nonItem = new DataItem(-1);
    }

    public void displayTable(){
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++){
            if (hashArray[j] != null){
                System.out.print(hashArray[j].getKey() + " ");
            }else{
                System.out.print("** ");
            }
        }
        System.out.println("");
    }

    public int hashFunc(int key){
        return key % arraySize;
    }

    public void insert(DataItem item){
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem find(int key){
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null){
            if (hashArray[hashVal].getKey() == key){
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
}
