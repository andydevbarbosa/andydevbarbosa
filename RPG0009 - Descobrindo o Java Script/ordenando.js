// a) Função swap
const swap = (arr, idx1, idx2) => {
    [arr[idx1], arr[idx2]] = [arr[idx2], arr[idx1]];
  };
  
  // b) Função shuffle
  const shuffle = (arr, numSwaps) => {
    for (let i = 0; i < numSwaps; i++) {
      const idx1 = Math.floor(Math.random() * arr.length);
      const idx2 = Math.floor(Math.random() * arr.length);
      swap(arr, idx1, idx2);
    }
    return arr;
  };
  
  // c) Função bubble_sort
  const bubble_sort = (arr) => {
    // Implemente o algoritmo de Bubble Sort aqui
  };
  
  // d) Função selection_sort
  const selection_sort = (arr) => {
    // Implemente o algoritmo de Selection Sort aqui
  };
  
  // e) Função quick_sort
  const quick_sort = (arr, start = 0, end = arr.length - 1) => {
    // Implemente o algoritmo de Quick Sort aqui
  };
  
  // f) Função particionamento
  const particionamento = (arr, start, end, pivot) => {
    // Implemente a função de particionamento aqui
  };
  