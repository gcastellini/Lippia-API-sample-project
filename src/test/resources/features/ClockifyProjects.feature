@prueba
Feature: Projects

  Scenario Outline: Consulta Projetcs resultado exitoso
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    @Workspace
    Examples:
      | operation | entity | jsonName     | status |
      | GET       | PROJECT | project/rq | 200    |