package com.leetcode.fan.arrays;

/**
*   Create by :PF23
*   Create date: 2018年2月1日
*/

public class ReverseInteger {
	private static int num4 = 123;
	private static int num2 = -123;
	private static int num3 = 120;
	private static int num1 = 1523462789;
	/**
	 * Example 1:
		Input: 123
		Output:  321
		Example 2:
	   Example 2:
		Input: -123
		Output: -321
		Example 3:
	   Example 3:
		Input: 120
		Output: 21
	Note:
		Assume we are dealing with an environment which could 
		only hold integers within the 32-bit signed integer range. 
		For the purpose of this problem, assume that your function 
		returns 0 when the reversed integer overflows.
	 */
	public int reverse(int i){
		int constt = 10;
		if (i == 0 || i >= Integer.MAX_VALUE || i <= Integer.MIN_VALUE) {
			return 0;
		} else {
			long temp = 0L;
			if (i < 0) {
				return -reverse(-i);
			}
			//1523462789
			while (i > 0) {
				//此步计算时溢出
				temp = temp * 10 + i % constt;
				if (temp > Integer.MAX_VALUE) {
					return 0;
				}
    				i /= constt;
			}
			int value = new Long(temp).intValue();
			return value;
		}
		
	}
	public static void main(String[] args) {
		ReverseInteger rInteger = new ReverseInteger();
		int reverseNum1 = rInteger.reverse(num1);
		int reverseNum2 = rInteger.reverse(num2);
		int reverseNum3 = rInteger.reverse(num3);
		int reverseNum4 = rInteger.reverse(num4);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println("---------------------------------------");
		System.out.println("the result of reversing num1:" + reverseNum1);
		System.out.println("the result of reversing num1:" + reverseNum2);
		System.out.println("the result of reversing num1:" + reverseNum3);
		System.out.println("the result of reversing num1:" + reverseNum4);
		
	}
}
