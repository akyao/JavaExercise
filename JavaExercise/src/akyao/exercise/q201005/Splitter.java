package akyao.exercise.q201005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * �����񕪊��������Ȃ��N���X
 * 
 * @author akio.konuma
 */
public final class Splitter extends Object {

    private boolean isTrimResults = false;

    private boolean isOmitEmptyStrings = false;

    private SplitterLogic logic;

    private Splitter(SplitterLogic logic, boolean isTrimResults,
            boolean isOmitEmptyStrings) {
        this.logic = logic;
        this.isTrimResults = isTrimResults;
        this.isOmitEmptyStrings = isOmitEmptyStrings;
    }

    private Splitter(SplitterLogic logic) {
        this(logic, false, false);
    }

    // ��蕶����CharMatcher��Joiner�͕W���N���X�̂��̂ł͂Ȃ����߁A�Ή����܂���B

    public static Splitter on(String delimiter) {
        return new Splitter(new StringSp��itterLogic(delimiter));
    }

    public static Splitter on(char delimiter) {
        return on(Character.toString(delimiter));
    }

    public static Splitter on(int delimitLength) {
        return new Splitter(new FixLengthSp��itterLogic(delimitLength));
    }

    public static Splitter on(Pattern regex) {
        return new Splitter(new StringSp��itterLogic(regex.toString()));
    }

    public List<String> split(CharSequence charseq) {
        if (charseq == null)
            return new ArrayList<String>();
        List<String> results = logic.split(charseq.toString());
        if (isOmitEmptyStrings || isTrimResults)
            results = format(results);
        return results;
    }

    public Splitter trimResults() {
        return new Splitter(this.logic, true, this.isOmitEmptyStrings);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.logic, this.isTrimResults, true);
    }

    private List<String> format(List<String> list) {
        List<String> result = new ArrayList<String>();
        for (String str : list) {
            if (isTrimResults)
                str = str.trim();
            if (!isOmitEmptyStrings || (str != null && !str.isEmpty()))
                result.add(str);
        }
        return result;
    }
}

/**
 * �����񕪊������N���X
 */
abstract class SplitterLogic {
    protected abstract List<String> split(String str);
}

/**
 * �����񕪊������N���X�i�f���~�^�[����������ɕ����j
 */
class StringSp��itterLogic extends SplitterLogic {

    private String delimiter;

    StringSp��itterLogic(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    protected List<String> split(String str) {
        return Arrays.asList(str.split(this.delimiter));
    }
}

/**
 * �����񕪊������N���X�i�w�肳�ꂽ�����ŕ����j
 * 
 */
class FixLengthSp��itterLogic extends SplitterLogic {

    private int length;

    FixLengthSp��itterLogic(int length) {
        this.length = length;
    }

    @Override
    protected List<String> split(String str) {
        List<String> result = new ArrayList<String>();
        for (int from = 0; from < str.length(); from = from + length) {
            int to = Math.min(from + this.length, str.length());
            result.add(str.substring(from, to));
        }
        return result;
    }
}