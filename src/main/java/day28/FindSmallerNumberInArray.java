package day28;

import java.util.Arrays;

public class FindSmallerNumberInArray {

    public static void main(String[] args) {

        //removing dollar sign

        String price="$200.98";
        String price1=price.replace("$","");  // remove the dollor sign
        System.out.println(Double.parseDouble(price1)); //converted to number

        //find smallest number in array

        int a[]= {500,400,100,200,700};

        Arrays.sort(a);

        for (int v:a) { //sort array
            System.out.println(v);
        }

        System.out.println("smallest number:"+a[0]);

        System.out.println("$"+a[0]);

    }
}
