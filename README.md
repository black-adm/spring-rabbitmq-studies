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
  "channel": "PF",
  "from": "Matheus Madureira",
  "to": "James Gosling",
  "value": 2334.96
}
````

* **channel**: Tipo de cliente (**PF** para pessoa física, **PJ** para pessoa jurídica).

* **from**: Nome do remetente do PIX.

* **to**: Nome do destinatário do PIX.

* **value**: Valor do PIX a ser enviado.

Ao enviar a requisição com sucesso, a **API** publica o evento em uma **Exchange** do **RabbitMQ** chamada ``pix-efetuado``. 

Esta **Exchange** é responsável por processar e distribuir os eventos de **PIX** para as filas de mensagens configuradas.

Atualmente, existe um microserviço chamado `auditms` que realiza o **binding** com a exchange `pix-efetuado`. Esse serviço direciona as mensagens para uma fila de auditoria e gera logs das transações processadas.
Exemplo de log gerado a partir de uma transação **PIX**:

``````text
AUDIT - Message Received: GenericMessage [payload=PixRequestDto[channel=PF, from=Matheus Madureira, to=Tom Cruise, value=4771.52] 
``````