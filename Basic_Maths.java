class Basic_Maths{

    public static int reverse_number(int x){
        int result = 0;
        
        while(x != 0){
            int digit = x % 10; 
            x = x / 10;
            
            // Check for overflow before updating result
            // Integer.MAX_VALUE = 2147483647, so MAX_VALUE/10 = 214748364
            // Integer.MIN_VALUE = -2147483648, so MIN_VALUE/10 = -214748364
            
            if(result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && digit > 7)){
                return 0; // Positive overflow
            }
            
            if(result < Integer.MIN_VALUE / 10 || 
               (result == Integer.MIN_VALUE / 10 && digit < -8)){
                return 0; // Negative overflow
            }
            
            result = result * 10 + digit; 
        }
        
        return result;
    }


    public static boolean String_Palindrome(String s){
        // Remove all non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Compare characters from both ends
        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
    
    public static int count_digits(int n){
        int count = 0;
        int reverse = 0;
        while (n>0) {
            int last_digit = n%10;
            reverse = reverse*10+last_digit;
            System.out.print(last_digit + " ");
            n = n/10;
            count++;
        }
        System.out.println();
        System.out.println(reverse);
        return count;
    }

    public static boolean isPalindrome(int n){
        int n1 = n;
        int reverse = 0;
        while(n>0){
            int last_digit = n%10;
            reverse = reverse*10+last_digit;
        }
        if(reverse == n1){
            return true;
        }
        else{
            return false;
        }
    }

    public static void  isArmstrong(int n){
        int n1 = n;
        double ans = 0;
        int count = (int)Math.log10(n)+1;
        while(n>0){
            int last_digit = n%10;
            ans = ans + Math.pow(last_digit, count);
            n = n/10;
        }
        if(ans == n1){
            System.out.println("Number is Armstrong");
        }
        else{
            System.out.println("Number is not Armstrong");
        }
    }

    public static void print_Divisors(int n){
        for (int i = 1; i <= n; i++) {
            if(n%i==0){
                System.out.print(i + " ");
            }
        }
    }

    public static boolean  check_prime(int n){
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }    
    
    public static void GCD(int n1,int n2){
        int[] divisors1 = new int[n1];
        int count1 = 0;
        for (int i = 1; i <= n1; i++) {
            if(n1 % i == 0){
                divisors1[count1] = i;
                count1++;
            }
        }
        
        int[] divisors2 = new int[n2];
        int count2 = 0;
        for (int i = 1; i <= n2; i++) {
            if(n2 % i == 0){
                divisors2[count2] = i;
                count2++;
            }
        }
        
        int gcd = 1;
        for (int i = 0; i < count1; i++) {
            for (int j = 0; j < count2; j++) {
                if(divisors1[i] == divisors2[j] && divisors1[i] > gcd){
                    gcd = divisors1[i];
                }
            }
        }
        
        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + gcd);
    } 

    public static int Gcd_simple(int a,int b){
        if(b==0){
            return a;
        }
        return Gcd_simple(a, a%b);
    }
    public static void main(String[] args) {
        // System.out.println(count_digits(77877));
        // isArmstrong(1634);
        // print_Divisors(34);
        // if(check_prime(17)){
        //     System.out.println("Number is Prime");
        // }
        // else{
        //     System.out.println("Number is not Prime");
        // }

        // GCD(12, 18);
        // System.out.println(Gcd_simple(9, 12));

        
        // Test cases including edge cases
        // int[] testCases = {123, -123, 120, 0, 1534236469, -2147483648};
        
        // for(int test : testCases) {
        //     System.out.println("Input: " + test + " -> Output: " + reverse_number(test));
        // }
        
        String str = "A man, a plan, a canal: Panama";
        System.out.println("Testing: \"" + str + "\"");
        System.out.println("Full version: " + String_Palindrome(str));
    }
}