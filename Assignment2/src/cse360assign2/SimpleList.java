package cse360assign2;

import java.util.Arrays;

public class SimpleList {	//The purpose of this class is to be able to create an array list of 10 integers.
							//In this case, the addition methods are to be able to add, search, remove and return 
							//both counters and the created array list.

	//Instance Fields
	private int list[]; // - list : int[]	(from uml diagram)
	private int count; // - count: int


	//constructor
	public SimpleList () { //+ SimpleList ()

	       list = new int[10]; //Array to hold 10 integers
	       this.count = 0; //Set count to 0
	}

	//mutators
	public void add (int number) {
	       if (0 == count) {

	           list[count] = number; //if the count is 0, add given number to that

	           count++;	//raise count

	       } else if (10 < count) {

	           for (int i = count; i >= 0; i--) { //since int i equals count, it adds it to the next int
	               list[i + 1] = list[i];
	           }

	           list[0] = number; 
	           count++;

	       } else {
	           list[count - 1] = 0; //Anything else lowers the array position to fall off

	           for (int i = count; i >= 0; i--) { //While i is greater than 0, decrease (basically shifting)

	               list[i + 1] = list[i];

	           }

	           list[0] = number;
	           count++;
	       }

	       System.out.println("Number was added.");
	}

	public void remove (int number) {
	       int location = search(number);

	       if (location != -1) {

	           for (int i = location; i < count - 1; i++) { //By left shifting to remove
	               list[i] = list[i + 1];				// a specific int
	           }
	           count--;
	           System.out.println("The element was removed.");
	       } else {
	           System.out.println(number + " element could not be found"); //this is just to know on testing
	       }
	}

	public int count() {
		return count; //returning the current count
	}

	public String toString() {

		 String string1 = "";	//This will be used for converting integers to strings

	       for (int i = 0; i < count; i++) {

	           string1 += list[i];
	           if (i != (count - 1)) {

	               string1 += " ";	//In order to add a space between each string integer

	           }
	       }

	       return string1;
	}

	public int search(int number) {
	       int location = -1;	//sets the location

	       for (int i = 0; i < count; i++) {

	           if (list[i] == number) {	//if searched number
	               location = i;
	           }

	       }
	       return location;	//returning the found number
	}



}