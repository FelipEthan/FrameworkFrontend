Feature: Login

  @Test1
  Scenario: Intentar iniciar sesión después de borrar las credenciales ingresadas
    Given El usuario está en la página de inicio de sesión
    When El usuario ingresa el nombre de usuario "standard_user"
    When El usuario ingresa la contraseña "secret_saue"
    And Borra los campos de usuario
    And El usuario hace clic en el botón de Login
    Then El sistema debe mostrar el mensaje de error se requiere nombre de usuario

  @Test2
  Scenario: Intentar iniciar sesión cuando se borra la contraseña después de ingresarla
    Given El usuario está en la página de inicio de sesión
    When El usuario ingresa el nombre de usuario "standard_user"
    When El usuario ingresa la contraseña "secret_saue"
    And Borra los campos de contraseña
    And El usuario hace clic en el botón de Login
    Then El sistema debe mostrar el mensaje de error se requiere contraseña

  @Test3
  Scenario Outline: Login exitoso con credenciales válidas
    Given El usuario está en la página de inicio de sesión
    When El usuario ingresa el nombre de usuario "<usuario>" y contraseña "<contraseña>"
    And El usuario hace clic en el botón de Login
    Then El sistema debe mostrar el mensaje de Swag labs
    Examples:
      | usuario                 | contraseña   |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |