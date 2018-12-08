#Author: your.email@your.domain.com
@Test1
Feature: Products can be sorted by Name

  Scenario: Verify products can be sorted by name
    When Select SORT BY as Name
    Then Products are sorted by Name
