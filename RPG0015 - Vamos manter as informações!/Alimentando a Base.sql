-- Tabela de pessoa
CREATE TABLE Pessoa (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    tipo CHAR(1) CHECK (tipo IN ('F', 'J')), -- 'F' para pessoa física, 'J' para pessoa jurídica
    cpf VARCHAR(14), -- Apenas para pessoas físicas
    cnpj VARCHAR(18), -- Apenas para pessoas jurídicas
    endereco VARCHAR(255),
    telefone VARCHAR(20)
);

-- Tabela de usuários
CREATE TABLE Usuarios (
    id INT PRIMARY KEY IDENTITY(1,1),
    nome VARCHAR(100),
    senha VARCHAR(50)
);

-- Tabela de pessoas físicas
CREATE TABLE PessoasFisicas (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14),
    endereco VARCHAR(255),
    telefone VARCHAR(20)
);

-- Tabela de pessoas jurídicas
CREATE TABLE PessoasJuridicas (
    id INT PRIMARY KEY,
    nomeFantasia VARCHAR(100),
    razaoSocial VARCHAR(100),
    cnpj VARCHAR(18),
    endereco VARCHAR(255),
    telefone VARCHAR(20)
);

-- Tabela de produtos
CREATE TABLE Produtos (
    id INT PRIMARY KEY IDENTITY(1,1),
    nome VARCHAR(100),
    quantidade INT,
    preco DECIMAL(10, 2)
);

-- Tabela de movimentos de compra
CREATE TABLE Compras (
    id INT PRIMARY KEY IDENTITY(1,1),
    idProduto INT,
    idFornecedor INT, -- Referência para PessoasJuridicas
    quantidade INT,
    precoUnitario DECIMAL(10, 2),
    FOREIGN KEY (idProduto) REFERENCES Produtos(id),
    FOREIGN KEY (idFornecedor) REFERENCES PessoasJuridicas(id)
);

-- Tabela de movimentos de venda
CREATE TABLE Vendas (
    id INT PRIMARY KEY IDENTITY(1,1),
    idProduto INT,
    idCliente INT, -- Referência para PessoasFisicas
    quantidade INT,
    precoUnitario DECIMAL(10, 2),
    FOREIGN KEY (idProduto) REFERENCES Produtos(id),
    FOREIGN KEY (idCliente) REFERENCES PessoasFisicas(id)
);

-- Sequência para geração de identificadores de pessoa
CREATE SEQUENCE SeqPessoa START WITH 1 INCREMENT BY 1;

-- Inserir movimentações de entrada (compra) na tabela Compras
INSERT INTO Compras (idProduto, quantidade, precoUnitario)
VALUES
    (1, 100, 5.00), -- Exemplo: Compra de 100 unidades do produto com id 1, a um preço unitário de 5.00
    (2, 50, 5.00);  -- Exemplo: Compra de 50 unidades do produto com id 2, a um preço unitário de 5.00

-- Inserir movimentações de saída (venda) na tabela Vendas
INSERT INTO Vendas (idProduto, quantidade, precoUnitario)
VALUES
    (1, 80, 5.00), -- Exemplo: Venda de 80 unidades do produto com id 1, a um preço unitário de 5.00
    (2, 40, 2.00); -- Exemplo: Venda de 40 unidades do produto com id 2, a um preço unitário de 2.00

SELECT *
FROM Pessoa
WHERE tipo = 'F';

SELECT *
FROM Pessoa
WHERE tipo = 'J';

SELECT c.idCompra, p.nome AS Produto, f.nome AS Fornecedor, c.quantidade, c.precoUnitario, c.quantidade * c.precoUnitario AS ValorTotal
FROM Compras c
JOIN Produtos p ON c.idProduto = p.idProduto
JOIN Fornecedores f ON c.idFornecedor = f.idFornecedor;

SELECT v.idVenda, p.nome AS Produto, c.nome AS Comprador, v.quantidade, v.precoUnitario, v.quantidade * v.precoUnitario AS ValorTotal
FROM Vendas v
JOIN Produtos p ON v.idProduto = p.idProduto
JOIN Clientes c ON v.idCliente = c.idCliente;

SELECT p.nome AS Produto, SUM(c.quantidade * c.precoUnitario) AS ValorTotalEntradas
FROM Compras c
JOIN Produtos p ON c.idProduto = p.idProduto
GROUP BY p.nome;

SELECT p.nome AS Produto, SUM(v.quantidade * v.precoUnitario) AS ValorTotalSaidas
FROM Vendas v
JOIN Produtos p ON v.idProduto = p.idProduto
GROUP BY p.nome;
SELECT u.nome AS Operador
FROM Usuarios u
LEFT JOIN Compras c ON u.idUsuario = c.idUsuario
WHERE c.idCompra IS NULL;

SELECT u.nome AS Operador, SUM(c.quantidade * c.precoUnitario) AS ValorTotalEntradas
FROM Usuarios u
JOIN Compras c ON u.idUsuario = c.idUsuario
GROUP BY u.nome;

SELECT u.nome AS Operador, SUM(v.quantidade * v.precoUnitario) AS ValorTotalSaidas
FROM Usuarios u
JOIN Vendas v ON u.idUsuario = v.idUsuario
GROUP BY u.nome;

SELECT p.nome AS Produto, SUM(v.quantidade * v.precoUnitario) / SUM(v.quantidade) AS ValorMedioVenda
FROM Vendas v
JOIN Produtos p ON v.idProduto = p.idProduto
GROUP BY p.nome;
