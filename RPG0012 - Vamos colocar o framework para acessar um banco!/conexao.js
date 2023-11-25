const mongoose = require('mongoose');

// Configurações para a conexão com o MongoDB
const options = {
  useUnifiedTopology: true,
  useNewUrlParser: true,
};

// Conectar ao banco de dados MongoDB
mongoose.connect('mongodb://localhost:27017/', options)
  .then(() => console.log('Conexão com o MongoDB estabelecida'))
  .catch((err) => console.error('Erro ao conectar ao MongoDB:', err));

// Exportar a conexão no padrão de módulo do JavaScript
module.exports = mongoose;
