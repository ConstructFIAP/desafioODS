# ReobraSpring

Deployado no Heroku usando banco Oracle: https://reobra.herokuapp.com/

### Endpoints:

---
GET /reobra/produto - lista de produtos

GET /reobra/produto/{id} - detalhes de um produto

GET /reobra/produto/imagem/{id} - imagem de um produto específico

POST /reobra/produto - salvar produto

DELETE /reobra/produto - deletar produto

---

GET /reobra/pedido - listar todos os pedidos

GET /reobra/pedido/{id} - detalhes de um pedido

GET/reobra/pedido/cliente/{id} - listar todos os pedidos feitos por um cliente específico

POST /reobra/pedido - salvar pedido

----

GET /reobra/loja - listar todas as lojas

GET /reobra/loja/{id} - detalhes de uma loja

-----

GET /reobra/cliente - listar todos os clientes

GET /reobra/cliente/{id} - detalhes de um cliente

POST /reobra/cliente - salvar cliente