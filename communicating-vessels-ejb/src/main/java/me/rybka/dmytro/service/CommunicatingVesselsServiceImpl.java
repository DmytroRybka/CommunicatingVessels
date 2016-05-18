package me.rybka.dmytro.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Stack;
import java.util.logging.Logger;

@Stateless
/**
 * Main service responsible for calculating capacity of water inside array.
 * Implements {@link CommunicatingVesselsService }
 */
public class CommunicatingVesselsServiceImpl implements CommunicatingVesselsService {

    @Override
    public int calculateCapacity(int[] vesselArray) {
        int i = 0;
        int capacity = 0;
        int borderMax;
        int borderLast = Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack<Integer>();

        borderMax = vesselArray[0];
        stack.push(borderMax);

        while (i <= vesselArray.length - 1) {
//            first element is greater than next element
            if (borderMax >= vesselArray[i]) {
//                store in stack
                stack.push(vesselArray[i]);
//                jump to the next element
                i++;
            } else {
                capacity = calculateNextVessel(capacity, borderMax, stack);
                stack.clear();
//                change left border
                borderMax = vesselArray[i];
                stack.push(vesselArray[i]);
//                jump to the next element
                i++;
            }
        }
        capacity = calculateLastVessel(capacity, borderLast, stack);
        return capacity;
    }

    /**
     * Calculates last vessel (starting from the end).
     *
     * @param capacity current capacity
     * @param last     the last right border
     * @param stack    the vessel
     * @return calculated capacity
     */
    private int calculateLastVessel(int capacity, int last, Stack<Integer> stack) {
        int lastElement = last;
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (temp >= lastElement)
                lastElement = temp;
            else {
                capacity = capacity + lastElement - temp;
            }
        }
        return capacity;
    }

    /**
     * Calculate a bucket.
     *
     * @param capacity current capacity
     * @param max      the left bucket border
     * @param stack    the vessel
     * @return calculated capacity
     */
    private int calculateNextVessel(int capacity, int max, Stack<Integer> stack) {
        int resultedCapacity = capacity;
        while (!stack.isEmpty()) {
            resultedCapacity = resultedCapacity + max - stack.pop();
        }
        return resultedCapacity;
    }

}
