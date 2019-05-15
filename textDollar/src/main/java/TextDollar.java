import java.util.ArrayList;
import java.util.List;

public class TextDollar {
  private static String POST_PENDING_STRING = "Dollars";
  private static int MAX_VALUE = 1000000000;
  private List<Integer> specialCases;
  private boolean isTeen = false;

  public TextDollar() {
    specialCases = new ArrayList<Integer>();
    specialCases.add(2);
    specialCases.add(5);
    specialCases.add(8);
  }

  public String convertNumberToWord(Integer input) throws Exception {
    if (input < 0 || input >= MAX_VALUE) {
      throw new Exception("Invalid Input.");
    }

    StringBuilder sb = new StringBuilder();
    int tempTeenArrayCounter = 0;
    char[] tempTeenArray = new char[2];
    char[] splitInputAsCharArray = input.toString().toCharArray();
    int currentDigitPlace = splitInputAsCharArray.length;

    for (char value : splitInputAsCharArray) {
      String returnValue = "";
      if (!this.isTeen) {
        returnValue = this.handleSingleDigitConversion(value, currentDigitPlace);
      }

      if (returnValue.equals("") || this.isTeen) {
        tempTeenArray[tempTeenArrayCounter++] = value;
        if (tempTeenArrayCounter == 2) {
          returnValue = this.handleTeenConversion(tempTeenArray);
          sb.append(returnValue);
          this.isTeen = false;
        }
      } else {
        sb.append(returnValue);
        this.isTeen = false;
      }

      currentDigitPlace--;
    }

    sb.append(POST_PENDING_STRING);
    return sb.toString();
  }

  private String handleSingleDigitConversion(char singleDigit, Integer currentDigitPlace) {
    StringBuilder retVal = new StringBuilder();
    int convertedSingleDigitValue = Integer.parseInt(Character.toString(singleDigit));

    switch (convertedSingleDigitValue) {
      case 1:
        if (!this.specialCases.contains(currentDigitPlace)) {
          retVal.append("One");
        } else {
          this.isTeen = true;
          return "";
        }
        break;
      case 2:
        if (!this.specialCases.contains(currentDigitPlace)) {
          retVal.append("Two");
        } else {
          retVal.append("Twenty");
        }
        break;
      case 3:
        if (!this.specialCases.contains(currentDigitPlace)) {
          retVal.append("Three");
        } else {
          retVal.append("Thirty");
        }
        break;
      case 4:
        if (!this.specialCases.contains(currentDigitPlace)) {
          retVal.append("Four");
        } else {
          retVal.append("Forty");
        }
        break;
      case 5:
        if (!this.specialCases.contains(currentDigitPlace)) {
          retVal.append("Five");
        } else {
          retVal.append("Fifty");
        }
        break;
      case 6:
        if (!this.specialCases.contains(currentDigitPlace)) {
          retVal.append("Six");
        } else {
          retVal.append("Sixty");
        }
        break;
      case 7:
        if (!this.specialCases.contains(currentDigitPlace)) {
          retVal.append("Seven");
        } else {
          retVal.append("Seventy");
        }
        break;
      case 8:
        if (!this.specialCases.contains(currentDigitPlace)) {
          retVal.append("Eight");
        } else {
          retVal.append("Eighty");
        }
        break;
      case 9:
        if (!this.specialCases.contains(currentDigitPlace)) {
          retVal.append("Nine");
        } else {
          retVal.append("Ninety");
        }
        break;
      default:
        break;
    }

    switch (currentDigitPlace) {
      case 3:
        retVal.append("Hundred");
        break;
      case 4:
        retVal.append("Thousand");
        break;
      case 6:
        retVal.append("HundredThousand");
        break;
      case 7:
        retVal.append("Million");
        break;
      case 9:
        retVal.append("HundredMillion");
        break;
      default:
        break;
    }

    return retVal.toString();
  }

  private String handleTeenConversion(char[] teenDigits) {
    StringBuilder retVal = new StringBuilder();
    int convertedTeenDigits = Integer.parseInt((teenDigits[0] + "" + teenDigits[1]));

    switch (convertedTeenDigits) {
      case 10:
        retVal.append("Ten");
        break;
      case 11:
        retVal.append("Eleven");
        break;
      case 12:
        retVal.append("Twelve");
        break;
      case 13:
        retVal.append("Thirteen");
        break;
      case 14:
        retVal.append("Fourteen");
        break;
      case 15:
        retVal.append("Fifteen");
        break;
      case 16:
        retVal.append("Sixteen");
        break;
      case 17:
        retVal.append("Seventeen");
        break;
      case 18:
        retVal.append("Eighteen");
        break;
      case 19:
        retVal.append("Nineteen");
        break;
      default:
        break;
    }

    return retVal.toString();
  }
}
