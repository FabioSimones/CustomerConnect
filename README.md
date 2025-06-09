## Projeto - CustomerConnect

<h2>CustomerConnect - Sistema de Gerenciamento de Clientes</h2>

<p>Bem-vindo ao CustomerConnect, um projeto envolvente e prático projetado para ajudá-lo a dominar os 
  fundamentos do Spring Boot e do Spring Data JPA. Neste projeto, você criará um robusto Sistema de 
  Gerenciamento de Clientes que executa operações CRUD em uma entidade Cliente.</p>
  </br>

 Regras de Negócio
Dados Cadastrais:
Precisamos das informações principais de nossos clientes:
Nome Completo
CPF
Email
Telefone Celular
Data de registro e atualização do cliente no sistema para fins de auditoria
Cadastro único:
Temos que garantir que não teremos clientes com id ou cpf ou email repetido. 
Busca flexível e personalizada
Permitir a paginação e ordenação de resultados
Permitir busca por CPF e/ou Email
Endpoint REST:
POST /customers: Endpoint para receber o cadastro de clientes.
Parâmetros requeridos:
fullName: Nome completo
cpf: CPF do cliente
email: Email do cliente.
phoneNumber: Telefone celular
Retorna:
customerId: Identificador do cliente no sistema.
GET /customers: Endpoint para consultar o cadastro de clientes.
Parâmetros de consulta:
page: Numero da página
pageSize: Quantidade de itens retornados por página
orderBy: Ordenação de clientes pela data de criação
email: Busca o cliente pelo email
cpf: Busca o cliente pelo CPF
Retorna:
Dados do cliente e da paginação
PUT /customers/{customerId}: Endpoint para atualizar um cliente.
Parâmetros requeridos:
fullName: Nome completo
email: Email do cliente.
phoneNumber: Telefone celular
DELETE /customers/{customerId}: Endpoint para deletar um cliente do cadastro.
