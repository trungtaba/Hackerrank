import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int extraChars = 0;
        boolean digitOccured = false;
        boolean lowerCaseOccured = false;
        boolean upperCaseOccured = false;
        boolean specialCharsOccured = false;
        int desiredLength = 0;

        for(char c: password.toCharArray() ){
            if (c >= 48 && c <= 57)
                digitOccured = true;

            if (c >= 97 && c <= 122)
                lowerCaseOccured = true;

            if (c >= 65 && c <= 90)
                upperCaseOccured = true;


            if (c == 33
               || c == 64
               || c == 94
               || c == 45
               ) //!@^-
                specialCharsOccured = true;

            if (c >= 35 && c <= 38) //#$%&
                specialCharsOccured = true;


            if (c >= 40 && c <= 43) //()*+
                specialCharsOccured = true;

            desiredLength++;
            if (digitOccured && lowerCaseOccured && upperCaseOccured && specialCharsOccured && desiredLength >= 6)
                break;

        }

        if (!digitOccured)
            extraChars++;

        if (!lowerCaseOccured)
            extraChars++;

        if (!upperCaseOccured)
            extraChars++;

        if (!specialCharsOccured)
            extraChars++;

        if (desiredLength + extraChars < 6)
            extraChars += 6 - extraChars - desiredLength;
        
        System.out.print(extraChars);
    
        scanner.close();
    }
}
