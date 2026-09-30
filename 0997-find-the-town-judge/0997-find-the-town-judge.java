class Solution {

    public int findJudge(int n, int[][] trust) {

        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for (int[] pair : trust) {

            int a = pair[0];
            int b = pair[1];

            outdegree[a]++;
            indegree[b]++;
        }

        for (int person = 1; person <= n; person++) {

            if (indegree[person] == n - 1 &&
                outdegree[person] == 0) {

                return person;
            }
        }

        return -1;
    }
}