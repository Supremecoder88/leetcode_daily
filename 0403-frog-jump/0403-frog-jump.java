class Solution {

    public boolean canCross(int[] stones) {

        HashMap<Integer, HashSet<Integer>> map =
                new HashMap<>();

        // Create an entry for every stone
        for(int stone : stones){
            map.put(stone, new HashSet<>());
        }

        // Start at stone 0 with jump 0
        map.get(0).add(0);

        // Process every stone
        for(int stone : stones){

            // Every jump that reaches this stone
            for(int jump : map.get(stone)){

                // Next possible jumps
                for(int next = jump - 1;
                    next <= jump + 1;
                    next++){

                    if(next <= 0)
                        continue;

                    int nextStone =
                            stone + next;

                    if(map.containsKey(nextStone)){

                        map.get(nextStone)
                           .add(next);
                    }
                }
            }
        }

        return !map.get(
            stones[stones.length-1]
        ).isEmpty();
    }
}