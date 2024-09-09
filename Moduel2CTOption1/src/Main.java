/*
Program Name: Module 2 Critical Thinking Option 1
Author: Nathan Curtis
Date: 9/1/2024
-------------------
Pseudocode:

Define Float weakly income with user prompt
Print: Calculating weekly tax withholding
call class Calculate Taxes with a return value
Print: Out of X , you were taxed Y

make function calculate taxes
define income as float and take as a parameter
define temp income as float = income
taxed amount as a float = 0
if temp income => 2500:
  dollars taxed = temp income - 2500
  taxed amount = taxed amount + (dollars taxed * .3)
  temp income = temp income - dollars taxed
if temp income => 1500:
  dollars taxed = temp income - 1500
  taxed amount = taxed amount + (dollars taxed * .2)
  temp income = temp income - dollars taxed
if temp income => 500:
  dollars taxed = temp income - 500
  taxed amount = taxed amount + (dollars taxed * .15)
  temp income = temp income - dollars taxed
if temp income => 0:
  dollars taxed = temp income
  taxed amount = taxed amount + (dollars taxed * .1)
  temp income = temp income - dollars taxed

return taxed amount
*/
import java.util.Scanner; // Allow user input
import java.text.DecimalFormat; // Allow decimal point for cash

public class Main {
    public static void main(String[] args){
        float weeklyIncome, taxedAmount; // Predefine float variables to edit later
        System.out.println("Calculating average weekly tax withholdings");
        System.out.println("What is your weekly earnings");
        Scanner myInput = new Scanner(System.in); // Obtain user input amount - Could add loop to check if float and get correction if not - could also strip and '$'
        weeklyIncome = myInput.nextFloat(); // Im still a little unclear what this line does
        taxedAmount = CalculateTaxes(weeklyIncome); // Sends user input to function Calculated Taxes to obtain how much was taxed and then retruns that amount into variable taxed amount
        DecimalFormat df = new DecimalFormat("$0.00"); // Formats floats to have a decimal pattern reflective of the USA formating of money
        System.out.println("Out of "+ df.format(weeklyIncome) +", you would been taxed " + df.format(taxedAmount)); // Prints out the formated amount of taxed money and the original amount. Could add more details
        myInput.close(); // Close input. Could and should have been put earlier
    }

    public static float CalculateTaxes(float income) { // Function calculating amount taxed
        float tempIncome = income, taxedAmount = 0, dollarsTaxed = 0; // Predefine float variables and fill.
        
        // The following code checks the amount of income the user inputed, and compares it to the tax brackets. Brackets will be taxed differently according to how taxes are done in the USA.
        // Starting from the largest bracket, the income is compated to see if there is any amount over.
        // That amount over is iscolated and taxed accordingly and tracked on the side, while the iscolated amount is subtracted from the income and sent to the next bracket.

        if (tempIncome >= 2500) { // Any amount of income over 2500 is taxed 30%. Remainging under 2500 is sent to next bracket
            dollarsTaxed = tempIncome - 2500; //iscolates an amount over the tax bracket minimum.
            taxedAmount = (float) (taxedAmount + (dollarsTaxed * 0.3)); //Calculates what is taxed from the iscolated amount and adds it to a total tracking
            tempIncome = tempIncome - dollarsTaxed; // The iscolated amount is subtracted from the total amount to avoid the same money being taxed again.
        }
        if (tempIncome >= 1500) {// Any amount of income over 1500 is taxed 20%. Remainging under 1500 is sent to next bracket
            dollarsTaxed = tempIncome - 1500;
            taxedAmount = (float) (taxedAmount + (dollarsTaxed * 0.2));
            tempIncome = tempIncome - dollarsTaxed;
        }
        if (tempIncome >= 500) {// Any amount of income over 500 is taxed 15%. Remainging under 500 is sent to next bracket
            dollarsTaxed = tempIncome - 500;
            taxedAmount = (float) (taxedAmount + (dollarsTaxed * 0.15));
            tempIncome = tempIncome - dollarsTaxed;
        }
        if (tempIncome >= 0) {// Any amount of income over 0 is taxed 10%. There should be no remaing
            dollarsTaxed = tempIncome;
            taxedAmount = (float) (taxedAmount + (dollarsTaxed * 0.1));
            tempIncome = tempIncome - dollarsTaxed;
        }
        return taxedAmount; // Total taxed amount is returned
    }
}

