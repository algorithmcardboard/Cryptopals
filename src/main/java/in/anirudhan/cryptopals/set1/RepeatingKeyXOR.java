package in.anirudhan.cryptopals.set1;

import org.apache.commons.codec.binary.Hex;

public class RepeatingKeyXOR {
    public static void main(String[] args){
        String inputString = "Burning 'em, if you ain't quick and nimble\n" +
                "I go crazy when I hear a cymbal";

        String output = "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272" +
                "a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f";

        String key = "ICE";

        String encrypted = encrypt(inputString, key);

        if(encrypted.length() != output.length()){
            System.out.println("Lengths dont match "+encrypted.length() + " "+ output.length());
        }
        for(int i =0; i < encrypted.length(); i++){
            if(encrypted.charAt(i) == output.charAt(i)){continue;}else{System.out.println("Not equal");break;}
        }
        System.out.println(encrypted);
        System.out.println("All good");
    }

    private static String encrypt(String inputString, String key) {
        byte[] inBytes = inputString.getBytes();
        for(int i=0; i < inBytes.length; i++){
            inBytes[i] = (byte) (inBytes[i] ^ key.charAt(i%key.length()));
        }
        return String.valueOf(Hex.encodeHex(inBytes));
    }

}
