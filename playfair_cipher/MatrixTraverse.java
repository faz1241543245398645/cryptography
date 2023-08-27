public class MatrixTraverse{

    public static main void(String[] args){

        private static final String KEYWORD = "KEYWORD";
        private static final String ALPHABET = "ABCDEFGHIKLMNOPQRSTUVWXYZ";//J in not here

    
        keyword = keyword.toUpperCase();//
        //keyword = removeDuplicates(keyword);//
        
        String key = keyword + ALPHABET;//
        //key = removeDuplicates(key);//

        char[][] keyMatrix = new char[5][5];//
        int index = 0;//

        for (int i = 0; i < 5; i++) {//
            for (int j = 0; j < 5; j++) {//
                
                System.out.println(key.charAt(index)+" "+index);
                
                keyMatrix[i][j] = key.charAt(index);//
                
                index++;//
            }
        }

        for (int i = 0; i < plaintext.length(); i += 2) {
            char first = plaintext.charAt(i);
            char second = plaintext.charAt(i + 1);
            int[] posFirst = findPosition(first, keyMatrix);
            int[] posSecond = findPosition(second, keyMatrix);

        //
        System.out.println(keyMatrix[posFirst[0]][(posFirst[1] + 1) % 5]);
        System.out.println(keyMatrix[posSecond[0]][(posSecond[1] + 1) % 5]);
        //
        System.out.println(keyMatrix[(posFirst[0] + 1) % 5][posFirst[1]]);
        System.out.println(keyMatrix[(posSecond[0] + 1) % 5][posSecond[1]]);
        //
        System.out.println(keyMatrix[posFirst[0]][posSecond[1]]);
        System.out.println(keyMatrix[posSecond[0]][posFirst[1]]);
        //
    }
}