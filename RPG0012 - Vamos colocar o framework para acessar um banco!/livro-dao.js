const Livro = require('./livro-schema'); // Importar o modelo Livro

// Função para obter todos os livros
const obterLivros = async () => {
  try {
    const livros = await Livro.find();
    return livros;
  } catch (error) {
    throw new Error('Erro ao obter livros: ' + error.message);
  }
};

// Função para incluir um novo livro
const incluir = async (livro) => {
  try {
    const novoLivro = await Livro.create(livro);
    return novoLivro;
  } catch (error) {
    throw new Error('Erro ao incluir livro: ' + error.message);
  }
};

// Função para excluir um livro pelo código (_id)
const excluir = async (codigo) => {
  try {
    await Livro.deleteOne({ _id: codigo });
    return { mensagem: 'Livro excluído com sucesso' };
  } catch (error) {
    throw new Error('Erro ao excluir livro: ' + error.message);
  }
};

// Exportar as funções definidas no padrão de módulo JavaScript
module.exports = {
  obterLivros,
  incluir,
  excluir,
};
