class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> symbolMap = new LinkedHashMap<>();
        symbolMap.put(1000, "M");
        symbolMap.put(900, "CM");
        symbolMap.put(500, "D");
        symbolMap.put(400, "CD");
        symbolMap.put(100, "C");
        symbolMap.put(90, "XC");
        symbolMap.put(50, "L");
        symbolMap.put(40, "XL");
        symbolMap.put(10, "X");
        symbolMap.put(9, "IX");
        symbolMap.put(5, "V");
        symbolMap.put(4, "IV");
        symbolMap.put(1, "I");

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer,String> entry: symbolMap.entrySet()) {
            count = num / entry.getKey();
            while(count != 0) {
                sb.append(entry.getValue());
                count--;
            }
            num = num % entry.getKey();
        }
        return sb.toString();
    }
}