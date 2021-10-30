package io.github.dailan.UnitTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockListTest {

    @Mock
    List<String> mockLIst;

    @Test
    public void basic_Test_List() {
        when(mockLIst.get(0)).thenReturn("UnitTest");
        assertEquals("UnitTest",mockLIst.get(0) );
    }

    @Test
    public void should_be_return_5() {
        when(mockLIst.size()).thenReturn(5);
        assertEquals(5,mockLIst.size());
    }

    @Test
    public void should_be_return_ok_when_any_parameter() {
        when(mockLIst.get(anyInt())).thenReturn("ok");
        assertEquals("ok",mockLIst.get(10));
        assertEquals("ok",mockLIst.get(11));
    }

    @Test
    public void should_be_when_diferent_values() {
        when(mockLIst.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mockLIst.size());
        assertEquals(10, mockLIst.size());
    }

    @Test
    public  void should_be_verify_call_mathod() {
        String value = mockLIst.get(0);
        String value2 = mockLIst.get(0);
        verify(mockLIst, times(2)).get(0);
    }

    @Test
    public  void should_be_verify_call_mathod_parameter_any() {
        String value = mockLIst.get(0);
        String value2 = mockLIst.get(anyInt());
        verify(mockLIst, times(2)).get(0);
        verify(mockLIst, times(0)).get(10);
        verify(mockLIst, never()).get(22);
    }

    @Test
    public void should_be_argument_capturing() {
        mockLIst.add("App");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockLIst).add(captor.capture());

        assertEquals("App", captor.getValue());
    }


    @Test
    public void should_be_multiple_argument_capturing() {
        mockLIst.add("App1");
        mockLIst.add("App2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockLIst, times(2)).add(captor.capture());

        assertEquals("App1", captor.getAllValues().get(0));
        assertEquals("App2", captor.getAllValues().get(1));
    }
}
