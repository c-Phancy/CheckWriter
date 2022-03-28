Assignment Instructions:

Assignment: CheckWriter

Submit:  2 files:  checkWriter.kt and testCheckWriter.kt

Create a program that creates a Class that EXTENDS the built-in Kotlin Double class.  This will reopen the class to add your own definition of a new function that will be available to all of the Double numbers in Kotlin.

Your class should implement ONLY the following public function:

            toCheckString()

Like:

    fun Double.toCheckString(): String {
The function “toCheckString()” will return a string which represents the Double number as a check writing string.  For instance, 10234.44  when converted will result in the string:  

    “Ten Thousand, Two Hundred Thirty Four dollars and Forty Four Cents”.

This should work for any number between 0.00 and 999,999.99

Because the CheckWriter function inherits all the attributes and methods of a Double, a user of your function should be able to ask for a number from the user and return the printed string.  It should also be able to add numbers together and print out the check string as a result.  THERE SHOULD BE NO PRINTING FROM THE FUNCTION!!!

For instance this code should work:

    (10.25 + 40.30).toCheckString()
should result in the following string:

    "Fifty dollars and Fifty Five Cents"
However, you are only responsible for writing the actual Double extension function - NOT the testing program.  You will be running my testing program to test your function that is in a different file.

You must submit your program with the name as follows so that my testing program will work with it as well.  In addition you must submit a copy of MY testing program along with your checkwriter program.

checkWriter.kt  (Your program)

testCheckWriter.kt   (My testing program)

ZIP these 2 files together and submit as a single file to this assignment.

The testing file is here for you to download and put into your project:  testCheckWriter.kt 