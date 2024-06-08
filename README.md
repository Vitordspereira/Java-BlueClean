<h1  align="center">Projeto Blue Clean :ocean:</h1>

<div align="center">
<h3>Integrantes do grupo :mortar_board:</h3>
  <li>Henrique Oliveira - RM97796 (2TDSPG)</li>
  <li>Kaique Oliveira - RM550815 (2TDSS)</li>
  <li>Rafael Minoro - RM99988 (2TDSS)</li>
  <li>Thiago Gil - RM551211 (2TDSPV)</li>
  <li>Vitor Pereira - RM551831 (2TDSS)</li>
</div>

<h3>Descrição do projeto :file_folder:</h3>

> O projeto BlueClean tem como objetivo desenvolver uma solução tecnológica avançada para monitorar, identificar e reduzir a poluição plástica nos oceanos.

Utilizando técnicas de Machine Learning (ML) e Internet of Things (IoT), a solução é composta por dispositivos IoT flutuantes equipados com sensores para detectar resíduos plásticos, 
GPS para localização e módulos de comunicação para transmitir dados. Esses dispositivos enviam informações para uma central de processamento de dados que utiliza algoritmos de ML 
para classificar e quantificar os resíduos e analisar padrões de poluição.

<h3>Modelo Relacional das Entidades :clipboard:</h3>
![relational-model png](https://github.com/Vitordspereira/Java-BlueClean/assets/115511851/d1b5a2c3-6ef5-4768-bb9c-13a7a48a2043)

<h3>Modelo Lógico das Entidades  :clipboard:</h3>
![logical-model png](https://github.com/Vitordspereira/Java-BlueClean/assets/115511851/8c89bc11-1674-4411-a180-e6f3677faed0)

<div>
  <h1 align ="center">Pacotes do Projeto :open_file_folder:</h1>

  <h3>Model</h3>
  <li>Pacote principal, onde contém as classes responsáveis por serem as base de modelagem da aplicação</li>
  <li>Classes responsáveis por mapearem a tabela do Banco de dados</li>

  <h3>Dto</h3>
  <li>Tem como função definir como as informações do sistema serão navegadas e utilizadas</li>
  <li>As classes desse pacote são responsáveis pelo mapeamento das tranferência que serão feitas no pacote controller</li>

  <h3>Repository</h3>
  <li>Essas classes serão utilizadas na controller para termos acesso do banco de dados</li>
  <li>As classes desse pacote são responsáveis pela persistência JPA das tabelas</li>

  <h3>Controller</h3>
  <li>Contém o CRUD do nosso projeto com os métodos GET, POST, PUT, DELETE</li>
  <li>As classes desse pacote são responsáveis por controlarem as requisições que faremos no Postman</li>

  <h3>Handler</h3>
  <li>A exceção será lançada caso tentemos realizar as requisições de algum dado que não existe, exemplo, um id</li>
  <li>A classe desse pacote é responsável por lançar a exceção "error 404 not found"</li>
</div>

<h3>Como o sistema da BlueClean funciona? 🤔</h3>
<li>Coemece iniciando a aplicação spring após clonar o repositório ou baixando o arquivo do projeto</li>
<li>Baixe os arquivos de requisições do Postman que se encontra depois das tabelas de endpoints</li>
<li>Importe o arquivo para o seu Postman</li>
<li>Realize as requisições GET, POST, PUT e DELETE</li>
<li>Utilize a URL "http://localhost:8080/{Endpoint}" (Confira abaixo os Endpoints)</li>

<h1 align="center">Endpoints :computer:</h1>

<li>Usuario</li>

|Método|Endpoint                 |Descrição                            |
|------|-------------------------|-------------------------------------|
|GET   |/usuarios                |Listar todos os usuários             |
|GET   |/usuarios/id             |Buscar usuário por id                |
|POST  |/usuarios                |Cadastrar um usuário                 |
|POST  |/usuarios/id/alertas     |Cadastrar um alerta a um usuário     |
|POST  |/usuarios/id/dispositivos|Cadastrar um dispositivo a um usuário|
|PUT   |/usuarios/id             |Alterar um usuário                   |
|DELETE|/usuarios/id             |Deletar um usuário                   |

<li>Localização</li>

|Método|Endpoint                     |Descrição                                 |
|------|-----------------------------|------------------------------------------|
|GET   |/localizacoes                |Listar todas as localizações              |
|GET   |/localizacoes/id             |Buscar localização por id                 |
|POST  |/localizacoes                |Cadastrar uma localização                 |
|POST  |/localizacoes/id/dispositivos|Cadastrar um dispositivo a uma localização|
|PUT   |/localizacoes/id             |Alterar uma localização                   |
|DELETE|/localizacoes/id             |Deletar uma localização                   |

<li>Dispositivo</li>

|Método|Endpoint                  |Descrição                              |
|------|--------------------------|---------------------------------------|
|GET   |/dispositivos             |Listar todos os dispositivos           |
|GET   |/dispositivos/id          |Buscar dispositivo por id              |
|POST  |/dispositivos             |Cadastrar um dispositivo               |
|POST  |/dispositivos/id/deteccaos|Cadastrar uma detecção a um dispositivo|
|PUT   |/dispositivos/id          |Alterar um dispositivo                 |
|DELETE|/dispositivos/id          |Deletar um dispositivo                 |

<li>Detecção</li>

|Método|Endpoint     |Descrição                |
|------|-------------|-------------------------|
|GET   |/deteccaos   |Listar todas as detecções|
|GET   |/deteccaos/id|Buscar detecção por id   |
|POST  |/deteccaos   |Cadastrar uma detecção   |
|PUT   |/deteccaos/id|Alterar uma detecção     |
|DELETE|/deteccaos/id|Deletar uma detecção     |

<li>Alerta</li>

|Método|Endpoint   |Descrição                |
|------|-----------|-------------------------|
|GET   |/alertas   |Listar todas as detecções|
|GET   |/alertas/id|Buscar detecção por id   |
|POST  |/alertas   |Cadastrar uma detecção   |
|PUT   |/alertas/id|Alterar uma detecção     |
|DELETE|/alertas/id|Deletar uma detecção     |

❗❗ Acesse o arquivo de requisições do postman <a href="BlueClean.postman_collection.json">AQUI</a> ❗❗

<li>ACESSO AOS VIDEOS PITCH E FUNCIONAL DA APLICAÇÂO :exclamation:</li>
<a href="https://www.youtube.com/watch?v=BzM0Lb2Ux_Q">Vídeo Funcional do Sistema</a>
<br>
<a href="https://youtu.be/mjy1jqSO3sU">Vídeo Pitch do projeto</a>
