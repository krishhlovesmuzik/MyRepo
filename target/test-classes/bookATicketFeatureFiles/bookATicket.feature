@tag1
Feature: Validate Wedsite Title

  @tag1
  Scenario: Open website
    Given I want to open the Web browser enter websiteURL "https://www.mailtravel.co.uk/"
    And search "India"
    When Search results dispayed
    Then Click MoreInfo on the first result
    Then Make sure it displaying days Price telephoneNumber
    Then Click BookOnline
    Then Check for first Available Date is selected
    Then Click Continue
    Then Select standard room
    And Click select your room and continue
    Then Click Continue without extra
    Then Fill in Passanger Detail
    And Verify Payment amount as per selected Accomodation
