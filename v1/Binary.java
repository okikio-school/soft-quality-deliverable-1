package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	private boolean Err=true;  // indicator if the binary value is invalid
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		Err=false;    //default value if no error detection
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				Err=true;
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}
    }
	/**
	* Return the status of the binary variable
	*
	* @return A false is returned if the binary value is invalid
	*/
	public boolean isGood() {
		return (!this.Err);
	}
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format. "0" if the status of the variable is not good.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of num1+num2. If either addend is invalid, the return variable would be invalid too
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		//If either addend is invalid, the return variable would be invalid too
		if((! num1.isGood()) || (! num2.isGood()))
		{
			Binary badResult=new Binary("");
			badResult.Err=true;
			return badResult;
		}
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}
}	
