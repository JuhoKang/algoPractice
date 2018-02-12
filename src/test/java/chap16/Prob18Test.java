package chap16;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class Prob18Test {

  Prob18 app;

  @Before
  public void init() {
    app = new Prob18();
  }

  @Test
  public void 앱테스트() {
    assertEquals(true, app.patternMatch("catcatgocatgo", "aabab"));
    assertEquals(true, app.patternMatch("catcatgocatgo", "a"));
    assertEquals(true, app.patternMatch("catcatgocatgo", "ab"));
    assertEquals(true, app.patternMatch("catcatgocatgo", "b"));
  }
  @Test
  public void main3() throws Exception {
    assertEquals(true, app.patternMatch("hahahoohahahoo", "aab"));
  }

  @Test
  public void main4() throws Exception {
    assertEquals(true, app.patternMatch("hahahoohahahahaha", "a"));
    assertEquals(true, app.patternMatch("hahahoohahahahaha", "b"));
    assertEquals(true, app.patternMatch("hahahoohahahahaha", "aabaaaaa"));        
    String ex1 = "catcatgocatgo";
    assertEquals(true, app.patternMatch(ex1, "aabab"));
    assertEquals(true, app.patternMatch(ex1, "a"));
    assertEquals(true, app.patternMatch(ex1, "ab"));
    assertEquals(true, app.patternMatch(ex1, "abb"));
    assertEquals(false, app.patternMatch(ex1, "aaa"));
    assertEquals(false, app.patternMatch(ex1, "bb"));
    assertEquals(false, app.patternMatch(ex1, "baba"));
  }

}
