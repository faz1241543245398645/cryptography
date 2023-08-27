public class KeyMatrixGenerator {

    private static final String KEYWORD = "KEYWORD";
    private static final String ALPHABET = "ABCDEFGHIKLMNOPQRSTUVWXYZ";//J in not here

    private static char[][] generateKeyMatrix(String keyword) {
        keyword = keyword.toUpperCase();//
        keyword = removeDuplicates(keyword);//
        
        String key = keyword + ALPHABET;//
        key = removeDuplicates(key);//

        char[][] keyMatrix = new char[5][5];//
        int index = 0;//

        for (int i = 0; i < 5; i++) {//
            for (int j = 0; j < 5; j++) {//
                
                System.out.println(key.charAt(index)+" "+index);
                
                keyMatrix[i][j] = key.charAt(index);//
                
                index++;//
            }
        }

        return keyMatrix;
    }

    private static String removeDuplicates(String input) {
        StringBuilder output = new StringBuilder();
        //String output = "";
        for (char c : input.toCharArray()) {
            if (output.indexOf(String.valueOf(c)) == -1) {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        char[][] keyMatrix = generateKeyMatrix(KEYWORD);

        System.out.println("Key Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(keyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}



// at one point I want to check if the matrix is 5x5 using pow(5,5)
//does it always have to reach Z?
//I and J are treated as the same letter? thats why its 25. so which one should i remove
//