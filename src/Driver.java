
public class Driver {

	private static String FILEPATH = "src/KeyVal.txt";
	
	/**
	   * This is the main method which makes use of sumCount and isPalindrome method.
	   * @param args Unused
	   * 
	   */
	public static void main(String[] args) {
		
	    Keycount keycnt = new Keycount();
		System.out.println("1) Key Counts:");
		System.out.println("------------------------");
		keycnt.sumCount(FILEPATH);      //method call
		
		System.out.println("\n2) Palindrome Detection:");
		System.out.println("------------------------");
		String strPalindrome1 = "Ah! Satan sees Natasha";
		System.out.print("The string \""+ strPalindrome1 + "\" isPalindrome? :  " );
		System.out.println(keycnt.isPalindrome(strPalindrome1));       //method call
		String strPalindrome2 = "John";
		System.out.print("The string \""+ strPalindrome2 + "\" isPalindrome? :  " );
		System.out.println(keycnt.isPalindrome(strPalindrome2));
		return;
		
	}
}
