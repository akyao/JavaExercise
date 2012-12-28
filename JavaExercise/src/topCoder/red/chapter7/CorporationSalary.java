package topCoder.red.chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorporationSalary {

    public long totalSalary(String[] relations) {
        Calc calc = new Calc(relations);
        long result = 0;
        for (int i = 0; i < relations.length; i++) {
            result += calc.getSalary(i);
        }
        return result;
    }

    class Calc {

        private String[] relations;

        private Map<Integer, Integer> memory = new HashMap<Integer, Integer>();

        Calc(String[] relations) {
            this.relations = relations;
        }

        int getSalary(int empNum) {
            if (memory.containsKey(empNum)) {
                return memory.get(empNum);
            }

            int salary = 0;
            // �����̋����̑��a���擾
            for (Integer subEmpNum : getSubList(empNum)) {
                salary += getSalary(subEmpNum);
            }
            // ���������Ȃ����1
            if (salary == 0) {
                salary = 1;
            }
            // �������ɃZ�b�g
            memory.put(empNum, salary);

            return salary;
        }

        // �����̈ꗗ���擾���܂��B
        List<Integer> getSubList(int empNum) {
            List<Integer> subList = new ArrayList<Integer>();
            String relation = relations[empNum];
            for (int i = 0; i < relation.length(); i++) {
                if ("Y".equals(String.valueOf(relation.charAt(i)))) {
                    subList.add(i);
                }
            }
            return subList;
        }
    }

}