package me.rybka.dmytro.service;

/**
 * Service for operations with vesselArray.
 *
 */
public interface CommunicatingVesselsService {

    /**
     * Calculates capacity of volume represented by water vesselArray.
     *
     * @param vesselArray describes profile of a surface.
     * @return capacity of possible water volume stored
     */
    int calculateCapacity(int[] vesselArray);
}
