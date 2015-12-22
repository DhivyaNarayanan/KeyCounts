/*
* The class Keycount implements function sumCount which
* sums up keys in a text file with data in the format of 
* "key,count" where key is a string and count is an integer, 
* and outputs key along with the sum of the count for all 
* occurrences of the key. It also implements the function for 
* Palindrome detection and output whether or not the string 
* is palindrome and return a boolean
*
* @author  Dhivya Narayanan
* @version 1.0
* @since   2015-12-01 
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
	
public class Keycount {
	
	/**
	 * This method is used to read the content of the file and stores 
	 * each line in vector
	 * @param file This is the parameter to readFile method -the file to be read
	 * @return vector Holds each lines in the file
	 */
	
	public Vector<String> readFile(String file){
		
		BufferedReader bufferReader = null;
		FileReader fileReader = null;
		Vector<String> vec = new Vector<String>();  //to store each line in the file
		String curLine;
		try{	
			fileReader = new FileReader(file);
			bufferReader = new BufferedReader(fileReader);			
			while ((curLine = bufferReader.readLine()) != null) {
				vec.add(curLine);     //adds the current line to the vector
				System.out.println(curLine);
			}
		}
		catch(FileNotFoundException e){
			System.err.println("Can not find specified file");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Can not read from file");
			e.printStackTrace();
		}
		finally {
			try{
				if(fileReader!=null)
					fileReader.close();
				if (bufferReader != null)
					bufferReader.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return vec;
	}
	
	/**
	 * This method outputs each key occurring in the file along with
	 * the sum of count for all occurrences of a given key
	 * @param file is passed as the parameter
	 * 
	 */
	
	public void sumCount(String file){
		// totals - holds all unique valid keys along with sum of the count
		Hashtable<String, Integer> totals = new Hashtable<String, Integer>();
		//call the function readFile and stores the returned value in the vector
		Vector<String> contentVector = readFile(file) ;
		//Enumerate through elements of the vector and calculate the sum of the count for each key
		Enumeration<String> keyCnts = contentVector.elements(); 
		try{
			if(contentVector.size()==0){
				throw new Exception();    //throws exception if file is empty
			}
			while (keyCnts.hasMoreElements()) {
				String kcStr = keyCnts.nextElement(); 
				String[] arr = kcStr.split(",");
				String key;
				int count;
				try{
					//check for valid key-count pair
					if(arr.length !=2){
						throw new Exception(); 
					}
				    key = arr[0];
					count = Integer.parseInt(arr[1]);  //count is parsed to Integer
					if(totals.containsKey(key)){
						int curCount = totals.get(key);
						count += curCount;       //sums up the count
						totals.put(key,count);
					}
					else{
						totals.put(key, count);
					}
				}
				catch(Exception e){
					System.err.println("Textfile contains some INVALID key-count pair\n");
				}
				
			}
			printTotal(totals);  //method call - prints the output key-count
			
		}
		catch(Exception e){
			System.err.println("Empty TextFile - has no key-count pair!");
		}
		      				
	}
	
	/**
	 * This method enumerates through elements of hashtable and
	 * prints the key and its value (sum of count)
	 * @param hashTable is passed as the parameter
	 *
	 */
	
	public void printTotal(Hashtable<String,Integer> hashTable){
		Enumeration<String> keysInTable = hashTable.keys();
		System.out.println("Output:");
		while (keysInTable.hasMoreElements()){
			String curKey = keysInTable.nextElement();
			System.out.println("The total for "+ curKey +" is "+ hashTable.get(curKey));
		}
	}
	
	/**
	 * This method check whether or not the string is palindrome
	 * @param str is passed as the parameter
	 * @return Boolean
	 */
	
	public boolean isPalindrome(String str){
		try{
			//replace all non-alphanumeric chars by empty string and converts all the chars to lower case
			String str1 = (str.replaceAll("[^A-Za-z0-9]", "")).toLowerCase();
			int len = str1.length();  //throws exception if len = 0 (empty/null string)
			/*compare the chars at 'i'th first and last position
			 * and return false if they mismatches */
			for (int i = 0; i < (len / 2) + 1; ++i) {
		        if (str1.charAt(i) != str1.charAt(len - i - 1)) {
		            return false;
		        }
		    }
			return true;
		}
		catch(Exception e){
			System.err.println("Empty String! - isPalindrome");
			return true;
		}		
	}
	
	
}
