import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class Main {

	public static void main(String[] args) throws IOException {
		
		readAndEncrypteAndWrite();
		readAndDencrypteAndWrite();
		
		
		
		/*
		int x = 5;
		int y = 1;
		System.out.println(x^y);
		*/
		
	}	
	
	public static String[] SplitWord(String name , String[] stringList) {
			//split our string to pieces by the help of split method
			stringList = name.split("") ;
		return stringList;
	}
	
	public static String MixTheWord(String newName , String[] stringList , int[] IP) {
		for (int i = 0 ; i < stringList.length ; i++) {
			// We take our IP array's numbers one by one
			int splitter = IP[i];
			// Then by using those numbers from IP we mix our string
			// And save in another String one by one
			newName = newName + stringList[splitter-1] ;// I use -1 since our IP is permutation starts from 1
		}
		return newName;
	}
	
	public static ArrayList ConvertToBinaryModified(String newName) {
		ArrayList binary = new ArrayList();
		for (int i = 0 ; i < newName.length() ; i++) {
			int tempASCII = Integer.valueOf(newName.charAt(i));// turn letter to their ASCII number
			tempASCII = tempASCII-53; // -53 because we want our "a" 's decimal is equal to 44
			String tempBinary = Integer.toBinaryString(tempASCII);// turn ASCII number to binary
			while(tempBinary.length() != 8) {
				tempBinary = "0"+ tempBinary;
			}
			binary.add(tempBinary);// add to arrayList
		}
		return binary;
	}
	
	public static ArrayList ConvertToBinarySplitted(String newName) {
		ArrayList binaryArray = new ArrayList();
		String[] binaryList ;
		for (int i = 0 ; i < newName.length() ; i++) {
			binaryArray.add("0");// since conversion to binary delete the first 0 at the start of the binary we add it here
			binaryList = null;
			int tempASCII = Integer.valueOf(newName.charAt(i));// turn letter to their ASCII number
			String tempBinary = Integer.toBinaryString(tempASCII);// turn ASCII number to binary
			binaryList = tempBinary.split("");// splitting binaryList
			for (int a =0 ; a<binaryList.length ; a++) {
				binaryArray.add(binaryList[a]);// add to arrayList
			}
		}
		return binaryArray;
	}
	
	public static void ShiftRightRotate(ArrayList binaryArrayList , int iteration) {
		for(int x = 0 ; x < iteration ; x++) {
			String first=null;
			String second;
			for (int i = 0 ; i<binaryArrayList.size();i++) {
				if(i == 0 ) {// for the first switch we take both first letter and second letter
					first = (String) binaryArrayList.get(i);
					second = (String) binaryArrayList.get(i+1);
					binaryArrayList.set(i+1, first);// change second position letter with first letter
					first = second;// change first letter with second
				}
				else if (i == binaryArrayList.size()-1) {
					binaryArrayList.set(0, first);// after we came to end put last letter to first position
				}
				else {
					second = (String) binaryArrayList.get(i+1);// didin't change the first letter and just change second letter
					binaryArrayList.set(i+1, first);
					first = second;// change dirt letter with second
				}
			}
		}
	}
	
	public static void SRR(ArrayList binaryArrayList , int iteration ) {
		for(int x = 0 ; x < iteration ; x++) {
			int first = 0;
			int second;
			for (int i = 0 ; i<binaryArrayList.size();i++) {
				if(i == 0 ) {// for the first switch we take both first letter and second letter
					first = (int) binaryArrayList.get(i);
					second = (int) binaryArrayList.get(i+1);
					binaryArrayList.set(i+1, first);// change second position letter with first letter
					first = second;// change first letter with second
				}
				else if (i == binaryArrayList.size()-1) {
					binaryArrayList.set(0, first);// after we came to end put last letter to first position
				}
				else {
					second = (int) binaryArrayList.get(i+1);// didin't change the first letter and just change second letter
					binaryArrayList.set(i+1, first);
					first = second;// change dirt letter with second
				}
			}
		}
	}
	
	public static void SLR(ArrayList binaryArrayList , int iteration ) {
		for(int x = 0 ; x < iteration ; x++) {
			int first = 0;
			int second;
			for (int i = binaryArrayList.size()-1 ; 0<=i ; i--) {
				if(i == binaryArrayList.size()-1 ) {// for the first switch we take both last letter and one before last letter
					first = (int) binaryArrayList.get(i);
					second = (int) binaryArrayList.get(i-1);
					binaryArrayList.set(i-1, first);// change one before last position letter with last letter
					first = second;// change last letter with one before last position
				}
				else if (i == 0) {
					binaryArrayList.set(7, first);// after we came to start put first letter to last position
				}
				else {
					second = (int) binaryArrayList.get(i-1);// didin't change the first letter and just change second letter
					binaryArrayList.set(i-1, first);
					first = second;// change first letter with second
				}
			}
		}
	}
	
	public static void SeparateToNibbles(ArrayList binaryArrayList , ArrayList rightNibble , ArrayList leftNibble) {
		int ArrayListSize = binaryArrayList.size()/2;
		for(int i = 0 ; i < ArrayListSize ; i++) {
			String temp1 = null;
			String temp2 = null;
			if(i != 3) {
				if(i%2 != 0) {
					temp1 =(String) binaryArrayList.get(0);
					temp2 =(String) binaryArrayList.get(2);
					binaryArrayList.remove(0);
					binaryArrayList.remove(1);
					rightNibble.add(temp1);
					rightNibble.add(temp2);
				}
				else if(i%2 == 0) {
					temp1 =(String) binaryArrayList.get(1);
					temp2 =(String) binaryArrayList.get(3);
					binaryArrayList.remove(1);
					binaryArrayList.remove(2);
					leftNibble.add(temp1);
					leftNibble.add(temp2);
				}
			}else {
				temp1 =(String) binaryArrayList.get(0);
				temp2 =(String) binaryArrayList.get(1);
				rightNibble.add(temp1);
				rightNibble.add(temp2);
			}
		}
	}
	
	public static void PrintInTheMatrix(int[][] matrix , ArrayList keyArrayList) {
		int keyIndex = 0 ; // initialize a keyIndex to keep where we are in keyArrayList
		for (int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				String character = (String) keyArrayList.get(keyIndex);// Get the String from keyArraList with Using keyIndex
				int integer = Integer.parseInt(character);// Turn it to int
				keyIndex ++;// increase keyIndex to proceed to next object in to the keyArrayList
				matrix[i][j] = integer;// add integer to matrix	
			}
		}
	}
	
	public static void GenerateKey(int firstColumn , int secondColumn , int thirdColumn , int fourthColumn  , ArrayList KEY , int[][] matrix){
		int index = 0 , keyIndex = 0;
		int[] tempKey1 = new int[4] , tempKey2 = new int[4];
		for (int i = 0 ; i < 4 ; i++) {// save first given column to tempKey1
			tempKey1[index] = matrix[i][firstColumn];
			index++;
		}
		index = 0;
		for (int i = 0 ; i < 4 ; i++) {// save second given column to tempKey2
			tempKey2[index] = matrix[i][secondColumn];
			index++;
		}
		index = 0;
		for (int i = 0 ; i < 4 ; i++) {// implement XOR between tempKey1 and tempKey2
			int a = tempKey1[i]^tempKey2[i];
			KEY.add(keyIndex, a);;// save the result to KEY
			keyIndex++;
		}
		for (int i = 0 ; i < 4 ; i++) {// save third given column to tempKey1
			tempKey1[index] = matrix[i][thirdColumn];
			index++;
		}
		index = 0;
		for (int i = 0 ; i < 4 ; i++) {// save fourth given column to tempKey2
			tempKey2[index] = matrix[i][fourthColumn];
			index++;
		}
		for (int i = 0 ; i < 4 ; i++) {// implement XOR between tempKey1 and tempKey2
			int a = tempKey1[i]^tempKey2[i];
			KEY.add(keyIndex, a);// save the result to KEY
			keyIndex++;
		}
	}
	
	public static void NibbleEncryptionSwitcher(ArrayList leftNibble , ArrayList KEY2 , ArrayList rightNibble , ArrayList KEY3) {
		ArrayList tempRightNibbleArray = new ArrayList();
		for(int i = 0 ; i<rightNibble.size() ; i++) {
			tempRightNibbleArray.add(rightNibble.get(i));
		}
		
		ArrayList tempArray = new ArrayList();
		for (int i = 0 ; i < 4 ; i++) {
			String tempString ="";
			String NibbleString = (String) leftNibble.get(i);
			String[] NibbleList = NibbleString.split("");
			for (int j = 0 ; j < NibbleList.length; j++	) {// convert strings to int 
				int tempNumber ;
				String character = (String) NibbleList[j];// Take string at j. position of NNibbleList
				int integer = Integer.parseInt(character);// Turn it to a integer
				int jhh = (int) KEY2.get(j);
				tempNumber = jhh^integer;
				tempString  = tempString + String.valueOf(tempNumber);
				
			}
			tempArray.add(tempString);
		}
		for(int i = 0 ; i < tempArray.size() ; i++) {
			rightNibble.set(i, tempArray.get(i));
		}
		tempArray.clear();
		for (int i = 0 ; i < 4 ; i++) {
			String tempString ="";
			String NibbleString = (String) tempRightNibbleArray.get(i);
			String[] NibbleList = NibbleString.split("");
			for (int j = 0 ; j < NibbleList.length; j++	) {// convert strings to int 
				int tempNumber ;
				String character = (String) NibbleList[j];// Take string at j. position of NNibbleList
				int integer = Integer.parseInt(character);// Turn it to a integer
				int jhh = (int) KEY3.get(j);
				tempNumber = jhh^integer;
				tempString  = tempString + String.valueOf(tempNumber);
				
			}
			tempArray.add(tempString);
		}
		for(int i = 0 ; i < tempArray.size() ; i++) {
			leftNibble.set(i, tempArray.get(i));
		}
	}
	
	public static void NibbleEncryption(ArrayList leftNibble ,ArrayList KEY4, ArrayList rightNibble ,ArrayList KEY5){
		ArrayList tempArray = new ArrayList();
		for (int i = 0 ; i < 4 ; i++) {
			String tempString ="";
			String NibbleString = (String) leftNibble.get(i);
			String[] NibbleList = NibbleString.split("");
			for (int j = 0 ; j < NibbleList.length; j++	) {// convert strings to int 
				int tempNumber ;
				String character = (String) NibbleList[j];// Take string at j. position of NNibbleList
				int integer = Integer.parseInt(character);// Turn it to a integer
				int jhh = (int) KEY4.get(j);
				tempNumber = jhh^integer;
				tempString  = tempString + String.valueOf(tempNumber);
			}
			tempArray.add(tempString);
		}
		for(int i = 0 ; i < tempArray.size() ; i++) {
			leftNibble.set(i, tempArray.get(i));
		}
		tempArray.clear();
		for (int i = 0 ; i < 4 ; i++) {
			String tempString ="";
			String NibbleString = (String) rightNibble.get(i);
			String[] NibbleList = NibbleString.split("");
			for (int j = 0 ; j < NibbleList.length; j++	) {// convert strings to int 
				int tempNumber ;
				String character = (String) NibbleList[j];// Take string at j. position of NNibbleList
				int integer = Integer.parseInt(character);// Turn it to a integer
				int jhh = (int) KEY5.get(j);
				tempNumber = jhh^integer;
				tempString  = tempString + String.valueOf(tempNumber);
			}
			tempArray.add(tempString);
		}
		for(int i = 0 ; i < tempArray.size() ; i++) {
			rightNibble.set(i, tempArray.get(i));
		}
	}
	
	public static ArrayList DoTheWork(String name) {
		
		int[][] matrix = new int [4][4];
		final int[] IP = {6,4,2,8,7,5,3,1};// fixed IP
		String[] stringList = new String[8];//Split word to letters and store in array
		String[] keyList = null;
		String newName = "";// empty String for new words
		String KEY = "ab";
		ArrayList binaryArrayList = new ArrayList();// ArrayList for binary numbers
		ArrayList keyArrayList = new ArrayList();
		ArrayList rightNibble = new ArrayList();
		ArrayList leftNibble = new ArrayList();
		ArrayList KEY2 = new ArrayList();
		ArrayList KEY3 = new ArrayList();
		ArrayList KEY4 = new ArrayList();
		ArrayList KEY5 = new ArrayList();
		
		stringList = SplitWord(name, stringList); // first split the original word and keep in array
		newName = MixTheWord(newName, stringList, IP); // Then mix the word which i split in previous method 
		stringList = SplitWord(newName, stringList); // Then i split the mixed word again so i can turn it in to binary code
		binaryArrayList = ConvertToBinaryModified(newName);// Then get the Binary number of all letters in array list
		
		//CHECK
		//System.out.println(stringList[2] +"\n"+ newName + "\n" + binaryArrayList.get(2)); 
		
		//CHECK
		/*
		binaryArrayList.clear();
		binaryArrayList.add("y");
		binaryArrayList.add("s");
		binaryArrayList.add("i");
		binaryArrayList.add("e");
		binaryArrayList.add("l");
		binaryArrayList.add("e");
		binaryArrayList.add("r");
		binaryArrayList.add("b");
		*/
		
		ShiftRightRotate(binaryArrayList , 4);
		
		//CHECK
		/*
		for(int i = 0 ; i < binaryArrayList.size() ; i++) {
			System.out.print(binaryArrayList.get(i)+" *** ");
		}*/
		
		
		SeparateToNibbles(binaryArrayList, rightNibble, leftNibble);
		
		//CHECK
		/*
		System.out.println("LeftNibble");
		for (int i = 0 ; i < leftNibble.size() ; i++ ) {
			System.out.println(leftNibble.get(i)+"*");
		}
		System.out.println("RightNibble");
		for (int i = 0 ; i < rightNibble.size() ; i++ ) {
			System.out.println(rightNibble.get(i)+"*");
		}
		*/
		
		//CHECK
		/*
		System.out.println(KEY);
		keyList = SplitWord(KEY, keyList);
		for(String a : keyList) {
			System.out.println(keyList);
		}
		*/
		
		keyArrayList = ConvertToBinarySplitted(KEY);// convert our KEY to binary then split it one by one and save to arryalist
		PrintInTheMatrix(matrix, keyArrayList);// add keyArrayList to matrix table
		
		// CHECK
		/*
		for (int[] row : matrix){
            System.out.println(Arrays.toString(row));
		}
		*/
		
		GenerateKey(3 , 1 , 0 , 2 , KEY2 , matrix);
		
		GenerateKey(0, 1, 3, 2 , KEY3 , matrix);
		
		NibbleEncryptionSwitcher(leftNibble, KEY2 , rightNibble , KEY3);
		
		//CHECK
		/*
		for(int i = 0 ; i < leftNibble.size() ; i++) {
			System.out.println("Left Nibble = " + leftNibble.get(i));
		}
		for(int i = 0 ; i < rightNibble.size() ; i++) {
			System.out.println("Right Nibble = " + rightNibble.get(i));
		}
		*/
		
		SLR(KEY2, 3);// Generate KEY4 to shift 3 times to the left
		KEY4 = KEY2;
		
		SRR(KEY3, 3);// Generate KEY5 to shift 3 times to the right
		KEY5 = KEY3;
		
		NibbleEncryption(leftNibble, KEY4, rightNibble, KEY5);
		
		//CHECK
		/*		
		for(int i = 0 ; i < leftNibble.size() ; i++) {
			System.out.println("Left Nibble = " + leftNibble.get(i));
		}
				for(int i = 0 ; i < rightNibble.size() ; i++) {
			System.out.println("Right Nibble = " + rightNibble.get(i));
		}
		*/
		binaryArrayList.clear();
		for(int i = 0 ; i<leftNibble.size() ; i ++) {
			binaryArrayList.add(leftNibble.get(i));
		}
		for(int i = 0 ; i<rightNibble.size() ; i ++) {
			binaryArrayList.add(rightNibble.get(i));
		}
		return binaryArrayList;
	}
	
	public static void readAndEncrypteAndWrite() throws IOException	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C://Users//Asus//Desktop//CE340 HW1/1-PlainText.txt"));
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("C://Users//Asus//Desktop//CE340 HW1/2-CipherText.txt")));
			String[] array ;
			int pointer = 0;
			int wordPointer = 0;
			String word="";
			ArrayList arrayList = new ArrayList();
			String encryptedWord = "" ;
			for (int i = 0 ; i<10 ; i++	){
				String line = reader.readLine();
				 array = line.split("");
				 
				 //CHECK
				 /*
				 for(int j = 0 ; j< array.length;j++) {
						System.out.println("Array " + array[j]);
					}
				 */
					 for(wordPointer = 0 ; wordPointer < array.length ; wordPointer ++) {
						 
						 word = word + array[wordPointer];
						 if(wordPointer == 7) {
							 arrayList = DoTheWork(word);
							 word = "";
							 for(int j = 0 ; j < arrayList.size() ; j++) {
								encryptedWord = encryptedWord + arrayList.get(j);
							 }
							 
							 arrayList.clear();
						 }
						 else if(wordPointer==15){
							 arrayList = DoTheWork(word);
							 word = "";
							 for(int j = 0 ; j < arrayList.size() ; j++) {
									encryptedWord = encryptedWord + arrayList.get(j);
								 }
								 arrayList.clear();
						 }
						 else if(wordPointer==23){
							 arrayList = DoTheWork(word);
							 word = "";
							 for(int j = 0 ; j < arrayList.size() ; j++) {
									encryptedWord = encryptedWord + arrayList.get(j);
								 }
								 arrayList.clear();
						 }
						 else if (wordPointer==24) {
							 word = word +"aaaaaaa";
							 arrayList = DoTheWork(word);
							 word = "";
							 for(int j = 0 ; j < arrayList.size() ; j++) {
									encryptedWord = encryptedWord + arrayList.get(j);
								 }
								 arrayList.clear();
						 }
					 }
			}
			writer.write(encryptedWord);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readAndDencrypteAndWrite() throws IOException	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C://Users//Asus//Desktop//CE340 HW1/2-CipherText.txt"));
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("C://Users//Asus//Desktop//CE340 HW1/3-PlainTextDecrypted.txt")));
			String[] array ;
			int counter = 1;
			String word="";
			ArrayList KEY2 = new ArrayList();
			int addKEY2 = 11101011;
			KEY2.add(addKEY2);
			ArrayList KEY3 = new ArrayList();
			int addKEY3 = 10101111;
			KEY3.add(addKEY3);
			int KEY4 = 01011111;
			int KEY5 = 11110101;
			ArrayList rightNibble = new ArrayList();
			ArrayList leftNibble = new ArrayList();
			ArrayList fullWord = new ArrayList();
			ArrayList arrayList = new ArrayList();
			String encryptedWord = "" ;
			for (int i = 0 ; i<1 ; i++	){
				String line = reader.readLine();
				 array = line.split("");
				 
				 for(int j = 1 ; j <= array.length ; j++) {
					 word = word + array[j-1];
					 if(j>2&&j % 8 == 0){
						 if(counter <=4) {
							 rightNibble.add(word);
						 }else if(counter == 8){
							 fullWord.add(leftNibble);
							 fullWord.add(rightNibble);
							 counter = 0;
						 }
						 else {
							 leftNibble.add(word);
						 }
						 word = "";
						 counter++;
					 }
				 }
				
				 //CHECK
				 /*
				 for(int j = 0 ; j< array.length;j++) {
						System.out.println("Array " + array[j]);
					}
				 */
					
			}
			writer.write(encryptedWord);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


