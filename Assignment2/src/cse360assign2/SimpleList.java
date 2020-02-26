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
	public void add (int number) {	//UPDATED TO INCREASE CAPACITY 50%

        if (count == list.length) {	

             int half = count/2; //50% capacity

             modify(count + half); //Increases capacity by 50% if array is full

        }

        for (int i = count; i > 0; i--) {	//If there are any remaining elements, it will shift

             list[i] = list[i - 1];

        }

        list[0] = number; //Adding number parameter to element 0

        count++;	//Increase count

        System.out.println("Number was added.");
	}
	
	
    private void modify(int newSize) {

        int newArray[] = new int[newSize];


        for (int i = 0; i < newSize && i < count; i++) { //This simple for loop copies over the elements to new array
             newArray[i] = list[i];
        }

        list = newArray; //This replaces the old array with a new array

        if (newSize < count) { //This adjust the count when it is large than new array

            count = newSize;

        }

    }
	
	
	public void remove (int number) {
		
		 int location = search(number);

	        if (location != -1) {


	             for (int i = location; i < count - 1; i++) { //By left shifting to remove

	                 list[i] = list[i + 1];				      // a specific integer in array

	             }

	             count--;

	             System.out.println("The element was removed.");
	        } else {
	             System.out.println(number + "element could not be found"); //this is just to know on testing
	        }

	        int calculation = 3 * list.length/4;

	        if (count < calculation) { // if "count" is less than "calculation (75%), then the modify function is used to resize to an a specific size

	             modify(count);

	        }
	}
	

    public void append(int num) { //append the parameter to the end of the list, if list is full capacity will increase 50%

        if (count == list.length) {	//Increases capacity when full

             int half = count/2;
             modify(count + half);

        }

        list[count] = num; //With a given index, adds "num"

        count++;

    }

    public int first() {	//This returns the first element in array

        if (count == 0) {	//This just makes sure an error does not occur if no first element exists

             throw new RuntimeException("Error: first element not found.");

        }

        return list[0]; //Returns first element

    }


    public int size() { //Return the current number of possible locations in the list
    	
        return list.length;

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

