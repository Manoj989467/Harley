Feature: Harley Enterprise : API Login Testing

  Background:
    Given the login API is available

  @LoginWithOTP @SuccessfulLogin
  Scenario: Successful login with valid mobile number
    Then the response status should be 200 and message "OTP Generated Successfully"

  @LoginWithOTP @NonExistingAndSpecialChar
  Scenario Outline: Unsuccessful login with non existing mobile number
    When the user sends a login request with "<requestType>" and header is "<header>"
    Then Validate response with Message "<message>", Status code "<statuscode"> ,Success "<success>", errorCode "<errorCode>" and error description "<desc>"

    Examples:
      | header  | requestType                   | message                       | statuscode | success | errorCode | desc                           |
      | headers | non_existing_mobile_number    | User is not registered        |        200 | false   |      1001 | Unable to process Your Request |
      | headers | special_characters_in_LoginId | Mobile number is not numeric. |        200 | false   |      1002 | Unable to process Your Request |

  @MoreThanTenCharacters_LoginID
  Scenario Outline: Unsuccessful login with enter more than ten digits in LoginId
    When the user sends a login request with "<requestType>" and header is "<header>"
    Then Validate response with Message "<message>", Status code "<statuscode>" ,Success "<success>", login Id "<loginId>" and registered User "<status>"

    Examples:
      | header  | requestType                     | message                    | statuscode | success | loginId    | status |
      | headers | more_than_ten_digits_in_LoginId | OTP Generated Successfully |        200 | true    | 7004813003 | true   |