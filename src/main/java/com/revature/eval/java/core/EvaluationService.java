package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashSet;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
//		System.out.println(new String(reversed));
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String acronym = "";
		boolean new_word = true;
		char prev = ' ';
		for(int i = 0; i < phrase.length(); i++) {
			if(!Character.isAlphabetic(prev)) {
				if(Character.isAlphabetic(phrase.charAt(i))) {
					acronym += Character.toUpperCase(phrase.charAt(i));
				}
			}
			prev = phrase.charAt(i);
		}
		//System.out.println(phrase);
		//System.out.println(acronym);
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			return sideThree == sideTwo && sideTwo == sideOne;
		}

		public boolean isIsosceles() {
			return sideThree == sideTwo || sideTwo == sideOne || sideThree == sideOne;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			return sideThree != sideTwo && sideTwo != sideOne && sideThree != sideOne;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		String s = string.toLowerCase();
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			sum += scrabbleScoreLetter(s.charAt(i));
		}
		return sum;
	}
	
	/**
	 * Helper function for problem 4.
	 * Takes in a lowercase letter and returns its value.
	 * returns 0 if character is not lowercase, or is not a letter
	 * 
	 * @param c
	 * @return
	 */
	private int scrabbleScoreLetter(char c) {
		switch(c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'l':
			case 'n':
			case 'r':
			case 's':
			case 't':
				return 1;
			case 'd':
			case 'g':
				return 2;
			case 'b':
			case 'c':
			case 'm':
			case 'p':
				return 3;
			case 'f':
			case 'h':
			case 'v':
			case 'w':
			case 'y':
				return 4;
			case 'k':
				return 5;
			case 'x':
				return 8;
			case 'q':
			case 'z':
				return 10;
			default:
				return 0;
		}
				
			
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException{
		String result = "";
		boolean checkCountryCode = true;
		int digitCount = 0;
		for(int i = 0; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i))) {
				if(checkCountryCode) {
					if(string.charAt(i) != '1') {
						result += string.charAt(i);
						digitCount++;
						checkCountryCode = false;
					}
				}
				else {
					result += string.charAt(i);
					digitCount++;
				}
			}
		}
		if(digitCount != 10 || result.charAt(3) == '1') {
			throw new IllegalArgumentException();
		}
		return result;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		String[] words = string.split("\\W+");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String word : words) {
			if(map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			}
			else {
				map.put(word, 1);
			}
		}
		
		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
