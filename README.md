## Estudos com RabbitMQ e Spring

### 1. Subindo o container do RabbitMQ

Na raiz do projeto, execute o comando abaixo para iniciar o container:

```bash
docker compose up -d
````

### 2. Acessando a interface de administração

Com o container em execução, abra o navegador e acesse:

```text
http://localhost:15672/
````

### 3. Credenciais de acesso padrão

Utilize as seguintes credenciais para login:

* Usuário: ``guest``

* Senha:  ``guest``

### 4. Como interagir com a API

Para criar um evento de envio **PIX**, utilize o endpoint:

```POST - http://localhost:8080/api/pix```

O corpo da requisição deve ser enviado em JSON com os seguintes campos:

````json
{
  "channel": "pf",
  "from": "Matheus Madureira",
  "to": "James Gosling",
  "value": 2334.96
}
````

* **channel**: Tipo de cliente (pf para pessoa física, pj para pessoa jurídica).

* **from**: Nome do remetente do PIX.

* **to**: Nome do destinatário do PIX.

* **value**: Valor do PIX a ser enviado.

Ao enviar a requisição com sucesso, a **API** cria uma nova **Exchange** no **RabbitMQ** chamada ``pix-efetuado``. Esta Exchange será usada para processar e distribuir os eventos de **PIX** na fila de mensagens.
