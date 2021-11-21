# desperdicioZero

Deployado no Heroku usando banco Oracle: https://desperdiciozero.herokuapp.com/
Também é possível rodar localmente
Projeto realizado com JDK 8

### Endpoints:

---
GET /dzero/produtos - lista de produtos

GET /dzero/produtos/{id} - detalhes de um produto

GET /dzero/produtos/imagem/{id} - imagem de um produto específico

GET /dzero/produtos/mercado/{idMercado} - lista de produtos por mercado

POST /dzero/produtos - salvar/atualizar produto

POST /dzero/produtos/mercado - associar produto a um mercado

DELETE /dzero/produtos - deletar produto

----

GET /dzero/mercados - listar todos os mercados

GET /dzero/mercados/{id} - detalhes de uma mercado

POST /dzero/mercados - salvar/atualizar mercado

-----

GET /dzero/caridade - listar todas as instituições de caridade

GET /dzero/caridade/{id} - detalhes de uma instituição de caridade

POST /dzero/caridade - salvar/atualizar instituição de caridade

-----

GET /dzero/clientes - listar todos os clientes

GET /dzero/clientes/{id} - detalhes de um cliente

POST /dzero/clientes - salvar/atualizar cliente