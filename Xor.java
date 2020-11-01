public class Xor {
    public static String compare(String key, String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++)
            sb.append((char) (message.charAt(i) ^ key.charAt(i % key.length())));
        String result = sb.toString();
        return result;
    }

    public static String numOut(String x) {
        String hex = "";
        for (int i = 0; i < x.length(); i++){
            char ch = x.charAt(i);
            int in = (int)ch;
            String part = Integer.toHexString(in);
            hex += part + " ";
        }
        return hex;
    }

    private static String subk(String key) {
        String key1 = "A";
        String key2 = "FISH";
        String ky = "";
        if (key.equals("key1"))
            ky = key1;
        else
            ky = key2;
        return ky;
    }

    private static String subm(String message) {
        String message1 = "hello";
        String message2 = ")$--.";
        String message3 = "this is a test";
        String message4 = "f=;l5i:;f(s<#:";
        String ms = "";
        if (message.equals("message1"))
            ms = message1;
        else if (message.equals("message2"))
            ms = message2;
        else if (message.equals("message3"))
            ms = message3;
        else
            ms = message4;
        return ms;
    }

    public static void main(String[] args) {
        String mode = (args[0]);
        String key = (args[1]);
        String message = (args[2]);
        String m = compare(subk(key), subm(message));
        if (mode.equals("human"))
            System.out.println(m);
        else
            System.out.println(numOut(m));
    }
}