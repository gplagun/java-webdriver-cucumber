@java
  Feature: Java steps

    @java1
    Scenario: Writing java steps
      Given I write java steps

    @java2
    Scenario: Java steps with arguments
       Given I print "Galina" as argument

    @java3
    Scenario: Java steps with two arguments
      Given I perform actions with "my var" and "my VAR"

    @java4
    Scenario: Java - compare two string arguments
      Given I compare two "my var" and "my VAR"

    @java5
    Scenario: Java steps with numbers
      Given I run operations with 10 and 3

    @java6
    Scenario: Java steps with strings
      Given I compare two "string1" and "string2"

    @java7
    Scenario: Java condition exercise
      Given  I print "yahoo" as argument

    @java8
    Scenario: Java arrays
      Given I print arrays

    @java9
    Scenario: Classes
      Given I create classes

    @java10
    Scenario: Map use
      Given I define map data



