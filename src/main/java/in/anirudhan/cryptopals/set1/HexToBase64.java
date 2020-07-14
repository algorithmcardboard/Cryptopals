package in.anirudhan.cryptopals.set1;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class HexToBase64 {
    public static void main(String[] args){
        String hexStr = args[0];
        try {
            byte[] bytes = Hex.decodeHex(hexStr);
            System.out.println(Base64.encodeBase64String(bytes));

        } catch (DecoderException e) {
            e.printStackTrace();
        }
    }
}
