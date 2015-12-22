import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.Test;

public class KeyCountTest {

   /**TestCases for Keycount class */
	
	//Test isPalindrome method
	/**
	 * This is the test case method which
	 *  tests the isPalindrome method for different strings
	 *  
	 */
    Keycount keyCntTest = new Keycount();
	@Test
	public void testIsPalindrome() {
	
		assertTrue(keyCntTest.isPalindrome("Bob"));
		assertTrue(keyCntTest.isPalindrome("Ah! Satan sees natasha"));
		assertFalse(keyCntTest.isPalindrome("John"));
		assertTrue(keyCntTest.isPalindrome("1Race car1"));
		System.out.println("Palindrome check for empty/null string - throws Exception");
		assertTrue(keyCntTest.isPalindrome(""));
		assertTrue(keyCntTest.isPalindrome(null));			
	}
	
	//Test sumCount method
		/**
		 * This is the test case method 
		 * which tests the sumCount method by passing different text files
		 * @throws FileNotFoundException on passing not-existing file to the method
		 *
		 */
	@Test
	public void testSumCount1() throws FileNotFoundException {
		System.out.println("----------------------------------------");
		System.out.println("Testing with Valid key-count pair:");
		keyCntTest.sumCount("src/KeyVal.txt");     //KeyVal.txt contains valid key-count pair
		System.out.println("----------------------------------------");
		System.out.println("Testing demonstrates handling of keys as case-sensitive:");
		keyCntTest.sumCount("src/test1.txt");      
		System.out.println("----------------------------------------");
		System.out.println("Testing with invalid key-count pair :");
		keyCntTest.sumCount("src/test2.txt");      //test2.txt contains invalid key-count pair
		System.out.println("----------------------------------------");
		
	}
	
	@Test
	public void testSumCount2() throws FileNotFoundException{
		
		System.out.println("Testing with invalid key-count pair (count is not a number) : ");
		keyCntTest.sumCount("src/test3.txt");       //test3.txt contains invalid key-count pair
		System.out.println("----------------------------------------");
		System.out.println("Testing with empty textfile :");
		keyCntTest.sumCount("src/test4.txt");	      //test4.txt is an empty file
	}
	

}
