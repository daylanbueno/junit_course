package io.github.dailan.UnitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class SomeBusinessImplMockTest {

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
        SomeDataService someDataServiceMock = mock(SomeDataService.class);
        SomeBusinessImpl business = new SomeBusinessImpl(someDataServiceMock);
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int []{ 3});

        int actualResult = business.calculateSumUsingServiceDate();
        int expectResult = 3;
        Assertions.assertEquals(actualResult, expectResult);
    }


    @Test
    public void calculateSum_using_data_service_shuold_be_return_empty() {
        SomeDataService someDataServicemock = mock(SomeDataService.class);
        when(someDataServicemock.retrieveAllData()).thenReturn(new int[] {});
        SomeBusinessImpl business = new SomeBusinessImpl(someDataServicemock);
        int actualResult = business.calculateSumUsingServiceDate();
        int expectResult = 0;
        Assertions.assertEquals(actualResult, expectResult);
    }


    @Test
    public void calculateSum_using_data_service_shuold_be_return_10() {
        SomeDataService someDataServiceMock =  mock(SomeDataService.class);
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] { 10 });

        SomeBusinessImpl business = new SomeBusinessImpl(someDataServiceMock);
        int actualResult = business.calculateSumUsingServiceDate();

        int expectResult = 10;
        Assertions.assertEquals(actualResult, expectResult);
    }
}