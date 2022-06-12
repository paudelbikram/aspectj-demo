package aspectpointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

aspect CheckoutAspect {
  private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutAspect.class);

  /**
   * A join point is a well-defined point in the program flow.
   * A pointcut picks out certain join points and values at those points (values are called context)
   * Here we are defining pointcut with name callPlaceOrder. It has CheckOut and numberOfRaspberryPi
   * as its context and placeOrder method of CheckOut class as a join point.
   * Few ways to add context to pointcut or advice are
   * -- Using args
   * -- Using target
   * -- Using this
   * Note here && is called with [Should not mistake with Binary && Operator]
   * AspectJ also offers very powerful wildcard features to create pointcut for various scenarios
   */
  pointcut callPlaceOrder(int numberOfRaspberryPi, CheckOut checkOut) :
      call(boolean CheckOut.placeOrder(int))
       && args(numberOfRaspberryPi) && target(checkOut);

  /**
   * Advice is the piece of code that runs when join point is reached.
   * before advice on a method call join point runs before the actual method starts running,
   * just after the arguments to the method call are evaluated.
   */
  before(int numberOfRaspberryPi, CheckOut checkOut) : callPlaceOrder(numberOfRaspberryPi, checkOut) {
    LOGGER.info("Number Of Raspberry Pi before placing order: {}", checkOut.numberOfRaspberryPi);
    LOGGER.info("Number of Raspberry Pi placed order: {}", numberOfRaspberryPi);
  }


  /**
   * Around advice on a join point runs as the join point is reached,
   * and has explicit control over whether the program proceeds with the join point.
   * Here we are only processing if we have enough raspberry pi on the stock, making
   * the check in placeOrder function useless.
   */
  boolean around(int numberOfRaspberryPi, CheckOut checkOut) :
      callPlaceOrder(numberOfRaspberryPi, checkOut) {
    if (checkOut.numberOfRaspberryPi < numberOfRaspberryPi) {
      LOGGER.warn("Order can not be fulfilled !!!");
      return false;
    }
    return proceed(numberOfRaspberryPi, checkOut);
  }

  /**
   * after advice on a method call join point runs after the method body has run,
   * just before control is returned to the caller.
   * There are also after returning and after throwing
   * [regular after] runs after [after returning] or [after throwing].
   */
  after(int numberOfRaspberryPi, CheckOut checkOut) : callPlaceOrder(numberOfRaspberryPi, checkOut) {
    LOGGER.info("Number of Raspberry pi after placing order: {}", checkOut.numberOfRaspberryPi);
  }
}