### Batalha-CLI

Um jogo de batalha por turnos para terminal, totalmente desenvolvido em Java. Este projeto oferece uma experiência de RPG de console com gerenciamento de inventário, combate por turnos e um sistema de salvamento de jogo.

#### Aviso: Esse projeto provavelmente não receberá mais atualizações. Talvez num futuro distante pois o seu objetivo de existência era a obtenção de nota. Não foi testado como um programa completo e pode conter INÚMEROS bugs. Seria legal se você pudesse reportá-los. Nós podemos ver o que deixamos passar batido no tempo de desenvolvimento.

#### Funcionalidades
  * **Combate por Turnos:** O jogo apresenta um sistema de batalha por turnos entre um jogador e inimigos gerados aleatoriamente.
  * **Sistema de Inventário:** O jogador pode gerenciar um inventário de 8 slots com diferentes tipos de itens:
      * **Itens de Ataque (`ItemAtk`):** Aumentam o dano causado.
      * **Itens de Defesa (`ItemDef`):** Reduzem o dano sofrido.
      * **Itens Consumíveis (`ItemConsumivel`):** Oferecem efeitos como cura de HP ou melhorias permanentes de atributos.
  * **Sprites em ASCII:** A interface do jogo é renderizada no terminal usando sprites de arte ASCII para representar o jogador, os inimigos e os itens.
  * **Sistema de Salvar Jogo:** O progresso do jogo pode ser salvo e carregado em um arquivo JSON.

#### Tecnologias

O projeto foi construído utilizando as seguintes tecnologias:

  * **Linguagem de Programação:** Java 21.
  * **Gerenciador de Dependências:** Maven.
  * **Biblioteca de JSON:** Google Gson 2.10.1.

#### Como Executar

Para compilar e executar o jogo usando o Maven, um passo a passo simples:

1.  Certifique-se de ter o **Maven** e o **JDK 21** instalados. 
2.  Navegue até o diretório raiz do projeto.
3.  Compile o projeto usando o Maven:
    ```sh
    mvn clean install
    ```
4.  Execute a aplicação a partir da classe principal:
    ```sh
    java -cp target/classes:target/dependency/* Main
    ```
    Ou, se você estiver usando um ambiente como o Replit, a compilação e execução são automatizadas pelos comandos definidos em `.replit`.
    #### Recomendados / Testados
    Usamos IDEs como IntelliJ, Vscode e até o próprio Replit para rodar o código. De verdade, não testamos compilar e executar o código da maneira acima (apesar de ser a forma correta, enfim, foi mals)


#### Estrutura do Projeto

  * `pom.xml`: Gerenciador de dependências e configuração de build.
  * `src/main/java/Main.java`: Ponto de entrada do programa.
  * `src/main/java/negocios/`: Contém a lógica central do jogo (personagens, itens, batalhas e o gerenciador do jogo).
  * `src/main/java/persistencia/`: Lida com o salvamento e carregamento de dados do jogo.
  * `src/main/java/telas/`: Gerencia a renderização de todas as telas e sprites no terminal.
  * `src/main/java/utilidades/`: Contém classes de utilidade, como a de centralização de texto.
  * `src/saves/`: Diretório para arquivos de salvamento do jogo (por exemplo, `save_01.json`).
  
### Considerações finais

Este projeto foi feito com o objetivo de obtenção de nota da ultima avaliação da disciplina de Projeto de Programas ministrada na Universidade do Estado do Amazonas para o curso de Sistemas de Informação pelo Prof. Fábio Santos com os seguintes requisitos:

* Data de Atribuição: 29 de maio de 2024
* Data de Entrega: 9 de junho de 2024
* Tempo de trabalho: 10 dias
	* Descrição dos requisitos da atividade

> O trabalho consiste no desenvolvimento de um projeto de programa implementado por meio da linguagem Java.  
> Para isso cada equipe deverá identificar um problema e desenvolver um projeto de programa. Exemplo de problema: controlar os gastos pessoais.  
> Esse projeto de programa deverá procurar explorar todos os conceitos da programação orientada a objetos que estudamos nos dois bimestres.  
> Dessa forma, minha avaliação deverá levar em conta quais conceitos foram empregados e de que forma foram usados no projeto de projeto de programa.  
  > A nota será proporcional a quantidade e forma como os conceitos foram empregados.  
 >  Procurem desenvolver um trabalho com zelo.
   >
 >  O que deverá ser entregue:  
> 1. Link do projeto de programa no Replit.com  
> 2. Explicação do Código ao vivo.
