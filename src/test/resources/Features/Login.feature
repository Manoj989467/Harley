Feature: Harley Enterprise : API Login Testing

  Background:
    Given the login API is available

  @SpecialChar
  Scenario Outline: Unsuccessful login with special character in mobile number
    When user add requestbody for login "<loginid>" ,"<logintype>" and "<notificationtype>"
    And the user sends a login request with "POST"
    Then Validate response with Message "<message>", Status code <statuscode> ,Success "<success>", errorCode <errorCode> and error description "<desc>"

    Examples:
      | loginid     | logintype | notificationtype | message                       | statuscode | success | errorCode | desc                           |
      | $##$%#$%dwd | mobile    | sms              | Mobile number is not numeric. | 200        | false   | 1002      | Unable to process Your Request |


#  @Invalid_Login_type
#  Scenario Outline: Unsuccessful login for Invalid login type
#    When user add requestbody for loginInvalidInput "<loginid>" ,"<logintype>" and "<notificationtype>"
#    And the user sends a invalidlogintype request with "POST"
#    Then the response status should be 200 and message "Invalid loginType, Please try again.Invalid AppId."
#
#    Examples:
#      | loginid    | logintype | notificationtype |
#      | 7004813003 | *&&&&     | sms              |