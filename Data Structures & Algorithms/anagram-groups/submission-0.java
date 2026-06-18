class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        Map<String, List<String>> hm = new HashMap<>();
        for(String str : strs){
            int[] arr = new int[26];
            for(char ch : str.toCharArray()){
                arr[ch-'a']++; 
            }
            String key = Arrays.toString(arr);
            if(hm.containsKey(key) == false){
                hm.put(key, new ArrayList());
            }
            hm.get(key).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for(String key : hm.keySet()){
            result.add(hm.get(key));
        } 
        return result;
    }
}
