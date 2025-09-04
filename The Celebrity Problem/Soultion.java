class Solution {
    public int celebrity(int mat[][]) {
        // code here
         int n = mat.length;
        int a = 0, b = n - 1;

        // Step 1 & 2: Eliminate non-celebrities
        while (a < b) {
            if (mat[a][b] == 1) {
                // a knows b, so a cannot be celebrity
                a++;
            } else {
                // a does not know b, so b cannot be celebrity
                b--;
            }
        }

        int candidate = a;

        // Step 3: Validate candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }
        return candidate;
        
    }
}
