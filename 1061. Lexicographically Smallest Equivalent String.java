class Solution {
int[] parent = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        for(int i = 0; i < 26; i++){
            parent[i] = i;
        }

        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();

        int len = s1.length();

        for(int i = 0; i < len; i++){
            union(s1c[i] - 'a', s2c[i] - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            int index = find(baseStr.charAt(i) - 'a');
            sb.append((char) (index + 'a'));
        }

        return sb.toString();
    }

    private void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            if(pa <= pb) parent[pb] = pa;
            else parent[pa] = pb;
        }
    }

    private int find(int num){
        while(num != parent[num]){
            num = parent[num];
        }
        return num;
    }
}
