# Projeto Infnet Arquitetura Java 24E4_2

## Visão Geral

Este projeto é um exemplo de aplicação Java utilizando Spring Boot e Maven. A versão do Java utilizada é a 17. O código-fonte está organizado de maneira a facilitar a manutenção e a expansão da aplicação.

## Requisitos

- Java 17
- Maven
- IDE (IntelliJ IDEA ou Eclipse)

## Clonando o Repositório

Para começar, você precisa clonar o repositório do GitHub. Abra seu terminal e execute o seguinte comando:

```bash
git clone https://github.com/bkmoises/projeto-infnet-arquitetura-java-24E4_2
cd projeto-infnet-arquitetura-java-24E4_2
```

## Configuração do Ambiente

### Configuração no IntelliJ IDEA

1. **Abrir o Projeto**:
    - Abra o IntelliJ IDEA.
    - Vá em `File > Open` e selecione a pasta do projeto clonada.

2. **Importar Dependências do Maven**:
    - O IntelliJ IDEA deve detectar automaticamente o arquivo `pom.xml` e importar as dependências Maven. Caso contrário, clique com o botão direito no arquivo `pom.xml` e selecione `Add as Maven Project`.

3. **Configuração do SDK**:
    - Certifique-se de que o SDK do projeto está configurado para o Java 17. Vá em `File > Project Structure > Project`, e selecione a versão 17 do SDK.

4. **Run Application**:
    - Navegue até a classe principal `AppMoisesAndradeApplication.java`.
    - Clique com o botão direito e selecione `Run 'AppMoisesAndradeApplication'`.

### Configuração no Eclipse

1. **Importar o Projeto Maven**:
    - Abra o Eclipse.
    - Vá em `File > Import`.
    - Selecione `Maven > Existing Maven Projects` e clique em `Next`.
    - Navegue até a pasta do projeto clonada e clique em `Finish`.

2. **Configuração do JDK**:
    - Certifique-se de que o JDK 17 está configurado no Eclipse. Vá em `Window > Preferences > Java > Installed JREs` e adicione o JDK 17 se ainda não estiver listado.

3. **Build do Projeto**:
    - O Eclipse deve automaticamente detectar e baixar as dependências Maven definidas no `pom.xml`. Caso contrário, clique com o botão direito no projeto, selecione `Maven > Update Project`.

4. **Run Application**:
    - Navegue até a classe principal `AppMoisesAndradeApplication.java`.
    - Clique com o botão direito e selecione `Run As > Java Application`.

4. **Utilizando o projeto**:
    - Abra seu navegador e acesse a URL [http://localhost:8080/](http://localhost:8080/)
  
### Acessando o banco de Dados

1. **Verifique se a aplicação está rodando**:

	- Para acessar o banco de dados H2, a aplicação precisa estar em execução. Certifique-se de que o servidor Spring Boot está rodando.

2. **Acesse o Console do H2**:

	- Abra seu navegador de internet e vá para o seguinte endereço: http://localhost:8080/h2-console

3. **Configurar o Console H2**:

	- Na tela de login do console H2, você precisará fornecer algumas informações para conectar ao banco de dados. Use as seguintes configurações padrão:

		-   **JDBC URL**: `jdbc:h2:~/appmoisesandradedb`
		-   **User Name**: `sa`
		-   **Password**: (deixe em branco)

		**Nota**: A URL do banco de dados pode variar dependendo de como está configurado o `application.properties`. Se a URL estiver diferente, ajuste a configuração de acordo.

4. **Conectar e Navegar no Banco de Dados**:

	- Clique no botão "Connect" para acessar o console H2.

		Depois de conectar, você verá uma interface onde pode executar consultas SQL e visualizar as tabelas e dados armazenados no banco de dados em memória.

### Importando Collection no Postman


#### Pré-requisitos

-   Certifique-se de que o Postman está instalado em sua máquina. Se ainda não tiver, baixe e instale a partir do site oficial do Postman.
    
-   Tenha em mãos o arquivo JSON que deseja importar. Neste caso, o arquivo `AppMoisesAndrade.postman_collection.json` localizado na raiz do projeto.
    

#### Passo a Passo para Importar uma Collection

1.  **Abrir o Postman**:
    
    -   Inicie o Postman clicando no ícone no seu desktop.
2.  **Navegar até a opção de importação**:
    
    -   No canto superior esquerdo do Postman, clique no botão `Import`.
3.  **Selecionar o arquivo JSON**:
    
    -   Na janela de importação que se abrir, você terá várias opções de importação. Escolha a aba `File` (Arquivo).
    -   Clique no botão `Upload Files` ou arraste o arquivo `AppMoisesAndrade.postman_collection.json` para a área indicada.
4.  **Importar o arquivo**:
    
    -   Após selecionar o arquivo, o Postman exibirá uma prévia da collection que será importada. Verifique as informações e clique no botão `Import`.
5.  **Verificar a Collection importada**:
    
    -   Após a importação, a nova collection aparecerá na lista de collections no painel esquerdo do Postman.
    -   Clique na collection para visualizar as requisições e pastas contidas nela.
6.  **Executar Requisições (Opcional)**:
    
    -   Se desejar, você pode testar as requisições importadas clicando em uma delas e selecionando `Send`.
