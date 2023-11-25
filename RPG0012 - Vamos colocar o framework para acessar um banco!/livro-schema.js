const mongoose = require('./conexao'); // Importar a conexão definida anteriormente

// Definir a estrutura do modelo de Livro usando Mongoose Schema
const LivroSchema = new mongoose.Schema({
  titulo: String,
  autor: String,
  editora: String,
  // Outros atributos do livro, se houverem
});

// Associar o LivroSchema à coleção 'livros' no banco de dados
const Livro = mongoose.model('Livro', LivroSchema, 'livros');

// Exportar o modelo 'Livro' no padrão de módulo do JavaScript
module.exports = Livro;
