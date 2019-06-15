package LeetCode;

public class AtoI {
    public static int myAtoi(String str) {
        String trimmedString = str.trim(); // remove leading whitespace (and trailing)
        int sign = 1;
        StringBuilder numberString = new StringBuilder();
        if(trimmedString.equals("")){ // edge case
            return 0;
        }
        if(trimmedString.charAt(0)== '+' || trimmedString.charAt(0) =='-'){
            if(trimmedString.charAt(0) == '-'){ // pull out the sign
                sign = -1;
            }
            // remove optional sign
            trimmedString = trimmedString.substring(1);
        }
        for(int i =0; i < trimmedString.length(); i++){
            int currDigit;
            try{
                currDigit = Integer.parseInt(trimmedString.charAt(i) + "");
            } catch(NumberFormatException e){
                break;
            }
            numberString.append(currDigit);
            if(sign * Long.parseLong(numberString.toString())> Integer.MAX_VALUE){ // don't forget to multiply by sign here to get true value of number i.e if input is Integer.MIN_VALUE this would be true w/out sign 
                return Integer.MAX_VALUE;
            } else if (sign *Long.parseLong(numberString.toString()) < Integer.MIN_VALUE){ // don't forget to multiply by sign here to get true value of number
                return Integer.MIN_VALUE;
            }
        }

        if(numberString.toString().equals("")) {
            return 0;
        }
        Long temp = Long.parseLong(numberString.toString()); // parse final value to Long (case where we have input = Integer.MIN_VALUE or Integer.MAX_VALUE will error)
        return temp.intValue() * sign;
    }

    public static void main(String[] args){
        String test = "-2147483648";
        System.out.println(myAtoi(test));
        //System.out.println(Integer.MAX_VALUE);
    }
}
