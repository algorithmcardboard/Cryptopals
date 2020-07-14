package in.anirudhan.cryptopals.set1;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class FixedXOR {
    public static void main(String[] args) throws DecoderException {
        String inHexStr = "1c0111001f010100061a024b53535009181c";
        String toXORStr = "686974207468652062756c6c277320657965";

        byte[] bytes = Hex.decodeHex(inHexStr);
        byte[] bytes1 = Hex.decodeHex(toXORStr);

        byte[] result = new byte[bytes.length];

        for(int i = 0; i < bytes.length; i++){
            result[i] = (byte) (bytes[i] ^ bytes1[i]);
        }

        System.out.println(Hex.encodeHexString(result));

        assert Hex.encodeHexString(result).equals("746865206b696420646f6e277420706c6179");
    }
}
