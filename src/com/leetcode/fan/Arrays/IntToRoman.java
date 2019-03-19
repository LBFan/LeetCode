package com.leetcode.fan.Arrays;
class IntToRoman {
    public String intToRoman(int num) {
        String str = "";
        int i = 1, n;     //n表示从右到左数的第几位
        if(num < 0 || num > 3999){
            return null;
        }else{
            while(num > 0){
            n = num % 10;  //表示该位上的数字
            num /= 10;
            str=intToCharacter(n, i).concat(str);  //把每一位返回的字符串和str相连
            i++;
        }
        return str;
        }
        
        
    }
    
    public String intToCharacter(int n, int i){//n表示特定的输入，i表示个位十位百位或者千位
        String str1,str2,str3;//拿0~9之间的数举例，str1表示I，str2表示V，str3表示X
         String str="";//这个函数返回特定位上的罗马数字表示形式
         if(1 == i){            //下面if语句是判断n是哪一位上的,依次用罗马数字表示1、5、10
             str1 = "I";        //个位上的数
             str2 = "V";
             str3 = "X";
         }
        else if(2 == i){           //十位上的数
            str1 = "X";
            str2 = "L";
            str3 = "C";
        }
        else if(3 == i){           //百位上的数
            str1 = "C";
            str2 = "D";
            str3 = "M";
        }else{
            str1 = "M";            //千位上的数
            str2 = "";
            str3 = "";
        }
        switch(n){         //switch对各数字进行组合以个位上的数举例如下
            case 0:break;                      //空
            case 1:str+=str1;break;            //I
            case 2:str+=str1+str1;break;      //II
            case 3:str+=str1+str1+str1;;break;//III
            case 4:str+=str1+str2;break;      //IV
            case 5:str+=str2;break;           //V
            case 6:str+=str2+str1;break;      //VI
            case 7:str+=str2+str1+str1;break; //VII
            case 8:str+=str2+str1+str1+str1;break;    //VIII
            case 9:str+=str1+str3;break;             //IX
        }
        return str;
    }
    public static void main(String[] args) {
    		int number1 = 1;
    		int number2 = 2004;
    		int number3 = 4000;
		IntToRoman iToRoman = new IntToRoman();
		String roman1 = iToRoman.intToRoman(number1);
		String roman2 = iToRoman.intToRoman(number2);
		String roman3 = iToRoman.intToRoman(number3);
		
		System.out.println("the number changed,and the roman result is: ");
		System.out.println("roman1:" + roman1);
		System.out.println("roman2:" + roman2);
		System.out.println("roman3:" + roman3);
	}
}