Feature: Harley Enterprise : API Login Testing

  @LoginWithOTP
  Scenario: Successful login with valid mobile number
    Given the login API is available
    Then the response status should be 200 and message "OTP Generated Successfully"

