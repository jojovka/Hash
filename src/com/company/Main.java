package com.company;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        DataItem aDataitem;
        int aKey, size, n, keysPerCell;

        System.out.println("Enter size of hash table: ");
        size = getInt();
        System.out.println("Enter number of items: ");
        n = getInt();
        keysPerCell = 10;

        HashTable theHashTable = new HashTable(size);

        for(int j = 0; j < n; j++){
            aKey = (int)(java.lang.Math.random() * keysPerCell * size);
            aDataitem = new DataItem(aKey);
            theHashTable.insert(aDataitem);
        }

        while(true){
            System.out.println("Enter first letter of ");
            System.out.println("Show, insert, or find");
            char choice = getChar();
            switch (choice){
                default:
                    System.out.println("Invalid entry \n");
                case 'f':
                    System.out.println("Enter key value to find: ");
                    aKey = getInt();
                    aDataitem = theHashTable.find(aKey);
                    if(aDataitem != null){
                        System.out.println("Found " + aKey);
                    }else{
                        System.out.println("Could not find " + aKey);
                    }
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataitem = new DataItem(aKey);
                    theHashTable.insert(aDataitem);
                    break;
                case 's':
                    theHashTable.displayTable();
                    break;
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
