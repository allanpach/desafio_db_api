# Test API de Tarefas Módulo Contato

Este é o projeto de Testes de API automatizado.

##  Requisitos
 * Java 8+ JDK deve estar instalado
 * Maven deve estar instalado e configurado no path da aplicação
 * Como configurar o path: https://www.linkedin.com/pulse/como-instalar-o-chromedriver-windows-10-jo%C3%A3o-gross/?originalSubdomain=pt
 * Para vizualizar os relatórios indico o Alluer report baixe e mapeia no path do sistema.
 
##  Aplicação usada para  os testes
  * Alguns status code mapeado no documento não está de acordo com o retorno da aplicação.
  * Exemplo quando é para retornar status code 400 está retornando o 422.
 
##  Como executar a aplicação 

 * Na raiz do projeto, através de seu Prompt de Commando/Terminal/Console execute o comando 

```bash
 * mvn clean test
```
## Casos de Testes
 * A cobertura dos testes conforme Regras definidas https://apidetarefas.docs.apiary.io/#reference/0/contatos/listar-contatos
## Reports
 * O report da execução dos testes fica na raiz do projeto em: /DesafioApiDb/target/surefire-reports
 * Pode ser usado uma ferramenta para ler os logs conforme escolha.

