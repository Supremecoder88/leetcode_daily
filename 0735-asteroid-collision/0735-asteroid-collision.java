import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean alive = true;

            // Collision can happen only: + then -
            while (alive && asteroid < 0 && !stack.isEmpty()
                    && stack.peek() > 0) {

                int top = stack.peek();

                if (top < -asteroid) {
                    // Top asteroid explodes
                    stack.pop();
                }
                else if (top == -asteroid) {
                    // Both explode
                    stack.pop();
                    alive = false;
                }
                else {
                    // Current asteroid explodes
                    alive = false;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}