const express = require('express');
const router = express.Router();
const { obterLivros, incluir, excluir } = require('../modelo/livro-dao');

// Rota para obter todos os livros (GET)
router.get('/', async (req, res) => {
  try {
    const livros = await obterLivros();
    res.json(livros);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Rota para incluir um novo livro (POST)
router.post('/', async (req, res) => {
  try {
    const novoLivro = await incluir(req.body);
    res.json({ mensagem: 'Livro incluído com sucesso', livro: novoLivro });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Rota para excluir um livro pelo código (_id) (DELETE)
router.delete('/:codigo', async (req, res) => {
  const codigo = req.params.codigo;
  try {
    await excluir(codigo);
    res.json({ mensagem: 'Livro excluído com sucesso' });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

module.exports = router;
