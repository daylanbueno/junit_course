package io.github.dailan.UnitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SomeBusinessImplTest {

    @Test
    public void calculateSum_should_be_return_6() {
      SomeBusinessImpl business = new SomeBusinessImpl();
      int actualResult = business.calculateSum(new int [] {1, 2, 3});
      int expectResult = 6;
        Assertions.assertEquals(actualResult, expectResult);
    }

    @Test
    public void calculateSum_should_be_return_0() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int [] {0});
        int expectResult = 0;
        Assertions.assertEquals(actualResult, expectResult);
    }

    @Test
    public void calculateSum_should_be_return_4() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int [] {1,1,2});
        int expectResult = 4;
        Assertions.assertEquals(actualResult, expectResult);
    }

    @Test
    public void calculateSum_using_data_service_shuold_be_return_3() {
        SomeBusinessImpl business = new SomeBusinessImpl(new SomeBusinessDataServiceStub(new int [] {1,2}));
        int actualResult = business.calculateSumUsingServiceDate();
        int expectResult = 3;
        Assertions.assertEquals(actualResult, expectResult);
    }

    @Test
    public void calculateSum_using_data_service_shuold_be_return_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl(new SomeBusinessDataServiceStub());
        int actualResult = business.calculateSumUsingServiceDate();
        int expectResult = 0;
        Assertions.assertEquals(actualResult, expectResult);
    }

    @Test
    public void calculateSum_using_data_service_shuold_be_return_10() {
        SomeBusinessImpl business = new SomeBusinessImpl(new SomeBusinessDataServiceStub(new int[] {1,1,3,5}));
        int actualResult = business.calculateSumUsingServiceDate();
        int expectResult = 10;
        Assertions.assertEquals(actualResult, expectResult);
    }
}

class SomeBusinessDataServiceStub  implements SomeDataService{

    private int arr[] = {};

    public SomeBusinessDataServiceStub() {
    }
    public SomeBusinessDataServiceStub(int[] arr) {
        this.arr = arr;
    }
    @Override
    public int[] retrieveAllData() {
        return arr;
    }
}
