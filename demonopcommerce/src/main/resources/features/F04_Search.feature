@smoke
  Feature: F04_Search | users could search for a product
    Scenario Outline: user could search using product name
      When user enter in search field product name "<productName>"
      And user click on search button
      Then products with "<productName>" search keyword are shown
      Examples:
        | productName |
        | book |
        | laptop |
        | nike |

    Scenario Outline: user could search for product using sku
      When user enter in search field product sku "<productSku>"
      And user click on search button
      Then products with "<productSku>" sku are shown
      Examples:
        | productSku |
        | SCI_FAITH |
        | APPLE_CAM |
        | SF_PRO_11 |
