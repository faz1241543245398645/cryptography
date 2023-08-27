import java.util.Scanner;

public class VigenereCipher{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a plain text: ");
        String plaintext = input.nextLine().toUpperCase(); //can also do tolowercase
        System.out.print("Enter a keyword: ");
        String keyword = input.next().toUpperCase();
        String ctext = "";

        //note that you cant uppercase a character, but string will work
        String key = createKey(keyword, plaintext.length());
        
        //System.out.println(key); it will always match the length of plaintext
        

        //take a character from plaintext from keyw one by one and transmit for encryption 
        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char keyChar = key.charAt(i);

            //assign temporarily unless the character is noncharacter
            char encryptedChar = plainChar;
            
            //Prevent non-alphabet from being encrypted
            if (Character.isAlphabetic(plainChar)) {
                System.out.println(plainChar);
                encryptedChar = encryptChar(plainChar, keyChar);
            }
            ctext += encryptedChar;
        }

        System.out.println("Plaintext: " + plaintext);
        System.out.println("Keyword: " + key);
        System.out.println("Encrypted Text: " + ctext);

    }
//      String key = createKey(key, plaintext.length());
    public static String createKey(String kw, int len){
        String key = "";
        while(key.length() < len){
            key += kw;
        }
        //Notice that the key length is greated or same as length of plaintext
        //System.out.println(key);
        //Ensure the generated key length doesn't exceed the length of plaintext
        return key.substring(0,len);
    }

    public static char encryptChar(char plainChar, char keyChar) {
        int plainValue = plainChar - 'A';//as we have Uppercase it can be minus with capital A
        int keyValue = keyChar - 'A';
        int encryptedValue = (plainValue + keyValue) % 26;
        if (encryptedValue < 0) {
            encryptedValue += 26; // Ensure encryptedValue is positive
        }
        char encryptedChar = (char) (encryptedValue + 'A');
        return encryptedValue !=-1 ? encryptedChar:plainChar;
    }
}



//chatAt()
//toUppercase()
//char x = (char)(intVariable)
//key.substring()
//'B' - 'A'
//next()
//nextLine()
//Character.isAlphabetic(plainChar)
