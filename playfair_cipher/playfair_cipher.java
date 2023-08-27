/This code give false output, im actually working to build using different approach than this

public class PlayfairCipher {

    private static final String KEYWORD = "KEYWORD";
    private static final String ALPHABET = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

    private static char[][] generateKeyMatrix(String keyword) {
        keyword = keyword.toUpperCase();
        keyword = removeDuplicates(keyword);
        
        String key = keyword + ALPHABET;
        key = removeDuplicates(key);

        char[][] keyMatrix = new char[5][5];
        int index = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyMatrix[i][j] = key.charAt(index);
                index++;
            }
        }
        System.out.println("KeyMatrix:"+keyMatrix);
        return keyMatrix;
    }

    private static String removeDuplicates(String input) {
        StringBuilder output = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (output.indexOf(String.valueOf(c)) == -1) {
                output.append(c);
            }
        }
        return output.toString();
    }

    private static String formatPlaintext(String plaintext) {
        plaintext = plaintext.replaceAll("[J]", "I");
        plaintext = plaintext.replaceAll(" ", "").toUpperCase();
        StringBuilder formatted = new StringBuilder(plaintext);

        // for (int i = 0; i < formatted.length() - 1; i += 2) {
        //     if (formatted.charAt(i) == formatted.charAt(i + 1)) {
        //         formatted.insert(i + 1, 'X');
        //     }
        // }

        if (formatted.length() % 2 != 0) {
            formatted.append('X');
        }

        return formatted.toString();
    }

    private static String encrypt(String plaintext, char[][] keyMatrix) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2) {
            char first = plaintext.charAt(i);
            char second = plaintext.charAt(i + 1);
            int[] posFirst = findPosition(first, keyMatrix);
            int[] posSecond = findPosition(second, keyMatrix);

            /*
            If the two characters are in the same row of the key matrix:
                Replace each character with the character immediately to its right (circular wraparound if necessary).
            
            If the two characters are in the same column of the key matrix:
                Replace each character with the character immediately below it (circular wraparound if necessary).
            
            If the two characters are in different rows and different columns:
                Replace the first character with the character in the same row but the column of the second character.
                Replace the second character with the character in the same row but the column of the first character.
            */

            if (posFirst[0] == posSecond[0]) {
                ciphertext.append(keyMatrix[posFirst[0]][(posFirst[1] + 1) % 5]);
                ciphertext.append(keyMatrix[posSecond[0]][(posSecond[1] + 1) % 5]);
            } else if (posFirst[1] == posSecond[1]) {
                ciphertext.append(keyMatrix[(posFirst[0] + 1) % 5][posFirst[1]]);
                ciphertext.append(keyMatrix[(posSecond[0] + 1) % 5][posSecond[1]]);
            } else {
                ciphertext.append(keyMatrix[posFirst[0]][posSecond[1]]);
                ciphertext.append(keyMatrix[posSecond[0]][posFirst[1]]);
            }
        }

        return ciphertext.toString();
    }

    private static int[] findPosition(char c, char[][] keyMatrix) {
        int[] pos = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyMatrix[i][j] == c) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        String plaintext = "HELLO";
        char[][] keyMatrix = generateKeyMatrix(KEYWORD);
        String formattedPlaintext = formatPlaintext(plaintext);
        String ciphertext = encrypt(formattedPlaintext, keyMatrix);
        System.out.println("Key Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(keyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Plaintext: " + plaintext);
        System.out.println("Ciphertext: " + ciphertext);
    }
}