//			System.out.println(binarySearch(sortedList, t));
			return binarySearch(sortedList, t);
		}
		
		private int binarySearch(List<T> list, T target) {
			int mid = list.size()/2;
			Comparable<T> t = (Comparable<T>) target;
//			System.out.println("mid: " + mid);
//			System.out.println("list[mid]: " + list.get(mid));
//			System.out.println("t: " + t);
//			System.out.println("compareTo: " + t.compareTo(list.get(mid)));
			if(t.compareTo(list.get(mid)) == 0) {
				return mid;
			}
			else if(t.compareTo(list.get(mid)) <= 0) {
				return binarySearch(list.subList(0, mid), target);
			}
			else if(t.compareTo(list.get(mid)) >= 0) {
				return mid + binarySearch(list.subList(mid, list.size()), target);
			}
			return -1;
		}
		

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String[] words = string.split(" ");
		String result = "";
		for(String word : words) {
			result += wordToPigLatin(word) + " ";
		}
		//System.out.println(result.substring(0, result.length()-1));
		return result.substring(0, result.length()-1);//take substring to remove the extra space at the end
	}
	/**
	 * helper function for problem 8
	 * @param str
	 * @return
	 */
	private String wordToPigLatin(String str) {
		String ay = "ay";
		String pre = "";
		String meat = str;
		int firstVowel = 0;
		for(int i = 0; i < str.length(); i++) {
			if(isVowel(str.charAt(i))) {
				firstVowel = i;
				break;
			}
			if(str.charAt(i) == 'q') {
				if(str.charAt(i+1) == 'u') {
					if(isVowel(str.charAt(i+2))) {
						firstVowel = i+2;
						break;
					}
				}
			}
		}
		if(firstVowel > 0) {
			pre = str.substring(0, firstVowel);
			meat = str.substring(firstVowel, str.length());
		}
		
		return meat+pre+ay;
	}
	private boolean isVowel(char c) {
		switch(c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				return true;
			default:
				return false;
		}
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int temp = input;
		int sum = 0;
		int count = 0;
		ArrayList<Integer> digits = new ArrayList<Integer>();
		for(int i = 0; temp > 0; i++) {
			
			digits.add(temp%10);
			temp /= 10;
			count++;
		}
		for(int digit : digits) {
			sum += Math.pow(digit, count);
		}
//		System.out.println("sum: "+sum);
//		System.out.println("input: "+input);
		return sum == input;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> primeFactors = new ArrayList<Long>();
		
		if(updatePrimes(l)) {
			primeFactors.add(l);
//			System.out.println(primeFactors);
			return primeFactors;
		}
		
		long temp = l;
		int primeCursor = 0;
		while(primeCursor < Primes.size()) {
			break;
		}
		for(int i = 0; i < Primes.size(); i++) {
			if(temp % Primes.get(i) == 0) {//the prime is a factor of temp
				primeFactors.add(Primes.get(i));//add the prime to the factors list
				temp /= Primes.get(i);//divide temp by the prime
				if(temp == 1) {//if the all factors have been found exit
//					System.out.println(primeFactors);
					return primeFactors;
				}
				i--;//decrement i so we check if we have multiples of the same prime as a factor
			}
		}
//		System.out.println(primeFactors);
		return primeFactors;
	}
	/**
	 * dynamically sized list of prime numbers used in question 10
	 */
	private static ArrayList<Long> Primes = new ArrayList<Long>(Arrays.asList(2L));
	/**
	 * Helper function for problem 10. Takes in a long and returns true i the long 
	 * is prime, and false otherwise. It also updates Primes list.
	 * @param num
	 * @return
	 */
	private static boolean updatePrimes(long num) {
		
		for(long prime : Primes) {
			if(prime == num) {
				return true;
			}
			else if(prime > num) {
				return false;
			}
		}
		//if you get here, the maximum prime in our list is < num, so we may need to extend our list.
		long numCursor = Primes.get(Primes.size()-1);
		boolean isPrime = true;
		long temp = num;
		while(numCursor <= num) {
			numCursor++;
			isPrime = true;
			//check if numCursor is divisible by any of the primes
			for(long prime : Primes) {
				if(numCursor % prime == 0) {//if it is divisible, mark it as not prime, and break
					isPrime = false;
				}
			}
			if(isPrime) {
				Primes.add(numCursor);
				if(numCursor == num) {
					return true;
				}
				else if(num%numCursor == 0) { //return once we reach the greatest factor
					if(numCursor > temp/numCursor){
						return false;
					}
					temp /= numCursor;
				}
			}
		}
		return false;
	}
	

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;
		private static final char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String result = "";
			for(int i = 0; i < string.length(); i++) {
				if(Character.isAlphabetic(string.charAt(i))) {
					//boolean isUpper = false;
					if(Character.isUpperCase(string.charAt(i))) {
						//isUpper = true;
						result += Character.toUpperCase(alphabet[(Character.toLowerCase(string.charAt(i)) - 97 + key)%26]);
					}
					else {
						result += alphabet[(string.charAt(i) - 97 + key)%26];
					}
					
				}
				else {
					result += string.charAt(i);
				}
			}
			return result;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) throws IllegalArgumentException{
		int primeCount = PrimesInt.size();
		if(i<1) {
			throw new IllegalArgumentException();
		}
		
		if(i < PrimesInt.size()) {
//			System.out.println(PrimesInt.get(i-1));
			return PrimesInt.get(i-1);
		}
		else {
			int cursor = PrimesInt.get(PrimesInt.size() - 1)+1;
			while(primeCount < i) {
				boolean isPrime = true;
				for(int prime : PrimesInt) {
					if(cursor % prime == 0) {//if it is divisible, mark it as not prime, and break
						isPrime = false;
						break;
					}
				}
				if(isPrime) {
					PrimesInt.add(cursor);
					primeCount++;
				}
				cursor++;
			}
		}
//		System.out.println(PrimesInt.get(i-1));
		return PrimesInt.get(i-1);
	}
	/**
	 * dynamically sized list of prime numbers used in question 12
	 */
	private static ArrayList<Integer> PrimesInt = new ArrayList<Integer>(Arrays.asList(2));

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		private static final char[] cipherAlpha = {'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'};
		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String result = "";
			int letterCount = 0;
			for(int i = 0; i < string.length(); i++) {
				if(Character.isAlphabetic(string.charAt(i))) {
					result += cipherAlpha[Character.toLowerCase(string.charAt(i)) - 97];
					letterCount++;
					if(letterCount % 5 == 0) {
						result += ' ';
					}
				}
				else if(Character.isDigit(string.charAt(i))) {
					result += string.charAt(i);
					letterCount++;
					if(letterCount % 5 == 0) {
						result += ' ';
					}
				}
			}
			return result.trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String result = "";
			for(int i = 0; i < string.length(); i++) {
				if(Character.isAlphabetic(string.charAt(i))) {
					result += cipherAlpha[Character.toLowerCase(string.charAt(i)) - 97];
				}
				else if(Character.isDigit(string.charAt(i))) {
					result += string.charAt(i);
				}
			}
			return result;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		int[] digits = new int[10];
		int digitCount = 0;
		//int i;
		boolean check = false;
		boolean checkFound = false;
		for(int i = 0; digitCount < digits.length && i < string.length(); i++) {
			if(check){
				if(Character.isDigit(string.charAt(i))) {
					digits[digitCount] = string.charAt(i) - 48;
					digitCount++;
					checkFound = true;
				}
				else if(string.charAt(i) == 'X') {
					digits[digitCount] = 10;
					digitCount++;
					checkFound = true;
				}
			}
			if(digitCount < digits.length-1) {
				if(Character.isDigit(string.charAt(i))) {
					digits[digitCount] = string.charAt(i) - 48;
					digitCount++;
					
				}
			}
			else {
				check = true;
			}
		}
		if(digitCount < 10) {
//			System.out.println(false);
			return false;
		}
		
		int factor = 10;
		int sum = 0;
		for(int digit : digits) {
//			System.out.print(""+digit+"; ");
			sum += digit * factor;
			factor--;
		}
