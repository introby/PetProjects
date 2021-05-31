package encryptdecrypt;

public class Crypt {
    public static String crypt(String data, int key, String mode, String alg) {
        StringBuilder sb = new StringBuilder();
        int ch;
        int index;

        for (int i = 0; i < data.length(); i++) {
            ch = data.charAt(i);

            if (mode.equals("enc")) {
                if (alg.equals("shift")) {
                    switch (Character.getType(ch)){
                        case 1:
                            index = ch + key % 26 - 26 * ((ch + key % 26) / 91);
                            break;
                        case 2:
                            index = ch + key % 26 - 26 * ((ch + key % 26) / 123);
                            break;
                        default:
                            index = ch;
                            break;
                    }

                } else {
                    index = ch + key;
                }

            } else {
                if (alg.equals("shift")) {
                    switch (Character.getType(ch)){
                        case 1:
                            index = ch - key % 26 + 26 * (64 / (ch - key % 26));
                            break;
                        case 2:
                            index = ch - key % 26 + 26 * (96 / (ch - key % 26));
                            break;
                        default:
                            index = ch;
                            break;
                    }

                } else {
                    index = ch - key;
                }
            }

            sb.append((char) index);
        }

        return sb.toString();
    }

}
