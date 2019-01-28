# What is?
Todos os códigos relacionados aos cenários que serão testados devem
estar na pasta resources. Caso seja usado Cucumber(como nesse projeto)
para se utilizar do formato de cenários do BDD, essa pasta recebe
os `.feature` das features da aplicação que está sendo testada.
# When to use?

# Advantages
# Examples
```java
    public class Page {
        @AndroidFindBy(id = "idTextInput")
        @iOSFindBy(accessibility = "id_onda_money")
        WebElement textInput;

        @AndroidFindBy(xpath = "//*[contains(@text, 'screenTitle')]")
        @iOSXCUITFindBy(iOSNsPredicate = "label == \"screenTitle\"")
        WebElement screenTitle;

        public WebElement getScreenTitle(){
            return screenTitle;
        }
    }
```