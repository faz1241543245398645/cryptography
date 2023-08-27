public class BreakPair {

    public static void main(String[] args) {
        String plaintext = "fadzwan";
        plaintext = plaintext.replaceAll(" ", "").toUpperCase();
    
        // If the length is odd, append a filler character
        if (plaintext.length() % 2 != 0) {
            plaintext += 'X';
        }

        System.out.println(plaintext);
    }
}