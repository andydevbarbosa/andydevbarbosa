CREATE TABLE Usuarios (
    UsuarioID INT PRIMARY KEY,
    NomeUsuario VARCHAR(50) UNIQUE NOT NULL,
    Senha VARCHAR(100) NOT NULL,
    NomeCompleto VARCHAR(100),
    Email VARCHAR(100)
);

-- Criar tabela de pessoas
CREATE TABLE Pessoas (
    PessoaID INT PRIMARY KEY,
    TipoPessoa CHAR(1) CHECK (TipoPessoa IN ('F', 'J')),
    Nome VARCHAR(100) NOT NULL,
    Endereco VARCHAR(100),
    Telefone VARCHAR(20),
    Email VARCHAR(100),
    CPF VARCHAR(14) UNIQUE,
    CNPJ VARCHAR(18) UNIQUE
);

-- Criar tabela de pessoas físicas
CREATE TABLE PessoasFisicas (
    PessoaID INT PRIMARY KEY,
    RG VARCHAR(20),
    FOREIGN KEY (PessoaID) REFERENCES Pessoas(PessoaID)
);

-- Criar tabela de pessoas jurídicas
CREATE TABLE PessoasJuridicas (
    PessoaID INT PRIMARY KEY,
    RazaoSocial VARCHAR(100),
    NomeFantasia VARCHAR(100),
    FOREIGN KEY (PessoaID) REFERENCES Pessoas(PessoaID)
);

-- Criar tabela de produtos
CREATE TABLE Produtos (
    ProdutoID INT PRIMARY KEY,
    NomeProduto VARCHAR(100) NOT NULL,
    Quantidade INT,
    PrecoVenda DECIMAL(10, 2)
);

-- Criar tabela de compras
CREATE TABLE Compras (
    CompraID INT PRIMARY KEY,
    UsuarioID INT,
    ProdutoID INT,
    PessoaID INT,
    Quantidade INT,
    PrecoUnitario DECIMAL(10, 2),
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ProdutoID) REFERENCES Produtos(ProdutoID),
    FOREIGN KEY (PessoaID) REFERENCES Pessoas(PessoaID)
);

-- Criar tabela de vendas
CREATE TABLE Vendas (
    VendaID INT PRIMARY KEY,
    UsuarioID INT,
    ProdutoID INT,
    PessoaID INT,
    Quantidade INT,
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ProdutoID) REFERENCES Produtos(ProdutoID),
    FOREIGN KEY (PessoaID) REFERENCES Pessoas(PessoaID)
);