package topCoder.red.chapter7;

/**
 * ������ 2004TCCC Online Round4 Div1 Level1
 * @author akyao
 *
 */
public class BadNeighbors {

    public int maxDonations(int[] donations) {

        // �{���R�s����
        int ans = 0;
        int[] dp = new int[donations.length];

        for (int i = 0; i < donations.length - 1; i++) {
            dp[i] = donations[i];
            if (i > 0) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            if (i > 1) {
                dp[i] = Math.max(dp[i], dp[i - 2] + donations[i]);
            }
            ans = Math.max(ans, dp[i]);
        }

        for (int i = 0; i < donations.length - 1; i++) {
            dp[i] = donations[i + 1];
            if (i > 0) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            if (i > 1) {
                dp[i] = Math.max(dp[i], dp[i - 2] + donations[i + 1]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;

        // 0�X�^�[�g����2�X�^�[�g�܂�(donations�̐��ɂ����)

        // �ȉ��Ń������ق�
        // donations�̐��������[�v
        // �O��`�F�b�N�����Ƃ��납��2�ڂ���邩3�ڂ���邩����
        // �X�^�[�g�n�_�ƁA���ݍŌ�ɂƂ��Ă���Ƃ���̃C���f�b�N�X���L�[�Ɍ��݂܂ł̕�����z��ۑ�����

        // �������łɕۑ�����Ă������������z���傫���ق�������

        // �ŏI�C���f�b�N�X��i�̂�����o���Ă��

        // n-1��0�𒍈�
        // return 0;
    }

}
