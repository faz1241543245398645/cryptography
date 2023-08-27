class ShiftCipher:
    MOD = 26

    @staticmethod
    def encrypt(plaintext, key):
        encrypted_text = ""
        for ch in plaintext:
            if ch.isalpha():
                base = ord('a') if ch.islower() else ord('A')
                x = ord(ch) - base
                y = (x + key) % ShiftCipher.MOD
                encrypted_text += chr(base + y)
            else:
                encrypted_text += ch  # Non-alphabetic characters are unchanged
        return encrypted_text

    @staticmethod
    def decrypt(ciphertext, key):
        decrypted_text = ""
        for ch in ciphertext:
            if ch.isalpha():
                base = ord('a') if ch.islower() else ord('A')
                y = (ord(ch) - base + ShiftCipher.MOD - key) % ShiftCipher.MOD
                decrypted_text += chr(base + y)
            else:
                decrypted_text += ch  # Non-alphabetic characters are unchanged
        return decrypted_text

if __name__ == "__main__":
    plaintext = "Hello, my name is "
    key = 3

    # Encryption
    encrypted_text = ShiftCipher.encrypt(plaintext, key)
    print("Encrypted:", encrypted_text)

    # Decryption
    decrypted_text = ShiftCipher.decrypt(encrypted_text, key)
    print("Decrypted:", decrypted_text)
