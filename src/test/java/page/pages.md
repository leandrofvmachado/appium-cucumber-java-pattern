# What is?
Pages é o lugar onde são colocados os page objects. A ideia é
simples: fazer a separação entre a lógica de como os
elementos são encontrados
na tela da lógica de como a interação com os elementos é feita.
Cada Page Object contém a lógica do que a aplicação faz para
encontrar elementos de uma determinada tela ou parte importante
da UI.
# When to use?
O uso desse padrão de projeto é recomendado sempre que os
testes forem aplicados diretamente na UI do aplicativo
e para aplicativos que tenham muitas telas.
# Advantages
A vantagem mais explícita é a criação de uma nova camada
que cuidará somente da lógica de achar os elementos na tela,
fazendo com que mudanças na UI só necessitem ser
modificadas em um lugar no código, o que melhora a
manutenção.
# Examples
```java
    public class Page {
        Utils utils = new Utils();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        @AndroidFindBy(id = "nameText")
        WebElement name;

        @AndroidFindBy(id = "phoneText")
        WebElement phone;

        @AndroidFindBy(id = "email")
        WebElement email;

        @AndroidFindBy(xpath = "//*[@text = 'Convidar amigos']")
        WebElement screenTitle;

        public MGMPage(){
            driver  = super.getDriver();
            action = super.getAction();
            phoneType = super.getPhoneType();
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(utils.getTimeout())), this);
        }


    }
```