package io.github.dailan.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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


}
