package akyao.exercise.q201005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 文字列分割をおこなうクラス
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

    // 問題文中のCharMatcherとJoinerは標準クラスのものではないため、対応しません。

    public static Splitter on(String delimiter) {
        return new Splitter(new StringSpｌitterLogic(delimiter));
    }

    public static Splitter on(char delimiter) {
        return on(Character.toString(delimiter));
    }

    public static Splitter on(int delimitLength) {
        return new Splitter(new FixLengthSpｌitterLogic(delimitLength));
    }

    public static Splitter on(Pattern regex) {
        return new Splitter(new StringSpｌitterLogic(regex.toString()));
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
 * 文字列分割処理クラス
 */
abstract class SplitterLogic {
    protected abstract List<String> split(String str);
}

/**
 * 文字列分割処理クラス（デリミター文字列を元に分割）
 */
class StringSpｌitterLogic extends SplitterLogic {

    private String delimiter;

    StringSpｌitterLogic(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    protected List<String> split(String str) {
        return Arrays.asList(str.split(this.delimiter));
    }
}

/**
 * 文字列分割処理クラス（指定された長さで分割）
 * 
 */
class FixLengthSpｌitterLogic extends SplitterLogic {

    private int length;

    FixLengthSpｌitterLogic(int length) {
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