package alert;

import java.util.HashMap;
import java.util.Map;

public class TwoSum
{



        public static Map<Integer, Integer> findTwoSum(int[] list, int sum) {
            if (list == null || list.length < 2) return null;
            Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
            Map<Integer, Integer> arrayResult = new HashMap<Integer, Integer>();
            for (int i = 0; i < list.length; i++) {
                indexMap.put(list[i], i);
            }

            for (int i = 0; i < list.length; i++) {
                int needed = sum - list[i];
                if (indexMap.get(needed) != null) {
                    arrayResult.put(i, indexMap.get(needed));
                }
            }
            return arrayResult.isEmpty()?null:arrayResult;
        }

        public static void main(String[] args) {
            Map<Integer, Integer> indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
            System.out.println("indices are"+indices);
        }

    }

