Feature: Test Automation Rest API

  @api
  Scenario: Test get list user normal
    Given prepare url for "USER_REST"
    And hit api get list users
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_list_users.json"
