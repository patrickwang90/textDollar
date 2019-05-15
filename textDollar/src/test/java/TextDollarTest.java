import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TextDollarTest {
  private TextDollar textDollar;

  @Before
  public void setUp() {
    textDollar = new TextDollar();
  }

  @Test
  public void exampleTest1_HappyPath() throws Exception {
    Assert.assertEquals(textDollar.convertNumberToWord(3), "ThreeDollars");
  }

  @Test
  public void exampleTest2_HappyPath() throws Exception {
    Assert.assertEquals(textDollar.convertNumberToWord(466), "FourHundredSixtySixDollars");
  }

  @Test
  public void exampleTest3_HappyPath() throws Exception {
    Assert.assertEquals(textDollar.convertNumberToWord(1234), "OneThousandTwoHundredThirtyFourDollars");
  }

  @Test
  public void exampleTest4_HappyPath() throws Exception {
    Assert.assertEquals(textDollar.convertNumberToWord(10), "TenDollars");
  }

  @Test
  public void exampleTest5_HappyPath() throws Exception {
    Assert.assertEquals(textDollar.convertNumberToWord(21), "TwentyOneDollars");
  }

  @Test(expected = Exception.class)
  public void myTest_throwsExceptionInvalidInputNegativeValue() throws Exception {
    textDollar.convertNumberToWord(-1);
  }

  @Test(expected = Exception.class)
  public void myTest_throwsExceptionInvalidInputMaxValue() throws Exception {
    textDollar.convertNumberToWord(1000000000);
  }
}
