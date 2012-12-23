package topCoder.red.chapter5;

public class ThePalindrome {

    public int find(String s) {

        // ���łɉ�
        if (isPalindrome(s)) {
            return s.length();
        }

        // �������t�ɂ���������
        String upsideDown = getPalindrome(s);

        // ���̕�������A�t�������������T�C�Y��ς��Ȃ���A�������Ă����A�`�F�b�N
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