//		System.out.println();
//		System.out.println(sum%11==0);
		
		return sum%11==0;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		String str = string.toLowerCase();
		int[] alphaCount = new int[26];
		
		//initialize empty array
		for(int i = 0; i < alphaCount.length; i++) {
			alphaCount[i] = 0;
		}
		
		//each time an alphabetic character is found, increment the corresponding count.
		for(int i = 0; i < str.length(); i++){
			if(Character.isAlphabetic(str.charAt(i))) {
				alphaCount[str.charAt(i) - 97]++;
			}
		}
		
		//check that all counts are at least one.
		for(int count : alphaCount) {
			if(count <= 0) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// I assume we are given their date of birth
		if(given instanceof LocalDate) {
			return ((LocalDate) given).atStartOfDay().plus(1000000000L, ChronoUnit.SECONDS);
		}
		return given.plus(1000000000L, ChronoUnit.SECONDS);
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
		HashSet<Integer> multiples = new HashSet<Integer>();
		int sum = 0;
		
		for(int num : set) {
			for(int nn = 1; nn < i; nn++) {
				if(nn % num == 0) {
					multiples.add(nn);
				}
			}
		}
		
		for(int multiple : multiples) {
			sum += multiple;
		}
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		
		//parse through string and collect all digits. 
		//Any non-digit characters except a space will render the string invalid.
		for(int i = 0; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i))) {
				digits.add(string.charAt(i) - 48);
			}
			else if(string.charAt(i) != ' ') {
				return false;
			}
		}
		
		if(digits.size() > 1) {
			int sum = 0;
			for(int i = digits.size() % 2; i < digits.size(); i++) {
				if(i % 2 != 0) {
					int doubled = digits.get(i) * 2;
					if(doubled > 9) {
						sum += doubled - 9;
					}
					else {
						sum += doubled;
					}
				}
				else {
					sum += digits.get(i);
				}
			}
			return sum % 10 == 0;
		}
		else {
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String[] words = string.substring(0, string.length() - 1).split(" ");
		int[] numbers = new int[2];
		
		int index = 0;
		for(String word : words) {
//			System.out.println(word);
			if(index < 2) {
				if(word.charAt(0) == '-') {
					Scanner scan = new Scanner(word.substring(1));
					numbers[index] = -scan.nextInt();
					index++;
					scan.close();
				}
				else if(Character.isDigit(word.charAt(0))) {
					Scanner scan = new Scanner(word);
					numbers[index] = scan.nextInt();
					index++;
					scan.close();
				}
			}
			else {
				break;
			}
		}
//		System.out.println(numbers[0] + ", " + numbers[1]);
		switch(words[3]) {
			case "plus":
				return numbers[0] + numbers[1];
			case "minus":
				return numbers[0] - numbers[1];
			case "divided":
				return numbers[0] / numbers[1];
			case "multiplied":
				return numbers[0] * numbers[1];
		}
		return 0;
	}

}
