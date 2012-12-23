package topCoder.red.chapter5;

public class ThePalindrome {

    public int find(String s) {

        // すでに回文
        if (isPalindrome(s)) {
            return s.length();
        }

        // 引数を逆にした文字列
        String upsideDown = getPalindrome(s);

        // 元の文字から、逆文字を少しずつサイズを変えながら連結させていき、チェック
        for (int i = s.length() - 1; i > 0; i--) {
            String temp = s + upsideDown.substring(i, s.length());
            if (isPalindrome(temp)) {
                return temp.length();
            }
        }
        return -1;
    }

    protected boolean isPalindrome(String s) {
        return s.equals(getPalindrome(s));
    }

    protected String getPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            sb.append(s.charAt(length - i));
        }

        return sb.toString();
    }
}