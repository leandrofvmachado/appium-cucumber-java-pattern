# What is?
Steps deve ser a camada que contém a lógica de negócio do seu
código. Essa camada está diretamente ligada com as outras duas
presentes no código: a camada de cenários e a camada de pages.
Nessa camada, são detalhadas as funções criadas para cada step
dos cenários do BDD e são utilizadas as Pages das telas para
acessar os elementos e executar a lógica de negócio.
# Examples
```java
public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    StartPage startPage = new StartPage();

    @Given("^O usuário está na tela de Login$")
    public void oUsuárioEstáNaTelaDeLogin(DataTable dataTable) {
        assertTrue(loginPage.getScreenTitle().isDisplayed());
    }

    @When("^O usuário insere o e-mail \"([^\"]*)\" e a senha \"([^\"]*)\"$")
    public void oUsuárioInsereOEMailEASenha(String email, String password) {
        loginPage.insertDataAndLogin(email, password);
    }

    @And("Clica no botão de Login")
    public void clicaNoBotãoDeLogin(){
        loginPage.clickLoginButton();
    }

    @Then("^O usuário é direcionado a tela inicial$")
    public void oUsuárioÉDirecionadoATelaInicial() {
        assertTrue(startPage.getScreenTitle().isDisplayed());
    }
```