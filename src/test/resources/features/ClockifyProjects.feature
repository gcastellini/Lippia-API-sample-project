Feature: Projects

  Scenario Outline: Consulta Projects resultado exitoso
    Given Mi cuenta creada en clockify y mi X-Api-Key geneada
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    @Projects
    Examples:
      | operation | entity  | jsonName   | status |
      | GET       | PROJECT | project/rq | 200    |

  Scenario Outline: Consulta Projects no autorizado
    Given X-Api-Key invalido
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then se obtuvo el status code <status>
    @Projects
    Examples:
      | operation | entity | jsonName   | status |
      | GET       | ERROR  | project/rq | 401    |


  Scenario Outline: Consulta Project no encontrado
    Given Mi cuenta creada en clockify y mi X-Api-Key geneada
    And Tengo el ID de un proyecto <id>
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then se obtuvo el status code <status>
    @Projects
    Examples:
      | operation | entity    | jsonName      | id                       | status |
      | GET       | PROJECTID | project/proID | 6349b42eac11fd230b4f2dd9 | 400    |

  @prueba
  Scenario Outline: Consulta Project exitosa
    Given Mi cuenta creada en clockify y mi X-Api-Key geneada
    When  I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then se obtuvo el status code <status>
    @Projects
    Examples:
      | operation | entity  | jsonName   | status |
      | GET       | PROJECT | project/proID | 200    |

  Scenario Outline: Editar Project exitosamente
    Given Mi cuenta creada en clockify y mi X-Api-Key geneada
    When I perform a 'GET' to 'PROJECT' endpoint with the 'project/rq' and ''
    And se obtuvo el status code <status>
    When  I perform a 'GET' to '<entity>' endpoint with the 'project/proID' and ''
    And se obtuvo el status code <status>
    And un nombre '<name>'
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then se valida que el nombre '<name>' haya sido cambiado
    @Projects
    Examples:
      | operation | entity    | jsonName       | status | name      |
      | PUT       | PROJECTID | project/editar | 200    | Giuliana2 |