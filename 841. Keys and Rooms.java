class Solution {

    public static void dfs(List<List<Integer>> rooms, boolean flag[], int index) {
        if(flag[index])
            return;
        flag[index] = true;
        for(int key : rooms.get(index))
            dfs(rooms, flag, key);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean flag[] = new boolean[n];
        /*
         * Approach 1: Below is the recursive approach
         */
        dfs(rooms, flag, 0);

        for (int i = 0; i < n; i++)
            if (!flag[i])
                return false;
        return true;

        /*
         * Approach 2: Below is the iterative approach.
         */

        // flag[0] = true;
        // Queue<Integer> q = new LinkedList<>();
        // // To get the keys from the first room
        // for (int key : rooms.get(0))
        // q.add(key);

        // // keep checking the rooms till they keys in the queue finish.
        // while (!q.isEmpty()) {
        // // Poll key from queue and check if we have visited that room or not
        // int currKey = q.poll();
        // if (!flag[currKey]) {
        // flag[currKey] = true;
        // // If yes, then enter the room and get new keys from inside the new room
        // for (int keys : rooms.get(currKey))
        // q.add(keys);
        // }
        // }
        // // If any room is not visited, meaning flag is false, then return false
        // for (int i = 0; i < n; i++)
        // if (!flag[i])
        // return false;
        // return true;
    }
}
