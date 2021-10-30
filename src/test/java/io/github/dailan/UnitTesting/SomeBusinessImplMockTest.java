package io.github.dailan.UnitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Mock
    private SomeDataService someDataServiceMock;

    @InjectMocks
    private SomeBusinessImpl business;

    @BeforeEach
    public void beforeEach() {
        business = new SomeBusinessImpl(someDataServiceMock);
    }

    @Test
    public void calculateSum_should_be_return_6() {
      SomeBusinessImpl business = new SomeBusinessImpl();
      int actualResult = business.calculateSum(new int [] {1, 2, 3});
        Assertions.assertEquals(6, actualResult);
    }

    @Test
    public void calculateSum_should_be_return_0() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int [] {0});
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    public void calculateSum_should_be_return_4() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int [] {1,1,2});
        Assertions.assertEquals(4, actualResult);
    }

    @Test
    public void calculateSum_using_data_service_shuold_be_return_3() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int []{ 3});
        int actualResult = business.calculateSumUsingServiceDate();
        Assertions.assertEquals(3,actualResult);
    }

    @Test
    public void calculateSum_using_data_service_shuold_be_return_empty() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        int actualResult = business.calculateSumUsingServiceDate();
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    public void calculateSum_using_data_service_shuold_be_return_10() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] { 10 });
        int actualResult = business.calculateSumUsingServiceDate();
        Assertions.assertEquals(10, actualResult);
    }
}