Feature: Tests wikipedia

    Scenario Outline: Test wikipedia in english
        Given I open <browser>
        And I open wikipedia
        When I search <articleName>
        Then I should see <articleTitle>

    Examples:
    s    | browser    | articleName | articleTitle|
         | "chrome"  | "h2o"       |"Properties of water"|
         | "firefox" | "France"  |"France"|
         | "firefox"  | "messi" |"Lionel Messi"|
         | "chrome"   | "France"    |"France"|
         | "chrome"  | "messi"     |"Lionel Messi"|
         | "firefox  | "h2o" |"Properties of water"|
