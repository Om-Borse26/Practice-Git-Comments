public class Bit_Manipulation {

    public static void decimal_binary(int n){
        if (n == 0) {
            System.out.println("0");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            if(n % 2 == 1){
                sb.append('1');
            } else {
                sb.append('0');
            }
            n = n / 2;
        }
        
        sb.reverse();
        System.out.println(sb.toString());
    }

    public static void binary_decimal(String str){

        int ans = 0;
        int pow = 0;
        for (int i = str.length()-1; i >= 0 ; i--) {
            int digit = (int)str.charAt(i) - '0';
            if(digit == 1){
                ans = ans + (int)Math.pow(2, pow);
            }
            pow++;
        }
        System.out.println(ans);
    }


    public static boolean check_set_ith_bit(int n, int k){
        // int bitmask = 1<<k;
        // if ((n & bitmask) != 0) {
        //     return true;
        // } else {
        //     return false;
        // }
        
        // or 
        int bitmask = n>>k;
        if ((1 & bitmask) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int clear_ith_bit(int n, int i){
        int bitmask = ~(1<<i);
        return n&bitmask;
    }

    public static int update_ith_bit(int n, int i){
        int bitmask = 1<<i;
        return n^bitmask;
    }

    public static int remove_lastSetBit(int n){
        return n & (n-1);
    }

    public static int count_setBits(int n){
        int count = 0;
        int i =0;
        while(n>=0){
            if((n & 1>>i) == 1){
                count++;
            }
            n = n-(int)Math.pow(2, i);
            i++;
        }
        return count;
    }



    public static void main(String[] args) {
        
        // decimal_binary(13);
        // binary_decimal("1100011");

        //operators
        // System.out.println(5&6);
        // System.out.println(5|6);
        // System.out.println(5^6);
        // System.out.println(5>>2);
        // System.out.println(5<<2);

        // if(check_set_ith_bit(13, 1)){
        //     System.out.println("1");
        // }
        // else{
        //     System.out.println("0");
        // }

        // System.out.println(clear_ith_bit(5, 2));
        // System.out.println(update_ith_bit(13, 1));

        // System.out.println(remove_lastSetBit(5));


        System.out.println(count_setBits(5));

    }
}
