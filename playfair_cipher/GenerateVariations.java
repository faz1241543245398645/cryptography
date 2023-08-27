public class GenerateVariations {

    public static void generateVariations(String keyword) {

        for (char c : keyword.toCharArray()) {
            int index = keyword.indexOf(c);

             if (index >= 0) {
                for (int i = index + 1; i <= keyword.length(); i++) {
                    StringBuilder variation = new StringBuilder(keyword);
                    variation.insert(i, c);
                    System.out.println(variation);
                }
            }
        }
        
        
       
    }

    public static void main(String[] args) {
        String keyword = "FADZWAN";
        generateVariations(keyword);
    }
}

/*
variations of the same keyword with repeated letters will result in the same key matrix in the Playfair cipher. 
This is because the key matrix is constructed based on the unique letters in the keyword. When you have repeated letters, they are effectively treated as a single letter in terms of constructing the matrix.

Disadvantages of Using Keywords with Repeated Letters:

Reduced Security: Using keywords with repeated letters reduces the number of unique letters available for the key matrix. 
This could potentially make the cipher more vulnerable to attacks like frequency analysis.
Limited Key Space: The key space, which is the number of possible keys the cipher can have, is reduced when using keywords with repeated letters. 
This makes the cipher easier to crack through brute-force methods.
*/