
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
  <link rel="stylesheet" href="css/payment.css">
<meta name="robots" content="noindex,follow" />
</head>
<body>

  <div class="checkout-panel">
    <div class="panel-body">
      <h2 class="title">Checkout</h2>

      <div class="progress-bar">
        <div class="step active"></div>
        <div class="step active"></div>
        <div class="step"></div>
        <div class="step"></div>
      </div>

      <div class="payment-method">
        <label for="card" class="method card">
          <div class="card-logos">
            <img src="images/visa_logo.png"/>
            <img src="images/mastercard_logo.png"/>
          </div>

          <div class="radio-input">
            <input id="card" type="radio" name="payment">
            Pay  <b>Rs${amount_paid}.00</b> with debit card
          </div>
        </label>

        <label for="paypal" class="method paypal">
          <img src="images/paypal_logo.png"/>
          <div class="radio-input">
            <input id="paypal" type="radio" name="payment">
            Pay  <b>Rs${amount_paid}.00</b> with credit card
          </div>
        </label>
      </div>

      <div class="input-fields">
        <div class="column-1">
          <label for="cardholder">Cardholder's Name</label>
          <input type="text" id="cardholder" required="required" />

          <div class="small-inputs">
            <div>
              <label for="date">Valid thru</label>
              <input type="text" id="date" placeholder="MM / YY" />
            </div>

            <div>
              <label for="verification">CVV / CVC *</label>
              <input type="password" id="verification"/>
            </div>
          </div>

        </div>
        <div class="column-2">
          <label for="cardnumber">Card Number</label>
          <input type="password" id="cardnumber"/>

          <span class="info">* CVV or CVC is the card security code, unique three digits number on the back of your card separate from its number.</span>
        </div>
      </div>
    </div>

    <div class="panel-footer">
     <a href="first1.jsp"> <button class="btn back-btn">Back</button></a>
      <a href='final_book.htm?passengers=${passengers}&flight_No=${flight.flight_No}&amount_paid=${amount_paid}&sdate=${sdate}&available_seats=${available_seats}'><button class="btn next-btn">Confirm Ticket</button></a>
    </div>
  </div>

  <script src="js/jquery.min.js"></script>
  <script src="js/payment.js"></script>
</body>
</html>