
# Carrinho de compras

Esta é uma api de carrinho de compras usando spring


## Stack utilizada

**Back-end:** Java Spring


## Autores

- [@LusoNetto](https://www.github.com/LusoNetto)


## Foi utilizado

- Java 17
- MySQL (Por hora usando o H2)


## Documentação da API

### clientes

#### Retorna todos os clientes

```http
  GET /clientes
```

#### Retorna um cliente

```http
  GET /clientes/${id}
```

#### Adiciona um cliente

```http
  POST /clientes
  body:

    {
      "nome": "nome aqui",
      "login": "login aqui",
      "senha": "senha aqui",
      "email": "email aqui",
      "whatsapp": "whats aqui"
    }
```

#### Atualiza um cliente

```http
  PUT /clientes/${id}
  body:

    {
      "nome": "novo nome aqui",
      "login": "novo login aqui",
      "senha": "nova senha aqui",
      "email": "novo email aqui",
      "whatsapp": "novo whats aqui"
    }
```

#### Deleta um cliente

```http
  DELETE /clientes/${id}
```
### produtos

#### Retorna todos os produtos

```http
  GET /produtos
```

#### Retorna um produto

```http
  GET /produtos/${id}
```

#### Adiciona um produto

```http
  POST /produtos
  body:

    {
      "nome": "nome1",
      "preco": 123
    }
```

#### Atualiza um produto

```http
  PUT /produtos/${id}
  body:

    {
      "nome": "nomeNovo",
      "preco": 1234
    }
```

#### Deleta um produto

```http
  DELETE /produtos/${id}
```

### items

#### Retorna todos os items

```http
  GET /items
```

#### Retorna um item

```http
  GET /items/${id}
```

#### Adiciona um item

```http
  POST /items
  body:

    {
      "quantidade": 1,
      "produto": {"id":1},
      "carrinho": {"id":1}
    }   
```

#### Atualiza um item

```http
  PUT /items/${id}
  body:

    {
      "quantidade": 2,
      "produto": {"id":2}
    }
```

#### Deleta um item

```http
  DELETE /items/${id}
```

### carrinhos

#### Retorna todos os carrinhos

```http
  GET /carrinhos
```

#### Retorna um carrinho

```http
  GET /carrinhos/${id}
```

#### Adiciona um carrinho

```http
  POST /carrinhos
  body:

    {
    }  
```

#### Atualiza um carrinho

```http
  PUT /carrinhos/${id}
  body:

    {
      "cliente": {"id":1}
    }
```

#### Deleta um carrinho

```http
  DELETE /carrinhos/${id}
```



