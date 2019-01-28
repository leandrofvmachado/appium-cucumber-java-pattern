# What is?
Todos os códigos relacionados aos cenários que serão testados devem
estar na pasta resources. Caso seja usado Cucumber(como nesse projeto)
para se utilizar do formato de cenários do BDD, essa pasta recebe
os `.feature` das features da aplicação que está sendo testada.
# Examples
```gherkin
    Given O usuário está na tela de Login
    When O usuário insere e-mail e senha
    And Clica no botão de Login
    Then O usuário é direcionado a tela inicial
```