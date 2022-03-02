@cna
Feature: CNA page verification

  @Scenario3
  Scenario Outline: Verify wether condition in Singapore
    Given Given I am landing in cna International
    When I click 'Wether' value from All selecter menu
    Then I check temperature of '<city>' should equal to '<temperature>'
    Then I check condition of '<city>' should equal to '<condition>'
    Examples:
      |city|temperature|condition|
      |Singapore|33|thunderstorm |

    @Scenario1
    Scenario Outline: Verify news feeds
      Given Given I am landing in cna.com
      When I should see the headline news item Title
      And I click on Headline news
     Then I should see the actual story as '<Headline>' for the headline
      And I scroll the browser
      And I click '<newsNo>' news item
      Examples:
      |Headline|newsNo|
      |I was going to die: Unvaccinated COVID-19 patient urges others to get jabbed after near-death experience|2|

  @Scenario2
  Scenario Outline: Verify news feeds of Singapore
    Given Given I am landing in cna International
    When I click '<Country>' to switch from international
    When I should see the headline news item Title
    And I click on Headline news
    Then I should see the actual story as '<Headline>' for the headline
    Examples:
      |Headline|Country|
      |I was going to die': Unvaccinated COVID-19 patient urges others to get jabbed after near-death experience|Singapore|



       
