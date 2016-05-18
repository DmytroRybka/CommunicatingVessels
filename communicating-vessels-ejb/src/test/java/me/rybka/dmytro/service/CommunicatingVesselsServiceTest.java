package me.rybka.dmytro.service;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

/**
 * Capacity Service test.
 */
public class CommunicatingVesselsServiceTest {

    public CommunicatingVesselsService communicatingVesselsService;

    @BeforeMethod
    public void initialize() throws Exception {
        communicatingVesselsService = new CommunicatingVesselsServiceImpl();
    }

    @DataProvider(name = "data")
    public static Object[][] primeNumbers() {
        return new Object[][]{
                {new int[]{1, 1, 3, 3, 7, 5, 7, 4, 1, 3, 2, 1}, 4},
                {new int[]{1, 1, 3, 3, 7, 5, 7, 4, 1, 3, 2, 8}, 20},
                {new int[]{4, 1, 3, 3, 7, 5, 2, 4, 1, 3, 2, 5}, 18}
        };
    }

    /**
     * Checks possible combinations of expected volumes.
     *
     * @param vesselArray array to check
     * @param capacity    expected capacity
     * @throws Exception
     */
    @org.testng.annotations.Test(dataProvider = "data")
    public void testCalculateCapacity(int[] vesselArray, int capacity) throws Exception {
        Assert.assertTrue(communicatingVesselsService.calculateCapacity(vesselArray) == capacity, "Expected volume doesn't match");
    }
}