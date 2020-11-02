import java.nio.file.*;

public class Hex {
    public static void main(String[] args) {
        String mode;
        String keyfile;
        String inpfile;
        String key;
        String inp;
        boolean debug = false;
        try {
            mode = args[0];
            keyfile = args[1];
            inpfile = args[2];
            key = Files.readString(Path.of(keyfile));
            key = key.substring(0, key.length());
            inp = Files.readString(Path.of(inpfile));
            inp = inp.substring(0, inp.length() - 1);
            if (debug) {
                System.out.println("mode:" + mode);
                System.out.println("key: " + key);
                System.out.println("inp: " + inp);
            }
            String m = compare(key, inp);
            if (mode.equals("human"))
                System.out.println(m);
            else
                System.out.println(numOut(m));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public static String compare(String key, String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++)
            sb.append((char) (message.charAt(i) ^ key.charAt(i % key.length())));
        String result = sb.toString();
        return result;
    }

    public static String numOut(String x) {
        String hex = "";
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            int in = (int) ch;
            String part = Integer.toHexString(in);
            hex += part + " ";
        }
        return hex;
    }
}