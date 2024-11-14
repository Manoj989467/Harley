Feature: Harley Enterprise : API Login Testing

  Background:
    Given the login API is available

  @SuccessfulLoginWithOTP
  Scenario Outline: Successful login with valid mobile number
    When the user sends a login request with valid_mobile_number and add headers
    And user add requestbody for validlogin "<loginid>" ,"<logintype>" and "<notificationtype>"
    And the user sends a Externallogin request with "POST"
    Then the response status should be 200 and message "OTP Generated Successfully"

    Examples:
      | loginid    | logintype | notificationtype |
      | 9891803084 | mobile    | sms              |


  @SpecialChar
  Scenario Outline: Unsuccessful login with special character in mobile number
    When user add requestbody for login "<loginid>" ,"<logintype>" and "<notificationtype>"
    And the user sends a login request with "POST"
    Then Validate response with Message "<message>", Status code <statuscode> ,Success "<success>", errorCode <errorCode> and error description "<desc>"

    Examples:
      | loginid     | logintype | notificationtype | message                       | statuscode | success | errorCode | desc                           |
      | $##$%#$%dwd | mobile    | sms              | Mobile number is not numeric. | 200        | false   | 1002      | Unable to process Your Request |


