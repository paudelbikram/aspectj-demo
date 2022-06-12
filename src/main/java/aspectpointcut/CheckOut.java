package aspectpointcut;

/**
 * Raspberry PI model 4 B is sold out everywhere.
 * Here we have shop with only 10 Raspberry PI and we
 * want to monitor every time someone places order.
 */
public class CheckOut {
  int numberOfRaspberryPi = 10;
  /**
   * If number of pi to buy is more than current stock,
   * we will reject the order
   * @param numberOfPiToBuy
   * @return
   */
  public boolean placeOrder(int numberOfPiToBuy) {
    numberOfRaspberryPi = numberOfRaspberryPi - numberOfPiToBuy;
    return true;
  }
}
