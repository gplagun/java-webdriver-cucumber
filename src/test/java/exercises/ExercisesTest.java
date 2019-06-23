//package exercises;
//
//import com.gargoylesoftware.htmlunit.html.HtmlListing;
//import org.assertj.core.internal.Arrays;
//import org.junit.Test;
//import org.junit.experimental.theories.Theories;
//
//import java.text.SimpleDateFormat;
//
//import java.awt.*;
//import java.lang.reflect.Array;
//import java.util.Date;
//import java.util.concurrent.ForkJoinPool;
//
//public class ExercisesTest {
//
//    @Test
//    public void codeChallenges() {
////        printMessage("New Message");
////
////        swapValues();//         printMessage(divisionBy(9));
////        printNumbers(5);
////        System.out.println(Arrays.toString(returnNumbers(5)));//       System.out.println(verifyPrime(5));
//        //fibonacci(10);
////        System.out.print(factorial1(5));
////        System.out.print(factorial1(-5));
////        System.out.print(reverseString("WebDriver"));
////        String[]array ={"one","two","three","four"};
////        reversedArray(array);
////        String words ="one two three four";
////        reverseWordsInString(words);
////        getDate();
////        printNumbers2(7);
////        printPosNegativeNumbers(-8);
////        System.out.println(isNumberPrime(9));
////        printFizzBuzz(18);
////        System.out.println(factorial2(5));
////        System.out.println(reversedString("cat"));
////        checkPassFail(51);
////        printNumberInWord("webdriver");
////        printDayInWord(5);
////        reversedStringWithArray("WebDriver");
////        palindrom("driver");
////        duplicateCharacter("Sakkett");
////        biggestNumber();
////        removeWhiteSpaces1("Galina   Lagunova      is  a    SDET");
////        removeWhiteSpaces2("Galina   Lagunova      is  a    SDET");
////        palindrome2(121);
////        oddOrEven(64);
////          checkMultiple(48, 6 );
////          calculateBMI(88.6, 164.2);
////        int[] myArray = {2, 1, 2, 3, 4};
////        countsEven(myArray);
//        //System.out.println(nearTen(12));
//    }
//
//
//
//
//
//    private void countsEven(int[] numbers) {
//        int counts = 0;
//
//        for (int i = 0; i <= numbers.length - 1; i++) {
//
//            if (numbers[i] % 2 == 0) {
//                int count = 1;
//                counts += count;
//            }
//        }
//        System.out.println(counts);
//    }
//
////   private static int fibonacci(int number) {
////
////        int fibo1 = 0, fibo2 = 1, fibonacci=0;
////        for (int i = 3; i <= number; i++) {
////            System.out.print(fibo1 + " ");
////            fibonacci = fibo1 + fibo2;
////            fibo1 = fibo2;
////            fibo2 = fibonacci;
////        }
////        return fibonacci;
////    }
////}
//
//    private void calculateBMI(double weight, double height){
//        double bmi = weight/height*height;
//        System.out.println("BMI VALUES");
//        if(bmi<18.5){
//            System.out.println("Underweight: less than 18.5");
//        }
//        else if (bmi > 18.5 && bmi <24.9){
//            System.out.println("Normal: between 18.5 and 24.9");
//        }
//        else if ( bmi > 25.0 && bmi < 29.9){
//            System.out.println("Overweight: between 25.0 and 29.9");
//        }
//        else if (bmi > 30){
//            System.out.println("Obese: 30.0 or greater");
//        }
//    }
//
//    private void checkMultiple(int multiple, int num){
//        if (multiple%num == 0){
//            System.out.println("Number " + multiple + " is the multiple of number " + num);
//        }
//        else{
//            System.out.println("Number " + multiple + " is not the multiple of number " + num);
//        }
//    }
//
//    private void oddOrEven (int number){
//        if (number%2 == 0) {
//            System.out.println("The number " + number + " is even");
//        }
//        else{
//            System.out.println("The number " + number + " is odd");
//        }
//    }
//
//
//
//    private void palindrome2(int number) {
//        int palindrome = number; // copied number into variable
//        int reverse = 0;
//
//        while (palindrome != 0) {
//            int remainder = palindrome % 10;
//            reverse = reverse * 10 + remainder;
//            palindrome = palindrome / 10;
//        }
//
//        if (number == reverse) {
//            System.out.println("This is a palindrom");
//        } else {
//            System.out.println("This is not a palindrom");
//        }
//
//    }
//
//
//
//
//    private void removeWhiteSpaces1(String str){
//        String newString = str.replace(" ","");
//        System.out.println(newString);
//
//    }
//
//    private void removeWhiteSpaces2(String str){
//        String newString = " ";
//        StringBuffer sb = new StringBuffer();
//        char[] strArray = str.toCharArray();
//        for (int i=0; i<strArray.length; i++){
//            if( strArray[i] != ' '){
//
//                sb.append(strArray[i]);
//        }
//        }
//        System.out.println(sb);
//
//    }
//
//
//    private void biggestNumber() {
//        int[] numbers = {14, 46, 47, 94, 9, 52, 86, 36, 89};
//        int maxNum = numbers[0];
//        System.out.print("Array of integers is: ");
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.print(numbers[i]+ " ");
//        }
//        System.out.println();
//        for (int i = 0; i < numbers.length; i++) {
//
//            if ( maxNum< numbers[i])
//                maxNum = numbers[i];
//        }
//        System.out.println("Biggest number is: " + maxNum);
//    }
//
//
//    private void duplicateCharacter(String text) {
//        int count = 0;
//        char[] chars = text.toCharArray();
//        System.out.println("Duplicate characters are:");
//        for (int i=0; i<text.length();i++) {
//            for(int j=i+1; j<text.length();j++) {
//                if (chars[i] == chars[j]) {
//                    System.out.println(chars[j]);
//                    count++;
//                    break;
//                }
//            }
//        }
//    }
//
//
//
//    private void reversedStringWithArray(String word){
//
//        char[]chars = word.toCharArray();
//        for (int i = chars.length-1; i>=0; i--){
//            System.out.print(chars[i]);
//        }
//
//    }
//
//
//    private void palindrom(String text){
//        String newString="";
//
//        for (int i =text.length()-1; i >=0; i--){
//           newString = newString +text.charAt(i);
//        }
//        System.out.println(text);
//        System.out.println(newString);
//        if (newString.equalsIgnoreCase(text)) {
//            System.out.println("This is a palindrom");
//        }
//        else{
//            System.out.println("This is not a palindrom");
//        }
//    }
//
//    private void palindrom3(String text){
//        String newString=" ";
//
//        System.out.println(text);
//        System.out.println(newString);
//        if (newString.equalsIgnoreCase(text)) {
//            System.out.println("This is a palindrom");
//        }
//        else{
//            System.out.println("This is not a palindrom");
//        }
//    }
//
//    private void printDayInWord(int day){
//
//        switch(day) {
//            case 1:
//               System.out.println("Sunday");
//                break;
//            case 2:
//                System.out.println("Monday");
//                break;
//            case 3:
//                System.out.println("Tuesday");
//                break;
//            case 4:
//                System.out.println("Wednesday");
//                break;
//            case 5:
//                System.out.println("Thursday");
//                break;
//            case 6:
//                System.out.println("Friday");
//                break;
//            case 7:
//                System.out.println("Saturday");
//                break;
//            default:
//                System.out.println("Not a valid day");
//        }
//    }
//
//
//
//
//    private void printNumberInWord(String word){
//        int number = word.length();
//        String numInWord = " ";
//        numInWord=Integer.toString(number);
//        System.out.println("You entered  ' "+ word + "'.  It has " + numInWord + " letters.");
//
//    }
//
//
//    private String reversedString(String origSting){
//
//        String newString = " ";
//        int stringLength = origSting.length();
//        for (int i =origSting.length()-1; i >=0; i--){
//            newString= newString+origSting.charAt(i);
//        }
//        return newString;
//    }
//
//    private void checkPassFail(int mark) {
//
//        if (mark >= 50) {
//            System.out.println("PASS");
//        } else {
//            System.out.println("FAIL");
//        }
//        System.out.println("DONE");
//    }
//
//
//    private int factorial2(int number){
//        int factorial = 1;
//        for (int i =1; i<= number; i++)
//        {
//           factorial = factorial * (i);
//        }
//        return factorial;
//    }
//
//
//    private void printFizzBuzz(int n){
//        for (int i = 1; i<=n; i++){
//                if (i%3==0 && i%5==0){
//                    System.out.println("FizzBuzz");
//                }
//                else if (i%3==0){
//                    System.out.println("Fizz");
//                }
//                else if (i%5==0){
//                    System.out.println("Buzz");
//                }
//                else {System.out.println(i);}
//            }
//}
//
//
//
//
//
//
//    private void printMessage(String text){
//        System.out.println(text);
//    }
//
//    private String getDate() {
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//
//        String date1 = dateFormat.format(date);
//
//        System.out.println("Current date is " + date1);
//        return date1;
//    }
//
//
//    private void swapValues() {
//        int a = 3;
//        int b = 5;
//
//        int temp = a;
//        a = b;
//        b = temp;
//        System.out.println("a" + a);
//        System.out.println("b" + b);
//    }
//
//    private String divisionBy(int number) {
//        String message = " ";
//        if (number % 3 == 0 && number % 4 == 0) {
//            message = "divisible by 3 and 4";
//        }
//
//        else if (number % 3 == 0) {
//            message = "divisible by 3";
//        }
//        else if (number % 4 == 0) {
//            message = "divizible by 4";
//        }
//        else
//        {message ="not divisible by 3 and 4";}
//
//
//        return message;
//    }
//
//    private void printNumbers(int num) {
//        if (num > 0) {
//            for (int i = 0; i <= num; i++) {
//                System.out.println(i);
//            }
//        } else {
//            for (int i = 0; i >= num; i--) {
//                System.out.println(i);
//            }
//        }
//
//    }
//
//    private int[] returnNumbers(int num) {
//        int[] myArray = new int[num + 1];
//        if (num > 0) {
//            for (int i = 0; i <= num; i++) {
//                myArray[i] = i;
//            }
//        }
//        return myArray;
//    }
//
//    private boolean verifyPrime(int num) {
//        for (int i = 2; i < num; i++) {
//            if (num % i == 0)
//                return false;
//        }
//        return true;
//    }
//
//
//
//    public int factorial(int number) {
//        int i, fact = 1;
//
//        for (i = 1; i <= number; i++) {
//            fact = fact * i;
//            System.out.print(fact + " ");
//        }
//        return fact;
//
//
//    }
//
//
//
//
//    private int factorial1(int number) {
//        if (number == 0) {
//            return 1;
//        }
//        if (number > 0) {
//            return number * factorial1(number - 1);
//        } else {
//            return number * factorial1(number + 1);
//        }
//    }
//
//    private String reverseString(String text){
//        String reversedText="";
//        for (int i=text.length()-1; i>=0; i--) {
//            reversedText= reversedText + text.charAt(i);
//
//        }
//        return reversedText;
//
//    }
//    private void reversedArray (String [] array){
//
//
//        for ( int i= array.length -1; i>=0; i--){
//           System.out.print(array[i] + " ");
//
//        }
//        System.out.println();
//
//    }
//
//    private void reverseWordsInString (String words){
//        String [] array = words.split(" ");
//
//        for ( int i= array.length -1; i>=0; i--){
//            System.out.print(array[i] + " ");
//
//        }
//        System.out.println();
//    }
//
//    private void printNumbers2(int n){
//        for (int i=1; i<=n; i++){
//            System.out.print(i + " ");
//        }
//    }
//
//    private void printPosNegativeNumbers(int n) {
//            if (n > 0) {
//                for (int i = 1; i <= n; i++) {
//                    System.out.print(i + " ");
//                }
//            }
//            else {
//                    for (int i = 0; i >= n; i--) {
//                        System.out.print(i + " ");
//                    }
//        }
//    }
//
//    private boolean isNumberPrime(int n){
//
//        for (int i=2; i<n; i++)
//            if (n%i==0){
//                return false;
//            }
//
//     return true;
//    }
//
//}
//
//
//
//
//
//
//
//
