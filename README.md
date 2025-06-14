## Projeto - CustomerConnect

<h2>CustomerConnect - Sistema de Gerenciamento de Clientes</h2>

<p>Bem-vindo ao CustomerConnect, um projeto envolvente e prático projetado para ajudá-lo a dominar os 
  fundamentos do Spring Boot e do Spring Data JPA. Neste projeto, você criará um robusto Sistema de 
  Gerenciamento de Clientes que executa operações CRUD em uma entidade Cliente.</p>
  </br>

## Regras de Negócio
<h3>Dados Cadastrais:</h3>
<h4>Precisamos das informações principais de nossos clientes:</h4>
<p>  --Nome Completo;</p>
<p>  --CPF;</p>
<p>  --Email;</p>
<p>  --Telefone Celular;</p>
<p>  --Data de registro e atualização do cliente no sistema para fins de auditoria.</p>
<h4>Cadastro único:</h4>
<p>  --Temos que garantir que não teremos clientes com id ou cpf ou email repetido.</p>
<h4>Busca flexível e personalizada</h4>
<p>  --Permitir a paginação e ordenação de resultados;</p>
<p>  --Permitir busca por CPF e/ou Email.</p>
</br>

## Endpoint REST:
<h3>POST /customers: Endpoint para receber o cadastro de clientes.</h3>
<h4>Parâmetros requeridos:</h4>
<p>  --fullName: Nome completo.</p>
<p>  --cpf: CPF do cliente.</p>
<p>  --email: Email do cliente.</p> 
<p>  --phoneNumber: Telefone celular.</p>
<h4>Retorna:</h4>
<p>  --customerId: Identificador do cliente no sistema.</p>
</br>

<h3>GET /customers: Endpoint para consultar o cadastro de clientes.</h3>
<h4>Parâmetros de consulta:</h4>
<p>  --page: Numero da página;</p>
<p>  --pageSize: Quantidade de itens retornados por página;</p>
<p>  --orderBy: Ordenação de clientes pela data de criação;</p>
<p>  --email: Busca o cliente pelo email;</p>
<p>  --cpf: Busca o cliente pelo CPF.</p>
<h4>Retorna:</h4>
<p>  --Dados do cliente e da paginação.</p>
</br>

<h3>PUT /customers/{customerId}: Endpoint para atualizar um cliente.</h3>
<h4>Parâmetros requeridos:</h4>
<p>  --fullName: Nome completo;</p>
<p>  --email: Email do cliente;</p>
<p>  --phoneNumber: Telefone celular.</p>
</br>

<h3>DELETE /customers/{customerId}: Endpoint para deletar um cliente do cadastro.</h3>


