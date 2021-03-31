## Colocando o servidor no ar ##

1. Fazer o download do Tomcat através do link: https://tomcat.apache.org/download-90.cgi
2. Extrair os arquivos
3. Através do terminal acessar a pasta `/bin` dentro do diretorio do tomcat e executar o comando `./catalina.sh start`

**com isso, isso uma mensagem informando o start do servidor aparecerá**

## Deploy do Projeto ##

1. Executar o comando `./gradlew war` no diretório em que o projeto será acessado via terminal.

## Build do Projeto ##

1.  No diretório do projeto acessado via terminal executar o comando `./gradlew clean build`, que irá gerar os arquivos `.war` e `.jar`
 
## Projeto TOMCAT ##

1. O arquivo `.war` será encontrado na pasta `/build/libs` do projeto.
2. Copiar o arquivo `.war` e colar na pasta `/webapps` que está no diretório do tomcat.

## Utilizando a aplicação no browser: ##

1. No browser a URL de acesso para a aplicação é http://localhost:8080/toll para ver a página index.
2. http://localhost:8080/toll/prices para acessar a página com os valores do pedagio para os veiculos.
3. http://localhost:8080/toll/{VehicleType}/?cost={cost} para realizar o pagamento de um veículo que não seja do tipo Truck.
4. http://localhost:8080/toll/TRUCK/?cost={cost}&axles={axles} para fazer o pagamento de um veiculo do tipo Truck.

* Veículos Disponíveis:
 	- BUS 
 	- BEETLE
 	- TRUCK 
 	- MOTORCYCLE 
 	- BIKE 
 	
## Exemplos: ## 

1. Neste link foi feito o pagamento de 6.95 para um Caminhão com 2 eixos, sem troco: http://localhost:8080/toll/TRUCK/?cost=6.95&axles=2
2. No link a seguir foi feito o pagamento de 2.0 para uma Bicicleta, com 1,51 de troco: http://localhost:8080/toll/BIKE/?cost=2.0&axles=0