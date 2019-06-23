package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import pages.Cat;
import pages.Dog;

import java.util.Arrays;
import java.util.HashMap;

public class JavaStepDefs {
    @Given("^I write java steps$")

    public void iWriteJavaSteps() {
        System.out.println("Hello!");

    }

    @Given("^I print \"([^\"]*)\" as argument$")
    public void iPrintAsArgument(String var) throws Throwable {
//       System.out.println("My name is " + var);


        if (var.equalsIgnoreCase("google")) {
            System.out.println("http://www.google.com");
        } else if (var.equalsIgnoreCase("sample")) {
            System.out.println("https://skryabin.com/webdriver/html/sample.html");
        } else {
            System.out.println("Unknown site");
        }

    }


    @Given("^I perform actions with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iPerformActionsWithAnd(String var1, String var2) throws Throwable {
            System.out.println(var1 + ", " + var2);
            System.out.println(var1.toUpperCase() + ", " + var2.toUpperCase());
            System.out.println(var1.length() + ", " + var2.length());
            System.out.println(var1.equals(var2));
            System.out.println(var1.equalsIgnoreCase(var2));
            System.out.println(var1.contains(var2));
            System.out.println();
        }






    @Given("^I compare two \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iCompareTwoAnd(String var1, String var2) throws Throwable {
        System.out.println(var1 + ", " + var2);
        System.out.println(var1.toUpperCase() + ", " + var2.toUpperCase());
        System.out.println(var1.length() + ", " + var2.length());
        System.out.println(var1.equals(var2));
        System.out.println(var1.equalsIgnoreCase(var2));
        System.out.println(var1.contains(var2));
        System.out.println();

        if(var1.equals(var2)) {
            System.out.println("Strings are equal");
        }
        else{
            System.out.println("Strings are not equal");
        }

        if (var1.equalsIgnoreCase(var2)){
            System.out.println("Strings are equal");
        }
        else{
            System.out.println("Strings are not equal");
        }
    }
        public double num3 = 1.5;
        public int num1 = 10;
        public int num2 = 3;
        public int sum = num1+num2;
        public int diff = num1-num2;
        public int prod = num1*num2;
        public double quot = num1/num2;

    @Given("^I run operations with (\\d+) and (\\d+)$")
    public void iRunOperationsWithAnd(int num1, int num2) {
        System.out.println(num1/num2);
        System.out.println(num1/num3);
        System.out.println(sum);
        System.out.println(diff);
        System.out.println(prod);
        System.out.println(quot);

        if(num1<num2){
            System.out.println("num1 is smaller that num2");
            }
            else {
                System.out.println("num1 is larger or equals num2");
        }
        }


    @Given("^I print arrays$")
    public void iPrintArrays() {
//        String[]groceryList = {"milk", "apple", "pear", "orange"};
//        System.out.println(Arrays.toString(groceryList));
//        System.out.println(groceryList[2]);
//        System.out.println(groceryList[1]);
//
//        for (int i=0; i<groceryList.length; i++){
//            System.out.print(groceryList[i]+ " ");
//        }
//        int[] arr = {3, 9, 24, 3, 20};
//        for (int element:arr)
//              {
//                System.out.println(element);
//        }
//
//        for (String element:groceryList) {
//            System.out.println(element);
//        }

        int[]days = new int[5];
        for (int i=0; i<days.length; i++) {
            System.out.println(i+1);

        }


    }

    @Given("^I create classes$")
    public void iCreateClasses() {
        Cat cat = new Cat("Zaika");
        cat.walk();
        cat.sleep();
        cat.eat("fish");
        cat.meow();


        Dog dog = new Dog(" ");
        dog.eat("meat");
        dog.walk();
        dog.sleep();
        dog.bark();




    }

    @Given("^I define map data$")
    public void iDefineMapData() throws Throwable{
//        HashMap<String, String> formData = new HashMap();
//        formData.put("username", "gplagun");
//        formData.put("email", "gplagun@aol.com");
//        System.out.println(formData.get("email"));
//        System.out.println(formData.get("username"));
//        System.out.println(formData.get("wrong"));
//        System.out.println(formData);

    }
}

