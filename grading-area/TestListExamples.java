import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "d");
    List<String> right = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeEmptyLeft() {
    List<String> left = new ArrayList<>();
    List<String> right = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeEmptyRight() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = new ArrayList<>();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeBothEmpty() {
    List<String> left = new ArrayList<>();
    List<String> right = new ArrayList<>();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = new ArrayList<>();
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter() {
    List<String> filter = Arrays.asList("Moon", "M0on");
    StringChecker moonChecker = new IsMoon();
    List<String> filtered = ListExamples.filter(filter, moonChecker);
    List<String> expected = Arrays.asList("Moon");
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilterWithMultipleMoon() {
    List<String> filter = Arrays.asList("Moon", "M0on", "Moon");
    StringChecker moonChecker = new IsMoon();
    List<String> filtered = ListExamples.filter(filter, moonChecker);
    List<String> expected = Arrays.asList("Moon", "Moon");
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilterWithNoMoon() {
    List<String> filter = Arrays.asList("M0on", "M00n");
    StringChecker moonChecker = new IsMoon();
    List<String> filtered = ListExamples.filter(filter, moonChecker);
    List<String> expected = new ArrayList<>();
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilterWithEmptyList() {
    List<String> filter = new ArrayList<>();
    StringChecker moonChecker = new IsMoon();
    List<String> filtered = ListExamples.filter(filter, moonChecker);
    List<String> expected = new ArrayList<>();
    assertEquals(expected, filtered);
  }

}
